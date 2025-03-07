package de.tu_bs.cs.isf.taxonomy.graphiti.patterns;

import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.pattern.IPattern;
import org.eclipse.graphiti.pattern.id.IdLayoutContext;
import org.eclipse.graphiti.pattern.id.IdPattern;
import org.eclipse.graphiti.pattern.id.IdUpdateContext;

import de.tu_bs.cs.isf.taxonomy.model.taxonomy.JavaVariable;
import de.tu_bs.cs.isf.taxonomy.model.taxonomy.JavaVariables;
import de.tu_bs.cs.isf.taxonomy.model.taxonomy.TaxonomyFactory;

/**
 * Class that creates the graphical representation of Methods
 * @author Tobias
 *
 */
public class VariablePattern extends IdPattern implements IPattern {

	/**
	 * Constructor of the class
	 */
	public VariablePattern() {
		super();
	}
	
	@Override
	public String getCreateName() {
		return "Variable";
	}
	
	@Override
	public String getCreateDescription() {
		return "Create a variable.";
	}

	@Override
	public boolean isMainBusinessObjectApplicable(Object mainBusinessObject) {
		return mainBusinessObject instanceof JavaVariable;
	}

	@Override
	public boolean canCreate(ICreateContext context) {
		return getBusinessObjectForPictogramElement(context.getTargetContainer()) instanceof JavaVariables;
	}

	@Override
	public Object[] create(ICreateContext context) {
		JavaVariables variables = (JavaVariables) getBusinessObjectForPictogramElement(context.getTargetContainer());
		JavaVariable variable = TaxonomyFactory.eINSTANCE.createJavaVariable();
		variable.setName("int a");
		variables.getVariables().add(variable);
		updatePictogramElement(context.getTargetContainer());
		return new Object[] { variable };
	}

	@Override
	public boolean canAdd(IAddContext context) {
		return false;
	}

	@Override
	public PictogramElement doAdd(IAddContext context) {
		return null;
	}

	@Override
	protected boolean layout(IdLayoutContext context, String id) {
		return false;
	}
	
	public boolean canUpdate(IdUpdateContext context) {
        Object bo = getBusinessObjectForPictogramElement(context.getPictogramElement());
        return (bo instanceof JavaVariable);
    }
 
    public IReason updateNeeded(IdUpdateContext context, String id) {
		Text nameText = (Text) context.getPictogramElement().getGraphicsAlgorithm();
		JavaVariable domainObject = (JavaVariable) getBusinessObjectForPictogramElement(context.getPictogramElement());
		if (domainObject.getName() == null || !domainObject.getName().equals(nameText.getValue())) {
			return Reason.createTrueReason("Name differs. Expected: '" + domainObject.getName() + "'");
		}
		return Reason.createFalseReason();
    }
 
    public boolean update(IdUpdateContext context, String id) {
    	Text nameText = (Text) context.getPictogramElement().getGraphicsAlgorithm();
		JavaVariable domainObject = (JavaVariable) getBusinessObjectForPictogramElement(context.getPictogramElement());
		nameText.setValue(domainObject.getName());
		return true;
    }
    
    @Override
	public int getEditingType() {
	    return TYPE_TEXT;
	}
	
	@Override
	public boolean canDirectEdit(IDirectEditingContext context) {
		Object domainObject = getBusinessObjectForPictogramElement(context.getPictogramElement());
		GraphicsAlgorithm ga = context.getGraphicsAlgorithm();
		if (domainObject instanceof JavaVariable && ga instanceof Text) {
			return true;
		}
		return false;
	}
	

	@Override
	public String getInitialValue(IDirectEditingContext context) {
		JavaVariable variable = (JavaVariable) getBusinessObjectForPictogramElement(context.getPictogramElement());
		return variable.getName();
	}

	@Override
	public String checkValueValid(String value, IDirectEditingContext context) {
		if (value == null || value.length() == 0) {
			return "Variable must not be empty";
		} else if (value.length() > 0 && !value.matches("[a-zA-Z]\\w*(\\[\\])?\\s[a-zA-Z]\\w*")) {
			return "Variable must contain a type and a name";
		}
		return null;
	}

	@Override
	public void setValue(String value, IDirectEditingContext context) {
		JavaVariable variable = (JavaVariable) getBusinessObjectForPictogramElement(context.getPictogramElement());
		variable.setName(value);
		updatePictogramElement(((Shape) context.getPictogramElement()));
	}
	
	@Override
	public void delete(IDeleteContext context) {
		Shape shape = (Shape) context.getPictogramElement();
		ContainerShape container = shape.getContainer();
		
		JavaVariable variable = (JavaVariable) getBusinessObjectForPictogramElement(context.getPictogramElement());
		if (variable.eContainer() != null && variable.eContainer() instanceof JavaVariables) {
			int indexToDelete = getIndex(shape.getGraphicsAlgorithm());
			
			for (Shape childShape : container.getChildren()) {
				if (getIndex(childShape.getGraphicsAlgorithm()) > indexToDelete) {
					setIndex(childShape.getGraphicsAlgorithm(), getIndex(childShape.getGraphicsAlgorithm()) - 1);
				}
			}
			super.delete(context);
			layoutPictogramElement(container);
		}
	}

}

