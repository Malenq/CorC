package de.tu_bs.cs.isf.cbc.statistics;

import java.nio.charset.StandardCharsets;

import org.eclipse.emf.ecore.EObject;

import com.google.common.hash.Hashing;

import de.tu_bs.cs.isf.cbc.cbcmodel.AbstractStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.Condition;
import de.tu_bs.cs.isf.cbc.cbcmodel.SelectionStatement;

public class FileNameManager {

	private int selectionCounter;
	private int abstractCounter;

	public String getFileName(String problem, String location, AbstractStatement statement) {

		String hash = Hashing.sha256().hashString(problem, StandardCharsets.UTF_8).toString();
		// TODO: get name from statement
		// match hash with hashes in statistics eobject : if
		// ja was dann... eigentlich macht das hashen doch nur sinn wenn ich wissen will
		// ob genau das problem schon einmal bewiesen wurde...
		// was will ich dann also machen wenn ich das weiﬂ? trotzdem beweisen oder
		// nicht?
		AbstractStatement statementParent = (AbstractStatement) statement.eContainer();

		// namen geben: root finden und dann mit tiefensuche auf eClass reagieren(bei
		// selection statement)
		// beim abstract statement nicht auf eClass reagierne sondern auf letztes blatt
		// (wenn das geht)
		// weil abstract statement als eClass kommt auch innerhalb von composition und
		// so vor

		// root identifizieren: eClass ist CbCFormula

		String statementKind = statement.eClass().getName();

		EObject root = getRoot(statement);

//		root.eContents().get(0)

		// TODO: call by reference is not working (or something else?)
		selectionCounter = 0;
		abstractCounter = 0;
//		if (statementKind == "SelectionStatement") {
		getKindNumber(root, statement);
//		}

//		statement.eContainer()

		int counter;
		if (statementKind == "SelectionStatement") counter = selectionCounter;
		else counter = abstractCounter;
		return "/" + statementKind + counter;
	}

	private boolean getKindNumber(EObject root, AbstractStatement statement) {

		// depth-first search for selection statement
		// different approach needed for abstract statement

		for (int i = 0; i < root.eContents().size(); i++) {
			EObject content = root.eContents().get(i);
			if (content instanceof Condition) {
				continue;
			}
//			if (content.eClass().getName().equals("SelectionStatement")) 
			if (content instanceof SelectionStatement)
				selectionCounter = selectionCounter + 1;
			if (content.equals(statement))
				return true;

			// if there are no children: counter for abstract statement can be increased by
			// 1
			if (content.eContents().size() > 0) 
				if (getKindNumber(content, statement))
					return true;
				
//			return counter;
		}
		return false;
	}

	private EObject getRoot(AbstractStatement statement) {

		EObject currentObject = statement.eContainer();
		while (currentObject.eClass().getName() != "CbCFormula") {
			currentObject = currentObject.eContainer();
		}
		return currentObject;
	}

}
