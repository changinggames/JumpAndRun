package mouseHandler;

import game.Keyboard;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class Mouse extends MouseAdapter {
	public ArrayList<IMouse> iMouses = new ArrayList<>();
	Keyboard keyboard;
	boolean s = true;
	public int x = 0, y = 0, x1 = 0, y1 = 0;

	public void startUpdate() {
	}

	public void endUpdate() {
	}

	@SuppressWarnings("unused")
	private boolean check(MouseEvent e) {
		for (Iterator<IMouse> iterator = iMouses.iterator(); iterator.hasNext();) {
			IMouse type = iterator.next();
			if (type.getBounds().contains(e.getPoint())) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	@SuppressWarnings("unused")
	private IMouse checkIMouse(MouseEvent e) {
		for (Iterator<IMouse> iterator = iMouses.iterator(); iterator.hasNext();) {
			IMouse type = iterator.next();
			if (type.getBounds().contains(e.getPoint())) {
				return type;
			} else {
				return null;
			}
		}
		return null;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == 1) {
			x = e.getX();
			y = e.getY();
		} else {
			x1 = e.getX();
			y1 = e.getY();
		}
		for (Iterator<IMouse> iterator = iMouses.iterator(); iterator.hasNext();) {
			IMouse type = iterator.next();
			if (type.getBounds().contains(e.getPoint())) {
				type.setPosition(e);
			}
		}
		for (Iterator<IMouse> iterator = iMouses.iterator(); iterator.hasNext();) {
			IMouse type = iterator.next();
			if (type.getBounds().contains(e.getPoint())) {
				type.setPressed(true, e);
			} else {
				type.setPressed(false, e);
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		for (Iterator<IMouse> iterator = iMouses.iterator(); iterator.hasNext();) {
			IMouse type = iterator.next();
			if (type.getBounds().contains(e.getPoint())) {
				type.setPosition(e);
			}
		}
		for (Iterator<IMouse> iterator = iMouses.iterator(); iterator.hasNext();) {
			IMouse type = iterator.next();
			if (type.getBounds().contains(e.getPoint())) {
				type.setReleased(true, e);
			} else {
				type.setReleased(false, e);
			}
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		for (Iterator<IMouse> iterator = iMouses.iterator(); iterator.hasNext();) {
			IMouse type = iterator.next();
			if (type.getBounds().contains(e.getPoint())) {
				type.setPosition(e);
			}
		}
		for (Iterator<IMouse> iterator = iMouses.iterator(); iterator.hasNext();) {
			IMouse type = iterator.next();
			if (type.getBounds().contains(e.getPoint()) && s) {
				type.setOn(true, e);
				s = false;
			} else {
				type.setOn(false, e);
			}
		}
		s = true;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		for (Iterator<IMouse> iterator = iMouses.iterator(); iterator.hasNext();) {
			IMouse type = iterator.next();
			if (type.getBounds().contains(e.getPoint())) {
				type.setPosition(e);
			}
		}
		for (Iterator<IMouse> iterator = iMouses.iterator(); iterator.hasNext();) {
			IMouse type = iterator.next();
			if (type.getBounds().contains(e.getPoint())) {
				type.setClick(true, e);
//				return;
			}
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		for (Iterator<IMouse> iterator = iMouses.iterator(); iterator.hasNext();) {
			IMouse type = iterator.next();
			if (type.getBounds().contains(e.getPoint())) {
				type.setPosition(e);
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		for (Iterator<IMouse> iterator = iMouses.iterator(); iterator.hasNext();) {
			IMouse type = iterator.next();
			if (type.getBounds().contains(e.getPoint())) {
				type.setPosition(e);
			}
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		for (Iterator<IMouse> iterator = iMouses.iterator(); iterator.hasNext();) {
			IMouse type = iterator.next();
			if (type.getBounds().contains(e.getPoint())) {
				type.setPosition(e);
			}
		}
		for (Iterator<IMouse> iterator = iMouses.iterator(); iterator.hasNext();) {
			IMouse type = iterator.next();
			if (type.getBounds().contains(e.getPoint())) {
				type.setDragged(true);
			} else {
				type.setDragged(false);
			}
		}
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		for (Iterator<IMouse> iterator = iMouses.iterator(); iterator.hasNext();) {
			IMouse type = iterator.next();
			if (type.getBounds().contains(e.getPoint())) {
				type.setWheel(e);
			}
		}
	}

	public void add(IMouse iMouse) {
		this.iMouses.add(0, iMouse);
	}

	public Mouse(Keyboard kl) {
		keyboard = kl;
	}

	public void draw(Graphics2D g) {
		if (keyboard.keys[KeyEvent.VK_CONTROL]) {
			for (Iterator<IMouse> iterator = iMouses.iterator(); iterator.hasNext();) {
				IMouse type = iterator.next();
				if (type.getOn()) {
					g.setColor(new Color(0f, 0f, 0.6f, 0.4f));
				} else {
					g.setColor(new Color(0.6f, 0f, 0f, 0.4f));
				}
				g.fill(type.getBounds());
				g.setColor(Color.BLACK);
				g.draw(type.getBounds());
			}
		}
	}

	public void removeAll() {
		iMouses.removeAll(iMouses);
	}
}
