package contact;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUILogin extends JFrame{
    private JPanel mainpanel;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JLabel usernamelabel;
    private JLabel passwordlabel;
    private JTextField username;
    private JPasswordField password;
    private JButton enter;
    private JLabel label;
    private int countdown = 3;
    private ImageIcon image;
    private JLabel picturelabel;
    private Authentication Au;
    private AddressBook Ab;
//    private DatabaseManager Dm;
//ALL THATS LEFT IS TO CHECK IF THE DATA ENTERED IS CORRECT THEN CALL USERINTERACE.JAVA .... LOGIN SHOULD CALL WELCOME
     
     
    public GUILogin(Authentication Au){
    	this.Au = Au;
        mainpanel = new JPanel();
        mainpanel.setLayout(new BorderLayout());
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel1.setLayout(new GridLayout(3,4));
        panel1.setBackground(Color.LIGHT_GRAY);
        panel2.setBackground(Color.LIGHT_GRAY);
        panel3.setBackground(Color.YELLOW);
           
        usernamelabel = new JLabel("Username: ");
        panel1.add(usernamelabel);
        
        username = new JTextField();
        panel1.add(username);

        passwordlabel = new JLabel("Password: ");
        panel1.add(passwordlabel);
     
        password = new JPasswordField();
        panel1.add(password);

        enter = new JButton ("ENTER");
        enter.setToolTipText("login");
        enter.addActionListener (new ButtonListener());
        panel2.add(enter); 

        label = new JLabel("Please note: You have " + this.countdown + " tries before being locked out of the system.");
        label.setFont (new Font ("Helvetica", Font.BOLD, 15));
        panel3.add(label);
        label.setForeground(Color.blue); //would choose red but it might be hard to see... try it

        image = new ImageIcon(getClass().getResource("loginicon2.png")); //loginicon2.png
        //image = new ImageIcon(new ImageIcon("loginicon2.png").getImage().getScaledInstance(100, 90, Image.SCALE_DEFAULT));
        picturelabel = new JLabel(image);
        panel3.add(picturelabel);
        
        mainpanel.add(panel1, BorderLayout.CENTER);
        mainpanel.add(panel2, BorderLayout.SOUTH);
        mainpanel.add(panel3, BorderLayout.NORTH);
     
        mainpanel.setPreferredSize (new Dimension(600, 500));
        mainpanel.setBackground (Color.LIGHT_GRAY);

        //setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().add(mainpanel);
    	pack();
        setVisible(true);

    }

    private class ButtonListener implements ActionListener{
    	DatabaseManager Db = new DatabaseManager();
    	AddressBook ab = new AddressBook(Db);
        public void actionPerformed (ActionEvent event)
        {
           if (event.getSource() == enter){
               
        	   String myPass=String.valueOf(password.getPassword());
        	 boolean check = Au.checkValidPassword(username.getText(),myPass);
                if(check==true){
//                	label.setText("SUCCESS");
                	WelcomeGUI wGui = new WelcomeGUI(Ab, Db);
                }
                else {
                	int n;
                    Object[] options = { "Ok" };
                    n = JOptionPane.showOptionDialog(null, "No user found", "Login Error",JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
                    //if yes: go to login page, if no.. just exit this panel
                    switch(n) {
                      case 0: //System.exit(0); 
                      //new Delete().setVisible(true);	
                	}
                }
              
                if (countdown==0){
                    label.setText("SORRY, LOCKED OUT OF SYSTEM!");
                    enter.setEnabled(false);
                }
                
                else if(check == false){
                	countdown--;
                    if(countdown==1){
                        label.setText("Please note: You have " + countdown + " try left before being locked out of the system.");
                    }
                    else{   
                        label.setText("Please note: You have " + countdown + " tries left before being locked out of the system.");
                    }
                    
           }
                
        }
     }
    }
     

    public static void main(String[] args){
        /**JFrame frame = new JFrame ("ADDRESS BOOK LOGIN");
           frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
     
           frame.getContentPane().add(new GUILogin());
     
           frame.pack();
           frame.setVisible(true);*/
        Authentication AU = new Authentication();
        GUILogin gui = new GUILogin(AU);
//        new GUILogin().setVisible(true);
    }
}
