package enkisoft.sobis.staruml.test;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class CanvasSWTTest {

	public static void main(String [] args) {
		final Display display = new Display();
		final Shell shell = new Shell(display);
		shell.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent event) {
				enkisoft.sobis.staruml.graphics.Canvas canvas = new enkisoft.sobis.staruml.swt.CanvasSWT(event.gc);
				((enkisoft.sobis.staruml.swt.CanvasSWT) canvas).setGC(event.gc);
				canvas.rectangle(10, 10, 200, 200);
			}
		});
		shell.setBounds(10, 10, 500, 500);
		shell.open ();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) display.sleep();
		}
		display.dispose();
	}

}
