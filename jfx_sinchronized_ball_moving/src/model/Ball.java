package model;

public class Ball {
	private double x;
	private double y;
	private double r;
	
	private final static double STEP = 5;
	
	public Ball(double x, double y, double r) {
		super();
		this.x = x;
		this.y = y;
		this.r = r;
	}
	
	public void moveX(double destinationX) {
		if(destinationX>x) {
			x = (destinationX-x>STEP)?x+STEP:destinationX;
		}
		if(destinationX<x) {
			x = (x-destinationX>STEP)?x-STEP:destinationX;
		}
	}
	
	public void moveY(double destinationY) {
		if(destinationY>y) {
			y = (destinationY-y>STEP)?y+STEP:destinationY;
		}
		if(destinationY<y) {
			y = (y-destinationY>STEP)?y-STEP:destinationY;
		}
	}
	
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public double getR() {
		return r;
	}
	
	
}
