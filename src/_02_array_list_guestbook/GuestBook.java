package _02_array_list_guestbook;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GuestBook implements ActionListener {
	// Create a GUI with two buttons. One button reads "Add Name" and the other button reads "View Names". 
	// When the add name button is clicked, display an input dialog that asks the user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked, display a message dialog that displays
	// all the names added to the list. Format the list as follows:
	// Guest #1: Bob Banders
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners
	
	ArrayList<String> guestList = new ArrayList<String>();
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton addName = new JButton();
	JButton viewName = new JButton();
	
	String list;
	
	public static void main(String[] args) {
		new GuestBook().run();
	}
	
	void run() 
	{
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		panel.add(addName);
		panel.add(viewName);
		
		addName.setText("Add Name");
		addName.addActionListener(this);
		viewName.setText("View Names");
		viewName.addActionListener(this);
		
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton eventButton = (JButton)e.getSource();
		
		if (eventButton == addName)
		{
			String addedName = JOptionPane.showInputDialog("Add A Name To The Guest List:");
			guestList.add(addedName);
		}
		else if (eventButton == viewName)
		{
			list = "";
			for (int i = 0; i < guestList.size(); i++)
			{
				int guestNum = i + 1;
				list = list + "Guest #" + guestNum + ": " + guestList.get(i) + "\n";
				//System.out.println("Guest #" + guestNum + ": " + guestList.get(i));
			}
			JOptionPane.showMessageDialog(null, list);
		}
	}
}
