package de.tu_bs.cs.isf.cbc.tool.helper;

import org.eclipse.graphiti.pattern.id.IdUpdateContext;

import de.tu_bs.cs.isf.cbc.cbcmodel.AbstractStatement;

public class HighlightHelper {
	
	public static final HighlightHelper instance = new HighlightHelper();
	
	private HighlightHelper() {}
	
	
	
	private String elementToHighlightID;
	
	public void registerElementToHighlight(String highlightID) {
		elementToHighlightID = highlightID;
	}
	
	public boolean elementNeedsHighlighting(IdUpdateContext context) {
		if(elementToHighlightID != null) {
			if(context.getDomainObject() instanceof AbstractStatement) {
				String contextElementID = ((AbstractStatement) context.getDomainObject()).getId();
				if(contextElementID.equals(elementToHighlightID)) {
					// TODO: check if was previously highlighted and needs to be unhighlighted...
					return true;
				}
			}
		}
		return false;
	}

	public void reset() {
		this.elementToHighlightID = null;
	}

}
