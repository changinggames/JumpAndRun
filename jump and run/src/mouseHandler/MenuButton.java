package mouseHandler;

import image_handling.Handler_Image;

import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.concurrent.atomic.AtomicBoolean;

public class MenuButton implements IMouse {
	private Rectangle bounds = new Rectangle();
	private AtomicBoolean on = new AtomicBoolean(false);
	private AtomicBoolean click = new AtomicBoolean(false);
	public AtomicBoolean pressed = new AtomicBoolean(false);
	public AtomicBoolean released = new AtomicBoolean(false);
	public AtomicBoolean dragged = new AtomicBoolean(false);
	public MouseEvent onEvent;
	public MouseEvent clickEvent;
	public MouseEvent pressedEvent;
	public MouseEvent releasedEvent;
	public MouseEvent positionEvent;
	private ActionListener l;
	public int wheel;
	private int x, y, width, height;
	private BufferedImage bufferedImage;
	private Insets insets;

	public MenuButton(int x, int y, int width, int height, Insets insets, String image) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.insets = insets;
		this.setBounds(x, y, width, height);
		this.bufferedImage = Handler_Image.getImage(image);
	}

	public void addActionListener(ActionListener l) {
		this.l = l;
	}

	public void action() {
		if (l != null) {
			l.actionPerformed(new ActionEvent(this, 0, "commmand"));
		}
	}

	public void update() {
		if (click.get()) {
			action();
			click.set(false);
		}
		if (pressed.get()) {
			pressed.set(false);
		}
		if (released.get()) {
			released.set(false);
		}
	}

	@Override
	public Rectangle getBounds() {
		return this.bounds;
	}

	@Override
	public void setBounds(int x, int y, int width, int height) {
		this.bounds.setBounds(x + insets.left, y + insets.top, width, height);
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
	}

	@Override
	public void setClick(boolean b, MouseEvent event) {
		click.set(b);
	}

	@Override
	public void setPressed(boolean b, MouseEvent event) {
		pressed.set(b);
	}

	@Override
	public boolean getPressed() {
		return pressed.get();
	}

	@Override
	public void setReleased(boolean b, MouseEvent event) {
		released.set(b);
	}

	@Override
	public boolean getReleased() {
		return released.get();
	}

	public void draw(Graphics2D g) {
		g.drawImage(bufferedImage, x, y, width, height, null);
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
		return positionEvent.getPoint();
	}

	@Override
	public void setWheel(MouseEvent event) {

	}

	@Override
	public int getWheel() {
		return wheel;
	}
}
