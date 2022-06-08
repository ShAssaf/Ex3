package Ex3;

public class AssignedTask extends Task {
	private Contacts contact = new Contacts();
	
	//getters 
	public Contacts get_contact() {
		return this.contact;
	}
	
	//setters 
	public void set_contact(Contacts contact) {
		this.contact = contact;
	}
	
	//printers
	@Override
	public void task_print() {
		System.out.println("###############################");
		System.out.println(String.format("Task name -- %s", this.getTitle()));
		System.out.println(String.format("Task created at -- %s", this.getCreateDate().format(formatter2)));
		System.out.println(String.format("Task target time is -- %s", this.getTargetDate().format(formatter2)));
		System.out.println(String.format("is active -- %b", this.getActive()));
		System.out.println("Contact: " + this.get_contact().get_name()
				+ ", " + this.get_contact().get_phone_num());
		System.out.println("###############################");
	}
		
	//constructors 

	public AssignedTask(String title, Contacts contact) {
		super(title);
		this.contact = contact;
		
	}
	public AssignedTask(String title,String target_time, Contacts contact) {
		super(title, target_time);
		this.contact = contact;
		
	}

	
}
