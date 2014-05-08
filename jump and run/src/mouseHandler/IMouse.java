package mouseHandler;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.concurrent.atomic.AtomicBoolean;

public interface IMouse {
	public String name = new String("noName");
	public Rectangle bounds = new Rectangle();
	public AtomicBoolean on = new AtomicBoolean(false);
	public AtomicBoolean click = new AtomicBoolean(false);
	public AtomicBoolean pressed = new AtomicBoolean(false);
	public AtomicBoolean released = new AtomicBoolean(false);
	public AtomicBoolean dragged = new AtomicBoolean(false);
	public MouseEvent onEvent = new MouseEvent(null, 0, 0, 0, 0, 0, 0, false);
	public MouseEvent clickEvent = new MouseEvent(null, 0, 0, 0, 0, 0, 0, false);
	public MouseEvent pressedEvent = new MouseEvent(null, 0, 0, 0, 0, 0, 0, false);
	public MouseEvent releasedEvent = new MouseEvent(null, 0, 0, 0, 0, 0, 0, false);
	public MouseEvent positionEvent = new MouseEvent(null, 0, 0, 0, 0, 0, 0, false);
	public int wheel = 0;

	public Rectangle getBounds();

	public void setBounds(int x, int y, int width, int height);

	public void setOn(boolean b, MouseEvent event);

	public boolean getOn();

	public void setClick(boolean b, MouseEvent event);

	public boolean getClick();

	public void setDragged(boolean b);

	public boolean getDragged();

	public void setPressed(boolean b, MouseEvent event);

	public boolean getPressed();

	public void setPosition(MouseEvent event);

	public Point getPosition();

	public boolean getReleased();

	public void setReleased(boolean b, MouseEvent event);

	public void setWheel(MouseEvent event);

	public int getWheel();

	/*
	 * private Rectangle bounds = new Rectangle(); private AtomicBoolean on = new AtomicBoolean(false); private AtomicBoolean click = newA tomicBoolean(false); public AtomicBoolean pressed = new AtomicBoolean(false); public AtomicBoolean released = new AtomicBoolean(false); public MouseEvent onEvent; public MouseEvent clickEvent; public MouseEvent pressedEvent; public MouseEvent releasedEvent;
	 * public MouseEvent positionEvent;
	 * 
	 * @Override public Rectangle getBounds() { return bounds; }
	 * 
	 * @Override public void setBounds(int x, int y, int width, int height) { bounds.setBounds(x, y, width, height); }
	 * 
	 * @Override public boolean getOn() { return this.on.get(); }
	 * 
	 * @Override public boolean getClick() { return this.click.get(); }
	 * 
	 * @Override public void setOn(boolean b, MouseEvent event) { on.set(b); onEvent = event; }
	 * 
	 * @Override public void setClick(boolean b, MouseEvent event) { click.set(b); clickEvent = event; }
	 * 
	 * @Override public void setPressed(boolean b, MouseEvent event) { pressed.set(b); pressedEvent = event; }
	 * 
	 * @Override public boolean getPressed() { return pressed.get(); }
	 * 
	 * @Override public void setReleased(boolean b, MouseEvent event) { released.set(b); releasedEvent = event; }
	 * 
	 * @Override public boolean getReleased() { return released.get(); }
	 * 
	 * @Override public void setDragged(boolean b) { dragged.set(b); }
	 * 
	 * @Override public boolean getDragged() { return dragged.get(); }
	 * 
	 * @Override public void setPosition(MouseEvent event) { positionEvent = event; }
	 * 
	 * @Override public Point getPosition() { return positionEvent.getPoint(); }
	 */
}
