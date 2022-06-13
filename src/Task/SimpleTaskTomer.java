package Task;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/** maybe change name????????? **/

public class SimpleTaskTomer {

	//--------------Data Members--------------
	
	private JPanel checkBoxPanel = new JPanel();
	private JPanel labelPanel 	 = new JPanel();
	private JPanel buttonPanel 	 = new JPanel();
	
	//--------------Constructor--------------
	
	public SimpleTaskTomer(String label) {
		this.initCheckBox();
		this.initLabelPanel(label);
		this.initButtonPanel();
	}
	
	//--------------Getters--------------
	
	public JPanel getCheckBoxPanel() {
		return this.checkBoxPanel;
	}
	
	public JPanel getLabelPanel() {
		return this.labelPanel;
	}
	
	public JPanel getButtonPanel() {
		return this.buttonPanel;
	}

	//--------------initiate Methods--------------
	
	//___________initiate Check Box Panel___________
	
	public void initCheckBox() {
		this.checkBoxPanel.setLayout(new GridLayout(30, 1, 10, 5));
		this.checkBoxPanel.setBackground(Color.WHITE);
	}
	
	//___________initiate Label Panel___________
	
	public void initLabelPanel(String text) {
		this.labelPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
		this.labelPanel.setBackground(Color.GRAY);
		JLabel label = new JLabel(text);
		label.setFont(new Font("david", Font.BOLD, 24));
		this.labelPanel.add(label);
	}
	
	//___________initiate button Panel___________
	
	public void initButtonPanel() {
		
		this.buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
		this.buttonPanel.setBackground(Color.LIGHT_GRAY);
		
	}
	
	//--------------Adding Methods--------------
	
	//___________Adding ChackBoxs___________
	
	public void addCheckBox(String task, ActionListener al) {
		JCheckBox checkBox = new JCheckBox();
		checkBox.setText(task);
		this.checkBoxPanel.add(checkBox);
		checkBox.addActionListener(al);
	}
	
	//___________Adding Button___________
	
	public void addButton(String text, ActionListener al) {
		JButton button = new JButton(text);
		this.buttonPanel.add(button);
		button.addActionListener(al);
	}
	
	
	
	
}
