package contact;


/**
 * @author Javon Ellis
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {

    private ArrayList<Contact> contactList;
    private Contact contact;
    String[] tokens;
    String []emails;
    String []address; 
    String []Phonelist;
    
    
    public ReadFile() {

        contactList= new ArrayList<Contact>();

        try {

            FileReader fr = new FileReader("Contacts.txt");
            BufferedReader br = new BufferedReader(fr);
            String oneLine = "";

            while ((oneLine = br.readLine()) != null) {
                // Split line into tokens
                tokens = oneLine.split(":");
                long dob = Long.parseLong(tokens[5]);
                Gender gen = Gender.valueOf(tokens[3]);
                
                contact = new Contact(tokens[1], tokens[2],gen,dob);
                contact.setAlias(tokens[4]);
                
                
                
                for(String phone: tokens[8].split(",")) {
                	
                	contact.addPhone(tokens[7].charAt(0), Long.parseLong(phone.substring(1)));
//                	System.out.println(Long.parseLong(phone.substring()));
//                	contact.addPhone('H', 0);
                
                }
                
               
                
               for(String email: tokens[6].split(",")) {
            	   contact.addEmail(email);
               
            	   
               }
               
               contactList.add(contact);
        	   
         	  contact.setAddress(tokens[8]);
               
               
                
                
               
            }
        } catch (IOException e) {
            // print a meaningful message
            System.out.println("An Error occured when trying to read the file");
        }
    }
    
//    public ArrayList<Contact>  getContactData() {
////    	ArrayList<Contact> contactArray = new Contact[contactList.size()];
////		for(int i =0; i<contactList.size();i++){
////			contactArray[i] = contactList.get(i);
////		}
////		return contactArray;
//    	
//    	for(Contact contact : contactList) {
//    		
//    	}
//	}
    
    
    public ArrayList<Contact> getContactArrayList() {
    	return contactList;
    }
    	
    }


