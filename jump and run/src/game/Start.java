package game;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

public class Start {
	static Game game;
	static String gameArgs[];

	public static Game getGame() {
		return game;
	}

	public static void main(String[] args) {
		gameArgs = args;
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
		try {
			GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
			GraphicsDevice device = env.getDefaultScreenDevice();

			game = new Game(device, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.exit(0);
	}
}
