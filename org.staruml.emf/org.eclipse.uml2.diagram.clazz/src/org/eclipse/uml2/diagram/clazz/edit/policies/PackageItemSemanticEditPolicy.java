package org.eclipse.uml2.diagram.clazz.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;
import org.eclipse.uml2.diagram.clazz.edit.commands.AssociationClass2CreateCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.AssociationClassRhombCreateCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.Class2CreateCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.CommentCreateCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.ConstraintCreateCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.DataType2CreateCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.DependencyNodeCreateCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.Enumeration2CreateCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.GeneralizationSetCreateCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.InstanceSpecification2CreateCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.InstanceSpecification4CreateCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.Interface2CreateCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.InterfaceCreateCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.Package3CreateCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.PackageAsFrameCreateCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.PackageCreateCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.PrimitiveType2CreateCommand;
import org.eclipse.uml2.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class PackageItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public PackageItemSemanticEditPolicy() {
		super(UMLElementTypes.Package_1000);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (UMLElementTypes.Package_2002 == req.getElementType()) {
			return getGEFWrapper(new PackageCreateCommand(req));
		}
		if (UMLElementTypes.Class_2001 == req.getElementType()) {
			return getGEFWrapper(new Class2CreateCommand(req));
		}
		if (UMLElementTypes.AssociationClass_2007 == req.getElementType()) {
			return getGEFWrapper(new AssociationClass2CreateCommand(req));
		}
		if (UMLElementTypes.DataType_2004 == req.getElementType()) {
			return getGEFWrapper(new DataType2CreateCommand(req));
		}
		if (UMLElementTypes.PrimitiveType_2005 == req.getElementType()) {
			return getGEFWrapper(new PrimitiveType2CreateCommand(req));
		}
		if (UMLElementTypes.Enumeration_2003 == req.getElementType()) {
			return getGEFWrapper(new Enumeration2CreateCommand(req));
		}
		if (UMLElementTypes.Interface_2010 == req.getElementType()) {
			return getGEFWrapper(new InterfaceCreateCommand(req));
		}
		if (UMLElementTypes.Constraint_2006 == req.getElementType()) {
			return getGEFWrapper(new ConstraintCreateCommand(req));
		}
		if (UMLElementTypes.InstanceSpecification_2008 == req.getElementType()) {
			return getGEFWrapper(new InstanceSpecification2CreateCommand(req));
		}
		if (UMLElementTypes.Dependency_2009 == req.getElementType()) {
			return getGEFWrapper(new DependencyNodeCreateCommand(req));
		}
		if (UMLElementTypes.GeneralizationSet_2012 == req.getElementType()) {
			return getGEFWrapper(new GeneralizationSetCreateCommand(req));
		}
		if (UMLElementTypes.Interface_2013 == req.getElementType()) {
			return getGEFWrapper(new Interface2CreateCommand(req));
		}
		if (UMLElementTypes.Package_2014 == req.getElementType()) {
			return getGEFWrapper(new Package3CreateCommand(req));
		}
		if (UMLElementTypes.AssociationClass_2015 == req.getElementType()) {
			return getGEFWrapper(new AssociationClassRhombCreateCommand(req));
		}
		if (UMLElementTypes.Package_2016 == req.getElementType()) {
			return getGEFWrapper(new PackageAsFrameCreateCommand(req));
		}
		if (UMLElementTypes.InstanceSpecification_2017 == req.getElementType()) {
			return getGEFWrapper(new InstanceSpecification4CreateCommand(req));
		}
		if (UMLElementTypes.Comment_2018 == req.getElementType()) {
			return getGEFWrapper(new CommentCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
		return getGEFWrapper(new DuplicateAnythingCommand(editingDomain, req));
	}

	/**
	 * @generated
	 */
	private static class DuplicateAnythingCommand extends DuplicateEObjectsCommand {

		/**
		 * @generated
		 */
		public DuplicateAnythingCommand(TransactionalEditingDomain editingDomain, DuplicateElementsRequest req) {
			super(editingDomain, req.getLabel(), req.getElementsToBeDuplicated(), req.getAllDuplicatedElementsMap());
		}
	}
}
