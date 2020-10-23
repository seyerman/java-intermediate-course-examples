package model;
import exceptions.NegativePriceException;
import exceptions.NoPriceException;
public class Product{
  private String name;
  private double price;
  public Product(String na,double pr){
    name = na;
    price = pr;
  }

  public void setPrice(double newPrice) throws NegativePriceException, NoPriceException{
    if(newPrice<0){
      throw new NegativePriceException(newPrice);
    }
    if(newPrice==0){
      throw new NoPriceException();
    }
    price = newPrice;
  }
  
  public String getName() {
	  return name;
  }
  
  public double getPrice() {
	  return price;
  }
}