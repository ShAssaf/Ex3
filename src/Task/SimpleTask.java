package Task;

public class SimpleTask extends Task {


	//constructors 

	
	public SimpleTask(String title) {
		this.setTaskID();
		this.setActive(true);
		this.setTitle(title);
		this.setCreateDate();	
	}

}
