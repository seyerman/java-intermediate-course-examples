package model;
import java.util.List;
import java.util.ArrayList;
import exceptions.MaximumCapacityException;
public class Elevator{
  public static final int MAX_CAP = 250;
  private List<Person> people;
  public Elevator(){
    people = new ArrayList<>();
  }
  public void addPerson(String na, double we) throws MaximumCapacityException{
    if(getTotalWeight()+we>MAX_CAP){
      throw new MaximumCapacityException(MAX_CAP,getTotalWeight()+we);
    }
    Person p = new Person(na,we);
    people.add(p);
  }
  public double getTotalWeight(){
    double total = 0;
    for(int i=0;i<people.size();i++){
      total += people.get(i).getWeight();
    }
    return total;
  }
  public List<Person> getPeople(){
    return people;
  }
}