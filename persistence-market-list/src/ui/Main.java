package ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import model.MarketList;

public class Main {
	public static final int EXIT_OPTION = 7;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MarketList ml;
		try {
			ml = new MarketList();
			int option;
			do {
				System.out.println("Market List");
				System.out.println("1. Add Element");
				System.out.println("2. Show Elements");
				System.out.println("3. Export Elements");
				System.out.println("4. Import Elements");
				System.out.println("5. Save Elements");
				System.out.println("6. Load Elements");
				System.out.println("7. Exit");
				System.out.print("Enter the option: ");
				option = Integer.parseInt(sc.nextLine());
				switch(option) {
					case 1:
						System.out.println("New Element");
						System.out.print("Name: ");
						String na = sc.nextLine();
						System.out.print("Amount: ");
						double am = Double.parseDouble(sc.nextLine());
						ml.addElement(na, am);
						System.out.println("The new element has been added succesfully");
					break;
					case 2:
						System.out.println(ml);
					break;
					case 3:
						System.out.println("Export data");
						System.out.print("Enter the file name to export data: ");
						String fileN = sc.nextLine();
						try {
							ml.exportData(fileN);
							System.out.println("The data was exported succesfully");
						} catch (FileNotFoundException e) {
							System.out.println("The data wasn't exported");
						}
					break;
					case 4:
						System.out.println("Import data");
						System.out.print("Enter the file name to import data:");
						String fileName = sc.nextLine();
						try {
							ml.importData(fileName);
							System.out.println("The data was imported succesfully");
						} catch (IOException e) {
							System.out.println("The data wasn't imported");
						}
					break;
					case 5:
						System.out.println("Saving data ...");
						try {
							ml.saveData();
							System.out.println("The elements were saved");
						}catch(IOException ioe) {
							System.out.println("The elements weren't saved");
							System.err.println(ioe.getMessage());
							System.err.println("========");
							ioe.printStackTrace();
						}					
					break;
					case 6:
						System.out.println("Loading data ...");
						try {
							ml.loadData();
							System.out.println("The elements were loaded");
						}catch(IOException | ClassNotFoundException cce) {
							System.out.println("The elements weren't loaded");
						}
					break;
				}
			}while(option!=EXIT_OPTION);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		sc.close();
	}

}
