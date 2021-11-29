package de.tu_bs.cs.isf.cbc.statistics;

import de.tu_bs.cs.isf.cbc.cbcmodel.CbCFormula;
import de.uka.ilkd.key.proof.Proof;
import de.uka.ilkd.key.proof.Statistics;

public class DataCollector {
	
	//! location is not close enough to match through it
//	public static void registerFormula(File location, CbCFormula formula) {
//		// check if location is already saved with a proof -> combine
//				// if not -> create new entry
//	}
//	
//	public static void registerProof(File location, Proof proof) {
//		// check if location is already saved with a formula -> combine
//				// if not -> create new entry
//	}
	
//	private void registerEntry(StatisticsEntry entry) {
//		StatisticsRegistry registry = statisticsFactory.eINSTANCE.createStatisticsRegistry();
//		registry.
//	}
	
	public void collectCorcStatistics(Proof proof, CbCFormula formula) {
		//TODO: if formula is null -> only a KeY file is proven: no diagram in direct relation 
		if(formula != null) {
			Statistics keyStats = proof.getStatistics();
			
			StatisticsEntry corcStatsEntry = statisticsFactory.eINSTANCE.createStatisticsEntry();
			StatisticsEntryData corcStatsEntryData = statisticsFactory.eINSTANCE.createStatisticsEntryData();
			
			//set statistics to this entry
			corcStatsEntry.setData(corcStatsEntryData);
			//set KeY file path mapping to this entry
			corcStatsEntry.setKeyFilePath(proof.getProofFile().getAbsolutePath());
			// set CorC element mapping to this entry
			corcStatsEntry.setCorcElement(formula);
			
			//collecting statistic data for this entry TODO: more
			corcStatsEntryData.setNumberOfNodes(keyStats.nodes);
			corcStatsEntryData.setAutoModeTimeInMillis(keyStats.autoModeTimeInMillis);
			corcStatsEntryData.setTimeInMillis(keyStats.timeInMillis);
			corcStatsEntryData.setTimePerStepInMillis(keyStats.timePerStepInMillis);
			
			
			StatisticsDatabase.instance.saveToDatabase(corcStatsEntry);
		}
		else {
			System.out.println("Directly proven a KeY file. Statistics not collected!");
		}
		
	}
}
