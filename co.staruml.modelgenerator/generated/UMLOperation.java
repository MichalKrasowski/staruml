package enkisoft.sobis.staruml.uml.model;

public class UMLOperation {

	private int concurrency;
	private boolean isRoot;
	private boolean isLeaf;
	private boolean isAbstract;
	private String specification;

	public int getConcurrency() {
		return concurrency;
	}

	public void setConcurrency(int value) {
		this.concurrency = value;
	}

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

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String value) {
		this.specification = value;
	}

}
