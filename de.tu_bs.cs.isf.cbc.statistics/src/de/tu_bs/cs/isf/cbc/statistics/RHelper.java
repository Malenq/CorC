package de.tu_bs.cs.isf.cbc.statistics;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;

import de.uka.ilkd.key.proof.Proof;
import de.uka.ilkd.key.proof.Statistics;

public class RHelper {
	
	private static final String PLUGIN_ID ="de.tu_bs.cs.isf.cbc.statistics";
	// TODO: rCode should be set in constructor
	private String rCode = "";
	private List<String> diagramPaths = new LinkedList<String>();

	public void createStatisticDiagramFile(String name) {
		IPath pluginStateFolderPath = Platform.getStateLocation(Platform.getBundle(PLUGIN_ID));
		File pluginStateFolder = pluginStateFolderPath.toFile();

		String folderName = "" + System.currentTimeMillis();
		// TODO: find suitable path
		String rootLocation = pluginStateFolder.getAbsolutePath() + File.separator + folderName + File.separator;
		File rFile = new File(rootLocation);
		rFile.mkdir();

		String rFileLocation = rootLocation + name + ".R";
		String errorFileLocation = rootLocation + name + "-errorlog.txt";
		String pdfFileLocation = rootLocation + name + ".pdf";
		pdfFileLocation = pdfFileLocation.replaceAll("\\\\", "/");

		// to replace path in generated .R file
//		  rCode = rCode.replaceAll("%PLACEHOLDER%", pdfFileLocation);

		try {
			writeToFile(rFileLocation, rCode, true);
		} catch (IOException e1) {
			e1.printStackTrace();
			return; // if this does not work ... well
		}

		// TODO: alter process information for builder -> RScript is in PATH
		ProcessBuilder rProcessBuilder = new ProcessBuilder("Rscript", rFileLocation);
		try {
			Process rProcess = rProcessBuilder.start();
			if (rProcess.waitFor() != 0) {
				StringBuilder textBuilder = new StringBuilder();
				try (Reader reader = new BufferedReader(new InputStreamReader(rProcess.getErrorStream(),
						Charset.forName(StandardCharsets.UTF_8.name())))) {
					int c = 0;
					while ((c = reader.read()) != -1) {
						textBuilder.append((char) c);
					}
				}
				writeToFile(errorFileLocation, textBuilder.toString(), true);
			}
		} catch (Exception e) {
			String errorOutput = "Rscript not found. Please install and make sure to add to PATH variable.\n"
					+ "  -> Eclipse may have to be restarted.";
			System.out.println(errorOutput);
			de.tu_bs.cs.isf.cbc.util.Console.println(errorOutput);
			e.printStackTrace();
		}

		// may be useful later: e.g. pdf view within ide
//		  try {
//		    statsProject.refreshLocal(IResource.DEPTH_INFINITE, null);
//		  } catch (CoreException e) {
//		    e.printStackTrace();
//		  }
	}

	private void writeToFile(String fileLocation, String content, boolean overwrite) throws IOException {
		File rFile = new File(fileLocation);
		if (!rFile.createNewFile()) {
			if (!overwrite)
				return;
		}
		FileWriter myWriter = new FileWriter(rFile);
		myWriter.write(content);
		myWriter.close();
	}
	
	public String createStatisticDummyFileString() {
		
		String emptyLine = "\r\n";
		String pdfPath = "png(filename=\"D:\\\\Uni\\\\Bachelorarbeit\\\\HTMLTemplateCode\\\\test.png\")\r\n";
		
		String yAxis = "cars <- c (1,3,6,4,20)\r\n";
		String xAxis = "x=c(22,39,50,25,18)\r\n";
		xAxis = "";
		
		String plotCommand = "mean(y)\r\nmean(x)\r\nplot(x,y)";
		plotCommand = "barplot(cars)";
		
		String fileString = pdfPath + emptyLine + xAxis + yAxis +  plotCommand;

		return fileString;
	}
	
	public String createStatisticsFileString(Proof proof) {
	
		Statistics keyStats = proof.getStatistics();
		
		String emptyLine = "\r\n";
		String pdfPath = "png(filename=\"D:\\\\Uni\\\\Bachelorarbeit\\\\HTMLTemplateCode\\\\test.png\")\r\n";
		
		String xAxis = "rules <- c(" + keyStats.totalRuleApps + ")\r\n";
		String yAxis = "time <- c(" + keyStats.autoModeTimeInMillis + ")\r\n";
		
		String plotCommand = "mean(rules)\r\nmean(time)\r\nplot(rules,time)";
		
		
		String fileString = pdfPath + emptyLine + xAxis + yAxis +  plotCommand;

		return fileString;
	}

//	public static void doSomethingToShow() {
//		//TODO: get saved data (not saved jet)
//		//TODO: return PNG or so
//		
//		RHelper helper = new RHelper();
//		// just yet only the dummy
//		String fileString = helper.createStatisticDummyFileString();
//		helper.createStatisticDiagramFile("test", fileString);
//		
//	}

	
	/**
	 * Sets a diagram file String of multiple CorC diagrams.
	 * 
	 * @param entries 
	 */
	public void setStatisticsFileStringForDiagrams(List<StatisticsEntry> entries) {
		
		IPath pluginStateFolderPath = Platform.getStateLocation(Platform.getBundle(PLUGIN_ID));
		File pluginStateFolder = pluginStateFolderPath.toFile();

		String folderName = "generatedDiagrams";
		String rootLocation = pluginStateFolder.getAbsolutePath() + File.separator + folderName + File.separator;
//		File rFile = new File(rootLocation);
//		rFile.mkdir();
		
		String generatedDiagramPath ="png(filename=\""+ rootLocation +"test.png" +"\")\r\n";
		generatedDiagramPath = generatedDiagramPath.replaceAll("\\\\", "/");
		diagramPaths.add(rootLocation +"test.png");
		
		File directory = new File(rootLocation);
		if (! directory.exists()){
	        directory.mkdir();
	    }
		
		List<String> diagramNames = new LinkedList<String>();
		for (StatisticsEntry entry : entries) {
			String entryDiagramName = entry.getMapping().getCorcDiagramName();
			boolean alreadyInDiagram = false;
			for (String name : diagramNames) {
				if (name.equals(entryDiagramName)) {
					alreadyInDiagram = true;
				}
			}
			if (!alreadyInDiagram) {
				diagramNames.add(entryDiagramName);
			}
		}
		
		String xAxis = "diagram <- c(";
		String yAxis = "time <- c(" ;
		
		for (String diagramName : diagramNames) {
			xAxis = xAxis + "\"" + diagramName +"\", ";
			float totalTime = 0;
			for (StatisticsEntry entry : entries) {
				if (entry.getMapping().getCorcDiagramName().equals(diagramName)) {
					totalTime = totalTime + entry.getData().getAutoModeTimeInMillis();
				}
			}
			yAxis = yAxis + totalTime + ", ";
		}
		xAxis = xAxis.substring(0, xAxis.length()-2) + ")\r\n";
		yAxis = yAxis.substring(0, yAxis.length()-2) + ")\r\n";
		
		String margins = "linch <-  max(strwidth(diagram, \"inch\")+0.4, na.rm = TRUE)\r\n"
				+ "par(mai=c(linch,1.02,0.82,0.42))\r\n";
		
//		String plotCommand = "mean(diagram)\r\nmean(time)\r\nplot(diagram,time)";
//		String plotCommand = "barplot(time,xlab = \"Diagrams\", ylab = \"Auto Mode Time in ms\", names.arg=diagram, las=2)\r\n";
		String plotCommand = "barplot(time, ylab = \"Auto Mode Time in ms\", names.arg=diagram, las=2)\r\n";
		
		rCode = generatedDiagramPath  + xAxis + yAxis + margins + plotCommand;
	}

	public List<String> getDiagramPaths() {
		return diagramPaths;
	}
}
