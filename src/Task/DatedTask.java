package Task;

public class DatedTask extends Task {


	public DatedTask(String title, String target_time) {
		this.setTaskID();
		this.setActive(true);
		this.setTitle(title);
		this.setCreateDate();
		this.setTargetDate(target_time);

	}

}
