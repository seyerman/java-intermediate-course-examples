package exceptions;
@SuppressWarnings("serial")
public class MaximumCapacityException extends Exception{
  private double maxCapacity;
  private double currentWeight;
  public MaximumCapacityException(double maxCap, double currW){
    super("The maximum capacity has been exceeded.");
    maxCapacity = maxCap;
    currentWeight = currW;
  }

  public double getMaxCapacity(){
    return maxCapacity;
  }

  public double getCurrentWeight(){
    return currentWeight;
  }
}