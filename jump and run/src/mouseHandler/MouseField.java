package mouseHandler;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.concurrent.atomic.AtomicBoolean;

public class MouseField implements IMouse {
	public String name = new String();
	public Rectangle bounds = new Rectangle();
	public AtomicBoolean on = new AtomicBoolean(false);
	public AtomicBoolean click = new AtomicBoolean(false);
	public AtomicBoolean pressed = new AtomicBoolean(false);
	public AtomicBoolean released = new AtomicBoolean(false);
	public AtomicBoolean dragged = new AtomicBoolean(false);
	public MouseEvent onEvent;
	public MouseEvent clickEvent;
	public MouseEvent pressedEvent;
	public MouseEvent releasedEvent;
	public MouseEvent positionEvent;
	private ActionListener actionListener, pressReleaseActionListener, pressActionListener, draggedActionListener, wheelActionListener;
	public int wheel;

	public MouseField(int x, int y, int width, int height) {
		bounds.setBounds(x, y, width, height);
	}

	public MouseField(int x, int y, int width, int height, String name) {
		bounds.setBounds(x, y, width, height);
		this.name = name;
	}

	public void addActionListener(ActionListener actionListener) {
		this.actionListener = actionListener;
	}

	public void action() {
		if (actionListener != null) {
			actionListener.actionPerformed(new ActionEvent(this, 0, "commmand"));
		}
	}

	public void addWheelActionListener(ActionListener actionListener) {
		this.wheelActionListener = actionListener;
	}

	public void actionWheel(MouseEvent event) {
		if (wheelActionListener != null) {
			wheelActionListener.actionPerformed(new ActionEvent(event, 0, "commmand"));
		}
	}

	public void addPressActionListener(ActionListener actionListener) {
		this.pressActionListener = actionListener;
	}

	public void actionPress() {
		if (pressActionListener != null) {
			pressActionListener.actionPerformed(new ActionEvent(this, 0, "commmand"));
		}
	}

	public void addDraggedActionListener(ActionListener actionListener) {
		this.draggedActionListener = actionListener;
	}

	public void actionDragged() {
		if (draggedActionListener != null) {
			draggedActionListener.actionPerformed(new ActionEvent(this, 0, "commmand"));
		}
	}

	public void addPressReleaseActionListener(ActionListener actionListener) {
		this.pressReleaseActionListener = actionListener;
	}

	public void actionPressReleas() {
		if (pressReleaseActionListener != null) {
			pressReleaseActionListener.actionPerformed(new ActionEvent(this, 0, "commmand"));
		}
	}

	Rectangle rec;

	public void update() {
		released.set(false);
		if (click.get()) {
			action();
			click.set(false);
		}
		if (pressed.get()) {
			rec = new Rectangle(pressedEvent.getPoint());
			pressed.set(false);
		}
		// if (dragged.get()) {
		// if (rec != null) {
		// rec.setSize(positionEvent.getX() - rec.x, positionEvent.getY() -
		// rec.y);
		// }
		// }
		if (released.get()) {
			actionPressReleas();
			rec = null;
			dragged.set(false);
			released.set(true);
		}
	}

	public void draw(Graphics2D g) {
		if (rec != null) {
			g.fill(rec);
		}
	}

	@Override
	public Rectangle getBounds() {
		return bounds;
	}

	@Override
	public void setBounds(int x, int y, int width, int height) {
		bounds.setBounds(x, y, width, height);
	}

	@Override
	public boolean getOn() {
		return this.on.get();
	}

	@Override
	public boolean getClick() {
		return this.click.get();
	}

	@Override
	public void setOn(boolean b, MouseEvent event) {
		on.set(b);
		onEvent = event;
	}

	@Override
	public void setClick(boolean b, MouseEvent event) {
		click.set(b);
		clickEvent = event;
	}

	@Override
	public void setPressed(boolean b, MouseEvent event) {
		pressed.set(b);
		pressedEvent = event;
	}

	@Override
	public boolean getPressed() {
		return pressed.get();
	}

	@Override
	public void setReleased(boolean b, MouseEvent event) {
		released.set(b);
		releasedEvent = event;
	}

	@Override
	public boolean getReleased() {
		return released.get();
	}

	@Override
	public void setDragged(boolean b) {
		dragged.set(b);
	}

	@Override
	public boolean getDragged() {
		return dragged.get();
	}

	@Override
	public void setPosition(MouseEvent event) {
		positionEvent = event;
	}

	@Override
	public Point getPosition() {
		try {
			return positionEvent.getPoint();
		} catch (NullPointerException e) {
			return new Point(0, 0);
		}
	}

	@Override
	public void setWheel(MouseEvent event) {
		actionWheel(event);
	}

	@Override
	public int getWheel() {
		return wheel;
	}

}
