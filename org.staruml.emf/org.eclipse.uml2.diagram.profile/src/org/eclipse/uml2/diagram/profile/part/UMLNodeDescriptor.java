package org.eclipse.uml2.diagram.profile.part;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.diagram.common.genapi.IUpdaterNodeDescriptor;

/**
 * @generated
 */
@SuppressWarnings("unchecked")
public class UMLNodeDescriptor implements IUpdaterNodeDescriptor {

	/**
	 * @generated
	 */
	private final EObject myModelElement;

	/**
	 * @generated
	 */
	private final int myVisualID;

	/**
	 * @generated
	 */
	public UMLNodeDescriptor(EObject modelElement, int visualID) {
		myModelElement = modelElement;
		myVisualID = visualID;
	}

	/**
	 * @generated
	 */
	public EObject getModelElement() {
		return myModelElement;
	}

	/**
	 * @generated
	 */
	public int getVisualID() {
		return myVisualID;
	}

	/**
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj instanceof IUpdaterNodeDescriptor) {
			IUpdaterNodeDescriptor that = (IUpdaterNodeDescriptor) obj;
			return this.getVisualID() == that.getVisualID() && // 
					safeEquals(this.getModelElement(), that.getModelElement());

		}
		return false;
	}

	/**
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int hashCode() {
		return myVisualID + (myModelElement == null ? 0 : myModelElement.hashCode());
	}

	/**
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	protected static boolean safeEquals(Object o1, Object o2) {
		return o1 == null ? o2 == null : o1.equals(o2);
	}

}
