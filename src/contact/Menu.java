package contact;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menu extends JFrame{ 
    private JPanel mainpanel;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JLabel loginicon, signupicon;
    private JLabel newaccount, oldaccount;
    private JButton login, signup;
    private ImageIcon image;
    private JLabel picturelabel;
    private AddressBook ab;
    private DatabaseManager db;
    
//ALL THATS LEFT IS TO CHECK IF THE DATA ENTERED IS CORRECT THEN CALL USERINTERACE.JAVA
     
     
    public Menu(AddressBook ab,DatabaseManager db){
    	this.ab = ab;
    	this.db = db;
//    	db.readFile();
        mainpanel = new JPanel();
        mainpanel.setLayout(new BorderLayout());
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel1.setBackground(Color.LIGHT_GRAY);
        panel2.setBackground(Color.LIGHT_GRAY);
        mainpanel.add(panel1, BorderLayout.NORTH);
        mainpanel.add(panel2, BorderLayout.SOUTH);
        mainpanel.add(panel3, BorderLayout.CENTER);
           
        newaccount = new JLabel("Have an account?  ");
        newaccount.setFont(new Font("Serif", Font.BOLD, 30));
        panel1.add(newaccount);
        
        login = new JButton("LOGIN");
        login.setFont(new Font("Serif", Font.BOLD, 30));
        login.addActionListener (new ButtonListener());
        panel1.add(login);

        oldaccount = new JLabel("Don't have an account? ");
        oldaccount.setFont(new Font("Serif", Font.BOLD, 30));
        panel2.add(oldaccount);
     
        signup = new JButton("SIGNUP");
        signup.setFont(new Font("Serif", Font.BOLD, 30));
        signup.addActionListener (new ButtonListener());
        panel2.add(signup);

        image = new ImageIcon(getClass().getResource("picture3.png"));
        picturelabel = new JLabel(image);
        panel3.add(picturelabel);

     
        mainpanel.setPreferredSize (new Dimension(1000,600)); //100,600

        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        getContentPane().add(mainpanel);
    	pack();
        setVisible(true);

    }

    private class ButtonListener implements ActionListener{
        public void actionPerformed (ActionEvent event){
        	Authentication Au = new Authentication();
            if(event.getSource()==login){
                GUILogin login = new GUILogin(Au);
                login.setVisible(true);  
            }
            else if(event.getSource()==signup){
            	WriteFile wf = new WriteFile();
                GUIRegister sign = new GUIRegister(wf, Au);
                sign.setVisible(true);  
            }
        }
    }
     

    public static void main(String[] args){
        /** JFrame frame = new JFrame ("ADDRESS BOOK REGISTRATION");
           frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
     
           frame.getContentPane().add(new GUISignUp());
     
           frame.pack();
           frame.setVisible(true);*/
    	DatabaseManager Db = new DatabaseManager();
        AddressBook Ab = new AddressBook(Db);
        Menu menu = new Menu(Ab, Db);
    }
}
