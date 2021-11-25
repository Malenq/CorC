/**
 */
package de.tu_bs.cs.isf.cbc.statistics.impl;

import de.tu_bs.cs.isf.cbc.statistics.StatisticsEntry;
import de.tu_bs.cs.isf.cbc.statistics.StatisticsEntryData;
import de.tu_bs.cs.isf.cbc.statistics.statisticsPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Statistics Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.tu_bs.cs.isf.cbc.statistics.impl.StatisticsEntryImpl#getKeyFilePath <em>Key File Path</em>}</li>
 *   <li>{@link de.tu_bs.cs.isf.cbc.statistics.impl.StatisticsEntryImpl#getCorcElement <em>Corc Element</em>}</li>
 *   <li>{@link de.tu_bs.cs.isf.cbc.statistics.impl.StatisticsEntryImpl#getData <em>Data</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StatisticsEntryImpl extends MinimalEObjectImpl.Container implements StatisticsEntry {
	/**
	 * The default value of the '{@link #getKeyFilePath() <em>Key File Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeyFilePath()
	 * @generated
	 * @ordered
	 */
	protected static final String KEY_FILE_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getKeyFilePath() <em>Key File Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeyFilePath()
	 * @generated
	 * @ordered
	 */
	protected String keyFilePath = KEY_FILE_PATH_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCorcElement() <em>Corc Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCorcElement()
	 * @generated
	 * @ordered
	 */
	protected EObject corcElement;

	/**
	 * The cached value of the '{@link #getData() <em>Data</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getData()
	 * @generated
	 * @ordered
	 */
	protected StatisticsEntryData data;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StatisticsEntryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return statisticsPackage.Literals.STATISTICS_ENTRY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getKeyFilePath() {
		return keyFilePath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKeyFilePath(String newKeyFilePath) {
		String oldKeyFilePath = keyFilePath;
		keyFilePath = newKeyFilePath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, statisticsPackage.STATISTICS_ENTRY__KEY_FILE_PATH, oldKeyFilePath, keyFilePath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getCorcElement() {
		if (corcElement != null && corcElement.eIsProxy()) {
			InternalEObject oldCorcElement = (InternalEObject)corcElement;
			corcElement = eResolveProxy(oldCorcElement);
			if (corcElement != oldCorcElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, statisticsPackage.STATISTICS_ENTRY__CORC_ELEMENT, oldCorcElement, corcElement));
			}
		}
		return corcElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetCorcElement() {
		return corcElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCorcElement(EObject newCorcElement) {
		EObject oldCorcElement = corcElement;
		corcElement = newCorcElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, statisticsPackage.STATISTICS_ENTRY__CORC_ELEMENT, oldCorcElement, corcElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatisticsEntryData getData() {
		return data;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetData(StatisticsEntryData newData, NotificationChain msgs) {
		StatisticsEntryData oldData = data;
		data = newData;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, statisticsPackage.STATISTICS_ENTRY__DATA, oldData, newData);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setData(StatisticsEntryData newData) {
		if (newData != data) {
			NotificationChain msgs = null;
			if (data != null)
				msgs = ((InternalEObject)data).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - statisticsPackage.STATISTICS_ENTRY__DATA, null, msgs);
			if (newData != null)
				msgs = ((InternalEObject)newData).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - statisticsPackage.STATISTICS_ENTRY__DATA, null, msgs);
			msgs = basicSetData(newData, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, statisticsPackage.STATISTICS_ENTRY__DATA, newData, newData));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case statisticsPackage.STATISTICS_ENTRY__DATA:
				return basicSetData(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case statisticsPackage.STATISTICS_ENTRY__KEY_FILE_PATH:
				return getKeyFilePath();
			case statisticsPackage.STATISTICS_ENTRY__CORC_ELEMENT:
				if (resolve) return getCorcElement();
				return basicGetCorcElement();
			case statisticsPackage.STATISTICS_ENTRY__DATA:
				return getData();
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
			case statisticsPackage.STATISTICS_ENTRY__KEY_FILE_PATH:
				setKeyFilePath((String)newValue);
				return;
			case statisticsPackage.STATISTICS_ENTRY__CORC_ELEMENT:
				setCorcElement((EObject)newValue);
				return;
			case statisticsPackage.STATISTICS_ENTRY__DATA:
				setData((StatisticsEntryData)newValue);
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
			case statisticsPackage.STATISTICS_ENTRY__KEY_FILE_PATH:
				setKeyFilePath(KEY_FILE_PATH_EDEFAULT);
				return;
			case statisticsPackage.STATISTICS_ENTRY__CORC_ELEMENT:
				setCorcElement((EObject)null);
				return;
			case statisticsPackage.STATISTICS_ENTRY__DATA:
				setData((StatisticsEntryData)null);
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
			case statisticsPackage.STATISTICS_ENTRY__KEY_FILE_PATH:
				return KEY_FILE_PATH_EDEFAULT == null ? keyFilePath != null : !KEY_FILE_PATH_EDEFAULT.equals(keyFilePath);
			case statisticsPackage.STATISTICS_ENTRY__CORC_ELEMENT:
				return corcElement != null;
			case statisticsPackage.STATISTICS_ENTRY__DATA:
				return data != null;
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
		result.append(" (keyFilePath: ");
		result.append(keyFilePath);
		result.append(')');
		return result.toString();
	}

} //StatisticsEntryImpl
