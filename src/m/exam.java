package m;

import org.eclipse.swt.*;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.*;

public class exam {

public static void main(String[] args) {
	Display display = new Display();
	Shell shell = new Shell(display);
	shell.setText("Snippet 13");
	FillLayout layout = new FillLayout();
	shell.setLayout(layout);
	for(int i=0;i<10;i++) {
		Button button = new Button(shell, SWT.PUSH);
		button.setText("No."+i+"");
	}
	Button button = new Button(shell, SWT.PUSH);
	button.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
	button.setText("hello");
	button.addSelectionListener(new SelectionAdapter() {
		@Override
		public void widgetSelected(SelectionEvent e) {
			System.out.println("clicked");
		}
	});
	
	shell.open();
	while (!shell.isDisposed()) {
		if (!display.readAndDispatch())
			display.sleep();
	}
	display.dispose();
}
}