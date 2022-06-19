package Task;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JOptionPane;


public class TasksApp{
	
	private TaskArr TAsimple = new TaskArr();
	private TaskArr TAcomplex = new TaskArr();
	private TaskArr TAdated = new TaskArr();
	private GUI gui = new GUI("Task Maneger",475,700);
	private Panel simpleTask = new Panel("Simple Task Maneger");
	private Panel complexTask = new Panel("Complex Task Maneger");
	private Panel datedTask = new Panel("Dated Task Maneger");
	private int current;
	
	public TasksApp() {
		this.gui.loadSimpleFrame(simpleTask);
		
		this.addSimpleTaskButton(simpleTask);
		this.addComplexTaskButton(complexTask);
		this.addDatedTaskButton(datedTask);
		
		this.addSortByTitleButton(simpleTask);
		this.addSortByTitleButton(complexTask);
		this.addSortByTitleButton(datedTask);
		
		this.addSortByCreateButton(simpleTask);
		this.addSortByCreateButton(complexTask);
		this.addSortByCreateButton(datedTask);
		
		this.addSortByTargetButton(complexTask);
		this.addSortByTargetButton(datedTask);
		
		this.addSimpleTaskMenu(simpleTask);
		this.addComplexTaskMenu(complexTask);
		this.addDatedTaskMenu(datedTask);
		
		this.addShowRunningTaskOnleMenu(simpleTask);
	}
	
	public void setCurrentPanel(int c) {
		/**
		 * 0 - simple
		 * 1 - complex
		 * 3 - dated
		 */
		this.current = c;
	}
	
	public Panel getCurrentPanel() {
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
	
	public void addSimpleTask(Panel st, int index) {
		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				if(TAsimple.taskArr.get(index).getActive())	
					TAsimple.taskArr.get(index).setActive(false);
				else
					TAsimple.taskArr.get(index).setActive(true);
				System.out.println(TAsimple.taskArr.get(index).getTitle() 
						+ TAsimple.taskArr.get(index).getActive());
			}
		};
		st.addCheckBox(this.TAsimple.taskArr.get(index).getTitle()
				,this.TAsimple.taskArr.get(index).getDescription()
				,this.TAsimple.taskArr.get(index).getActive(),al);
	}
	
	public void addSimpleTaskButton(Panel st) {
		 
		 ActionListener al = new ActionListener() {
			 @Override
			 public void actionPerformed(ActionEvent e){
				 String task =" ";
				 String desc = " ";
				 task = JOptionPane.showInputDialog("Enter new task");  
				 desc = JOptionPane.showInputDialog("Enter description");
				 if((task != null) && (desc != null)) {
					 TAsimple.addTask(new SimpleTask(task, desc));
					 addSimpleTask(st,(TAsimple.taskArr.size() -1));
					 gui.reset();
				 }
			}
		};
		st.addButton("add task", al);
	}
	
	/**------------[Complex Task Methods]-------------**/
		
	public void addComplexTask(Panel st, int index) {
		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				if(TAcomplex.taskArr.get(index).getActive())	
					TAcomplex.taskArr.get(index).setActive(false);
				else
					TAcomplex.taskArr.get(index).setActive(true);
				System.out.println(TAcomplex.taskArr.get(index).getTitle() + TAcomplex.taskArr.get(index).getActive());
			}
		};
		st.addCheckBox(this.TAcomplex.taskArr.get(index).getTitle(),
				Task.convertDateToString(this.TAcomplex.taskArr.get(index).getTargetDate())
				,this.TAcomplex.taskArr.get(index).getActive(),al);
	}
	
	public void addComplexTaskButton(Panel st) {
		 
		 ActionListener al = new ActionListener() {
			 @Override
			 public void actionPerformed(ActionEvent e){
				 String task =" ";
				 String date = " ";
				 task = JOptionPane.showInputDialog("Enter new task");  
				 date = JOptionPane.showInputDialog("Enter date yyyy-MM-dd HH:mm:ss"); 
				 if((task != null) && (date != null)) {
					 TAcomplex.addTask(new ComplexTask(task, date));
				 	addComplexTask(st,(TAcomplex.taskArr.size() -1));
				 	gui.reset();
				 }
			}
		};
		st.addButton("add task", al);
	}
	
	/**------------[Dated Task Methods]-------------**/
	
	public void addDatedTask(Panel st, int index) {
		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				if(TAdated.taskArr.get(index).getActive())	
					TAdated.taskArr.get(index).setActive(false);
				else
					TAdated.taskArr.get(index).setActive(true);
				System.out.println(TAdated.taskArr.get(index).getTitle() 
						+ TAdated.taskArr.get(index).getActive());
			}
		};
		st.addCheckBox(this.TAdated.taskArr.get(index).getTitle()
				,Task.convertDateToString(this.TAdated.taskArr.get(index).getTargetDate())
				,this.TAdated.taskArr.get(index).getActive(),al);
	}
	
	public void addDatedTaskButton(Panel st) {
		 
		 ActionListener al = new ActionListener() {
			 @Override
			 public void actionPerformed(ActionEvent e){
				 String task =" ";
				 String date = " ";
				 task = JOptionPane.showInputDialog("Enter new task");  
				 date = JOptionPane.showInputDialog("Enter date yyyy-MM-dd HH:mm:ss"); 
				 if((task != null) && (date != null)) {
					 TAdated.addTask(new DatedTask(task, date));
					 addDatedTask(st,(TAdated.taskArr.size() -1));
					 gui.reset();
				 }
			}
		};
		st.addButton("add task", al);
	}

	/**-----------[Sorts]-----------**/
	
	public void addSortByTitleButton(Panel st) {
		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				st.getCheckBoxPanel().removeAll();
				if(current == 0) {
					TAsimple.sort_by_title();
					for(int i=0;i<TAsimple.taskArr.size();i++) {
						addSimpleTask(st,i);
					}
				}
				else if(current == 1) {
					TAcomplex.sort_by_title();
					for(int i=0;i<TAcomplex.taskArr.size();i++) {
						addComplexTask(st,i);
					}
				}
				else if(current == 2){
					TAdated.sort_by_title();
					for(int i=0;i<TAdated.taskArr.size();i++) {
						addDatedTask(st,i);
					}
				}				
				gui.reset();
				
			}
		};
		st.addButton("Sort by name", al);
	}

	public void addSortByCreateButton(Panel st) {
		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				st.getCheckBoxPanel().removeAll();
				if(current == 0) {
					TAsimple.sort_by_date_started();
					for(int i=0;i<TAsimple.taskArr.size();i++) {
						addSimpleTask(st,i);
					}
				}
				else if(current == 1) {
					TAcomplex.sort_by_date_started();
					for(int i=0;i<TAcomplex.taskArr.size();i++) {
						addComplexTask(st,i);
					}
				}
				else if(current == 2){
					TAdated.sort_by_date_started();
					for(int i=0;i<TAdated.taskArr.size();i++) {
						addDatedTask(st,i);
					}
				}				
				gui.reset();
				
			}
		};
		st.addButton("Sort by create", al);
	}
	
	public void addSortByTargetButton(Panel st) {
		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				st.getCheckBoxPanel().removeAll();
				if(current == 1) {
					TAcomplex.sort_by_date_target();
					for(int i=0;i<TAcomplex.taskArr.size();i++) {
						addComplexTask(st,i);
					}
				}
				else if(current == 2){
					TAdated.sort_by_date_target();
					for(int i=0;i<TAdated.taskArr.size();i++) {
						addDatedTask(st,i);
					}
				}				
				gui.reset();
				
			}
		};
		st.addButton("Sort by create", al);
	}
	
	public void showOnlyRunningTasks(Panel st) {
		st.getCheckBoxPanel().removeAll();
		if(current == 0) {
			for(int i=0;i<TAsimple.taskArr.size();i++) {
				if(TAsimple.taskArr.get(i).getActive())
					addSimpleTask(st,i);
			}
		}
		else if(current == 1) {
			for(int i=0;i<TAcomplex.taskArr.size();i++) {
				if(TAcomplex.taskArr.get(i).getActive())
					addComplexTask(st,i);
			}
		}
		else if(current == 2){
			for(int i=0;i<TAdated.taskArr.size();i++) {
				if(TAdated.taskArr.get(i).getActive())
					addDatedTask(st,i);
			}
		}				
		gui.reset();
		
	}
	public void showAllTasks(Panel st) {
		st.getCheckBoxPanel().removeAll();
		if(current == 0) {
			for(int i=0;i<TAsimple.taskArr.size();i++) {
				addSimpleTask(st,i);
			}
		}
		else if(current == 1) {
			for(int i=0;i<TAcomplex.taskArr.size();i++) {
				addComplexTask(st,i);
			}
		}
		else if(current == 2){
			for(int i=0;i<TAdated.taskArr.size();i++) {
				addDatedTask(st,i);
			}
		}				
		gui.reset();
		
	}
	
	/**-----------[menus]-----------**/
	
	public void addSimpleTaskMenu(Panel st) {
		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				gui.remove(getCurrentPanel());
				gui.loadSimpleFrame(simpleTask);
				setCurrentPanel(0);
			}
		};
		this.gui.addMenu("Simple", al);
	}
	
	public void addComplexTaskMenu(Panel st) {
		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				gui.remove(getCurrentPanel());
				gui.loadSimpleFrame(complexTask);
				setCurrentPanel(1);
			}
		};
		this.gui.addMenu("Complex", al);
	}
	
	public void addDatedTaskMenu(Panel st) {
		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				gui.remove(getCurrentPanel());
				gui.loadSimpleFrame(datedTask);
				setCurrentPanel(2);
			}
		};
		this.gui.addMenu("Dated", al);
	}
	
	public void addShowRunningTaskOnleMenu(Panel st) {
		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				AbstractButton aButton = (AbstractButton) e.getSource();  
                boolean selected = aButton.getModel().isSelected(); 
                if(selected)
                	showOnlyRunningTasks(st);
                else
                	showAllTasks(st);
			}
		};
		this.gui.addCheckBoxMenu("Show running tasks only", al);
	}
	
	public void APPMgr(){
		
	}
}
