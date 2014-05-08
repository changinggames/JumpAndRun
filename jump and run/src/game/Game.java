package game;

import image_handling.Handler_Image;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.Insets;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferStrategy;
import java.io.IOException;

import javax.swing.JFrame;

import layout_handling.Loader_Layout;
import mouseHandler.Mouse;

public class Game {
	JFrame mainFrame;
	public static Keyboard kl;
	public static Mouse ml;
	static boolean inGame = false, inMenu = true, inEditor = false;
	public static int width, height;
	public static String user;
	boolean repeat = true;
	static boolean weiter = false, close = false;
	public static Loader_Layout layouts;
	public Insets insets;

	public Game(GraphicsDevice device, String args[]) {
		try {
			new Handler_Image();
		} catch (IOException e1) {
			e1.printStackTrace();
			System.exit(1);
		}
		GraphicsConfiguration gc = device.getDefaultConfiguration();
		mainFrame = new JFrame(gc);
		// mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setIgnoreRepaint(true);
		mainFrame.setResizable(false);
		mainFrame.setTitle("Jump and run");
		kl = new Keyboard();
		mainFrame.addKeyListener(kl);
		ml = new Mouse(kl);
		mainFrame.addMouseListener(ml);
		mainFrame.addMouseMotionListener(ml);
		mainFrame.addMouseWheelListener(ml);
		mainFrame.addWindowListener(new WindowListener() {
			public void windowOpened(WindowEvent arg0) {
			}

			public void windowIconified(WindowEvent arg0) {
			}

			public void windowDeiconified(WindowEvent arg0) {
			}

			public void windowDeactivated(WindowEvent arg0) {
			}

			public void windowClosing(WindowEvent arg0) {
				// sachen
				Thread thread = new Thread(new Runnable() {
					public void run() {
						mainFrame.setVisible(false);
						while (true) {
							try {
								Thread.sleep(0);
								System.exit(0);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				});
				thread.start();
			}

			public void windowClosed(WindowEvent arg0) {
			}

			public void windowActivated(WindowEvent arg0) {
			}
		});
		width = 800;
		height = 600;
		mainFrame.setSize(width, height);
		mainFrame.setVisible(true);
		insets = mainFrame.getInsets();
		mainFrame.setSize(width + insets.left + insets.right, height + insets.top + insets.bottom);
		// mainFramef
		mainFrame.setLocationRelativeTo(null);
		mainFrame.createBufferStrategy(3);
		BufferStrategy bufferStrategy = mainFrame.getBufferStrategy();

		try {
			layouts = new Loader_Layout(bufferStrategy, insets.left, insets.top, width, height, insets, kl, ml);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}

	}

	public static int getWidth() {
		return width;
	}

	public static int getHeight() {
		return height;
	}

	public static void update() {
		ml.startUpdate();
		kl.update();
		kl.keyTyped = null;
		ml.endUpdate();
	}

	public Game getGame() {
		return this;
	}
}
