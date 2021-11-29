package de.tu_bs.cs.isf.cbc.statistics.ui;

public class HtmlHandler {

	//String with placeholder
	private String beforeEntrys = "";
	private String betweenEntrysAndDiagrams = ""; 
	private String afterDiagrams = ""; 
	

	
	public static String getHtmlString() {
		
		return "<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <title>WebCorCStatistics Viewer</title>\r\n"
				+ "\r\n"
				+ "<!--  embedded style sheet:  -->\r\n"
				+ "    <style>\r\n"
				+ "        body{\r\n"
				+ "            margin: 0;\r\n"
				+ "            padding: 0;\r\n"
				+ "        }\r\n"
				+ "        .container{\r\n"
				+ "        }\r\n"
				+ "        .text{\r\n"
				+ "            font-family: sans-serif;\r\n"
				+ "        }\r\n"
				+ "        .block{\r\n"
				+ "            margin-left: 25px;\r\n"
				+ "            margin-bottom: 45px;\r\n"
				+ "        }\r\n"
				+ "        .horizontal-line{\r\n"
				+ "            height: 5px;\r\n"
				+ "            background-color: #f3f3f3;\r\n"
				+ "            border: none;\r\n"
				+ "        }\r\n"
				+ "        .inner-box{\r\n"
				+ "            padding: 10px;\r\n"
				+ "        }\r\n"
				+ "    </style>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "    <div class=\"container\">\r\n"
				+ "        <div class=\"inner-box\">\r\n"
				+ "            <h2 class=\"text\">Plain Statistics</h2>\r\n"
				+ "            <div class=\"text block\">\r\n"
				+ "                <p>placeholderStatistic</p>\r\n"
				+ "            </div>\r\n"
				+ "        </div>\r\n"
				+ "        <hr class=\"horizontal-line\">\r\n"
				+ "        <div class=\"inner-box\">\r\n"
				+ "            <h2 class=\"text\">Generated Diagrams</h2>\r\n"
				+ "            <img class=\"\" src=\"file:///D:/Uni/Bachelorarbeit/HTMLTemplateCode/test.jpg\">\r\n"
				+ "        </div>\r\n"
				+ "    </div>\r\n"
				+ "</body>\r\n"
				+ "</html>";
	}

}
