package Task;
import java.util.*;
import java.time.*;
import java.time.format.*;

public abstract class Task{
	static int idGen = 0;
	private boolean active;
	private int taskID;
	private LocalDateTime timeCreated;
	private LocalDateTime timeTarget;
	private String title = new String();
	private String label = new String();
	private DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	
	
	//getters 
	public String getTitle() {
		return this.title;
	}
	public String getLabel() {
		return this.label;
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
	public int getTaskID() {
		return this.taskID;
		
	}
	//setters 
	public void setTitle(String title) {
		this.title = title;
	}
	public void setLabl(String label) {
		this.label = label;
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
	public void setTaskID() {
		this.taskID = idGen;
		idGen ++;
		
	}
	

//	public void task_print() {
//		DateTimeFormatter formatter2 = DateTimeFormatter.ISO_DATE_TIME;
//		System.out.println("###############################");
//		System.out.println(String.format("Task name -- %s", this.getTitle()));
//		System.out.println(String.format("Task created at -- %s", this.getCreateDate().format(formatter2)));
//		System.out.println(String.format("Task taget time is -- %s", this.getTargetDate().format(formatter2)));
//		System.out.println(String.format("is active -- %b", this.getActive()));
//		System.out.println("###############################");
//
//	}
	abstract void taskPrint();
	abstract Task crateTask();
	
	//constructors 

//	public Task(String title) {
//		this.setTaskID()
//		this.setActive(true);
//		this.setTitle(title);
//		this.setCreateDate();
//		
//	}
//	public Task(String title,String target_time) {
//		this.setTaskID()
//		this.setActive(true);
//		this.setTitle(title);
//		this.setCreateDate();
//		this.setTargetDate(target_time);
//		
//	}


}
