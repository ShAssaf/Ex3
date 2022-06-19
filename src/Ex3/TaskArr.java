package Ex3;

import java.util.ArrayList;
import java.util.Comparator;

public class TaskArr {
	ArrayList<Task> taskArr = new ArrayList<Task>();

	public void addTask(Task t) {
		this.taskArr.add(t);
		
	}
	public void deleteTask(Task t) { 
		this.taskArr.remove(t);
	}
	
	public void sort_by_title() { // sort in place
       this.taskArr.sort(new Comparator<Task>() {
            @Override
            public int compare(Task first, Task second)
            {
                return first.getTitle().compareTo(second.getTitle());
            }
        }
       );
	}
	
	public void sort_by_date_started() { // sort in place
		this.taskArr.sort(new Comparator<Task>() {
            @Override
            public int compare(Task first, Task second)
            {
                return first.getCreateDate().compareTo(second.getCreateDate());
            }
        }
       );
	}
	
	public void sort_by_date_target() { // sort in place
		this.taskArr.sort(new Comparator<Task>() {
            @Override
            public int compare(Task first, Task second)
            {
                return first.getTargetDate().compareTo(second.getTargetDate());
            }
        }
       );
	}
}