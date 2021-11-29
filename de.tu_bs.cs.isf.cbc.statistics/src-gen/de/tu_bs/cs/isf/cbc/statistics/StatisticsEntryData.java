/**
 */
package de.tu_bs.cs.isf.cbc.statistics;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Statistics Entry Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.tu_bs.cs.isf.cbc.statistics.StatisticsEntryData#getNumberOfNodes <em>Number Of Nodes</em>}</li>
 *   <li>{@link de.tu_bs.cs.isf.cbc.statistics.StatisticsEntryData#getAutoModeTimeInMillis <em>Auto Mode Time In Millis</em>}</li>
 *   <li>{@link de.tu_bs.cs.isf.cbc.statistics.StatisticsEntryData#getTimeInMillis <em>Time In Millis</em>}</li>
 *   <li>{@link de.tu_bs.cs.isf.cbc.statistics.StatisticsEntryData#getTimePerStepInMillis <em>Time Per Step In Millis</em>}</li>
 * </ul>
 *
 * @see de.tu_bs.cs.isf.cbc.statistics.statisticsPackage#getStatisticsEntryData()
 * @model
 * @generated
 */
public interface StatisticsEntryData extends EObject {

	/**
	 * Returns the value of the '<em><b>Number Of Nodes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Of Nodes</em>' attribute.
	 * @see #setNumberOfNodes(int)
	 * @see de.tu_bs.cs.isf.cbc.statistics.statisticsPackage#getStatisticsEntryData_NumberOfNodes()
	 * @model
	 * @generated
	 */
	int getNumberOfNodes();

	/**
	 * Sets the value of the '{@link de.tu_bs.cs.isf.cbc.statistics.StatisticsEntryData#getNumberOfNodes <em>Number Of Nodes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Of Nodes</em>' attribute.
	 * @see #getNumberOfNodes()
	 * @generated
	 */
	void setNumberOfNodes(int value);

	/**
	 * Returns the value of the '<em><b>Auto Mode Time In Millis</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Auto Mode Time In Millis</em>' attribute.
	 * @see #setAutoModeTimeInMillis(long)
	 * @see de.tu_bs.cs.isf.cbc.statistics.statisticsPackage#getStatisticsEntryData_AutoModeTimeInMillis()
	 * @model
	 * @generated
	 */
	long getAutoModeTimeInMillis();

	/**
	 * Sets the value of the '{@link de.tu_bs.cs.isf.cbc.statistics.StatisticsEntryData#getAutoModeTimeInMillis <em>Auto Mode Time In Millis</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Auto Mode Time In Millis</em>' attribute.
	 * @see #getAutoModeTimeInMillis()
	 * @generated
	 */
	void setAutoModeTimeInMillis(long value);

	/**
	 * Returns the value of the '<em><b>Time In Millis</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time In Millis</em>' attribute.
	 * @see #setTimeInMillis(long)
	 * @see de.tu_bs.cs.isf.cbc.statistics.statisticsPackage#getStatisticsEntryData_TimeInMillis()
	 * @model
	 * @generated
	 */
	long getTimeInMillis();

	/**
	 * Sets the value of the '{@link de.tu_bs.cs.isf.cbc.statistics.StatisticsEntryData#getTimeInMillis <em>Time In Millis</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time In Millis</em>' attribute.
	 * @see #getTimeInMillis()
	 * @generated
	 */
	void setTimeInMillis(long value);

	/**
	 * Returns the value of the '<em><b>Time Per Step In Millis</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Per Step In Millis</em>' attribute.
	 * @see #setTimePerStepInMillis(float)
	 * @see de.tu_bs.cs.isf.cbc.statistics.statisticsPackage#getStatisticsEntryData_TimePerStepInMillis()
	 * @model
	 * @generated
	 */
	float getTimePerStepInMillis();

	/**
	 * Sets the value of the '{@link de.tu_bs.cs.isf.cbc.statistics.StatisticsEntryData#getTimePerStepInMillis <em>Time Per Step In Millis</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Per Step In Millis</em>' attribute.
	 * @see #getTimePerStepInMillis()
	 * @generated
	 */
	void setTimePerStepInMillis(float value);
} // StatisticsEntryData
