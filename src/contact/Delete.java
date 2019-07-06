package contact;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Delete extends JFrame{
    private JPanel mainpanel;
    private JPanel panel1;
    private JPanel panel2, panel2top, panel2lower;
    private JPanel panel3;
    private JLabel deletelabel, deletetitle;
    private JLabel findby;
    private JTextField deletetext;
    private JButton enter, delete;
    private JRadioButton byentry, byemail;
    private AddressBook ab;
    private DatabaseManager db;
    private int entryNoF;
     
     
    public Delete(AddressBook ab, DatabaseManager db){
    	this.ab = new AddressBook(db);
    	this.db = db;
    	db.readFile();
    	
        mainpanel = new JPanel();
        mainpanel.setLayout(new BorderLayout());
        panel1 = new JPanel();
        panel2 = new JPanel(new BorderLayout());
        panel2top = new JPanel();
        panel2lower = new JPanel();
        panel3 = new JPanel();
        panel1.setBackground(Color.YELLOW);
        panel2.setBackground(Color.YELLOW);
        panel2top.setBackground(Color.LIGHT_GRAY);
        panel2lower.setBackground(Color.LIGHT_GRAY);
        panel3.setBackground(Color.YELLOW);
           
        deletetitle = new JLabel("DELETE CONTACT");
        deletetitle.setFont(new Font("Serif", Font.BOLD, 30));
        panel1.add(deletetitle);

        deletelabel = new JLabel("How would you like to delete? ");
        deletelabel.setFont(new Font("Serif", Font.PLAIN, 20));
        panel2top.add(deletelabel);
     
        ButtonGroup deletegroup = new ButtonGroup();
        byentry = new JRadioButton("by entry number");
        deletegroup.add(byentry);
        panel2top.add(byentry);
        byemail = new JRadioButton("by email address");
        deletegroup.add(byemail);
        panel2top.add(byemail);

        enter = new JButton ("Enter");
        enter.setToolTipText("find contact");
        enter.addActionListener (new ButtonListener());
        panel2top.add(enter); 

        panel2.add(panel2top, BorderLayout.NORTH);
        panel2.add(panel2lower);

        findby = new JLabel();
        panel2lower.add(findby);
        findby.setVisible(true);

        deletetext = new JTextField(15);
        panel2lower.add(deletetext);
        deletetext.setVisible(true);

        delete = new JButton ("delete");
        delete.setToolTipText("find contact");
        delete.addActionListener (new ButtonListener());
        panel3.add(delete); 

               
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
        	
           if (event.getSource() == enter){
               
//               
////                    findby.setText("Enter Contact's Email Address: ");
//                    findby.setVisible(true);
//                    deletetext.setVisible(true);
//                }
           }
           if(event.getSource() == delete){
            int n;
            Object[] options = { "Yes", "No" };
            n = JOptionPane.showOptionDialog(null, "Are you sure you want to permanently delete this contact?", "DELETE CONTACT",JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            switch(n) {
              case 0: 
            	  if(byentry.isSelected()){
                      
                    String entryNo = deletetext.getText();

                	  entryNoF = Integer.parseInt(entryNo);
                	  ab.deleteViaEntryNo(entryNoF);
                	  db.write();
                    deletetext.setVisible(true);
            	  }
            	  else {
            		  if(byemail.isSelected()){
            			  String emailD = deletetext.getText();
            			  ab.deleteViaEmail(emailD);
            			  db.write();
            		  }
            		  
            	  }
                  
            	System.out.println(db.displayAllContacts());
            	  dispose(); //.. also find and delete the contact
           }
        }
     }
    }
     

    public static void main(String[] args){
        DatabaseManager Db = new DatabaseManager();
        AddressBook Ab = new AddressBook(Db);
        Delete Del = new Delete(Ab,Db);
    }
}