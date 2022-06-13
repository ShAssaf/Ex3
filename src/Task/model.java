package Task;

public class model {
	String task= new String();
	int finished;
	
	public void set_finished(int finished) {
		this.finished = finished;
	}
	
	public void set_task(String task) {
		this.task = task;
	}
	
	public int get_finished() {
		return this.finished;
	}
	
	public String get_task() {
		return this.task;
	}
	
	public void add_task(String task, int finished){
		this.set_finished(finished);
		this.set_task(task);
	}
	
	public model(String task, int finished ){
		this.add_task(task, finished);
	}
	public model(){
	}
	
}
