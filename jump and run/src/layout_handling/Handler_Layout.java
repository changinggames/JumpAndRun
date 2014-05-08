package layout_handling;

import java.awt.Graphics2D;
import java.util.concurrent.atomic.AtomicReference;

public interface Handler_Layout {
	public AtomicReference<String> next = new AtomicReference<String>();

	public void update();

	public void draw(Graphics2D g);
}
