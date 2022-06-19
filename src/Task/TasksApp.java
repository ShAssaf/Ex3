package Task;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.ArrayList;

import javax.swing.JOptionPane;


public class TasksApp{
	
	private TaskArr TAsimple = new TaskArr();
	private TaskArr TAdated = new TaskArr();
	private GUI gui = new GUI("Task Maneger",400,600);
	private SimpleTaskTomer simpleTask = new SimpleTaskTomer("Simple Task Maneger");
	private SimpleTaskTomer complexTask = new SimpleTaskTomer("Complex Task Maneger");
	private SimpleTaskTomer datedTask = new SimpleTaskTomer("Dated Task Maneger");
	private int current;
	//private ArrayList<model> tasks = new ArrayList<model>();//???
	
	public TasksApp() {
		this.gui.loadSimpleFrame(simpleTask);
		
		this.addSimpleTaskButton(simpleTask);
		this.addSimpleTaskButton(complexTask);
		this.addDatedTaskButton(datedTask);
		
		this.addSortByTitleButton(simpleTask);
		this.addSortByTitleButton(complexTask);
		this.addSortByTitleButton(datedTask);
		
		this.addSimpleTaskMenu(simpleTask);
		this.addComplexTaskMenu(complexTask);
		this.addDatedTaskMenu(datedTask);
	}
	
	public void setCurrentPanel(int c) {
		/**
		 * 0 - simple
		 * 1 - complex
		 * 3 - dated
		 */
		this.current = c;
	}
	
	public SimpleTaskTomer getCurrentPanel() {
		switch(this.current)
		{
			case(0):
				return this.simpleTask;
			case(1):
				return this.complexTask;
			case(2):
				return this.datedTask;
		}
		return null;
	}
	
	/**------------[Simple Task Methods]-------------**/
	
	public void addSimpleTask(SimpleTaskTomer st) {
		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				// TODO Auto-generated method stub 
				if(TAsimple.getNext().getActive())	
					TAsimple.getNext().setActive(false);
				else
					TAsimple.getNext().setActive(true);
				System.out.println(TAsimple.getNext().getLabel() + TAsimple.getNext().getActive());
			}
		};
		st.addCheckBox(this.TAsimple.getNext().getTitle(),this.TAsimple.getNext().getDescription(),al);
	}
	
	public void addSimpleTask(SimpleTaskTomer st, int index) {
		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				// TODO Auto-generated method stub 
				if(TAsimple.getNext().getActive())	
					TAsimple.getNext().setActive(false);
				else
					TAsimple.getNext().setActive(true);
				System.out.println(TAsimple.getNext().getLabel() + TAsimple.getNext().getActive());
			}
		};
		st.addCheckBox(this.TAsimple.taskArr[index].getTitle(),this.TAsimple.taskArr[index].getDescription(),al);
	}
	
	public void addSimpleTaskButton(SimpleTaskTomer st) {
		 String task =" ";
		 String desc = " ";
		 ActionListener al = new ActionListener() {
			 @Override
			 public void actionPerformed(ActionEvent e){
				 // TODO Auto-generated method stub
				 String task = JOptionPane.showInputDialog("Enter new task");  
				 String desc = JOptionPane.showInputDialog("Enter description"); 
				 TAsimple.addTask(new SimpleTask(task, desc));
				 addSimpleTask(st);
				 gui.reset();
			}
		};
		st.addButton("add task", al);
	}
	
	/**------------[Dated Task Methods]-------------**/
	
	public void addDatedTask(SimpleTaskTomer st) {
		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				// TODO Auto-generated method stub 
				if(TAdated.getNext().getActive())	
					TAdated.getNext().setActive(false);
				else
					TAdated.getNext().setActive(true);
				System.out.println(TAdated.getNext().getTitle() + TAdated.getNext().getActive());
			}
		};
		st.addCheckBox(this.TAdated.getNext().getTitle(),Task.convertDateToString(this.TAdated.getNext().getTargetDate()),al);
	}
	
	public void addDatedTask(SimpleTaskTomer st, int index) {
		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				// TODO Auto-generated method stub 
				if(TAdated.getNext().getActive())	
					TAdated.getNext().setActive(false);
				else
					TAdated.getNext().setActive(true);
				System.out.println(TAdated.getNext().getTitle() + TAdated.getNext().getActive());
			}
		};
		st.addCheckBox(this.TAdated.taskArr[index].getTitle(),Task.convertDateToString(this.TAdated.taskArr[index].getTargetDate()),al);
	}
	
	public void addDatedTaskButton(SimpleTaskTomer st) {
		 String task =" ";
		 String date = " ";
		 ActionListener al = new ActionListener() {
			 @Override
			 public void actionPerformed(ActionEvent e){
				 // TODO Auto-generated method stub
				 String task = JOptionPane.showInputDialog("Enter new task");  
				 String date = JOptionPane.showInputDialog("Enter date yyyy-MM-dd HH:mm:ss"); 
				 TAdated.addTask(new SimpleTask(task, date));
				 addDatedTask(st);
				 gui.reset();
			}
		};
		st.addButton("add task", al);
	}


	/**-----------[Sorts]-----------**/
	
	public void addSortByTitleButton(SimpleTaskTomer st) {
		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				// TODO Auto-generated method stub
				st.getCheckBoxPanel().removeAll();
				if(current == 0) {
					TaskArr.sort_by_title(TAsimple.taskArr);
					for(int i=0;i<TAsimple.taskArr.length;i++) {
						addSimpleTask(st,i);
					}
				}
				else if(current == 1) {
					
				}
				else if(current == 2){
					TaskArr.sort_by_title(TAdated.taskArr);
					for(int i=0;i<TAdated.taskArr.length;i++) {
						addSimpleTask(st,i);
					}
				}				
				gui.reset();
				
			}
		};
		st.addButton("Sort", al);
	}

	
	
	/**-----------[menus]-----------**/
	
	public void addSimpleTaskMenu(SimpleTaskTomer st) {
		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				// TODO Auto-generated method stub
				gui.remove(getCurrentPanel());
				gui.loadSimpleFrame(simpleTask);
				setCurrentPanel(0);
			}
		};
		this.gui.addMenu("Simple", al);
	}
	
	public void addComplexTaskMenu(SimpleTaskTomer st) {
		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				// TODO Auto-generated method stub
				gui.remove(getCurrentPanel());
				gui.loadSimpleFrame(complexTask);
				setCurrentPanel(1);
			}
		};
		this.gui.addMenu("Complex", al);
	}
	
	public void addDatedTaskMenu(SimpleTaskTomer st) {
		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				// TODO Auto-generated method stub
				gui.remove(getCurrentPanel());
				gui.loadSimpleFrame(datedTask);
				setCurrentPanel(2);
			}
		};
		this.gui.addMenu("Dated", al);
	}
	
	public void APPMgr(){
		
	}
}
