package enkisoft.sobis.staruml.uml.model;

public class UMLGeneralizableElement {

	private boolean isRoot;
	private boolean isLeaf;
	private boolean isAbstract;

	public boolean getIsRoot() {
		return isRoot;
	}

	public void setIsRoot(boolean value) {
		this.isRoot = value;
	}

	public boolean getIsLeaf() {
		return isLeaf;
	}

	public void setIsLeaf(boolean value) {
		this.isLeaf = value;
	}

	public boolean getIsAbstract() {
		return isAbstract;
	}

	public void setIsAbstract(boolean value) {
		this.isAbstract = value;
	}

}
