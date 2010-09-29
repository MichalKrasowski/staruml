package org.eclipse.uml2.diagram.sequence.internal.layout.model;

/**
 * 
 */
public class JustReshapedState {
    public JustReshapedState(Server server) {
        this(server.getCurrentReshapeCode(), server);
    }
	public JustReshapedState(int reshapeCode, Server server) {
		myReshapeCode = reshapeCode;
		myServer = server;
	}
    public boolean isStillJustReshaped() {
    	return myServer.getCurrentReshapeCode() == myReshapeCode;
    }
    
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("JustReshapedState").append(myReshapeCode); //$NON-NLS-1$
        if (isStillJustReshaped()) {
            buffer.append("(").append(myServer.getCurrentReshapeCode()).append(")"); //$NON-NLS-1$ //$NON-NLS-2$
        }
        return buffer.toString();
	}
    
    private final int myReshapeCode;
    private final Server myServer;
    
    public interface Server {
    	int getCurrentReshapeCode();
    }
}
