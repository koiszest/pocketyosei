package m;

import org.eclipse.swt.*;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class demo {
	static String value;
	int plx;
	int ply;
	int plpx = 60;
	int plpy = 30;
	Image ground,pl;
	public demo() {
		Display display= new Display();
		Shell shell = new Shell(display);
		shell.setText("ฟฺดüัýนึ");
		shell.setSize(512, 480);
		ground = new Image(display, new ImageData("src/m/ground.png"));
		pl = new Image(display, new ImageData("src/m/player.png"));
		plx = 230;
		ply = 220;
		Canvas canvas = new Canvas(shell, SWT.NO_BACKGROUND | SWT.DOUBLE_BUFFERED);
		canvas.setBounds(0,0,512,480);
		
		canvas.addPaintListener(e -> {
			e.gc.drawImage(ground, 0, 0);
			e.gc.drawImage(pl, plpx, plpy, 30, 30, plx, ply, 30, 30);
			value = String.valueOf (System.currentTimeMillis ());
			e.gc.drawString(value, 10, 10, true);
		});
		render(display, canvas);
		canvas.addKeyListener(new KeyListener(){
			@Override
			public void keyPressed(KeyEvent e) {
				GC gc = new GC(canvas);
				gc.setClipping(0,0,512,480);
				gc.drawImage(ground,0,0);
				if(e.keyCode == SWT.ARROW_UP) {
					ply -= 10;
					if(plpx == 60) {
						plpy = 90;
						plpx = 30;
					}else {
						plpx = 60;
						plpy = 0;
					}
				}
				if(e.keyCode == SWT.ARROW_DOWN) {
					ply += 10;
					if(plpy == 60) {
						plpx = 60;
						plpy = 90;
					}else {
						plpx = 60;
						plpy = 60;
					}
				}
				if(e.keyCode == SWT.ARROW_LEFT) {
					plx -= 10;
					if(plpy == 30) {
						plpx = 0;
						plpy = 90;
					}else {
						plpx = 0;
						plpy = 30;
					}
				}
				if(e.keyCode == SWT.ARROW_RIGHT) {
					plx += 10;
					if(plpy == 30) {
						plpx = 30;
						plpy = 60;
					}else {
						plpx = 30;
						plpy = 30;
					}
				}
				canvas.redraw(0, 0, 512, 480, false);
			}
			@Override
			public void keyReleased(KeyEvent e) {
				
				
			}
		});
		shell.open();
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()){
				display.sleep();
			}
		}
		display.dispose();
	}
	public void render(Display display,Canvas canvas) {
		display.timerExec(1000, new Runnable() {
			@Override
			public void run() {
				if(canvas.isDisposed()) {
					return;
				}
				canvas.redraw(0, 0, 512, 480, false);
				display.timerExec(1000, this);
			}
			
		});
	}
	public static void main(String[] args) {
		new demo();
	}
}
