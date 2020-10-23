package model;
public class Person{
  private String name;
  private double weight;
  public Person(String n, double w){
    name = n;
    weight = w;
  }
  public String getName(){
    return name;
  }
  public double getWeight(){
    return weight;
  }
}