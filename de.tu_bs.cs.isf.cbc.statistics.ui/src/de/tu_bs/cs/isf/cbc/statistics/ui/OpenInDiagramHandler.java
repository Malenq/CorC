package de.tu_bs.cs.isf.cbc.statistics.ui;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

public class OpenInDiagramHandler extends AbstractHandler {

	// TODO: get the name of a diagram and find already executed proofs related to it
	// TODO: if a package or folder or something is clicked -> collect statistics for multiple diagrams
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
//		ISelection selection = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().getSelection();
//		List<IResource> resourceList = new LinkedList<>();
//		
//		if (selection != null & selection instanceof IStructuredSelection) {
//			IStructuredSelection strucSelection = (IStructuredSelection) selection;
//			for(Object selectedElement : strucSelection.toList()) {
//				if(selectedElement instanceof IJavaElement) {
//					IResource res = ((IJavaElement) selectedElement).getResource();
//					resourceList.add(res);
//				}
//				else if(selectedElement instanceof IResource) {
//					resourceList.add((IResource) selectedElement);
//				}
//			}
//		}
		

		de.tu_bs.cs.isf.cbc.util.Console.println("Error: Could not find a matching statement.");
		
		return null;
	}
}
