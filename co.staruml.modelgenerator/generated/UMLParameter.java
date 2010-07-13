package enkisoft.sobis.staruml.uml.model;

public class UMLParameter {

	private String defaultValue;
	private int directionKind;
	private String typeExpression;

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String value) {
		this.defaultValue = value;
	}

	public int getDirectionKind() {
		return directionKind;
	}

	public void setDirectionKind(int value) {
		this.directionKind = value;
	}

	public String getTypeExpression() {
		return typeExpression;
	}

	public void setTypeExpression(String value) {
		this.typeExpression = value;
	}

}
