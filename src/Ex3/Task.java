package Ex3;
import java.util.*;
import java.time.*;
import java.time.format.*;

public class Task{
	private boolean active;
	private LocalDateTime timeCreated;
	private LocalDateTime timeTarget;
	private String title = new String();
	public DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	public DateTimeFormatter formatter2 = DateTimeFormatter.ISO_DATE_TIME;
	
	
	
	//getters 
	public String getTitle() {
		return this.title;
	}
	public LocalDateTime getCreateDate() {
		return this.timeCreated;
	}
	public LocalDateTime getTargetDate() {
		return this.timeTarget;
	}
	public boolean getActive() {
		return this.active;
		
	}
	//setters 
	public void setTitle(String title) {
		this.title = title;
	}
	public void setCreateDate() {
		this.timeCreated = LocalDateTime.now();
	}
	public void setTargetDate(String date_string) {
		
		this.timeTarget = LocalDateTime.parse(date_string, formatter1);
	}
	public void setActive(boolean active) {
		this.active= active;
		
	}
	
	
	//static methods
	public static void sort_by_title(Task[] tasks) { // sort in place
       Arrays.sort(tasks, new Comparator<Task>() {
            @Override
            public int compare(Task first, Task second)
            {
                return first.getTitle().compareTo(second.getTitle());
            }
        }
       );
	}
	public static void sort_by_date_started(Task[] tasks) { // sort in place
	       Arrays.sort(tasks, new Comparator<Task>() {
	            @Override
	            public int compare(Task first, Task second)
	            {
	                return first.getCreateDate().compareTo(second.getCreateDate());
	            }
	        }
	       );
		}
	public static void sort_by_date_target(Task[] tasks) { // sort in place
	       Arrays.sort(tasks, new Comparator<Task>() {
	            @Override
	            public int compare(Task first, Task second)
	            {
	                return first.getTargetDate().compareTo(second.getTargetDate());
	            }
	        }
	       );
		}
	public void task_print() {
		System.out.println("###############################");
		System.out.println(String.format("Task name -- %s", this.getTitle()));
		System.out.println(String.format("Task created at -- %s", this.getCreateDate().format(formatter2)));
		System.out.println(String.format("Task target time is -- %s", this.getTargetDate().format(formatter2)));
		System.out.println(String.format("is active -- %b", this.getActive()));
		System.out.println("###############################");

	}
	
	
	//constructors 

	public Task(String title) {
		this.setActive(true);
		this.setTitle(title);
		this.setCreateDate();
		
	}
	public Task(String title,String target_time) {
		this.setActive(true);
		this.setTitle(title);
		this.setCreateDate();
		this.setTargetDate(target_time);
		
	}


}
