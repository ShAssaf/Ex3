package Task;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.ArrayList;

import javax.swing.JOptionPane;


public class TasksApp{
	
	private GUI gui = new GUI("Task Maneger",400,600);
	private SimpleTaskTomer simpleTask = new SimpleTaskTomer("Simple Task Maneger");
	private SimpleTaskTomer complexTask = new SimpleTaskTomer("Complex Task Maneger");
	private SimpleTaskTomer datedTask = new SimpleTaskTomer("Dated Task Maneger");
	private int current;
	//private ArrayList<model> tasks = new ArrayList<model>();//???
	
	public TasksApp() {
		this.gui.loadSimpleFrame(simpleTask);
		
		this.addTaskButton(simpleTask);
		this.addTaskButton(complexTask);
		this.addTaskButton(datedTask);
		
		this.addSortButton(simpleTask);
		this.addSortButton(complexTask);
		this.addSortButton(datedTask);
		
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
	public void addTask(model task , SimpleTaskTomer st) {
		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				// TODO Auto-generated method stub 
				if(task.get_finished() == 0)	
					task.set_finished(1);
				else
					task.set_finished(0);
				System.out.println(task.get_task() + task.get_finished());
			}
		};
		st.addCheckBox(task.get_task(),al);
	}
	
	public void addTaskButton(SimpleTaskTomer st) {
		model task = new model();
		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				// TODO Auto-generated method stub
				 String test = JOptionPane.showInputDialog("Enter new task");  
				 task.set_task(test);
				 task.set_finished(0);
				 addTask(task,st);
				 gui.reset();
			}
		};
		st.addButton("add task", al);
	}
	
	public void addSortButton(SimpleTaskTomer st) {
		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				// TODO Auto-generated method stub
				 System.out.println("sort");
			}
		};
		st.addButton("Sort", al);
	}
	
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
