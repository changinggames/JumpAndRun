package layout_handling;

import game.Game;
import game.Keyboard;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.util.Properties;

import mouseHandler.Mouse;

public class Loader_Layout {
	public double g = 60;
	long lastTime = System.nanoTime();
	long timer = System.currentTimeMillis();
	final double ns = 1000000000.0 / g;
	double delta = 0;
	int frames = 0;
	int updates = 0;
	BufferStrategy bufferStrategy;
	Rectangle bounds;
	public Mouse mouse;
	Keyboard keyboard;
	public int width, height, x, y;
	Insets insets;
	Properties prop = new Properties();
	public String style = "default";
	public static boolean pause = false;

	public Loader_Layout(BufferStrategy bufferStrategy, int x, int y, int width, int height, Insets insets, Keyboard keyboard, Mouse mouse) throws IOException {
		this.bufferStrategy = bufferStrategy;
		this.bounds = new Rectangle(x, y, width, height);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.insets = insets;
		this.keyboard = keyboard;
		this.mouse = mouse;
		String next = "null";

		// test
		next = load(new Menu(this));

		while (true) {
			switch (next) {
			case "menu":
				System.out.println("load Menu");
				next = load(new Menu(this));
				break;
			case "singleplayer":
				System.out.println("dddd");
				break;
			default:
				System.out.println("load Default Menu");
				next = load(new Menu(this));
				break;
			}
		}
	}

	public String load(Handler_Layout layout) {
		while (Handler_Layout.next.get().equals("null")) {
			long now = System.nanoTime();
			final double ns = 1000000000.0 / g;
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				Game.update();
				// stuff:
				layout.update();
				// end
				updates++;
				delta--;
			}

			Graphics2D g = setRenderHints((Graphics2D) bufferStrategy.getDrawGraphics());

			if (!bufferStrategy.contentsLost()) {
				AffineTransform oldTransform = g.getTransform();
				g.translate(insets.left, insets.top);
				rendern(bounds, g);
				// stuff:
				layout.draw(g);
				// end
				g.setTransform(oldTransform);
				mouse.draw(g);
				bufferStrategy.show();
				g.dispose();
			} else {
				System.out.println("BufferStrategy ContentLost");
			}
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println(updates + " ups, " + frames + " fps");
				updates = 0;
				frames = 0;
			}
		}
		mouse.removeAll();
		return Handler_Layout.next.get();
	}

	static Graphics2D setRenderHints(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_TEXT_LCD_CONTRAST, 100);
		g.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
		g.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
		g.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
		g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
		return g;
	}

	private void rendern(Rectangle bounds, Graphics2D g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, bounds.width, bounds.height);
	}

	public Properties getProperties() {
		return prop;
	}

	public Insets getInsets() {
		return insets;
	}

}
