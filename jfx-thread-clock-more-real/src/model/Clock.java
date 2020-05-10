package model;

public class Clock {
	private Hand hourHand;
	private Hand minuteHand;
	private boolean spin;
	
	public static final int MIN_HOUR_RELATION = 12;
	
	public Clock(double rHour, double rMinute) {
		hourHand = new Hand(rHour);
		minuteHand = new Hand(rMinute);
		spin = false;
	}
	
	public boolean rotateHands() {
		boolean hourMoved = false;
		minuteHand.rotate();
		if(minuteHand.getRotation()%MIN_HOUR_RELATION==0) {
			hourHand.rotate();
			hourMoved = true;
		}
		return hourMoved;
	}
	
	public double getRotationHourHand() {
		return hourHand.getRotation();
	}
	
	public double getRotationMinuteHand() {
		return minuteHand.getRotation();
	}
	
	public void setSpin(boolean sp) {
		spin = sp;
	}
	
	public boolean getSpin() {
		return spin;
	}
}
