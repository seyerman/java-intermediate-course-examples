package ui;

import java.util.Scanner;

import model.Parking;

public class Menu {
	public static final int EXIT_OPTION=3;
	private Scanner sc;
	private Parking parking;
	
	public Menu() {
		sc = new Scanner(System.in);
		parking = new Parking();
	}
	
	public void startMenu() {
		String m = getMenuText();
		int option;
		do {
			System.out.print(m);
			option = readOption();
			executeOperation(option);
		}while(option!=EXIT_OPTION);
	}
	
	private void executeOperation(int option) {
		switch(option) {
			case 1:
				addCar();
			break;
			case 2:
				showCars();
			break;
			case 3:
				exitProgram();
			break;
			default:
			break;
		}
	}

	private void exitProgram() {
		sc.close();
	}

	private void showCars() {
		System.out.println(parking);
	}

	private void addCar() {
		System.out.println("Adding a new car...");
		System.out.print("Enter the parking id: ");
		int id = Integer.parseInt(sc.nextLine());
		System.out.print("Enter the car model: ");
		int model = Integer.parseInt(sc.nextLine());
		System.out.print("Enter the car color: ");
		String color = sc.nextLine();
		
		parking.addCar(id, model, color);
		
		System.out.println("The car has been added successfully");
	}

	private int readOption() {
		int op;
		op = Integer.parseInt(sc.nextLine());
		return op;
	}

	private String getMenuText() {
		String m;
		m  = "=========================\n";
		m += "         PARKING\n";
		m += "=========================\n";
		m += "1. Add Car\n";
		m += "2. Show Cars\n";
		m += "3. Exit\n";
		m += "Please enter the option: ";
		return m;
	}
}
