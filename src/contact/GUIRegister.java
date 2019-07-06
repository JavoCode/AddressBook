package contact;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

public class GUIRegister extends JFrame{ 
    private JPanel mainpanel;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JLabel usernamelabel;
    private JLabel passwordlabel, confirmpasswordlabel;
    private JTextField username;
    private JPasswordField password, confirmpassword;
    private JButton register;
    private ImageIcon image;
    private JLabel picturelabel, textlabel;
//ALL THATS LEFT IS TO CHECK IF THE DATA ENTERED IS CORRECT THEN CALL USERINTERACE.JAVA
	private WriteFile wf;
	private Authentication au;
     
     
    public GUIRegister(WriteFile wf, Authentication au){
    	this.wf = wf;
    	this.au =au;
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

        confirmpasswordlabel = new JLabel("Confirm Password: ");
        panel1.add(confirmpasswordlabel);
     
        confirmpassword = new JPasswordField();
        panel1.add(confirmpassword);

        register = new JButton ("REGISTER");
        register.setToolTipText("create your address book account");
        register.addActionListener (new ButtonListener());
        panel2.add(register); 

        
        mainpanel.add(panel1, BorderLayout.CENTER);
        mainpanel.add(panel2, BorderLayout.SOUTH);
        mainpanel.add(panel3, BorderLayout.NORTH);
     
        mainpanel.setPreferredSize (new Dimension(700, 500));
        mainpanel.setBackground (Color.LIGHT_GRAY);

        textlabel = new JLabel("CREATE A NEW ACCOUNT");
        textlabel.setFont (new Font ("Dialog", Font.BOLD, 30));
        panel3.add(textlabel);
        //label.setForeground(Color.BLACK);

        image = new ImageIcon(getClass().getResource("register.png"));
        //image = new ImageIcon(new ImageIcon("loginicon2.png").getImage().getScaledInstance(100, 90, Image.SCALE_DEFAULT));
        picturelabel = new JLabel(image);
        panel3.add(picturelabel);

        //setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().add(mainpanel);
    	pack();
        setVisible(true);

    }

    private class ButtonListener implements ActionListener{
    	public void actionPerformed (ActionEvent event)
        {
    		
    		
           if (event.getSource() == register){
            String un = username.getText();
            String pw =String.valueOf(password.getPassword());
            String cpw = String.valueOf(password.getPassword());
            int n;
            Object[] options = { "OK"};
            
            if(un.isEmpty()==true || pw.isEmpty() == true||cpw.isEmpty() == true) {
                n = JOptionPane.showOptionDialog(null, "ENSURE ALL FIELDS ARE USED", "REGISTRATION ERROR",JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            }
            //if statements for when the user doesnt fill out a field
            else if(au.checkifUserAlreadyExist(un)==true){
                n = JOptionPane.showOptionDialog(null, "USERNAME ALREADY EXIST", "REGISTRATION",JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            }
            else if(pw.equals(cpw)){  //if both passwords are created, the registration is complete, if not... Also, check if the username already exists
                    n = JOptionPane.showOptionDialog(null, "ACCOUNT CREATED", "REGISTRATION",JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
                    try {
    					wf.updateUserDetails(un, cpw);
    				} catch (IOException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
                    switch(n) {
                    case 0:
                    	dispose();
                    }
                }else {
                        n = JOptionPane.showOptionDialog(null, "PASSWORD ERROR", "REGISTRATION",JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
                }
            }
        }
           }
        
    
     

    public static void main(String[] args){
        /** JFrame frame = new JFrame ("ADDRESS BOOK REGISTRATION");
           frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
     
           frame.getContentPane().add(new GUIRegister());
     
           frame.pack();
           frame.setVisible(true);*/
    	WriteFile wf  = new WriteFile();
    	Authentication Au = new Authentication();
        GUIRegister guiR = new GUIRegister(wf,Au);
    }
}