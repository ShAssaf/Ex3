package Ex3;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		TaskArr tasks = new TaskArr();
		Task t1 = new Task("drink milk");
		Task t2 = new Task("buy milk");
		tasks.addTask(t1);
		tasks.addTask(t2);
		t1.setTargetDate("1999-03-14 08:02:00");
		t2.setTargetDate("1999-03-12 08:02:00");
		System.out.println(tasks.taskArr.get(0).getTitle());
		tasks.sort_by_title();
		System.out.println(tasks.taskArr.get(0).getTitle());
		tasks.sort_by_date_started();
		System.out.println(tasks.taskArr.get(0).getTitle());
		tasks.sort_by_date_target();
		System.out.println(tasks.taskArr.get(0).getTitle());

	}
}
