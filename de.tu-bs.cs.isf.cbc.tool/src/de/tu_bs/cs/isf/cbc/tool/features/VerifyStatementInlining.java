package de.tu_bs.cs.isf.cbc.tool.features;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

import de.tu_bs.cs.isf.cbc.cbcmodel.AbstractStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.GlobalConditions;
import de.tu_bs.cs.isf.cbc.cbcmodel.JavaVariables;
import de.tu_bs.cs.isf.cbc.cbcmodel.MethodClass;
import de.tu_bs.cs.isf.cbc.cbcmodel.MethodStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.MethodRefinements;
import de.tu_bs.cs.isf.cbc.cbcmodel.ProductVariant;
import de.tu_bs.cs.isf.cbc.cbcmodel.Rename;
import de.tu_bs.cs.isf.cbc.cbcmodel.Renaming;
import de.tu_bs.cs.isf.cbc.cbcmodel.ReturnStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.SkipStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.impl.AbstractStatementImpl;
import de.tu_bs.cs.isf.cbc.tool.helper.GetDiagramUtil;
import de.tu_bs.cs.isf.cbc.util.Console;
import de.tu_bs.cs.isf.cbc.util.FileUtil;
import de.tu_bs.cs.isf.cbc.util.Parser;
import de.tu_bs.cs.isf.cbc.util.ProveWithKey;
import de.tu_bs.cs.isf.taxonomy.graphiti.features.MyAbstractAsynchronousCustomFeature;
import de.tu_bs.cs.isf.toolkit.support.compare.CompareMethodBodies;

public class VerifyStatementInlining extends MyAbstractAsynchronousCustomFeature{

	public VerifyStatementInlining(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public String getName() {
		return "Verify a statement with inlining";
	}

	@Override
	public String getDescription() {
		return "Verifies a statement with inlining using the pre and post condition.";
	}

	@Override
	public boolean canExecute(ICustomContext context) {
		boolean ret = false;
		PictogramElement[] pes = context.getPictogramElements();
		if (pes != null && pes.length == 1) {
			Object bo = getBusinessObjectForPictogramElement(pes[0]);
			if (bo != null && (bo.getClass().equals(AbstractStatementImpl.class) || bo instanceof SkipStatement
					|| bo instanceof ReturnStatement || bo instanceof MethodStatement)) {
				AbstractStatement statement = (AbstractStatement) bo;
				if (statement.getRefinement() == null) {										
					ret = true;
				}
			}
		}
		return ret;
	}
	
	@Override
	protected void execute(ICustomContext context, IProgressMonitor monitor) {
		monitor.beginTask("Verify statement", IProgressMonitor.UNKNOWN);
		PictogramElement[] pes = context.getPictogramElements();
		if (pes != null && pes.length == 1) {
			Object bo = getBusinessObjectForPictogramElement(pes[0]);
			if (bo instanceof AbstractStatement) {
				boolean returnStatement = false;
				if(bo instanceof ReturnStatement) {
					returnStatement = true;
				}
				AbstractStatement statement = (AbstractStatement) bo;
				JavaVariables vars = null;
				GlobalConditions conds = null;
				Renaming renaming = null;
				EList<ProductVariant> variants = null;
				MethodClass javaClass = null;
				for (Shape shape : getDiagram().getChildren()) {
					Object obj = getBusinessObjectForPictogramElement(shape);
					if (obj instanceof JavaVariables) {
						vars = (JavaVariables) obj;
					} else if (obj instanceof GlobalConditions) {
						conds = (GlobalConditions) obj;
					} else if (obj instanceof Renaming) {
						renaming = (Renaming) obj;
					} else if (obj instanceof MethodRefinements) {
						MethodRefinements methodRef = (MethodRefinements) obj;
						variants = methodRef.getProductvariants();
					} else if(obj instanceof MethodClass) {
						javaClass = (MethodClass) obj;
					}
				}
				
				
//				try {
//					if(!getMethods(statement.getName(), javaClass, vars, renaming))
//						return;
//				} catch (IOException e) {
					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				
				boolean prove = false;

				if (CompareMethodBodies.readAndTestMethodBodyWithJaMoPP2(statement.getName())) {
					prove = ProveWithKey.proveStatementWithKey(statement, vars, conds, returnStatement, true, renaming, javaClass, variants,
							getDiagram().eResource().getURI(), monitor);
				} else {
					Console.println("Statement is not in correct format.");
				}
				if (prove) {
					statement.setProven(true);
				} else {
					statement.setProven(false);
				}
				updatePictogramElement(((Shape) pes[0]).getContainer());
			}
		}
		monitor.done();
	}
	
	private boolean getMethods(String s, MethodClass javaClass, JavaVariables vars, Renaming renaming) throws IOException {//regex without casting: "(\\w+\\.)(\\w+\\()(\\s*\\w+\\s+\\w+)(\\s*\\)|(\\s*\\,\\s*\\w+\\s*\\w+)+\\))"
		Pattern methodCallPattern = Pattern.compile("(\\w+\\.)(\\w+\\()(\\s*(\\(\\s*(\\w+)\\s*\\))?\\s*(\\\"\\w*\\\"|\\w+)\\s*)?(\\s*\\)|(\\s*\\,\\s*(\\(\\s*(\\w+|\\\"\\w*\\\")\\s*\\))?\\s*(\\w+|\\\"\\w*\\\")\\s*)+\\))");
		if(renaming != null) {
			for (Rename rename : renaming.getRename()) {
				s = s.replaceAll(rename.getNewName(), rename.getFunction());
			}
		}
		Matcher matcher = methodCallPattern.matcher(s);		
		while (matcher.find()) {
			String methodCall = matcher.group(0);
			String className = methodCall.substring(0, methodCall.indexOf('.'));
			String methodName = methodCall.substring(methodCall.indexOf('.') + 1, methodCall.length());
			
			//get class if classname if variable
			String type = Parser.getTypeOfVariable(className, vars);
			if(type != null) {
				className = type;
			}
			
			URI uri = getDiagram().eResource().getURI();
			String location;
			//check if class exists
			if(className.equals("this")) {
				location = FileUtil.getProject(uri).getLocation() + "/src/" + javaClass.getMethodClass() + ".java";
			} else {
			    location = FileUtil.getProject(uri).getLocation() + "/src/" + className + ".java";
			}
			
			File javaFile = new File(location);
			if(!javaFile.exists()) {
				Console.println("Java class does not exist.");
				return false;
			}
			
			BufferedReader br = new BufferedReader(new FileReader(javaFile));	
			if(methodName.contains("()")) {//todo: chnage to: index of first ( = index of second ). because it be a parameter that contains ()
				String line = br.readLine();
				while(line != null) {
					while(line != null && !line.matches("(\\s*)(private\\s+|public\\s+|protected\\s+)?(static\\s+)?(\\/\\*\\@\\s*\\w+\\s*\\@\\*\\/\\s*)?(\\w+\\s+\\w+\\(\\s*)(\\w+(\\[\\])*\\s+\\w+(\\,\\s*\\w+(\\[\\])*\\s+\\w+)*)?(\\))(\\s+\\{\\s*)")) {
						line = br.readLine();
					}
					/*while(line != null && !line.contains("@")) {
						line = br.readLine();
					}
					while(line != null && line.contains("@")) {
						line = br.readLine();
					}*/
					if(line != null) {
						line = line.replaceAll("\\/\\*\\@\\s*\\w+\\s*\\@\\*\\/", "");
					    line = line.replace("public", "");
					    line = line.replace("static", "");
					    line = line.replace("{", "");
					    line = line.trim().split(" ", 2)[1];
					    if(line.equals(methodName)) {
					    	br.close();
					    	return true;
					    }
					    line = br.readLine();
					}
				}
			} else {
				String[] methodVariables = methodName.substring(methodName.indexOf('(') + 1, methodName.lastIndexOf(')')).split(",");
				for(int j = 0; j < methodVariables.length; j++) {
					if(methodVariables[j].contains("(")) {//Cast
						methodVariables[j] = methodVariables[j].substring(methodVariables[j].indexOf('(') + 1, methodVariables[j].indexOf(')'));
					} else if(methodVariables[j].trim().startsWith("\"")) {
						methodVariables[j] = "String";
					} else if(methodVariables[j].trim().startsWith("\'")) {
						methodVariables[j] = "char";
					} else if(methodVariables[j].trim().matches("(\\-)?(\\d+)")) {
						try {
				             int i = Integer.parseInt(methodVariables[j].trim());
				             methodVariables[j] = "int";
				        }
				        catch (NumberFormatException e)
				        {
				             long l = Long.valueOf(methodVariables[j]);
				             methodVariables[j] = "long";
				        }
					} else if(methodVariables[j].trim().matches("(\\-)?(\\d+\\.\\d+)")) {
						methodVariables[j] = "double";
					} else if(methodVariables[j].trim().equals("true") || methodVariables[j].trim().equals("false") ) {
						methodVariables[j] = "boolean";
					} else {
						methodVariables[j] = Parser.getTypeOfVariable(methodVariables[j], vars);							
					} 
				}
				methodName = methodName.substring(0, methodName.indexOf('(') + 1);
				if(methodVariables.length == 1) {
					methodName  = methodName + methodVariables[0];
				} else {
					for(int j = 0; j < methodVariables.length - 1; j++) {
						methodName = methodName + methodVariables[j] + ",";
					}
					methodName = methodName + methodVariables[methodVariables.length - 1];
				}
			    methodName = methodName + ")";//method = method(type1,type2, ...)
				String line = br.readLine();
				while(line != null) {
					while(line != null && !line.matches("(\\s*)(private\\s+|public\\s+|protected\\s+)?(static\\s+)?(\\w+\\s+\\w+\\(\\s*)(\\w+(\\[\\])*\\s+\\w+(\\,\\s*\\w+(\\[\\])*\\s+\\w+)*)?(\\))(\\s+\\{\\s*)")) {
						line = br.readLine();
					}
					if(line != null) {
					    line = editMethodSignature(line);
					    if(line.equals(methodName)) {
					    	br.close();
					    	return true;
					    }	
					}
				    line = br.readLine();
				}
			}
			br.close();
			Console.println("Method to be inlined is not implemented");
			return  false;
		}
		Console.println("Statement is not a method call.");
		return false;
	}
	
	private String editMethodSignature(String s) {
	    s = s.replace("public", "");
	    s = s.replace("static", "");
	    s = s.replace("{", "");
	    s = s.trim().split(" ", 2)[1];
	    if(!s.contains("()")) {
	    	String s2 = s.substring(s.indexOf('(') + 1, s.lastIndexOf(')'));
	    	String[] variableTypes = s2.split(",");
	    	s2 = variableTypes[0].trim().split(" ")[0];
	    	for(int i = 1; i < variableTypes.length; i++) {
	    		if(variableTypes[i].trim().split(" ")[0].equals("float"))
	    			s2 = s2 + ",double";
	    		else
	    			s2 = s2 + "," + variableTypes[i].trim().split(" ")[0];
	    	}
	    	s = s.substring(0, s.indexOf('(') + 1);
	    	s = s + s2 + ")";
	    }
	    return s;
	}
	
	protected Collection<Diagram> getDiagrams() {
        Collection<Diagram> result = Collections.emptyList();
        Resource resource = getDiagram().eResource();
        URI uri = resource.getURI();
        URI uriTrimmed = uri.trimFragment();
        if (uriTrimmed.isPlatformResource()){
            String platformString = uriTrimmed.toPlatformString(true);
            IResource fileResource = ResourcesPlugin.getWorkspace()
              .getRoot().findMember(platformString);
            if (fileResource != null){
                IProject project = fileResource.getProject();
                result = GetDiagramUtil.getDiagrams(project);
            }
        }
        return result;
	}
}