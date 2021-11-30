package de.tu_bs.cs.isf.cbc.statistics;

import java.util.List;

import org.eclipse.core.resources.IFile;

public class StatisticsDatabase {
	
	public static StatisticsDatabase instance = new StatisticsDatabase();
	
	private StatisticsRegistry registry;

	private StatisticsDatabase() {
//		statisticsFactory.eINSTANCE.createStatisticsRegistry()
			//try to load registry out of XML
			// if XML file exists -> return loaded registry
			// else -> create registry via factory and return
	}
	
	public void saveToDatabase(StatisticsEntry entry) {
		//TODO add registry and then to XML
		registry.getEntries().add(entry);
		
	}

	private void saveRegistry() {
		// save registry to XML file
	}

	public void getDataRelatedTo(List<IFile> affectedFiles) {
		// TODO Auto-generated method stub
		
	}
}
