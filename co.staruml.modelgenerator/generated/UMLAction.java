package enkisoft.sobis.staruml.uml.model;

public class UMLAction {

	private String recurrence;
	private String target;
	private boolean isAsynchronous;
	private String script;

	public String getRecurrence() {
		return recurrence;
	}

	public void setRecurrence(String value) {
		this.recurrence = value;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String value) {
		this.target = value;
	}

	public boolean getIsAsynchronous() {
		return isAsynchronous;
	}

	public void setIsAsynchronous(boolean value) {
		this.isAsynchronous = value;
	}

	public String getScript() {
		return script;
	}

	public void setScript(String value) {
		this.script = value;
	}

}
