package Task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ComplexTask extends Task {
	// private
	MileStone[] mileStones;
	

	public ComplexTask() {
		this.setTaskID();
		this.setActive(true);
		this.setCreateDate();
	}

	public ComplexTask(String title, String target_time) {
		this.setTaskID();
		this.setActive(true);
		this.setTitle(title);
		this.setCreateDate();
		this.setTargetDate(target_time);

	}

}

class MileStone{
	boolean achived = false ;
	String title;
	LocalDateTime timeTarget = null;
	static DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	public MileStone(String title) {
		this.title = title;
		this.achived = false;
	}
	public MileStone(String title,String date_string) {
		this.title = title;
		this.achived = false;
		this.timeTarget = LocalDateTime.parse(date_string, formatter1);
	}
}

