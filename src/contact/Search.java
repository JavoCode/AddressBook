package contact;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;
//REMOVE LOCATE BUTTON....DISPLAY A SINGLE TABLE BELOW WHEN THEY CLICK SEARCH IF THE CONTACT IS FOUND... WHEN CLICK, OPEN AN UPDATE CONTACT FILE BUT CHANGE ALL TO UNEDITABLE SO THEY CAN SEE FULL DELETE

public class Search extends JFrame{
    private JPanel mainpanel;
    private JPanel panel1;
    private JPanel panel2, panel2top, panel2lower;
    private JPanel panel3;
    
    private JLabel searchlabel, searchtitle;
    private JLabel findby;
    private JTextField searchtext;
    private JTextArea display;
    private JButton enter, search, locatecontact;
    private JRadioButton byentry, byemail;
    private AddressBook Ab;
    private DatabaseManager Db;
    
    
    public Search(AddressBook Ab, DatabaseManager Db){
    	this.Ab = new AddressBook(Db);
    	this.Db = Db;
    	Db.readFile();
        mainpanel = new JPanel();
        mainpanel.setLayout(new BorderLayout());
        panel1 = new JPanel();
        panel2 = new JPanel(new BorderLayout());
        panel2top = new JPanel();
        panel2lower = new JPanel();
        panel3 = new JPanel();
        
        display = new JTextArea(15,60);
		//panel2.add(scroll, BorderLayout.CENTER);
		display.setEditable(false);
		//textarea.append("Entry Number First Name Last Name Gender Email Address");
		//panel2.setSize(900,400);
		 panel2lower.add(display);
	     display.setVisible(false);
	     
		
		
		
        //panel1.setLayout(new GridLayout(3,4));
        panel1.setBackground(Color.YELLOW);
        panel2.setBackground(Color.YELLOW);
        panel2top.setBackground(Color.LIGHT_GRAY);
        panel2lower.setBackground(Color.LIGHT_GRAY);
        panel3.setBackground(Color.YELLOW);
           
        searchtitle = new JLabel("SEARCH CONTACT");
        searchtitle.setFont(new Font("Serif", Font.BOLD, 30));
        panel1.add(searchtitle);

        searchlabel = new JLabel("How would you like to search? ");
        searchlabel.setFont(new Font("Serif", Font.PLAIN, 20));
        panel2top.add(searchlabel);
     
        ButtonGroup searchgroup = new ButtonGroup();
        byentry = new JRadioButton("by entry number");
        searchgroup.add(byentry);
        panel2top.add(byentry);
        byemail = new JRadioButton("by email address");
        searchgroup.add(byemail);
        panel2top.add(byemail);

        enter = new JButton ("Enter");
        enter.setToolTipText("find contact");
        enter.addActionListener (new ButtonListener());
        panel2top.add(enter); 

        panel2.add(panel2top, BorderLayout.NORTH);
        panel2.add(panel2lower);

        findby = new JLabel("-------");
        findby.setFont(new Font("Serif", Font.PLAIN, 20));
        panel2lower.add(findby);
        findby.setVisible(false);

        searchtext = new JTextField(15);
        panel2lower.add(searchtext);
        searchtext.setVisible(false);

        //locatecontact = new JButton("Locate Contact");
        //panel2lower.add(locatecontact);
        //locatecontact.setVisible(false);

        search = new JButton ("search");
        search.setToolTipText("find contact");
        search.addActionListener (new ButtonListener());
        panel3.add(search); 

               
        mainpanel.add(panel1, BorderLayout.NORTH);
        mainpanel.add(panel2, BorderLayout.CENTER);
        mainpanel.add(panel3, BorderLayout.SOUTH);
     
        mainpanel.setPreferredSize (new Dimension(600, 300));
        mainpanel.setBackground (Color.LIGHT_GRAY);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().add(mainpanel);
    	pack();
        setVisible(true);

    }

    private class ButtonListener implements ActionListener{
        public void actionPerformed (ActionEvent event)
        {
        	
        	DatabaseManager Db = new DatabaseManager();
        	AddressBook Ab = new AddressBook(Db);
        	int entryNoF = 0;
        	
        	
           if (event.getSource() == enter){
                if(byentry.isSelected()){
                    findby.setText("Enter Contact's Entry Number: ");
                    findby.setVisible(true);
                    searchtext.setVisible(true);
                    Db.searchforEntryNo(entryNoF);
                    
//                    locatecontact.setVisible(true);
                }
                else if(byemail.isSelected()){
                    findby.setText("Enter Contact's Email Address: ");
                    findby.setVisible(true);
                    searchtext.setVisible(true);
                    //locatecontact.setVisible(true);
                }
            }
            if(event.getSource() == search){
            	
        		


            	String entryNo = searchtext.getText();
            	System.out.println(entryNo);
            	System.out.println(Db.searchforEntryNo(Integer.parseInt(entryNo)));
            	entryNoF = Integer.parseInt(entryNo);
        		display.append(Db.searchforEntryNo(entryNoF));
        		 display.setVisible(true);
        		System.out.println();

                
            }
     }
        
    }
    
   
     

    public static void main(String[] args){
        /** JFrame frame = new JFrame ("search");
           frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
     
           frame.getContentPane().add(new Search());
     
           frame.pack();
           frame.setVisible(true);*/
    	DatabaseManager Db = new DatabaseManager();
    	AddressBook Ab = new AddressBook(Db);
        Search Ss = new Search(Ab,Db);
    }
}
