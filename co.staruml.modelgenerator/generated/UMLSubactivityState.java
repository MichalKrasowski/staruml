package enkisoft.sobis.staruml.uml.model;

public class UMLSubactivityState {

	private boolean isDynamic;
	private String dynamicArguments;
	private String dynamicMultiplicity;

	public boolean getIsDynamic() {
		return isDynamic;
	}

	public void setIsDynamic(boolean value) {
		this.isDynamic = value;
	}

	public String getDynamicArguments() {
		return dynamicArguments;
	}

	public void setDynamicArguments(String value) {
		this.dynamicArguments = value;
	}

	public String getDynamicMultiplicity() {
		return dynamicMultiplicity;
	}

	public void setDynamicMultiplicity(String value) {
		this.dynamicMultiplicity = value;
	}

}
