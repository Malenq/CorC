package de.tu_bs.cs.isf.cbc.statistics;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;

import com.google.common.hash.Hashing;

import de.tu_bs.cs.isf.cbc.cbcmodel.AbstractStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.CbCFormula;
import de.uka.ilkd.key.proof.Proof;
import de.uka.ilkd.key.proof.Statistics;

public class DataCollector {

	// TODO: data is constantly saved -> implement something to clean database either:
	// automatically (e.g. after a certain time) or 
	// manually (e.g. by clicking clean statistics within the context menu)

	public void collectCorcStatistics(Proof proof, CbCFormula formula, AbstractStatement statement) {
		// TODO: if formula is null -> only a KeY file is proven: no diagram in direct
		// relation
		if (formula != null) {
			Statistics keyStats = proof.getStatistics();
			String hashValue = getHashFromFileContent(proof);

			StatisticsEntry corcStatsEntry = statisticsFactory.eINSTANCE.createStatisticsEntry();
			StatisticsData corcStatsData = statisticsFactory.eINSTANCE.createStatisticsData();
			CorcKeyMapping mapping = statisticsFactory.eINSTANCE.createCorcKeyMapping();

			// set statistics to this entry
			corcStatsEntry.setData(corcStatsData);
			corcStatsEntry.setMapping(mapping);
			
			// set KeY file path mapping to this entry
			mapping.setKeyFilePath(proof.getProofFile().getAbsolutePath());
			// set CorC elements mapping to this entry
			mapping.setCorcElementFormula(formula);
			mapping.setCorcElementStatement(statement);
			// set KeY file hash value
			mapping.setKeyProofProblemHashValue(hashValue);

			// collecting statistic data for this entry TODO: more
			corcStatsData.setNumberOfNodes(keyStats.nodes);
			corcStatsData.setAutoModeTimeInMillis(keyStats.autoModeTimeInMillis);
			corcStatsData.setTimeInMillis(keyStats.timeInMillis);
			corcStatsData.setTimePerStepInMillis(keyStats.timePerStepInMillis);
			corcStatsData.setNumberOfBranches(keyStats.branches);
			corcStatsData.setTotalRuleApps(keyStats.totalRuleApps);
			Date date = new Date();
			corcStatsData.setTimestamp(date);
			
			StatisticsDatabase.instance.saveToDatabase(corcStatsEntry);
		} else {
			System.out.println("Directly proven a KeY file. Statistics not collected!");
		}
	}

	private String getHashFromFileContent(Proof proof) {

		Path keyFilePath = Path.of(proof.getProofFile().getAbsolutePath());
		String fileString = "";
		try {
			fileString = Files.readString(keyFilePath);
		} catch (IOException e) {
			System.out.println("read proof file failed - DataCollector Error: " + e.getMessage());
			e.printStackTrace();
			return "-1";
		}

		int startProblem = fileString.indexOf("\\problem");

		// TODO: check if file string is empty
		String problem = fileString.substring(startProblem, fileString.length() - 1);
		int firstOpeningBracket = problem.indexOf("{");
		int endOfProblem = problem.indexOf("\\proof");
		problem = problem.substring(firstOpeningBracket + 1, endOfProblem);

		problem = problem.substring(0, problem.lastIndexOf("}"));
		problem = problem.trim();

		String hash = Hashing.sha256().hashString(problem, StandardCharsets.UTF_8).toString();

		return hash;
	}
}
