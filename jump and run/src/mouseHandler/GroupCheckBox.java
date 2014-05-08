package mouseHandler;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.concurrent.atomic.AtomicBoolean;

import mouseHandler.IMouse;

public class GroupCheckBox implements IMouse {
	private Rectangle bounds = new Rectangle();
	private Rectangle checkBounds = new Rectangle();
	private AtomicBoolean on = new AtomicBoolean(false);
	private AtomicBoolean click = new AtomicBoolean(false);
	public AtomicBoolean pressed = new AtomicBoolean(false);
	public AtomicBoolean released = new AtomicBoolean(false);
	public AtomicBoolean dragged = new AtomicBoolean(false);
	private ActionListener actionListener;
	public MouseEvent onEvent;
	public MouseEvent clickEvent;
	public MouseEvent pressedEvent;
	public MouseEvent releasedEvent;
	public MouseEvent positionEvent;
	public int wheel;
	// private int x, y, width, height;
	private boolean selected;
	private String text = "";
	Insets insets;

	public GroupCheckBox(int x, int y, int width, int height, Insets insets, boolean selected) {
		this.insets = insets;
		// this.x = x;
		// this.y = y;
		// this.width = width;
		// this.height = height;
		this.selected = selected;
		this.checkBounds.setBounds(x, y, width, height);
		this.setBounds(x + insets.left - 1, y + insets.top - 1, width + 2, height + 2);
	}

	public void addActionListener(ActionListener actionListener) {
		this.actionListener = actionListener;
	}

	public void action() {
		if (actionListener != null) {
			actionListener.actionPerformed(new ActionEvent(this, 0, "commmand"));
		}
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public void addText(int width, String text) {
		this.text = text;
		setBounds(bounds.x, bounds.y, width, bounds.height);
	}

	public void update() {
		if (click.get()) {
			action();
			// selected = !selected;
			System.out.println("clicked");
			click.set(false);
		}
		if (pressed.get()) {
			pressed.set(false);
		}
		if (released.get()) {
			released.set(false);
		}
	}

	public void draw(Graphics2D g) {
		g.setColor(Color.white);
		g.draw(checkBounds);
		g.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 20));
		g.drawString(text, bounds.x + checkBounds.width + 4, bounds.y + bounds.height - 36);
		if (selected) {
			g.drawLine(checkBounds.x, checkBounds.y, checkBounds.x + checkBounds.width, checkBounds.y + checkBounds.height);
			g.drawLine(checkBounds.x + checkBounds.width, checkBounds.y, checkBounds.x, checkBounds.y + checkBounds.height);
		}
	}

	@Override
	public Rectangle getBounds() {
		return this.bounds;
	}

	@Override
	public void setBounds(int x, int y, int width, int height) {
		this.bounds.setBounds(x, y, width, height);
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
