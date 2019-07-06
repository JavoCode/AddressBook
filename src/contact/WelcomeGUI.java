package contact;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class WelcomeGUI extends JFrame{

   private JPanel mainpanel;
   private JPanel northpanel;
   private JPanel southpanel, southpaneleast, southpanelwest;
   private JPanel westpanel, westpanelmini;
   private JPanel centerpanel, centerpanelmini;
   private JButton add;
   private JButton display;
   private JButton search;
   private JButton delete;
   private JButton enter;
   private JButton help;
   private JButton logout;
   private JButton home;
   private JLabel picturelabel;
   private JLabel welcome;
   private JRadioButton sortbyentry;
   private JRadioButton sortbyname;
   private ImageIcon image;
   private AddressBook ab;
   private DatabaseManager dm;
   
    public WelcomeGUI(AddressBook ab,DatabaseManager Db){
    	this.ab = ab;
    	this.dm = Db;
    	dm.readFile();
        mainpanel = new JPanel();
        mainpanel.setLayout(new BorderLayout());
        mainpanel.setPreferredSize (new Dimension(1000, 600));
        mainpanel.setBackground (Color.LIGHT_GRAY);
        
        northpanel = new JPanel();
        mainpanel.add(northpanel, BorderLayout.NORTH);
        northpanel.setBorder(BorderFactory.createLineBorder(Color.white));
        northpanel.setBackground (Color.YELLOW);

        southpanel = new JPanel();
        mainpanel.add(southpanel, BorderLayout.SOUTH);
        southpanel.setBorder(BorderFactory.createLineBorder(Color.white));
        southpanel.setBackground (Color.YELLOW);
        //southpaneleast = new JPanel();
        //southpanelwest = new JPanel();
        //southpanel.add(southpaneleast, BorderLayout.EAST);
        //southpanel.add(southpanelwest, BorderLayout.WEST);
        help = new JButton("HELP");
        help.setFont(new Font("Arial", Font.BOLD, 20));
        help.addActionListener (new ButtonListener()); 
        southpanel.add(help);
        logout = new JButton("LOGOUT");
        logout.setFont(new Font("Arial", Font.BOLD, 20));
        logout.addActionListener (new ButtonListener()); 
        southpanel.add(logout);

        centerpanel = new JPanel();
        mainpanel.add(centerpanel, BorderLayout.CENTER);
        centerpanel.setBorder(BorderFactory.createLineBorder(Color.white));
        centerpanel.setBackground (Color.DARK_GRAY);

        centerpanelmini = new JPanel();
        centerpanelmini.setLayout(new GridLayout(0,1));
        centerpanel.add(centerpanelmini);
        centerpanelmini.setBackground (Color.DARK_GRAY);

        westpanel = new JPanel();
        mainpanel.add(westpanel, BorderLayout.WEST);
        westpanel.setBorder(BorderFactory.createLineBorder(Color.white));
        westpanel.setBackground (Color.DARK_GRAY);

        westpanelmini = new JPanel();
        westpanelmini.setLayout(new GridLayout(3,4));
        westpanel.add(westpanelmini);

        image = new ImageIcon(getClass().getResource("picture3.png"));
        picturelabel = new JLabel(image);
        westpanelmini.add(picturelabel);

        centerpanelmini.add(Box.createVerticalStrut(50)); //add a blank space between buttons

        add = new JButton("ADD CONTACTS");
        //add.setPreferredSize(new Dimension(200, 100));
        add.setToolTipText("Create/Add a new contact");
        add.addActionListener (new ButtonListener()); 
        centerpanelmini.add(add);
        add.setFont(new Font("Arial", Font.BOLD, 30));

        centerpanelmini.add(Box.createVerticalStrut(50)); //add a blank space between buttons

        display = new JButton("DISPLAY CONTACTS");
        //display.setPreferredSize(new Dimension(200, 100));
        display.setToolTipText("view all contacts in your address book");
        display.addActionListener(new ButtonListener()); 
        centerpanelmini.add(display);
        display.setFont(new Font("Arial", Font.BOLD, 30));

        centerpanelmini.add(Box.createVerticalStrut(50)); //add a blank space between buttons

        search = new JButton("SEARCH CONTACTS");
        //search.setPreferredSize(new Dimension(200, 100));
        search.setToolTipText("search for a contact");
        search.addActionListener(new ButtonListener()); 
        centerpanelmini.add(search);
        search.setFont(new Font("Arial", Font.BOLD, 30));

        centerpanelmini.add(Box.createVerticalStrut(50)); //add a blank space between buttons

        delete = new JButton("DELETE CONTACT");
        delete.setToolTipText("delete a contact");
        delete.addActionListener(new ButtonListener()); 
        centerpanelmini.add(delete);
        delete.setFont(new Font("Arial", Font.BOLD, 30));

        enter = new JButton("Enter");
        enter.setToolTipText("enter");
        enter.addActionListener(new ButtonListener()); 

        //label = new JLabel ("--");
        //centerpanel.add(label);

        welcome = new JLabel("WELCOME TO YOUR ADDRESSBOOK ");
        northpanel.add(welcome);
        welcome.setFont (new Font ("Helvetica", Font.BOLD, 30));

        //home = new JButton("HOME");
        //home.addActionListener (new ButtonListener()); 
        //northpanel.add(home);
        //Icon i = new ImageIcon("home.jpg");
        //home.setIcon(i);

        sortbyentry = new JRadioButton("sort by entry number");
        
        sortbyname = new JRadioButton("sort by name");


        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        getContentPane().add(mainpanel);
    	  pack();
        setVisible(true);
   } 

   private class ButtonListener implements ActionListener{
	   DatabaseManager DM = new DatabaseManager();
       AddressBook AB = new AddressBook(DM);
    public void actionPerformed (ActionEvent event)
    {
    	
       if (event.getSource() == add){
//    	   dm.readFile();
          //when i click x for the new panel, everything exits... also, it opens more panels.. should i disable them until i clear current panel
          //label.setText("EVENT: ADD");
          CreateContact cc = new CreateContact(AB, DM);
          cc.setVisible(true);
          //cc.run();
          //new CreateContact().setVisible(true);
        }
        if (event.getSource() == display){
          //label.setText("EVENT: DISPLAY");
        	 
        	
		
		DisplayGUI dg = new DisplayGUI(AB, DM);
         
          dg.setVisible(true);
          dispose();
          //northpanel.add(sortbyentry);
          //northpanel.add(sortbyname);
          //welcome.setVisible(false);
          //northpanel.add(enter);

        }
        if (event.getSource() == search){
            //label.setText("EVENT: SEARCH");
            Search s = new Search(ab, DM);
            s.setVisible(true);
        }
        if (event.getSource() == delete){
          //label.setText("EVENT: DELETE");
          Delete d = new Delete(AB, DM);
          d.setVisible(true);
        }
        if (event.getSource() == enter){
            sortbyentry.setVisible(false);
            sortbyname.setVisible(false);
            enter.setVisible(false);
            welcome.setText("*display contacts here*");
            welcome.setVisible(true);
        }
        if (event.getSource() == logout){
          int n;
          Object[] options = { "Yes", "No" };
          n = JOptionPane.showOptionDialog(null, "Are you sure you want to log out?", "Logout confirmation",JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
          //if yes: go to login page, if no.. just exit this panel
          switch(n) {
            case 0: //System.exit(0); 
            Menu menu = new Menu(ab, dm); menu.setVisible(true); dispose();  //Yes option... should go to start menu...  but for now, it closes the page.
            //case 1: JOptionPane.showMessageDialog(null, "GOODBYE!"); //No option
          }
        }
    }
}

    public static void main (String[] args){
      //JFrame frame = new JFrame ("ADDRESS BOOK");
      //frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

      //frame.getContentPane().add(new WelcomeGUI());

      //frame.pack();
      //frame.setVisible(true);
    	DatabaseManager Dm = new DatabaseManager();
    	AddressBook Ab = new AddressBook(Dm);
      
    	WelcomeGUI wGui = new WelcomeGUI(Ab,Dm);

   }
}
