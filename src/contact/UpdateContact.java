package contact;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//ADD ACTION LISTENER FOR BUTTONS (everytime update is clicked, this should show up), FOR PHONE AND EMAIL.. DO IT LIKE ADDRESS, GET EVERYTHING AT THE BOTTOM AS OPPOSED TO ACROSS

public class UpdateContact extends JFrame{
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JTextField jTextField1;
	private JTextField jTextField2;
	private JTextField jTextField3;
	private JTextField jTextField4;
	private JTextField jTextField5;
	private JTextField entryNo;
	private JButton jButton1;
	private JButton jButton2;
	private JPanel mainpanel;
	private JPanel jPanel1;
	private JPanel jPanel2;
	private JPanel jPanel3;
	private JPanel jPanel4;
	private JPanel jPanel5;
	private JPanel jPanel6;
	private JLabel town, street, country, phone, email,entryNoL;
	private JTextField towntext, streettext, countrytext, phonetext, emailtext;
	private JPanel addresspanel;
	private AddressBook Ab;
	
    //private JRadioButton genderM, genderF;
    

	//public UpdateContact(String name, String address, String telNo, String email){
    public UpdateContact(AddressBook ab, DatabaseManager Db){
    	
    	this.Ab = new AddressBook(Db);
    	
		//setResizable(true);

			mainpanel = new JPanel();

			town = new JLabel("Town: ");
            
            towntext = new JTextField(10);
    
            street = new JLabel("Street: ");
            
            streettext = new JTextField(10);
    
            country = new JLabel("Country: ");
            
            countrytext = new JTextField(10);

			addresspanel = new JPanel();
            addresspanel.setLayout(new GridLayout(4, 1));
            addresspanel.setBorder(BorderFactory.createTitledBorder("Address"));
            addresspanel.add(town);
            addresspanel.add(towntext);
            addresspanel.add(street);
            addresspanel.add(streettext);
            addresspanel.add(country);
            addresspanel.add(countrytext);
            JPanel x = new JPanel();
			addresspanel.add(x);
			

		jLabel1 = new javax.swing.JLabel("First Name: ");
		jLabel2 = new javax.swing.JLabel("Last Name: ");
		jLabel3 = new javax.swing.JLabel("NickName: ");
		jLabel4 = new javax.swing.JLabel("Gender: ");
//		jLabel5 = new javax.swing.JLabel("Date Of Birth: (Format: yyyymmdd) ");
		phone = new javax.swing.JLabel("Phone: ");
		email = new javax.swing.JLabel("Email: ");
		entryNoL = new javax.swing.JLabel("Entry Number: ");

		jTextField1 = new javax.swing.JTextField(15);
		jTextField2 = new javax.swing.JTextField(30);
		jTextField3 = new javax.swing.JTextField(10);
		jTextField4 = new javax.swing.JTextField(15);
//		jTextField5 = new javax.swing.JTextField(15);
		phonetext = new javax.swing.JTextField(15);
		emailtext = new javax.swing.JTextField(15);
		entryNo = new javax.swing.JTextField(15);

		//jTextField1.setText(name);
		//jTextField2.setText(address);
		//jTextField3.setText(telNo);
		//jTextField4.setText(email);

		jButton1 = new javax.swing.JButton("Update");
		jButton2 = new javax.swing.JButton("Cancel");

		jPanel1 = new javax.swing.JPanel(new java.awt.GridLayout(7, 1, 1, 5));

		jPanel1.add(jLabel1);
		jPanel1.add(jLabel2);
		jPanel1.add(jLabel3);
		jPanel1.add(jLabel4);
//		jPanel1.add(jLabel5);
		jPanel1.add(phone);
		jPanel1.add(email);
		jPanel1.add(entryNoL);

		jPanel2 = new javax.swing.JPanel(new java.awt.GridLayout(7, 1));

		jPanel2.add(jTextField1);
		jPanel2.add(jTextField2);
		jPanel2.add(jTextField3);
		jPanel2.add(jTextField4);
//		jPanel2.add(jTextField5);
		jPanel2.add(phonetext);
		jPanel2.add(emailtext);
		jPanel2.add(entryNo);

		jPanel3 = new javax.swing.JPanel(new java.awt.FlowLayout());

		jPanel3.add(jPanel1);
		jPanel3.add(jPanel2);

		jPanel4 = new javax.swing.JPanel(new java.awt.FlowLayout());

		jPanel4.add(jButton1);
		jPanel4.add(jButton2);

		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
//					Ab.(new AddressBook(jTextField1.getText(), jTextField2.getText(), jTextField3.getText(), jTextField4.getText()));
				Integer entryNoF = Integer.parseInt(entryNo.getText());
				Ab.updateFirstName(jTextField1.getText(),entryNoF);
				Ab.updateLastName(jTextField2.getText(), entryNoF);
				Ab.updateContactAlias(jTextField3.getText(), entryNoF);
				Ab.addContactPhone('M', Long.parseLong(phonetext.getText()), entryNoF);
				Ab.addContactEmail(emailtext.getText(), entryNoF);
				
//				Ab.NewContact(firstName, lastName, gender, dob, alias, Address, type, number, email);
				setVisible(false);
				dispose();
			}
		});

		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});

		jPanel5 = new JPanel(new BorderLayout());

		jPanel5.add(jPanel3, java.awt.BorderLayout.CENTER);
        jPanel5.add(jPanel4, java.awt.BorderLayout.SOUTH);
        
        mainpanel.add(jPanel1);
        mainpanel.add(jPanel2);
        mainpanel.add(jPanel3);
        mainpanel.add(jPanel4);
		mainpanel.add(jPanel5);
		jPanel3.add(addresspanel);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().add(mainpanel);
    	pack();
        setVisible(true);
	}

	public static void main(String args[]) {
		//javax.swing.JFrame.setDefaultLookAndFeelDecorated(true);

        //new UpdateEntry("", "", "", "").setVisible(true);
        //JFrame frame = new JFrame("Update Contact");

		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//frame.setResizable(false);

		//frame.getContentPane().add(new UpdateContact());

		//frame.pack();
		//frame.setVisible(true);
		DatabaseManager Db = new DatabaseManager();
		AddressBook Ab = new AddressBook(Db);
		UpdateContact Uc = new UpdateContact(Ab,Db);
		
        
    }
}
