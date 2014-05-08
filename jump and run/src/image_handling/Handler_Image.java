package image_handling;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

public class Handler_Image {
	public static Logger logger = Logger.getLogger("Images");
	private static HashMap<String, String> paths = new HashMap<>();
	private static HashMap<String, BufferedImage> images = new HashMap<>();
	public static String Tile_1 = "tile_1", Tile_2 = "tile_2", Tile_3 = "tile_3";

	public Handler_Image() throws IOException {
		System.out.println("Images werden geladen:");
		paths.put(Tile_1, "tiles/tile_1.png");
		paths.put(Tile_2, "tiles/tile_2.png");
		paths.put(Tile_3, "tiles/tile_3.png");
		for (Iterator<String> iterator = paths.keySet().iterator(); iterator.hasNext();) {
			String type = iterator.next();
			try {
				images.put(type, ImageIO.read(getClass().getResource("/images/" + paths.get(type))));
				// System.out.println("Geladen: \"" + type + "\"");
				logger.info("Geladen: \"" + type + "\"");
			} catch (IllegalArgumentException e) {
				// System.err.println("Konnte datei nich finden: \"" + type + " (" + paths.get(type) + ")\"");
				logger.warning("Konnte datei nich finden: \"" + type + " (" + paths.get(type) + ")\"");
				// System.err.println(e.getStackTrace()[0]);
			}
		}
		System.out.println("Fertig");
	}

	public static BufferedImage getImage(String name) {
		return images.get(name);
	}
}
