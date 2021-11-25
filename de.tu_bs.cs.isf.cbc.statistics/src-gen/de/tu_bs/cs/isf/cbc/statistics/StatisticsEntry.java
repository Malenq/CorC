/**
 */
package de.tu_bs.cs.isf.cbc.statistics;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Statistics Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.tu_bs.cs.isf.cbc.statistics.StatisticsEntry#getKeyFilePath <em>Key File Path</em>}</li>
 *   <li>{@link de.tu_bs.cs.isf.cbc.statistics.StatisticsEntry#getCorcElement <em>Corc Element</em>}</li>
 *   <li>{@link de.tu_bs.cs.isf.cbc.statistics.StatisticsEntry#getData <em>Data</em>}</li>
 * </ul>
 *
 * @see de.tu_bs.cs.isf.cbc.statistics.statisticsPackage#getStatisticsEntry()
 * @model
 * @generated
 */
public interface StatisticsEntry extends EObject {
	/**
	 * Returns the value of the '<em><b>Key File Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Key File Path</em>' attribute.
	 * @see #setKeyFilePath(String)
	 * @see de.tu_bs.cs.isf.cbc.statistics.statisticsPackage#getStatisticsEntry_KeyFilePath()
	 * @model required="true"
	 * @generated
	 */
	String getKeyFilePath();

	/**
	 * Sets the value of the '{@link de.tu_bs.cs.isf.cbc.statistics.StatisticsEntry#getKeyFilePath <em>Key File Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Key File Path</em>' attribute.
	 * @see #getKeyFilePath()
	 * @generated
	 */
	void setKeyFilePath(String value);

	/**
	 * Returns the value of the '<em><b>Corc Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Corc Element</em>' reference.
	 * @see #setCorcElement(EObject)
	 * @see de.tu_bs.cs.isf.cbc.statistics.statisticsPackage#getStatisticsEntry_CorcElement()
	 * @model required="true"
	 * @generated
	 */
	EObject getCorcElement();

	/**
	 * Sets the value of the '{@link de.tu_bs.cs.isf.cbc.statistics.StatisticsEntry#getCorcElement <em>Corc Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Corc Element</em>' reference.
	 * @see #getCorcElement()
	 * @generated
	 */
	void setCorcElement(EObject value);

	/**
	 * Returns the value of the '<em><b>Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data</em>' containment reference.
	 * @see #setData(StatisticsEntryData)
	 * @see de.tu_bs.cs.isf.cbc.statistics.statisticsPackage#getStatisticsEntry_Data()
	 * @model containment="true" required="true"
	 * @generated
	 */
	StatisticsEntryData getData();

	/**
	 * Sets the value of the '{@link de.tu_bs.cs.isf.cbc.statistics.StatisticsEntry#getData <em>Data</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data</em>' containment reference.
	 * @see #getData()
	 * @generated
	 */
	void setData(StatisticsEntryData value);

} // StatisticsEntry
