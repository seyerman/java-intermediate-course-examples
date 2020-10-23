package ui;
import java.util.Scanner;
import model.Product;
import exceptions.NegativePriceException;
import exceptions.NoPriceException;
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Bienvenido a la Tienda Don Pedro");
    System.out.print("Por favor digite el nombre del producto: ");
    String n = sc.nextLine();
    System.out.print("Por favor digite el precio del producto: ");
    double p = Double.parseDouble(sc.nextLine());

    Product pr = new Product(n,p);
    System.out.print("Por favor digite el nuevo precio del producto: ");
    p = Double.parseDouble(sc.nextLine());
    
    try{
      pr.setPrice(p);
      System.out.println("El precio del producto ha sido actualizado correctamente.");
    }catch(NegativePriceException npe){
      System.out.println("El precio de un producto no puede ser negativo("+npe.getPrice()+")");
      System.err.println(npe.getMessage());
      npe.printStackTrace();
    }catch(NoPriceException npe){
      System.out.println("El precio de un producto no puede ser cero.");
      System.err.println(npe.getMessage());
    }finally {
    	sc.close();
    }
  }
}