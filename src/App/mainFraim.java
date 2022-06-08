package App;

import java.util.Scanner;

import Task.*;

public class mainFraim {
	static TaskArr openTasks;
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		// variable
		String choice = new String(); // the choice that the user will make

		// the Program
		while (choice.compareTo("4") != 0) { // compareTo return 0 if true
			printMenu();
			choice = in.nextLine();
			switch (choice) {
			case ("1"):
				openTasks.addTask(null);//TODO:  complete the call
				break;
			case ("2"):
				deleteTask();
				break;
			case ("3"):
				
				//updateTask();
				break;
			case ("4"):
				break;
			default:
				System.out.println("bad input");
	
			}
			in.close();
			System.out.println("goodBy");

		}
	}
//	public Task getTaskByID(int id) {
//		for(int i = 0; i<openTasks.g)
//	}
	

	public static void deleteTask() {
	}

	public static void updateTask(Task t) {
	}

	public static void printMenu() {
		System.out.println("-----Task Menager------");
		System.out.println("Option:");
		System.out.println("1 - Add Task");
		System.out.println("2 - Delete Task");
		System.out.println("3 - Modify Task");
		System.out.println("4 - Exit");
	}

}
