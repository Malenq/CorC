package de.tu_bs.cs.isf.cbc.statistics;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

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

	public void getDataRelatedTo(List<IFile> affectedFiles) {
		// TODO: maybe save more redundant information to make it more robust
		
		// TODO: change method to get only one file and not multiple -> more clean
		List<StatisticsEntry> data = new LinkedList<StatisticsEntry>();

		for (IFile file : affectedFiles) {
			List<StatisticsEntry> entries = new LinkedList<StatisticsEntry>();
			for (StatisticsEntry entry : registry.getEntries()) {
				// TODO: mismatch: entry file is KeY file and affected files are diagrams
				// TODO: check if CorcKeyMapping.getKeyFilePath() is null
				String entryPath;
				if (entry.getMapping().getKeyFilePath() != null) {
					entryPath = entry.getMapping().getKeyFilePath().toString();
					
				}
				else continue;
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
					entries.add(entry);
					System.out.println("equal path found");
				}
			}
			
			// now: if there are multiple entries: get the latest (time stamp)
//			data.add(entries.get(entries.size()));
		}

	}
}
