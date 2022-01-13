package de.tu_bs.cs.isf.cbc.cbcmodel.impl;

import de.tu_bs.cs.isf.cbc.cbcmodel.AbstractStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.CompositionStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.ReturnStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.SelectionStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.SkipStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.SmallRepetitionStatement;

public class CbcmodelFactoryCustom extends CbcmodelFactoryImpl {

	public static void setId(AbstractStatement statement) {
		if(statement.getId() == null)
			statement.setId(java.util.UUID.randomUUID().toString());
	}

	@Override
	public AbstractStatement createAbstractStatement() {
		AbstractStatementImpl abstractStatement = new AbstractStatementImpl();
		setId(abstractStatement);
		return abstractStatement;
	}

	@Override
	public SkipStatement createSkipStatement() {
		SkipStatementImpl skipStatement = new SkipStatementImpl();
		setId(skipStatement);
		return skipStatement;
	}

	@Override
	public CompositionStatement createCompositionStatement() {
		CompositionStatementImpl compositionStatement = new CompositionStatementImpl();
		setId(compositionStatement);
		return compositionStatement;
	}

	@Override
	public SelectionStatement createSelectionStatement() {
		SelectionStatementImpl selectionStatement = new SelectionStatementImpl();
		setId(selectionStatement);
		return selectionStatement;
	}

	@Override
	public ReturnStatement createReturnStatement() {
		ReturnStatementImpl returnStatement = new ReturnStatementImpl();
		setId(returnStatement);
		return returnStatement;
	}

	@Override
	public SmallRepetitionStatement createSmallRepetitionStatement() {
		SmallRepetitionStatementImpl smallRepetitionStatement = new SmallRepetitionStatementImpl();
		setId(smallRepetitionStatement);
		return smallRepetitionStatement;
	}
}
