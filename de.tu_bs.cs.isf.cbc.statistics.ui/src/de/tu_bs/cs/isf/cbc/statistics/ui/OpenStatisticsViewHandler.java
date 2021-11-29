package de.tu_bs.cs.isf.cbc.statistics.ui;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.handlers.HandlerUtil;

import de.tu_bs.cs.isf.cbc.statistics.RHelper;

public class OpenStatisticsViewHandler extends AbstractHandler {

	// TODO: get the name of a diagram and find already executed proofs related to it
	// TODO: if a package or folder or something is clicked -> collect statistics for multiple diagrams
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		ISelection selection = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().getSelection();
		if (selection != null & selection instanceof IStructuredSelection) {
			IStructuredSelection strucSelection = (IStructuredSelection) selection;
			List<IFile> fileList = strucSelection.toList();
//			for (Object file : fileList) {
////				if (!(file instanceof IFile)) {
////					throw new ExecutionException("Select only Files.");
////				}
//			}
			
			System.out.println(fileList);
//			VerifyThread thread = new VerifyThread(fileList);
//			thread.start();
		}
		
		RHelper helper = new RHelper();
		// this will return PNG in future (or similar)
		helper.doSomethingToShow();
		// TODO PNG to dialog -> feed into HTML string or similar
		
		StatisticsDialog dialog = new StatisticsDialog(Display.getCurrent().getActiveShell());
		dialog.open();
		
		return null;
	}

}
