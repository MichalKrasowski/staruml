package enkisoft.sobis.staruml.uml.model;

public class UMLStructuralFeature {

	private String multiplicity;
	private int changeability;
	private int targetScope;
	private int ordering;
	private String typeExpression;

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

	public int getTargetScope() {
		return targetScope;
	}

	public void setTargetScope(int value) {
		this.targetScope = value;
	}

	public int getOrdering() {
		return ordering;
	}

	public void setOrdering(int value) {
		this.ordering = value;
	}

	public String getTypeExpression() {
		return typeExpression;
	}

	public void setTypeExpression(String value) {
		this.typeExpression = value;
	}

}
