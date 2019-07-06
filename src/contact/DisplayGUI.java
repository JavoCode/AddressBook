package contact;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.*;
import javax.*;

public class DisplayGUI extends JFrame{
	private static JTable table;
	public JTextArea textarea;
	private JLabel label, arealabel;
	private JScrollPane scroll;
	private JPanel mainpanel;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JButton add;
	private JButton update;
	//private JButton delete;
	//private JButton close;
	private JButton help;
	//private JButton search;
	private JButton home;
	private static int rowCnt = 0;
	private static int selectedRow;
	private String data[][] = {{"","", "", "",""}};
	private String column[] = {"Entry Number","First Name","Last Name","Gender","Email Address"};
	private int pos = 0;
	private AddressBook ab;
//	private DatabaseManager db2;
	

	public DisplayGUI(AddressBook ab, DatabaseManager db2){
//		this.ab = new AddressBook(db2);
		this.ab = ab;
//		this.db2 = db2;
		db2.readFile();
		mainpanel = new JPanel();
		mainpanel.setLayout(new BorderLayout());
		mainpanel.setPreferredSize (new Dimension(1000, 600));
		mainpanel.setBackground (Color.LIGHT_GRAY);
		
		//
		//panel1.add(panel2, BorderLayout.SOUTH);
		//panel1.setPreferredSize(new Dimension(750, 300));

		
		//PANELS
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
        panel1.setBackground(Color.YELLOW);
        panel2.setBackground(Color.LIGHT_GRAY);
		panel3.setBackground(Color.YELLOW);

		//MAIN PANEL
		mainpanel.add(panel1);
        mainpanel.add(panel2);
		mainpanel.add(panel3);
		
		arealabel = new JLabel("Entry Number                    First Name                    Last Name                    Gender                    Email Address");
		panel2.add(arealabel);
     
		
		//JTABLE
		//table = new JTable(data,column);
	
		//TEXTAREA
		textarea = new JTextArea(15,60);
		scroll = new JScrollPane(textarea);
		//panel2.add(scroll, BorderLayout.CENTER);
		textarea.setEditable(false);
		panel2.add(scroll);
		//textarea.append("Entry Number First Name Last Name Gender Email Address");
		//panel2.setSize(900,400);
		System.out.println(ab.displayAllContacts());
		textarea.setText(db2.displayGuiContacts());

		//JLabel
		label = new JLabel("ADDRESS BOOK");
		panel1.add(label);
		label.setFont(new Font("Serif", Font.BOLD, 40));

		//BUTTONS
		add = new JButton("ADD CONTACT");
		add.addActionListener(new ButtonListener());
		panel3.add(add);
		update = new JButton("UPDATE CONTACT");
		update.addActionListener(new ButtonListener());
		panel3.add(update);
		//delete = new JButton("Delete");
		//delete.addActionListener(new ButtonListener());
		//panel3.add(delete);
		//search = new JButton("Search");
		//search.addActionListener(new ButtonListener());
		//panel3.add(search);
		help = new JButton("HELP");
		help.addActionListener(new ButtonListener());
		panel3.add(help, BorderLayout.EAST);
		home = new JButton("HOME");
		home.addActionListener(new ButtonListener());
		panel3.add(home, BorderLayout.EAST);

		//ADDING PANELS TO MAIN PANEL
		mainpanel.add(panel1, BorderLayout.NORTH);
		mainpanel.add(panel2);  //mainpanel.add(panel2, BorderLayout.CENTER);
		mainpanel.add(panel3, BorderLayout.SOUTH);
		

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().add(mainpanel);
    	pack();
        setVisible(true);
        
	
	}
	

		//ACTION LISTENER
		private class ButtonListener implements ActionListener{
			DatabaseManager Db = new DatabaseManager();
			AddressBook ab = new AddressBook(Db);
			public void actionPerformed (ActionEvent event){
				if (event.getSource() == add){
					CreateContact cc = new CreateContact(ab, Db);
          			cc.setVisible(true);
				}
				if (event.getSource() == update){
					
					//UpdateEntry(jTable.getValueAt(getSelectedRow(), 0).toString(),
								//jTable.getValueAt(getSelectedRow(), 1).toString(),
								//jTable.getValueAt(getSelectedRow(), 2).toString(),
								//jTable.getValueAt(getSelectedRow(), 3).toString()).setVisible(true);
					UpdateContact uc = new UpdateContact(ab, Db);
					uc.setVisible(true);
				}
				//if (event.getSource() == delete){
					//removeEntry();......are you sure you want to remove?
				//}
				//if (event.getSource() == search){
					//setVisible(true);
					//System.exit(0);
				//}
				if(event.getSource() == home){
					WelcomeGUI wg = new WelcomeGUI(ab, Db);
					wg.setVisible(true);
					dispose();
				}
			}
		}

		
	public static void main(String args[]){
		
		//frame.setDefaultLookAndFeelDecorated(true);

		//JFrame frame = new JFrame("Address Book");

		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//frame.setResizable(false);

		//frame.getContentPane().add(new DisplayGUI());

		//frame.pack();
		//frame.setVisible(true);
		DatabaseManager Db = new DatabaseManager();
		AddressBook Ab = new AddressBook(Db);
		DisplayGUI newD = new DisplayGUI(Ab,Db);
	}
}

	