package de.tu_bs.cs.isf.cbc.statistics;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;

import de.uka.ilkd.key.proof.Statistics;

public class RHelper {
	
	private static final String PLUGIN_ID ="de.tu_bs.cs.isf.cbc.statistics";

	public void createStatisticFiles(String name, String rCode) {
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

		// TODO: alter process information for builder -> Rscript is in PATH
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
	
	// TODO: input: some statistic data of the proofing process
	public String createStatisticFileString(Statistics statisticObject) {
	
		String emptyLine = "\r\n";
		String pdfPath = "pdf(file=\"C:\\\\Users\\\\m-hor\\\\Desktop\\\\test.pdf\", height=10, width=15)\r\n";
		
		String xAxis = "y=c(12,15,28,17,18)\r\n";
		String yAxis = "x=c(22,39,50,25,18)\r\n";
		
		String plotCommand = "mean(y)\r\nmean(x)\r\nplot(x,y)";
		
		String fileString = pdfPath + emptyLine + xAxis + yAxis +  plotCommand;

		return fileString;
	}

}
