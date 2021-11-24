package de.tu_bs.cs.isf.cbc.statistics.ui;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.swt.widgets.Display;

public class OpenStatisticsViewHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		StatisticsDialog dialog = new StatisticsDialog(Display.getCurrent().getActiveShell());
		dialog.open();
		
		return null;
	}

}
