package layout_handling;

import image_handling.Handler_Image;

import java.awt.Graphics2D;

public class Singleplayer implements Handler_Layout {
	public Loader_Layout ll;
	int mapLength = 14;
	int position = 0;

	public Singleplayer(Loader_Layout ll) {
		this.ll = ll;
		next.set("null");
	}

	@Override
	public void update() {
		position++;
	}

	@Override
	public void draw(Graphics2D g) {
		for (int i = 0; i < mapLength; i++) {
			g.drawImage(Handler_Image.getImage(Handler_Image.Tile_1), 64 * i - (position / 2) % 64, ll.height - 128, null);
		}
		for (int i = 0; i < mapLength; i++) {
			g.drawImage(Handler_Image.getImage(Handler_Image.Tile_1), 64 * i - position % 64, ll.height - 64, null);
		}
	}
}
