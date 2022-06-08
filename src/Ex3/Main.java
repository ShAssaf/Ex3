package Ex3;

import java.util.ArrayList;

public class Main {
	public static void main(String [] args) {
		Contacts c = new Contacts("ari", "055");
		Task t1 = new Task("1", "1911-11-01 11:11:11");
		Task t2 = new Task("2", "1922-02-02 22:22:22");
		ArrayList<Task> al = new ArrayList<Task>();
		al.add(t1);
		al.add(t2);
		
		AssignedTask at = new AssignedTask("3", "1933-03-03 13:33:33", c);
		at.task_print();
		MultiTask mt = new MultiTask("4", "1944-04-04 14:44:44", al);
		mt.task_print();
		mt.get_task_by_title("1").task_print();
		mt.get_task_by_index(1).task_print();
	}
}
