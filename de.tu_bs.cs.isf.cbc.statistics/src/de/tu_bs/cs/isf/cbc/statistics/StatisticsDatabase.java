package de.tu_bs.cs.isf.cbc.statistics;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import de.tu_bs.cs.isf.cbc.cbcmodel.AbstractStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.CbCFormula;

public class StatisticsDatabase {

	private static final String PLUGIN_ID = "de.tu_bs.cs.isf.cbc.statistics";

	public static StatisticsDatabase instance = new StatisticsDatabase();

	private StatisticsRegistry registry;
	private ResourceSet resourceSet = new ResourceSetImpl();

	private StatisticsDatabase() {
		IPath pluginStateFolderPath = Platform.getStateLocation(Platform.getBundle(PLUGIN_ID));
		File pluginStateFolder = pluginStateFolderPath.toFile();

		String folderName = "XMLStatisticsDatabase";

		String rootLocation = pluginStateFolder.getAbsolutePath() + File.separator + folderName + File.separator;
		File rFile = new File(rootLocation);
		rFile.mkdir();

		String xmlLocation = rootLocation + "satisticsDatabase.xml";
		Resource resource;
		try {
			resource = resourceSet.getResource(URI.createFileURI(xmlLocation), true);
		} catch (Exception e) {
			resource = resourceSet.createResource(URI.createFileURI(xmlLocation));
		}
		if (resource.getContents().isEmpty()) {
			resource.getContents().add(statisticsFactory.eINSTANCE.createStatisticsRegistry());
		}
		registry = (StatisticsRegistry) resource.getContents().get(0);
	}

	public void saveToDatabase(StatisticsEntry entry) {
		registry.getEntries().add(entry);
		saveRegistry();
	}

	private void saveRegistry() {
		try {
			registry.eResource().save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<StatisticsEntry> getEntriesRelatedTo(IFile file) {
		// TODO: maybe save more redundant information to make it more robust

		List<StatisticsEntry> validDBEntries = new LinkedList<StatisticsEntry>();

		System.out.println("File: " + file);
		List<StatisticsEntry> affectedEntriesInDB = new LinkedList<StatisticsEntry>();
		for (StatisticsEntry entry : registry.getEntries()) {
			// TODO: mismatch: entry file is KeY file and affected files are diagrams
			// TODO: check if CorcKeyMapping.getKeyFilePath() is null

			// TODO: replace entryPath with diagram name which is new in statistics model
			String entryPath;
			if (entry.getMapping().getKeyFilePath() != null) {
				entryPath = entry.getMapping().getKeyFilePath().toString();

			} else
				continue;
//				Path filePath = new Path(file.getRawLocation().toString());

			String filePath = file.getFullPath().toString();
			int indexLastSeparator = filePath.lastIndexOf("/") + 1;
			int indexExtension = filePath.indexOf(".diagram");
			String affectedDiagram = filePath.substring(indexLastSeparator, indexExtension);

			int indexLastSeperatorEntry = entryPath.lastIndexOf(File.separator);
			entryPath = entryPath.substring(0, indexLastSeperatorEntry);
			// adding 6 because of prove string
			indexLastSeperatorEntry = entryPath.lastIndexOf(File.separator) + 6;

			String entryFolder = entryPath.substring(indexLastSeperatorEntry, entryPath.length());

//				System.out.println(affectedDiagram);
			if (entryFolder.equals(affectedDiagram)) {
				affectedEntriesInDB.add(entry);
				System.out.println("equal path found");
			}
		}

		if (!affectedEntriesInDB.isEmpty()) {
			affectedEntriesInDB = removeOutdated(affectedEntriesInDB);
			validDBEntries.addAll(getLatestEntriesWithRedundantID(affectedEntriesInDB));
		}

		return validDBEntries;

	}

	private List<StatisticsEntry> removeOutdated(List<StatisticsEntry> entries) {

		List<StatisticsEntry> validEntries = new LinkedList<StatisticsEntry>();

		for (StatisticsEntry entry : entries) {
			String elementId = entry.getMapping().getCorcElementId();
			String pathString = entry.getMapping().getCorcDiagramPath();
			if (!isOutdated(elementId, pathString)) {
				validEntries.add(entry);
			}
		}
		return validEntries;
	}

	public boolean isOutdated(String elementId, String pathString) {

		pathString = pathString.replace(".diagram", ".cbcmodel");
		URI uri = URI.createPlatformResourceURI(pathString, false);

		Resource resource;
		try {
			resource = resourceSet.getResource(uri, true);
		} catch (Exception e) {
			resource = resourceSet.createResource(uri);
		}
		CbCFormula formula;
		formula = (CbCFormula) resource.getContents().get(0);

		if (findAbstractStatementById(formula, elementId) == null) {
			System.out.println("id doeas not exist");
			return true;
		}

		return false;
	}

	private AbstractStatement findAbstractStatementById(EObject e, String id) {
		if (e instanceof AbstractStatement) {
			if (((AbstractStatement) e).getId().equals(id))
				return (AbstractStatement) e;
		}
		// e is not what we are looking for!
		for (EObject child : e.eContents()) {
			AbstractStatement foundStmt = findAbstractStatementById(child, id);
			if (foundStmt != null)
				return foundStmt;
		}
		return null;
	}

	private List<StatisticsEntry> getLatestEntriesWithRedundantID(List<StatisticsEntry> entries) {

		List<StatisticsEntry> olderEntriesWithRedundantId = new LinkedList<StatisticsEntry>();
		
		for (int i = 0; entries.size() > i; i++) {
			StatisticsEntry outterEntry = entries.get(i);
			String id = outterEntry.getMapping().getCorcElementId();
			for (int j = i + 1;  entries.size() > j; j ++ ) {
				StatisticsEntry innerEntry = entries.get(j);
				if (id.equals(entries.get(j).getMapping().getCorcElementId())) {

					Date outterEntryDate = outterEntry.getData().getTimestamp();
					Date innerEntryDate = innerEntry.getData().getTimestamp();
					if (outterEntryDate.after(innerEntryDate)) {
						olderEntriesWithRedundantId.add(innerEntry);
					}
					else {
						olderEntriesWithRedundantId.add(outterEntry);
					}
				}
			}
		}
		entries.removeAll(olderEntriesWithRedundantId);	
		return entries;
	}
}
