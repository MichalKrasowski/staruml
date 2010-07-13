package enkisoft.sobis.staruml.uml.model;

public class UMLAssociationEnd {

	private boolean isNavigable;
	private int ordering;
	private int aggregation;
	private int targetScope;
	private String multiplicity;
	private int changeability;

	public boolean getIsNavigable() {
		return isNavigable;
	}

	public void setIsNavigable(boolean value) {
		this.isNavigable = value;
	}

	public int getOrdering() {
		return ordering;
	}

	public void setOrdering(int value) {
		this.ordering = value;
	}

	public int getAggregation() {
		return aggregation;
	}

	public void setAggregation(int value) {
		this.aggregation = value;
	}

	public int getTargetScope() {
		return targetScope;
	}

	public void setTargetScope(int value) {
		this.targetScope = value;
	}

	public String getMultiplicity() {
		return multiplicity;
	}

	public void setMultiplicity(String value) {
		this.multiplicity = value;
	}

	public int getChangeability() {
		return changeability;
	}

	public void setChangeability(int value) {
		this.changeability = value;
	}

}
