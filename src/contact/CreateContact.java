package contact;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

//ADD BUTTONS TO THE BOTTOM (and actionlisteners.. everytime add is clicked, this should show up), title at the top maybe

public class CreateContact extends JFrame{
  private JPanel northpanel, mainpanel, panel1, panel2, panel3, panel4, panel5, addresspanel, genderpanel,typepanel;
  private JButton save, cancel;
  private JLabel title, firstname, lastname, nickname, genderLabel, town, street, country, dateofbirth,phone,email,phonetype;
  private JTextField firstnametext, lastnametext, nicknametext, gendertext, towntext, streettext, countrytext, dateofbirthtext,phonetext,emailtext;
  private JRadioButton genderM, genderF,typeW,typeM,typeH;
  private AddressBook Ab;
//  private DatabaseManager Dm;
    
  CreateContact(AddressBook Ab,DatabaseManager Dm){
	  this.Ab = Ab;
//	  this.Dm =Dm;
//	  Dm.readFile();
//	  Ab.nullContact();
    //PANELS
    mainpanel = new JPanel();
    northpanel = new JPanel(new BorderLayout());
    northpanel.setBackground(Color.YELLOW);
    mainpanel.add(northpanel, BorderLayout.NORTH);
    mainpanel.setLayout(new FlowLayout());
    mainpanel.setPreferredSize (new Dimension(400, 300));
    mainpanel.setBackground (Color.YELLOW);

    panel1 = new JPanel(new GridLayout(8, 1, 1, 6));
    panel1.setBackground(Color.LIGHT_GRAY);
    panel2 = new JPanel(new GridLayout(8, 1));
    panel2.setBackground(Color.LIGHT_GRAY);
    panel3 = new JPanel(new FlowLayout());
    panel3.setBackground(Color.LIGHT_GRAY);
    panel4 = new JPanel(new GridLayout(1,2));
    panel4.setBackground(Color.LIGHT_GRAY);
    genderpanel = new JPanel(new GridLayout(1,2));
    genderpanel.setBackground(Color.LIGHT_GRAY);
    addresspanel = new JPanel(new GridLayout(1,3));
    addresspanel.setBackground(Color.LIGHT_GRAY);
    typepanel = new JPanel(new GridLayout(1,4));
    typepanel.setBackground(Color.LIGHT_GRAY);
    
    //JTEXTFIELD AND LABELS
    title = new JLabel("ADD CONTACTS");
    title.setFont(new Font("Arial", Font.BOLD, 30));
    northpanel.add(title);

    firstname = new JLabel("First Name: ");
    panel1.add(firstname);
	
            
    firstnametext = new JTextField(10);
    panel2.add(firstnametext);
    
    lastname = new JLabel("Last Name: ");
    panel1.add(lastname);
            
    lastnametext = new JTextField(10);
    panel2.add(lastnametext);

    nickname = new JLabel("NickName: ");
    panel1.add(nickname);
            
    nicknametext = new JTextField(10);
    panel2.add(nicknametext);
    
    
    phone = new JLabel("Phone number");
    panel1.add(phone);
    
    phonetext = new JTextField(10);
    panel2.add(phonetext);
    
    genderLabel = new JLabel("Gender: ");
    panel1.add(genderLabel);
    
    phonetype = new JLabel("Type: ");
    panel1.add(phonetype);
    
    
    
    
    
    
   
 
    ButtonGroup gendergroup = new ButtonGroup();
    genderF = new JRadioButton("Female");
    genderM = new JRadioButton("Male");
    gendergroup.add(genderF);
    gendergroup.add(genderM);
    genderpanel.add(genderF);
    genderpanel.add(genderM);
    panel2.add(genderpanel);
    
    ButtonGroup typeGroup = new ButtonGroup();
    typeW = new JRadioButton("Work");
    typeM = new JRadioButton("Mobile");
    typeH = new JRadioButton("Home");
    typeGroup.add(typeW);
    typeGroup.add(typeM);
    typeGroup.add(typeH);
    typepanel.add(typeW);
    typepanel.add(typeM);
    typepanel.add(typeH);
    panel2.add(typepanel);
    
    dateofbirth = new JLabel("Date of birth (Format: yyyymmdd) ");
    panel1.add(dateofbirth);
            
    dateofbirthtext = new JTextField(10);
    panel2.add(dateofbirthtext);

    
    panel3.add(panel1);
    panel3.add(panel2);
    mainpanel.add(panel3);
    mainpanel.add(addresspanel);
    mainpanel.add(panel4);

    town = new JLabel("Town: ");

    towntext = new JTextField(10);

    street = new JLabel("Street: ");
    
    streettext = new JTextField(10);

    country = new JLabel("Country: ");
    
    countrytext = new JTextField(10);

    addresspanel.setLayout(new GridLayout(3,1));
    addresspanel.setBorder(BorderFactory.createTitledBorder("Address"));
    addresspanel.add(town);
    addresspanel.add(towntext);
    addresspanel.add(street);
    addresspanel.add(streettext);
    addresspanel.add(country);
    addresspanel.add(countrytext);
    JPanel x = new JPanel(new GridLayout(1,3));
    x.setBackground(Color.LIGHT_GRAY);
    addresspanel.add(x);
    

    //JBUTTONS
    save = new JButton("Save");
    save.addActionListener(new ButtonListener());
    cancel = new JButton("Cancel");
    cancel.addActionListener(new ButtonListener());
    panel4.add(save);
    panel4.add(cancel);
    
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    getContentPane().add(mainpanel);

    pack();
    setVisible(true);
  
    
  }

  private class ButtonListener implements ActionListener{

	  DatabaseManager Dm = new DatabaseManager();
	  	AddressBook An = new AddressBook(Dm);
  	
    public void actionPerformed (ActionEvent event)
    {
    	 
 	   String gender = "";
    	char type = ' ';
    	
    	if(genderM.isSelected()) {
    		gender = "MALE";
    	}
    	else if (genderF.isSelected()) {
    		gender = "FEMALE";
    	}
    	
    	if(typeW.isSelected()) {
    		type = 'W';
    	}
    	else if(typeM.isSelected()) {
    		type = 'M';
    	}
    	else {
    		type = 'H';
    	}
    	
 	   String Address = towntext.getText()+";"+streettext.getText()+";"+countrytext.getText();
 	   System.out.println(firstnametext.getText());
 	   An.nullContact();
    	
 	   try {
		An.NewContact(firstnametext.getText(), lastnametext.getText(), gender, dateofbirth.getText(), nicknametext.getText(), Address, type, Long.parseLong(phonetext.getText()),emailtext.getText());
	} catch (NumberFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    	
       if (event.getSource() == save){
    	  
    	 	
    	  
        	
          //add the info to the table..save the info to the text ui, dispose(); (so itll close page)..
    	   
    	   Dm.write();
       }
       if (event.getSource()== cancel){
            int n;
            Object[] options = { "YES", "NO"};
            n = JOptionPane.showOptionDialog(null, "Are you sure ........", "DISCARD CHANGES?", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            switch(n) {
              case 0:
              dispose();
              case 1:
            	  
            }
      }
    }
  }

  public static void main (String[] args){
	  DatabaseManager Dm = new DatabaseManager();
	  AddressBook Ab = new AddressBook(Dm);
    CreateContact cc = new CreateContact(Ab, Dm);
}
}

            