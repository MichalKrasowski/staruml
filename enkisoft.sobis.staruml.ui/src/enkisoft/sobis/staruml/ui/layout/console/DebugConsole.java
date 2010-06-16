package enkisoft.sobis.staruml.ui.layout.console;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;

public class DebugConsole extends MessageConsole{
	private MessageConsoleStream outMessageStream;

	private MessageConsoleStream inMessageStream;

	
	public DebugConsole() {
		super("Process Debug", null);
		this.outMessageStream = newMessageStream();
		this.outMessageStream.setColor(Display.getCurrent().getSystemColor(
				SWT.COLOR_BLUE));
		this.inMessageStream = newMessageStream();
		this.inMessageStream.setColor(Display.getCurrent().getSystemColor(
				SWT.COLOR_RED));
	}
	
	protected void dispose() {
	}
}
