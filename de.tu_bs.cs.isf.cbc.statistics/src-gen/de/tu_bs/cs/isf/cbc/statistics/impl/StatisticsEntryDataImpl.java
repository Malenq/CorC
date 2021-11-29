/**
 */
package de.tu_bs.cs.isf.cbc.statistics.impl;

import de.tu_bs.cs.isf.cbc.statistics.StatisticsEntryData;
import de.tu_bs.cs.isf.cbc.statistics.statisticsPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Statistics Entry Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.tu_bs.cs.isf.cbc.statistics.impl.StatisticsEntryDataImpl#getNumberOfNodes <em>Number Of Nodes</em>}</li>
 *   <li>{@link de.tu_bs.cs.isf.cbc.statistics.impl.StatisticsEntryDataImpl#getAutoModeTimeInMillis <em>Auto Mode Time In Millis</em>}</li>
 *   <li>{@link de.tu_bs.cs.isf.cbc.statistics.impl.StatisticsEntryDataImpl#getTimeInMillis <em>Time In Millis</em>}</li>
 *   <li>{@link de.tu_bs.cs.isf.cbc.statistics.impl.StatisticsEntryDataImpl#getTimePerStepInMillis <em>Time Per Step In Millis</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StatisticsEntryDataImpl extends MinimalEObjectImpl.Container implements StatisticsEntryData {
	/**
	 * The default value of the '{@link #getNumberOfNodes() <em>Number Of Nodes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOfNodes()
	 * @generated
	 * @ordered
	 */
	protected static final int NUMBER_OF_NODES_EDEFAULT = 0;
	/**
	 * The cached value of the '{@link #getNumberOfNodes() <em>Number Of Nodes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOfNodes()
	 * @generated
	 * @ordered
	 */
	protected int numberOfNodes = NUMBER_OF_NODES_EDEFAULT;

	/**
	 * The default value of the '{@link #getAutoModeTimeInMillis() <em>Auto Mode Time In Millis</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAutoModeTimeInMillis()
	 * @generated
	 * @ordered
	 */
	protected static final long AUTO_MODE_TIME_IN_MILLIS_EDEFAULT = 0L;
	/**
	 * The cached value of the '{@link #getAutoModeTimeInMillis() <em>Auto Mode Time In Millis</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAutoModeTimeInMillis()
	 * @generated
	 * @ordered
	 */
	protected long autoModeTimeInMillis = AUTO_MODE_TIME_IN_MILLIS_EDEFAULT;
	/**
	 * The default value of the '{@link #getTimeInMillis() <em>Time In Millis</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeInMillis()
	 * @generated
	 * @ordered
	 */
	protected static final long TIME_IN_MILLIS_EDEFAULT = 0L;
	/**
	 * The cached value of the '{@link #getTimeInMillis() <em>Time In Millis</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeInMillis()
	 * @generated
	 * @ordered
	 */
	protected long timeInMillis = TIME_IN_MILLIS_EDEFAULT;
	/**
	 * The default value of the '{@link #getTimePerStepInMillis() <em>Time Per Step In Millis</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimePerStepInMillis()
	 * @generated
	 * @ordered
	 */
	protected static final float TIME_PER_STEP_IN_MILLIS_EDEFAULT = 0.0F;
	/**
	 * The cached value of the '{@link #getTimePerStepInMillis() <em>Time Per Step In Millis</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimePerStepInMillis()
	 * @generated
	 * @ordered
	 */
	protected float timePerStepInMillis = TIME_PER_STEP_IN_MILLIS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StatisticsEntryDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return statisticsPackage.Literals.STATISTICS_ENTRY_DATA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNumberOfNodes() {
		return numberOfNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumberOfNodes(int newNumberOfNodes) {
		int oldNumberOfNodes = numberOfNodes;
		numberOfNodes = newNumberOfNodes;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, statisticsPackage.STATISTICS_ENTRY_DATA__NUMBER_OF_NODES, oldNumberOfNodes, numberOfNodes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getAutoModeTimeInMillis() {
		return autoModeTimeInMillis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAutoModeTimeInMillis(long newAutoModeTimeInMillis) {
		long oldAutoModeTimeInMillis = autoModeTimeInMillis;
		autoModeTimeInMillis = newAutoModeTimeInMillis;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, statisticsPackage.STATISTICS_ENTRY_DATA__AUTO_MODE_TIME_IN_MILLIS, oldAutoModeTimeInMillis, autoModeTimeInMillis));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getTimeInMillis() {
		return timeInMillis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeInMillis(long newTimeInMillis) {
		long oldTimeInMillis = timeInMillis;
		timeInMillis = newTimeInMillis;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, statisticsPackage.STATISTICS_ENTRY_DATA__TIME_IN_MILLIS, oldTimeInMillis, timeInMillis));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getTimePerStepInMillis() {
		return timePerStepInMillis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimePerStepInMillis(float newTimePerStepInMillis) {
		float oldTimePerStepInMillis = timePerStepInMillis;
		timePerStepInMillis = newTimePerStepInMillis;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, statisticsPackage.STATISTICS_ENTRY_DATA__TIME_PER_STEP_IN_MILLIS, oldTimePerStepInMillis, timePerStepInMillis));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case statisticsPackage.STATISTICS_ENTRY_DATA__NUMBER_OF_NODES:
				return getNumberOfNodes();
			case statisticsPackage.STATISTICS_ENTRY_DATA__AUTO_MODE_TIME_IN_MILLIS:
				return getAutoModeTimeInMillis();
			case statisticsPackage.STATISTICS_ENTRY_DATA__TIME_IN_MILLIS:
				return getTimeInMillis();
			case statisticsPackage.STATISTICS_ENTRY_DATA__TIME_PER_STEP_IN_MILLIS:
				return getTimePerStepInMillis();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case statisticsPackage.STATISTICS_ENTRY_DATA__NUMBER_OF_NODES:
				setNumberOfNodes((Integer)newValue);
				return;
			case statisticsPackage.STATISTICS_ENTRY_DATA__AUTO_MODE_TIME_IN_MILLIS:
				setAutoModeTimeInMillis((Long)newValue);
				return;
			case statisticsPackage.STATISTICS_ENTRY_DATA__TIME_IN_MILLIS:
				setTimeInMillis((Long)newValue);
				return;
			case statisticsPackage.STATISTICS_ENTRY_DATA__TIME_PER_STEP_IN_MILLIS:
				setTimePerStepInMillis((Float)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case statisticsPackage.STATISTICS_ENTRY_DATA__NUMBER_OF_NODES:
				setNumberOfNodes(NUMBER_OF_NODES_EDEFAULT);
				return;
			case statisticsPackage.STATISTICS_ENTRY_DATA__AUTO_MODE_TIME_IN_MILLIS:
				setAutoModeTimeInMillis(AUTO_MODE_TIME_IN_MILLIS_EDEFAULT);
				return;
			case statisticsPackage.STATISTICS_ENTRY_DATA__TIME_IN_MILLIS:
				setTimeInMillis(TIME_IN_MILLIS_EDEFAULT);
				return;
			case statisticsPackage.STATISTICS_ENTRY_DATA__TIME_PER_STEP_IN_MILLIS:
				setTimePerStepInMillis(TIME_PER_STEP_IN_MILLIS_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case statisticsPackage.STATISTICS_ENTRY_DATA__NUMBER_OF_NODES:
				return numberOfNodes != NUMBER_OF_NODES_EDEFAULT;
			case statisticsPackage.STATISTICS_ENTRY_DATA__AUTO_MODE_TIME_IN_MILLIS:
				return autoModeTimeInMillis != AUTO_MODE_TIME_IN_MILLIS_EDEFAULT;
			case statisticsPackage.STATISTICS_ENTRY_DATA__TIME_IN_MILLIS:
				return timeInMillis != TIME_IN_MILLIS_EDEFAULT;
			case statisticsPackage.STATISTICS_ENTRY_DATA__TIME_PER_STEP_IN_MILLIS:
				return timePerStepInMillis != TIME_PER_STEP_IN_MILLIS_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (numberOfNodes: ");
		result.append(numberOfNodes);
		result.append(", autoModeTimeInMillis: ");
		result.append(autoModeTimeInMillis);
		result.append(", timeInMillis: ");
		result.append(timeInMillis);
		result.append(", timePerStepInMillis: ");
		result.append(timePerStepInMillis);
		result.append(')');
		return result.toString();
	}

} //StatisticsEntryDataImpl
