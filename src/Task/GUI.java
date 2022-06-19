package Task;

import java.awt.BorderLayout;

import java.awt.event.ActionListener;

import javax.swing.*;  

public class GUI {
	
	//--------------Data Member--------------
	
	private JFrame frame 		 = new JFrame();
	
	private JMenu menu 			 = new JMenu("Tasks"); 
	private JMenuBar menuBar 	 = new JMenuBar();
	
	//--------------Constructor--------------
	
	public GUI(String title, int widght, int height) {
		this.frame.setTitle(title);
		this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.frame.setSize(widght, height);
		this.frame.setResizable(false);
		this.frame.setLocationRelativeTo(null);
		this.frame.setVisible(false);
		
		this.menuBar.add(this.menu); 	
		this.frame.setJMenuBar(menuBar);
		
	}
	
	//--------------reset--------------
	
	//___________load frame___________
	
	public void loadSimpleFrame(Panel st) {
		this.frame.add(st.getCheckBoxPanel(), BorderLayout.CENTER);
		this.frame.add(st.getLabelPanel(), BorderLayout.NORTH);
		this.frame.add(st.getButtonPanel(), BorderLayout.SOUTH);
		this.reset();
	}
	
	//___________preper the frame for the next one___________
	
	public void remove(Panel st) {
		this.frame.remove(st.getCheckBoxPanel());
		this.frame.remove(st.getLabelPanel());
		this.frame.remove(st.getButtonPanel());
		this.frame.setVisible(false);
	}
	
	//___________reset the frame___________
	
	public void reset() {
		this.frame.setVisible(false);
		this.frame.setVisible(true);
	}
	

	public void addMenu(String text, ActionListener al) {
		JMenuItem menuItem 	 = new JMenuItem(text);
		this.menu.add(menuItem);
		
		menuItem.addActionListener(al);
		this.reset();
	}
	
	public void addCheckBoxMenu(String text, ActionListener al) {
		JCheckBoxMenuItem menuItem 	 = new JCheckBoxMenuItem(text);
		this.menu.add(menuItem);
		
		menuItem.addActionListener(al);
		this.reset();
	}
}
