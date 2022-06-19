
package Task;

public class SimpleTask extends Task {


	//constructors 

	public SimpleTask(String title,String description) {
		this.setTaskID();
		this.setActive(true);
		this.setDescription(description);
		this.setTitle(title);
		this.setCreateDate();	
	}

}