/**
 */
package de.tu_bs.cs.isf.cbc.statistics;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.tu_bs.cs.isf.cbc.statistics.statisticsFactory
 * @model kind="package"
 * @generated
 */
public interface statisticsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "statistics";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "https://www.tu-braunschweig.de/isf/statistics";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "statistics";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	statisticsPackage eINSTANCE = de.tu_bs.cs.isf.cbc.statistics.impl.statisticsPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.tu_bs.cs.isf.cbc.statistics.impl.StatisticsRegistryImpl <em>Statistics Registry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tu_bs.cs.isf.cbc.statistics.impl.StatisticsRegistryImpl
	 * @see de.tu_bs.cs.isf.cbc.statistics.impl.statisticsPackageImpl#getStatisticsRegistry()
	 * @generated
	 */
	int STATISTICS_REGISTRY = 0;

	/**
	 * The feature id for the '<em><b>Entries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATISTICS_REGISTRY__ENTRIES = 0;

	/**
	 * The number of structural features of the '<em>Statistics Registry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATISTICS_REGISTRY_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Statistics Registry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATISTICS_REGISTRY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.tu_bs.cs.isf.cbc.statistics.impl.StatisticsEntryImpl <em>Statistics Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tu_bs.cs.isf.cbc.statistics.impl.StatisticsEntryImpl
	 * @see de.tu_bs.cs.isf.cbc.statistics.impl.statisticsPackageImpl#getStatisticsEntry()
	 * @generated
	 */
	int STATISTICS_ENTRY = 1;

	/**
	 * The feature id for the '<em><b>Key File Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATISTICS_ENTRY__KEY_FILE_PATH = 0;

	/**
	 * The feature id for the '<em><b>Corc Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATISTICS_ENTRY__CORC_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATISTICS_ENTRY__DATA = 2;

	/**
	 * The number of structural features of the '<em>Statistics Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATISTICS_ENTRY_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Statistics Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATISTICS_ENTRY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.tu_bs.cs.isf.cbc.statistics.impl.StatisticsEntryDataImpl <em>Statistics Entry Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tu_bs.cs.isf.cbc.statistics.impl.StatisticsEntryDataImpl
	 * @see de.tu_bs.cs.isf.cbc.statistics.impl.statisticsPackageImpl#getStatisticsEntryData()
	 * @generated
	 */
	int STATISTICS_ENTRY_DATA = 2;

	/**
	 * The feature id for the '<em><b>Number Of Nodes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATISTICS_ENTRY_DATA__NUMBER_OF_NODES = 0;

	/**
	 * The feature id for the '<em><b>Auto Mode Time In Millis</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATISTICS_ENTRY_DATA__AUTO_MODE_TIME_IN_MILLIS = 1;

	/**
	 * The feature id for the '<em><b>Time In Millis</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATISTICS_ENTRY_DATA__TIME_IN_MILLIS = 2;

	/**
	 * The feature id for the '<em><b>Time Per Step In Millis</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATISTICS_ENTRY_DATA__TIME_PER_STEP_IN_MILLIS = 3;

	/**
	 * The feature id for the '<em><b>Number Of Branches</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATISTICS_ENTRY_DATA__NUMBER_OF_BRANCHES = 4;

	/**
	 * The feature id for the '<em><b>Total Rule Apps</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATISTICS_ENTRY_DATA__TOTAL_RULE_APPS = 5;

	/**
	 * The number of structural features of the '<em>Statistics Entry Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATISTICS_ENTRY_DATA_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Statistics Entry Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATISTICS_ENTRY_DATA_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link de.tu_bs.cs.isf.cbc.statistics.StatisticsRegistry <em>Statistics Registry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Statistics Registry</em>'.
	 * @see de.tu_bs.cs.isf.cbc.statistics.StatisticsRegistry
	 * @generated
	 */
	EClass getStatisticsRegistry();

	/**
	 * Returns the meta object for the containment reference list '{@link de.tu_bs.cs.isf.cbc.statistics.StatisticsRegistry#getEntries <em>Entries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Entries</em>'.
	 * @see de.tu_bs.cs.isf.cbc.statistics.StatisticsRegistry#getEntries()
	 * @see #getStatisticsRegistry()
	 * @generated
	 */
	EReference getStatisticsRegistry_Entries();

	/**
	 * Returns the meta object for class '{@link de.tu_bs.cs.isf.cbc.statistics.StatisticsEntry <em>Statistics Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Statistics Entry</em>'.
	 * @see de.tu_bs.cs.isf.cbc.statistics.StatisticsEntry
	 * @generated
	 */
	EClass getStatisticsEntry();

	/**
	 * Returns the meta object for the attribute '{@link de.tu_bs.cs.isf.cbc.statistics.StatisticsEntry#getKeyFilePath <em>Key File Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key File Path</em>'.
	 * @see de.tu_bs.cs.isf.cbc.statistics.StatisticsEntry#getKeyFilePath()
	 * @see #getStatisticsEntry()
	 * @generated
	 */
	EAttribute getStatisticsEntry_KeyFilePath();

	/**
	 * Returns the meta object for the reference '{@link de.tu_bs.cs.isf.cbc.statistics.StatisticsEntry#getCorcElement <em>Corc Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Corc Element</em>'.
	 * @see de.tu_bs.cs.isf.cbc.statistics.StatisticsEntry#getCorcElement()
	 * @see #getStatisticsEntry()
	 * @generated
	 */
	EReference getStatisticsEntry_CorcElement();

	/**
	 * Returns the meta object for the containment reference '{@link de.tu_bs.cs.isf.cbc.statistics.StatisticsEntry#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Data</em>'.
	 * @see de.tu_bs.cs.isf.cbc.statistics.StatisticsEntry#getData()
	 * @see #getStatisticsEntry()
	 * @generated
	 */
	EReference getStatisticsEntry_Data();

	/**
	 * Returns the meta object for class '{@link de.tu_bs.cs.isf.cbc.statistics.StatisticsEntryData <em>Statistics Entry Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Statistics Entry Data</em>'.
	 * @see de.tu_bs.cs.isf.cbc.statistics.StatisticsEntryData
	 * @generated
	 */
	EClass getStatisticsEntryData();

	/**
	 * Returns the meta object for the attribute '{@link de.tu_bs.cs.isf.cbc.statistics.StatisticsEntryData#getNumberOfNodes <em>Number Of Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number Of Nodes</em>'.
	 * @see de.tu_bs.cs.isf.cbc.statistics.StatisticsEntryData#getNumberOfNodes()
	 * @see #getStatisticsEntryData()
	 * @generated
	 */
	EAttribute getStatisticsEntryData_NumberOfNodes();

	/**
	 * Returns the meta object for the attribute '{@link de.tu_bs.cs.isf.cbc.statistics.StatisticsEntryData#getAutoModeTimeInMillis <em>Auto Mode Time In Millis</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Auto Mode Time In Millis</em>'.
	 * @see de.tu_bs.cs.isf.cbc.statistics.StatisticsEntryData#getAutoModeTimeInMillis()
	 * @see #getStatisticsEntryData()
	 * @generated
	 */
	EAttribute getStatisticsEntryData_AutoModeTimeInMillis();

	/**
	 * Returns the meta object for the attribute '{@link de.tu_bs.cs.isf.cbc.statistics.StatisticsEntryData#getTimeInMillis <em>Time In Millis</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time In Millis</em>'.
	 * @see de.tu_bs.cs.isf.cbc.statistics.StatisticsEntryData#getTimeInMillis()
	 * @see #getStatisticsEntryData()
	 * @generated
	 */
	EAttribute getStatisticsEntryData_TimeInMillis();

	/**
	 * Returns the meta object for the attribute '{@link de.tu_bs.cs.isf.cbc.statistics.StatisticsEntryData#getTimePerStepInMillis <em>Time Per Step In Millis</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time Per Step In Millis</em>'.
	 * @see de.tu_bs.cs.isf.cbc.statistics.StatisticsEntryData#getTimePerStepInMillis()
	 * @see #getStatisticsEntryData()
	 * @generated
	 */
	EAttribute getStatisticsEntryData_TimePerStepInMillis();

	/**
	 * Returns the meta object for the attribute '{@link de.tu_bs.cs.isf.cbc.statistics.StatisticsEntryData#getNumberOfBranches <em>Number Of Branches</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number Of Branches</em>'.
	 * @see de.tu_bs.cs.isf.cbc.statistics.StatisticsEntryData#getNumberOfBranches()
	 * @see #getStatisticsEntryData()
	 * @generated
	 */
	EAttribute getStatisticsEntryData_NumberOfBranches();

	/**
	 * Returns the meta object for the attribute '{@link de.tu_bs.cs.isf.cbc.statistics.StatisticsEntryData#getTotalRuleApps <em>Total Rule Apps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total Rule Apps</em>'.
	 * @see de.tu_bs.cs.isf.cbc.statistics.StatisticsEntryData#getTotalRuleApps()
	 * @see #getStatisticsEntryData()
	 * @generated
	 */
	EAttribute getStatisticsEntryData_TotalRuleApps();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	statisticsFactory getstatisticsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.tu_bs.cs.isf.cbc.statistics.impl.StatisticsRegistryImpl <em>Statistics Registry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tu_bs.cs.isf.cbc.statistics.impl.StatisticsRegistryImpl
		 * @see de.tu_bs.cs.isf.cbc.statistics.impl.statisticsPackageImpl#getStatisticsRegistry()
		 * @generated
		 */
		EClass STATISTICS_REGISTRY = eINSTANCE.getStatisticsRegistry();

		/**
		 * The meta object literal for the '<em><b>Entries</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATISTICS_REGISTRY__ENTRIES = eINSTANCE.getStatisticsRegistry_Entries();

		/**
		 * The meta object literal for the '{@link de.tu_bs.cs.isf.cbc.statistics.impl.StatisticsEntryImpl <em>Statistics Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tu_bs.cs.isf.cbc.statistics.impl.StatisticsEntryImpl
		 * @see de.tu_bs.cs.isf.cbc.statistics.impl.statisticsPackageImpl#getStatisticsEntry()
		 * @generated
		 */
		EClass STATISTICS_ENTRY = eINSTANCE.getStatisticsEntry();

		/**
		 * The meta object literal for the '<em><b>Key File Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATISTICS_ENTRY__KEY_FILE_PATH = eINSTANCE.getStatisticsEntry_KeyFilePath();

		/**
		 * The meta object literal for the '<em><b>Corc Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATISTICS_ENTRY__CORC_ELEMENT = eINSTANCE.getStatisticsEntry_CorcElement();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATISTICS_ENTRY__DATA = eINSTANCE.getStatisticsEntry_Data();

		/**
		 * The meta object literal for the '{@link de.tu_bs.cs.isf.cbc.statistics.impl.StatisticsEntryDataImpl <em>Statistics Entry Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tu_bs.cs.isf.cbc.statistics.impl.StatisticsEntryDataImpl
		 * @see de.tu_bs.cs.isf.cbc.statistics.impl.statisticsPackageImpl#getStatisticsEntryData()
		 * @generated
		 */
		EClass STATISTICS_ENTRY_DATA = eINSTANCE.getStatisticsEntryData();

		/**
		 * The meta object literal for the '<em><b>Number Of Nodes</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATISTICS_ENTRY_DATA__NUMBER_OF_NODES = eINSTANCE.getStatisticsEntryData_NumberOfNodes();

		/**
		 * The meta object literal for the '<em><b>Auto Mode Time In Millis</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATISTICS_ENTRY_DATA__AUTO_MODE_TIME_IN_MILLIS = eINSTANCE.getStatisticsEntryData_AutoModeTimeInMillis();

		/**
		 * The meta object literal for the '<em><b>Time In Millis</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATISTICS_ENTRY_DATA__TIME_IN_MILLIS = eINSTANCE.getStatisticsEntryData_TimeInMillis();

		/**
		 * The meta object literal for the '<em><b>Time Per Step In Millis</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATISTICS_ENTRY_DATA__TIME_PER_STEP_IN_MILLIS = eINSTANCE.getStatisticsEntryData_TimePerStepInMillis();

		/**
		 * The meta object literal for the '<em><b>Number Of Branches</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATISTICS_ENTRY_DATA__NUMBER_OF_BRANCHES = eINSTANCE.getStatisticsEntryData_NumberOfBranches();

		/**
		 * The meta object literal for the '<em><b>Total Rule Apps</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATISTICS_ENTRY_DATA__TOTAL_RULE_APPS = eINSTANCE.getStatisticsEntryData_TotalRuleApps();

	}

} //statisticsPackage
