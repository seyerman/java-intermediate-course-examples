package model;

public class Square {
	public final static double ANGLE_ROTATE = 1;
	
	private double rotation;
	
	public Square(double r) {
		rotation = r;
	}
	
	public void rotate() {
		rotation = (rotation+ANGLE_ROTATE)%360;
	}
	
	public double getRotation() {
		return rotation;
	}
}
