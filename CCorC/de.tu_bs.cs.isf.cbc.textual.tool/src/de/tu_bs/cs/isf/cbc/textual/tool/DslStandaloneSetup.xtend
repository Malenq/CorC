/*
 * generated by Xtext 2.10.0
 */
package de.tu_bs.cs.isf.cbc.textual.tool


/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
class DslStandaloneSetup extends DslStandaloneSetupGenerated {

	def static void doSetup() {
		new DslStandaloneSetup().createInjectorAndDoEMFRegistration()
	}
}
