package ui;
import java.util.Scanner;
import model.Elevator;
import exceptions.MaximumCapacityException;
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String nam;
    double wei;

    Elevator elev = new Elevator();

    System.out.println("Progama Ascensor");
    System.out.print("Por favor digite la cantidad de personas que subirán al ascensor: ");
    int totalPeople = Integer.parseInt(sc.nextLine());
    try{

      while(totalPeople>0){
        System.out.print("Por favor digite el nombre de la persona que subira al ascensor: ");
        nam = sc.nextLine();
        System.out.print("Por favor digite el peso (en kg) de la persona que subira al ascensor: ");
        wei = Double.parseDouble(sc.nextLine());

        elev.addPerson(nam,wei);
        System.out.println("El ascensor ahora tiene "+elev.getTotalWeight()+" kg de peso");
        totalPeople--;
      }
      
    }catch(MaximumCapacityException mce){
      System.out.println("La capacidad del ascensor ha sido excedida.");
      System.out.println("La capacidad máxima es: "+mce.getMaxCapacity()+" y el peso actual es: "+mce.getCurrentWeight());
      mce.printStackTrace();
    }finally {
    	sc.close();
    }
  }
}