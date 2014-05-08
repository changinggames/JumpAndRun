package layout_handling;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Menu implements Handler_Layout {
	public Loader_Layout ll;
	String difficulty;

	// NewMenuButtonMitte buttonEasy;

	public Menu(Loader_Layout ll) {
		this.ll = ll;
		next.set("null");
		Graphics2D g2 = ll.setRenderHints((Graphics2D) ll.bufferStrategy.getDrawGraphics());
		// buttonEasy = new NewMenuButtonMitte(400, 300, ll.insets, "Einfach", g2);
		// buttonEasy.addActionListener(new ActionListener() {
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// System.out.println("Wwww");
		// next.set("normal");
		// }
		// });
		// ll.mouse.add(buttonEasy);
	}

	@Override
	public void update() {
		// buttonEasy.update();
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(new Color(10, 10, 10));
		g.fillRect(0, 0, ll.width, ll.height);
		g.setColor(Color.white);
		Font font = new Font(Font.DIALOG, Font.BOLD, 35);
		g.setFont(font);

		Rectangle2D textBounds = font.getStringBounds("Einzelspieler", g.getFontRenderContext());
		g.drawString("Einzelspieler", 400 - (int) textBounds.getCenterX(), 250);

		// buttonEasy.draw(g);
	}
}
