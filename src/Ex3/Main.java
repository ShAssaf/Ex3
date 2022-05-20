package Ex3;

public class Main {
	public static void main(String [] args) {
		Task[] a = {new Task ("second","2012-05-02 02:30:10"),new Task ("first","2018-05-02 02:30:10")};
		for (int i=0; i<2;i++) {
			a[i].task_print();
		}
		Task.sort_by_title(a);
		for (int i=0; i<2;i++) {
			a[i].task_print();
		}
		Task.sort_by_date_target(a);
		for (int i=0; i<2;i++) {
			a[i].task_print();
		}
	}
}
