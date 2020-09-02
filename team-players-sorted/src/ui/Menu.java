package ui;

import java.util.Scanner;

import model.Team;

public class Menu {
	private final static int EXIT_OPTION = 3;
	private Scanner sc;
	private Team team;
	
	public Menu() {
		sc = new Scanner(System.in);
		team = new Team();
	}
	
	public void startMenu() {
		String menu = getMenuText();
		int option;
		do {
			System.out.print(menu);
			option = readOption();
			executeOperation(option);
		}while(option!=EXIT_OPTION);
	}
	
	private String getMenuText() {
		String menu;
		menu  = "==============================\n";
		menu += "      TEAM PLAYERS SORTED\n";
		menu += "==============================\n";
		menu += "1. Add Player\n";
		menu += "2. Show Players\n";
		menu += "3. Exit\n";
		menu += "Please enter the option: ";
		return menu;
	}
	
	private int readOption() {
		int op;
		op = Integer.parseInt(sc.nextLine());
		return op;
	}
	
	private void executeOperation(int option) {
		switch(option) {
			case 1: addPlayer();   break;
			case 2: showPlayers(); break;
			case 3: exitProgram(); break;
			default: break;
		}
	}

	private void exitProgram() {
		sc.close();
	}

	private void showPlayers() {
		System.out.println(team);
	}

	private void addPlayer() {
		System.out.println("Adding Player ...");
		System.out.print("Please enter the shirt number: ");
		int shirtNumber = Integer.parseInt(sc.nextLine());
		System.out.print("Please enter the player full name: ");
		String fullName = sc.nextLine();
		System.out.print("Please enter the position name: ");
		String positionName = sc.nextLine();
		
		team.addPlayer(shirtNumber, fullName, positionName);
		
		System.out.println("The player has been added succesfully");
	}
}
