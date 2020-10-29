package m;

import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class goldminer {
	private int scores = 0;
	public goldminer() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell(display);
		GC gc = new GC(shell);
		shell.setText("Gold Miner");
		shell.addPaintListener(event -> {
			//Rectangle rect = shell.getClientArea();
			event.gc.drawString("Click to start!",350,300);
		});
		shell.addMouseListener(new MouseListener() {
			@Override
			public void mouseDoubleClick(MouseEvent arg0) {
				// TODO Auto-generated method stub
				display.update();
			}

			@Override
			public void mouseDown(MouseEvent e) {
				// TODO Auto-generated method stub
				int x = e.x;
				int y = e.y;
				System.out.println(x+" "+y);
				//Rectangle rect = shell.getClientArea();
				gc.fillRectangle(0,0,800,600);
				gc.drawLine(400,0,x,y);
				gc.drawOval(400, 400, 100, 100);
				line(gc,x,y);
				gc.drawRectangle(20, 400, 180, 100);
				if(20<x && x<200 && y<500 && y>400) {
					scores += 100;
				}
				if(400<x && x<500 && 400<y && y<500) {
					scores += 100;
				}
				gc.drawString("Goal: 100 Current:"+scores, 10, 10);
			}

			@Override
			public void mouseUp(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		Rectangle clientArea = shell.getClientArea();
		shell.setBounds(clientArea.x + 10, clientArea.y + 10, 800, 600);
		shell.open ();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) display.sleep();
		}
		display.dispose();
	}
	public void line(GC gc,int dx,int dy) {
		
	}
	public static void main(String [] args) {
		new goldminer();
	}
	}