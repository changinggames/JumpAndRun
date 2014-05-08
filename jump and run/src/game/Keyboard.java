package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.logging.Logger;

import layout_handling.Loader_Layout;

public class Keyboard extends KeyAdapter {
	public static Logger logger = Logger.getLogger("Keyboard");
	public KeyEvent keyTyped = null;
	public boolean keys[] = new boolean[300];
	public boolean escape = false;

	@Override
	public void keyPressed(KeyEvent e) {
		try {
			keys[e.getKeyCode()] = true;
		} catch (ArrayIndexOutOfBoundsException ex) {
			logger.warning("Taste nicht unterstüzt: " + ex.getMessage());
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		try {
			keys[e.getKeyCode()] = false;
		} catch (ArrayIndexOutOfBoundsException ex) {
			logger.warning("Taste nicht unterstüzt: " + ex.getMessage());
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		keyTyped = e;
	}

	public void update() {
		if (keys[KeyEvent.VK_ESCAPE] && !escape) {
			Loader_Layout.pause = !Loader_Layout.pause;
			escape = true;
		}
		if (!keys[KeyEvent.VK_ESCAPE]) {
			escape = false;
		}
	}
}
