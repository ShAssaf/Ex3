package Ex3;

import java.util.ArrayList;

public class MultiTask extends Task{
	private ArrayList<Task> tasks = 
			new ArrayList<Task>(); 

	//adders 
	public void add_sub_task(Task task) {
		this.tasks.add(task);
	}
	
	//getters 
	public Task get_task_by_index(int index) {
		return this.tasks.get(index);
	}
	
	public Task get_task_by_title(String title) {
		for (Task t : this.tasks) {
			if (t.getTitle().equals(title)) {
				return t;
			}
			else {
				continue;
			}
		}
		return null;
	}
	
	public ArrayList<Task> get_tasks_by_status(Boolean bool) {
		ArrayList<Task> ret = 
				new ArrayList<Task>();
		for (Task t : this.tasks){
			Boolean b = t.getActive();
			if (b.equals(bool)) {
				ret.add(t);
			}
			else {
				continue;
			}
		}
		return ret;
	}
	
	
	//setters 	
	public void set_task_status(Task task, Boolean bool) {
		int idx = this.tasks.indexOf(task);
		this.tasks.get(idx).setActive(bool);
	}
	
	//printers
	@Override
	public void task_print() {
		for (Task t : this.tasks) {
			t.task_print();
		};
	}
		
	//constructors 

	public MultiTask(String title) {
		super(title);
		
	}
	public MultiTask(String title,String target_time,
			ArrayList<Task> tasks) {
		super(title, target_time);
		this.tasks = tasks;
	}

}
