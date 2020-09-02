package model;

import java.util.LinkedList;
import java.util.List;

public class Parking {
	private List<Car> cars;
	public Parking() {
		cars = new LinkedList<>(); 
	}
	
	public void addCar(int id, int model, String color) {
		Car c = new Car(id,model,color);
		if(cars.isEmpty()) {
			cars.add(c);
		}else {
			int i = 0;
			while(c.getId()>cars.get(i).getId()) {
				i++;
			}
			cars.add(i,c);
		}
	}
	
	public List<Car> getCars(){
		return cars;
	}
	
	public String toString() {
		String m;
		m  = "======================\n";
		m += "         CARS\n";
		m += "======================\n";
		
		for(Car c:cars) {
			m += c + "\n";
		}
		
		return m;
	}
}
