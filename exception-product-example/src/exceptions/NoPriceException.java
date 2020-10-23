package exceptions;
@SuppressWarnings("serial")
public class NoPriceException extends Exception{
  public NoPriceException(){
    super("The product price can't be cero");
  }
}