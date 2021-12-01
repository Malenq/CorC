/**
 */
package de.tu_bs.cs.isf.cbc.statistics.impl;

import de.tu_bs.cs.isf.cbc.statistics.StatisticsEntry;
import de.tu_bs.cs.isf.cbc.statistics.StatisticsEntryData;
import de.tu_bs.cs.isf.cbc.statistics.StatisticsRegistry;
import de.tu_bs.cs.isf.cbc.statistics.statisticsFactory;
import de.tu_bs.cs.isf.cbc.statistics.statisticsPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class statisticsPackageImpl extends EPackageImpl implements statisticsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass statisticsRegistryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass statisticsEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass statisticsEntryDataEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see de.tu_bs.cs.isf.cbc.statistics.statisticsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private statisticsPackageImpl() {
		super(eNS_URI, statisticsFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link statisticsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static statisticsPackage init() {
		if (isInited) return (statisticsPackage)EPackage.Registry.INSTANCE.getEPackage(statisticsPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredstatisticsPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		statisticsPackageImpl thestatisticsPackage = registeredstatisticsPackage instanceof statisticsPackageImpl ? (statisticsPackageImpl)registeredstatisticsPackage : new statisticsPackageImpl();

		isInited = true;

		// Create package meta-data objects
		thestatisticsPackage.createPackageContents();

		// Initialize created meta-data
		thestatisticsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thestatisticsPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(statisticsPackage.eNS_URI, thestatisticsPackage);
		return thestatisticsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStatisticsRegistry() {
		return statisticsRegistryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStatisticsRegistry_Entries() {
		return (EReference)statisticsRegistryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStatisticsEntry() {
		return statisticsEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStatisticsEntry_KeyFilePath() {
		return (EAttribute)statisticsEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStatisticsEntry_CorcElement() {
		return (EReference)statisticsEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStatisticsEntry_Data() {
		return (EReference)statisticsEntryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStatisticsEntryData() {
		return statisticsEntryDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStatisticsEntryData_NumberOfNodes() {
		return (EAttribute)statisticsEntryDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStatisticsEntryData_AutoModeTimeInMillis() {
		return (EAttribute)statisticsEntryDataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStatisticsEntryData_TimeInMillis() {
		return (EAttribute)statisticsEntryDataEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStatisticsEntryData_TimePerStepInMillis() {
		return (EAttribute)statisticsEntryDataEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStatisticsEntryData_NumberOfBranches() {
		return (EAttribute)statisticsEntryDataEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStatisticsEntryData_TotalRuleApps() {
		return (EAttribute)statisticsEntryDataEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public statisticsFactory getstatisticsFactory() {
		return (statisticsFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		statisticsRegistryEClass = createEClass(STATISTICS_REGISTRY);
		createEReference(statisticsRegistryEClass, STATISTICS_REGISTRY__ENTRIES);

		statisticsEntryEClass = createEClass(STATISTICS_ENTRY);
		createEAttribute(statisticsEntryEClass, STATISTICS_ENTRY__KEY_FILE_PATH);
		createEReference(statisticsEntryEClass, STATISTICS_ENTRY__CORC_ELEMENT);
		createEReference(statisticsEntryEClass, STATISTICS_ENTRY__DATA);

		statisticsEntryDataEClass = createEClass(STATISTICS_ENTRY_DATA);
		createEAttribute(statisticsEntryDataEClass, STATISTICS_ENTRY_DATA__NUMBER_OF_NODES);
		createEAttribute(statisticsEntryDataEClass, STATISTICS_ENTRY_DATA__AUTO_MODE_TIME_IN_MILLIS);
		createEAttribute(statisticsEntryDataEClass, STATISTICS_ENTRY_DATA__TIME_IN_MILLIS);
		createEAttribute(statisticsEntryDataEClass, STATISTICS_ENTRY_DATA__TIME_PER_STEP_IN_MILLIS);
		createEAttribute(statisticsEntryDataEClass, STATISTICS_ENTRY_DATA__NUMBER_OF_BRANCHES);
		createEAttribute(statisticsEntryDataEClass, STATISTICS_ENTRY_DATA__TOTAL_RULE_APPS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(statisticsRegistryEClass, StatisticsRegistry.class, "StatisticsRegistry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStatisticsRegistry_Entries(), this.getStatisticsEntry(), null, "entries", null, 0, -1, StatisticsRegistry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(statisticsEntryEClass, StatisticsEntry.class, "StatisticsEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStatisticsEntry_KeyFilePath(), ecorePackage.getEString(), "keyFilePath", null, 1, 1, StatisticsEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStatisticsEntry_CorcElement(), ecorePackage.getEObject(), null, "corcElement", null, 1, 1, StatisticsEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStatisticsEntry_Data(), this.getStatisticsEntryData(), null, "data", null, 1, 1, StatisticsEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(statisticsEntryDataEClass, StatisticsEntryData.class, "StatisticsEntryData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStatisticsEntryData_NumberOfNodes(), ecorePackage.getEInt(), "numberOfNodes", null, 0, 1, StatisticsEntryData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStatisticsEntryData_AutoModeTimeInMillis(), ecorePackage.getELong(), "autoModeTimeInMillis", null, 0, 1, StatisticsEntryData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStatisticsEntryData_TimeInMillis(), ecorePackage.getELong(), "timeInMillis", null, 0, 1, StatisticsEntryData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStatisticsEntryData_TimePerStepInMillis(), ecorePackage.getEFloat(), "timePerStepInMillis", null, 0, 1, StatisticsEntryData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStatisticsEntryData_NumberOfBranches(), ecorePackage.getEInt(), "numberOfBranches", null, 0, 1, StatisticsEntryData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStatisticsEntryData_TotalRuleApps(), ecorePackage.getEInt(), "totalRuleApps", null, 0, 1, StatisticsEntryData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //statisticsPackageImpl
