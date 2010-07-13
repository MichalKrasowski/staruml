package enkisoft.sobis.staruml.uml.model;

public class UMLSequenceDiagram {

	private boolean showSequenceNumber;
	private int messageSignature;

	public boolean getShowSequenceNumber() {
		return showSequenceNumber;
	}

	public void setShowSequenceNumber(boolean value) {
		this.showSequenceNumber = value;
	}

	public int getMessageSignature() {
		return messageSignature;
	}

	public void setMessageSignature(int value) {
		this.messageSignature = value;
	}

}
