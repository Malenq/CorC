package de.tu_bs.cs.isf.cbc.statistics.ui;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IFile;

import de.tu_bs.cs.isf.cbc.statistics.RHelper;
import de.tu_bs.cs.isf.cbc.statistics.StatisticsEntry;

public class HtmlHandler {

	// String with placeholder
//	private String beforeEntrys = "";
//	private String betweenEntrysAndDiagrams = ""; 
//	private String afterDiagrams = ""; 
	private int numberOfDiagrams;
	private List<StatisticsEntry> entries = new LinkedList<StatisticsEntry>();
	private List<IFile> selectedDiagramFiles = new LinkedList<IFile>();

	private String placeholderPlainStatistics = "";
	private String placeholderGeneratedDiagram = "";
	private String lineBreak = "<br />";

	public void setDiagramPaths(List<?> paths) {

	}

	public void setData(int numberOfDiagrams, List<StatisticsEntry> entries, List<IFile> selectedDiagramFiles) {

		this.numberOfDiagrams = numberOfDiagrams;
		this.entries = entries;
		this.selectedDiagramFiles = selectedDiagramFiles;

	}

	public String getHtmlString() {
		String diagramName = "";
		List<StatisticsEntry> entriesPerDiagram = new LinkedList<StatisticsEntry>();

		if (entries == null || entries.isEmpty()) {
			
		}
		else {
			
			if (numberOfDiagrams == 1) {
				entriesPerDiagram = entries;
				diagramName = entries.get(0).getMapping().getCorcDiagramName();
				createPlaceholderPlainStringForOneDiagram(diagramName, entriesPerDiagram);
				
				placeholderGeneratedDiagram = "<div class=\"text block\">\r\n"
						+ "                <p>No diagrams generated. For diagram generation, please select more than one CorC diagram</p>\r\n" + "            </div>";
			} else if (numberOfDiagrams > 1) {
				
				for (IFile file : selectedDiagramFiles) {
					diagramName = file.getName().substring(0, file.getName().indexOf(".diagram"));
					for (StatisticsEntry entry : entries) {
						if (entry.getMapping().getCorcDiagramName().equals(diagramName)) {
							entriesPerDiagram.add(entry);
						}
					}
					createPlaceholderPlainStringForOneDiagram(diagramName, entriesPerDiagram);
					entriesPerDiagram = new LinkedList<StatisticsEntry>();
				}
				
				RHelper helper = new RHelper();
				helper.setStatisticsFileStringForDiagrams(entries);
				helper.createStatisticDiagramFile("test");
				
				
				List<String> diagramPaths = new LinkedList<String>();
				diagramPaths  = helper.getDiagramPaths();
				if ( diagramPaths == null || diagramPaths.isEmpty() ) {
					placeholderGeneratedDiagram = "<div class=\"text block\">\r\n"
							+ "                <p>Diagram generation failed.</p>\r\n" + "            </div>";
				}
				else{
					for(String path : diagramPaths) {
						placeholderGeneratedDiagram = placeholderGeneratedDiagram 
								+ "<img class=\"\" src=\"" + path + "\">\r\n";
					}
				}
			}
		}
//		TODO: abfangen keine entries

		String htmlStyleTag = "<style>\r\n" + "        body{\r\n" + "            margin: 0;\r\n"
				+ "            padding: 0;\r\n" + "        }\r\n" + "        .container{\r\n" + "        }\r\n"
				+ "        .text{\r\n" + "            font-family: sans-serif;\r\n" + "        }\r\n"
				+ "        .block{\r\n" + "            margin-left: 25px;\r\n" + "            margin-bottom: 45px;\r\n"
				+ "        }\r\n" + "        .horizontal-line{\r\n" + "            height: 5px;\r\n"
				+ "            background-color: #f3f3f3;\r\n" + "            border: none;\r\n" + "        }\r\n"
				+ "        .inner-box{\r\n" + "            padding: 10px;\r\n" + "        }\r\n"
				+ "        .left-margin-class{\r\n" + "            margin-left: 20px;\r\n" + "        }\r\n"
				+ "    </style>";

		return "<!DOCTYPE html>\r\n" + "<html lang=\"en\">\r\n" + "<head>\r\n" + "    <meta charset=\"UTF-8\">\r\n"
				+ "    <title>WebCorCStatistics Viewer</title>\r\n" + "\r\n" + htmlStyleTag + "</head>\r\n"
				+ "<body>\r\n" + "    <div class=\"container\">\r\n" + "        <div class=\"inner-box\">\r\n"
				+ "            <h2 class=\"text\">Plain Statistics</h2>\r\n"
				+ "            <div class=\"text block\">\r\n" + "                <p>" + placeholderPlainStatistics
				+ "</p>\r\n" + "            </div>\r\n" + "        </div>\r\n"
				+ "        <hr class=\"horizontal-line\">\r\n" + "        <div class=\"inner-box\">\r\n"
				+ "            <h2 class=\"text\">Generated Diagram</h2>\r\n"
//				+ "            <img class=\"\" src=\"file:///D:/Uni/Bachelorarbeit/HTMLTemplateCode/test.png\">\r\n"
				+ placeholderGeneratedDiagram + "        </div>\r\n" + "    </div>\r\n" + "</body>\r\n" + "</html>";
	}

	private void createPlaceholderPlainStringForOneDiagram(String diagramName,
			List<StatisticsEntry> entriesPerDiagram) {

		placeholderPlainStatistics = placeholderPlainStatistics + "<h3 class\"text\">Diagram: " + diagramName + "</h3>";

		if (entriesPerDiagram.isEmpty()) {
			placeholderPlainStatistics = placeholderPlainStatistics
					+ "<p class= \"left-margin-class\">No data found. Please generate statistics by verifying statements.</p>";
		} else {
			float totalTime = 0;
			for (StatisticsEntry entry : entriesPerDiagram) {

				String KeYFile = entry.getMapping().getKeyFilePath();
				KeYFile = KeYFile.substring(KeYFile.lastIndexOf(File.separator) + 1, KeYFile.length());

				placeholderPlainStatistics = placeholderPlainStatistics + "<div class=\"left-margin-class\">"
						+ "<h4 class=\"text\">KeY file: " + KeYFile + "</h4>" + "<p class= \"left-margin-class\">"
						+ "Automode Time: " + entry.getData().getAutoModeTimeInMillis() + "ms" + lineBreak
						+ "Number of Branches: " + entry.getData().getNumberOfBranches() + lineBreak
						+ "Number of Nodes: " + entry.getData().getNumberOfNodes() + lineBreak
						+ "total Rule Applications: " + entry.getData().getTotalRuleApps() + lineBreak
						+ "Time per Step: " + entry.getData().getTimePerStepInMillis() + "ms" + lineBreak + "Time: "
						+ entry.getData().getTimeInMillis() + "ms" + "</p>" + "</div>";
				totalTime = totalTime + entry.getData().getTimeInMillis();
			}
			placeholderPlainStatistics = placeholderPlainStatistics + "Total time needed: " + totalTime + "ms" 
			+ lineBreak			+ lineBreak			+ lineBreak;
		}
	}

}
