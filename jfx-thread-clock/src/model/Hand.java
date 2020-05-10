package model;

public class Hand {
	public final static double ANGLE_ROTATE = 1;
	private double rotation;
	public Hand(double r) {
		rotation = r;
	}
	public void rotate() {
		rotation = (rotation+ANGLE_ROTATE)%360;
	}
	
	public double getRotation() {
		return rotation;
	}	
}
