package game;

public class Vector {
	public double dX, dY, oldX, oldY, newX, newY;
	public double d;

	// d = distance
	public Vector(double x, double y, double xx, double yy) {
		this.oldX = x;
		this.oldY = y;
		this.newX = xx;
		this.newY = yy;
		this.dX = xx - x;
		this.dY = yy - y;
		this.d = pyta(dX, dY);
	}

	public double pyta(double dX, double dY) {
		return Math.sqrt(dX * dX + dY * dY);
	}

	public int winkel() {
		if (dX < 0) {
			return (int) Math.toDegrees(Math.acos(dY / d));
		}
		return 360 - (int) Math.toDegrees(Math.acos(dY / d));
	}
}
