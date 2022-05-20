package App;
import java.util.Scanner;
import Ex3.*;


public class mainFraim {
	Task[] openTask;
	static Ta openTasks;
	static Scanner in = new Scanner(System.in);
	
	public static void main(String [] args) {
		//		variable
		String choice = new String();				//the choice that the user will make
		
		//the Program
		while(choice.compareTo("4") != 0) {		//compareTo return 0 if true
			printMenu();
			choice = in.nextLine();
			switch(choice) {
				case("1"):		//PhoneBook
					phonebookApp.menu();}
			}
		in.close();
		}

	
	public void addTask(Task[] taskList ) {
		
	}
	public void deleteTask() {}
	public void updateTask() {}
	public static void  printMenu() {		
		System.out.println("-----Task Menager------");
		System.out.println("Option:");
		System.out.println("1 - Add Task");
		System.out.println("2 - Delete Task");
		System.out.println("3 - Modify Task");
		System.out.println("5 - Exit");}

	}
	
	

}
