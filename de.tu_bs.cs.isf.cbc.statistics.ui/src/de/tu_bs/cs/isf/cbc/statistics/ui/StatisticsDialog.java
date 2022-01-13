package de.tu_bs.cs.isf.cbc.statistics.ui;


import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import de.tu_bs.cs.isf.cbc.statistics.RHelper;
import de.tu_bs.cs.isf.cbc.statistics.StatisticsDatabase;
import de.tu_bs.cs.isf.cbc.statistics.StatisticsEntry;


public class StatisticsDialog extends TitleAreaDialog {
	
	private List<?> paths = null;
	private int numberOfDiagrams;
	private List<StatisticsEntry> entries = new LinkedList<StatisticsEntry>();
	private List<IFile> selectedDiagramFiles = new LinkedList<IFile>();
	
	public StatisticsDialog(Shell parentShell) {
		super(parentShell);
	}

	@Override
	public void create() {
		super.create();
		setTitle("Statistics Viewer");
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		GridLayout layout = new GridLayout(2, false);
		container.setLayout(layout);

		createBrowser(container);

		return area;
	}

	private void createBrowser(Composite parent) {
		Browser browser = new Browser(parent, SWT.NONE);
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		browser.setLayoutData(gridData);
		
		HtmlHandler htmlSite = new HtmlHandler();
		htmlSite.setDiagramPaths(paths);
		htmlSite.setData(numberOfDiagrams, entries, selectedDiagramFiles);
		String templateHTML = htmlSite.getHtmlString();
		browser.setText(templateHTML);

		browser.setFocus();
	}

	@Override
	protected boolean isResizable() {
		return true;
	}

	@Override
	protected void okPressed() {
		super.okPressed();
	}

	@Override
	protected void cancelPressed() {
		super.cancelPressed();
	}

	@Override
	protected Point getInitialSize() {
		return new Point(1200, 800);
	}

	public void setData(List<IFile> allDiagramFiles) {
		
		if (allDiagramFiles.size() < 1) {
			de.tu_bs.cs.isf.cbc.util.Console.println("No diagram files selected.");
		}
		else {
			for (IFile file : allDiagramFiles) {
				entries.addAll(StatisticsDatabase.instance.getEntriesRelatedTo(file));
			}
			numberOfDiagrams = allDiagramFiles.size();
			selectedDiagramFiles = allDiagramFiles;
		}
	}

//	private boolean multipleDiagrams(List<StatisticsEntry> entries) {
//
//		boolean moreThanOne = false;
//		
//		for (int i = 0; entries.size() > i; i++) {
//			String outterDiagramName = entries.get(i).getMapping().getCorcDiagramName();
//			for (int j= i + 1; entries.size() > j; j++) {
//				String innerDiagramName = entries.get(j).getMapping().getCorcDiagramName();
//				if (!outterDiagramName.equals(innerDiagramName)) {
//					moreThanOne = true;
//				}
//			}
//			
//		}
//		return moreThanOne;
//	}
}