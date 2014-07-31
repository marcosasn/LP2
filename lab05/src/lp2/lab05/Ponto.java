package lp2.lab05;

public class Ponto {
	private static double x;
	private static double y;
	private static double z;
	
	public Ponto(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
	
	public double getZ() {
		return z;
	}
	
	public String toString() {
		return "(" + getX() + "," + getY() + "," + getZ() + ")";
	}
}
