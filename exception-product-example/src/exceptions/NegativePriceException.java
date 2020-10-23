package exceptions;
@SuppressWarnings("serial")
public class NegativePriceException extends Exception{
  private double price;
  public NegativePriceException(double pr){
    super("The product price can't be negative. The price is "+pr);
    price = pr;
  }
  public double getPrice(){
    return price;
  }
}