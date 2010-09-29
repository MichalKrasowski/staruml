package org.eclipse.uml2.diagram.statemachine.part;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.uml2.diagram.common.genapi.IUpdaterLinkDescriptor;

/**
 * @generated
 */
@SuppressWarnings("unchecked")
public class UMLLinkDescriptor extends UMLNodeDescriptor implements IUpdaterLinkDescriptor {

	/**
	 * @generated
	 */
	private EObject mySource;

	/**
	 * @generated
	 */
	private EObject myDestination;

	/**
	 * @generated
	 */
	private IAdaptable mySemanticAdapter;

	/**
	 * @generated
	 */
	private UMLLinkDescriptor(EObject source, EObject destination, EObject linkElement, int linkVID) {
		super(linkElement, linkVID);
		mySource = source;
		myDestination = destination;
	}

	/**
	 * @generated
	 */
	public UMLLinkDescriptor(EObject source, EObject destination, IElementType elementType, int linkVID) {
		this(source, destination, (EObject) null, linkVID);
		final IElementType elementTypeCopy = elementType;
		mySemanticAdapter = new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if (IElementType.class.equals(adapter)) {
					return elementTypeCopy;
				}
				return null;
			}
		};
	}

	/**
	 * @generated
	 */
	public UMLLinkDescriptor(EObject source, EObject destination, EObject linkElement, IElementType elementType, int linkVID) {
		this(source, destination, linkElement, linkVID);
		final IElementType elementTypeCopy = elementType;
		mySemanticAdapter = new EObjectAdapter(linkElement) {

			public Object getAdapter(Class adapter) {
				if (IElementType.class.equals(adapter)) {
					return elementTypeCopy;
				}
				return super.getAdapter(adapter);
			}
		};
	}

	/**
	 * @generated
	 */
	public EObject getSource() {
		return mySource;
	}

	/**
	 * @generated
	 */
	public EObject getDestination() {
		return myDestination;
	}

	/**
	 * @generated
	 */
	public IAdaptable getSemanticAdapter() {
		return mySemanticAdapter;
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
		if (obj instanceof IUpdaterLinkDescriptor) {
			IUpdaterLinkDescriptor that = (IUpdaterLinkDescriptor) obj;
			return this.getVisualID() == that.getVisualID() && // 
					safeEquals(this.getModelElement(), that.getModelElement()) && // 
					safeEquals(this.getSource(), that.getSource()) && //
					safeEquals(this.getDestination(), that.getDestination());
		}
		return false;
	}

	/**
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int hashCode() {
		return super.hashCode() + 3 * safeHashCode(mySource) + 7 * safeHashCode(myDestination);
	}

	/**
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	private int safeHashCode(Object o) {
		return o == null ? 0 : o.hashCode();
	}

}
