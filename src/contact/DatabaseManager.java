package contact;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Formatter;
/**
* Manages the Data
*
* @author J.Ellis
* @version 1.0.0
*/
public class DatabaseManager {
	
	private Contact contact;
	private int entryNo;
	private String str;
	private Gender gen;
	private String textforfile;
	private String strnew;
	
	private ArrayList<Contact>data;
	private Formatter x = new Formatter();
	
	private ArrayList<String>dataString;
    String[] tokens;
    String []emails;
    String []address; 
    String []Phonelist;

	
	/**
	 * Constructor
	 */
	public DatabaseManager() {
		this.data = new ArrayList<Contact>();
		this.dataString = new ArrayList<String>();
	}


	/**
	 * Adds new contact to data
	 * @param contact
	 */
	public void addNewContact(Contact contact) {
		data.add(contact);
	}
	
	/**
	 * Sorts contacts by Entry number
	 */
	public void sortbyEntryNo() {
		ComparebyEntryNo entryCom = new ComparebyEntryNo();
		Collections.sort(data,entryCom);
		displayAllContacts();
	}
	/**
	 * Sorts contacts by first Name
	 */
	public void sortbyFirstName() {
		ComparebyFirstName firstNameCompare = new ComparebyFirstName();
		Collections.sort(data,firstNameCompare);
		for (Contact contact: data)
			System.out.println(contact.getEntryNo()+" " +contact.getFirstName()+ " "+contact.getLastName()+ " "+ contact.getGender()+" "+contact.getEmailList());
	}
	/**
	 * Sorts contacts by last name
	 */
	public void sortbyLastName() {
		CompoarebyLastName lastNameCompare = new CompoarebyLastName();
		Collections.sort(data,lastNameCompare);
		displayAllContacts();
		for (Contact contact : data)
			System.out.println(contact.getEntryNo()+" " +contact.getFirstName()+ " "+contact.getLastName()+ " "+ contact.getGender()+" "+contact.getEmailList());
	}
	/**
	 * Searches for a contact given the first name 
	 * @param firstName
	 */
	public void searchforFirstName(String firstName) {
		Contact searchVal = new Contact(firstName,null, null,00000L);
		int index = Collections.binarySearch(data,searchVal,new ComparebyFirstName());
		System.out.println(data.get(index).toString());
		
	}
	/**
	 * Searches for a contact given the last name 
	 * @param LastName
	 */
	public void searchforLastName(String LastName) {
		Contact searchval = new Contact(null,LastName,null,0);
		int index2 = Collections.binarySearch(data,searchval,new CompoarebyLastName());
		System.out.println(data.get(index2).toString());

	}
	
	/**
	 * Copies the data to an Array
	 * @return a Array of Contacts
	 */
	public Contact[] getContactArray() {
		Contact [] contactArray = new Contact[data.size()];
		for(int i =0; i<data.size();i++){
			contactArray[i] = data.get(i);
		}
		return contactArray;
	}
	/**
	 * Retrieves data
	 * @return an arraylist of contacts
	 */
	public ArrayList<Contact> getContactArrayList(){
		return data;
	}

	/**
	 * 
	 * @return
	 */
	public boolean ifEmpty() {
		if (data == null) {
			
		}
		return false;
		
	}
	
	/**
	 * Searches for a contact using the given entry number and prints said contact
	 * @param entryNo
	 */
	public String searchforEntryNo(int entryNo) {
		String strSearch = "";
		String strGUI = "";
			for (Contact el: data) {
				if (el.getEntryNo() == entryNo) {
					strSearch = setArrayInfo(el.getEntryNo(), el.getFirstName(), el.getLastName(), el.getGender(), el.getAlias(), el.getDOB(), el.getEmailList(), el.getPhoneList(), el.getAddress());
					strGUI = setGuiArrayInfo(el.getEntryNo(), el.getFirstName(), el.getLastName(), el.getGender(),el.getEmailList());
				}
			}
			return strGUI;
	}
	
	/**
	 * Searches for contact given an email and prints said contact
	 * @param email
	 */
	public void searchViaEmail(String email) {
		for (Contact el: data) {
			for (String em : el.getEmailList()) {
				if(em.contentEquals(email))
				System.out.println(setArrayInfo(el.getEntryNo(), el.getFirstName(), el.getLastName(), el.getGender(), el.getAlias(), el.getDOB(), el.getEmailList(), el.getPhoneList(), el.getAddress()));
			}
		}
	}
	/**
	 * 	Deletes contact by entry Number
	 * @param entryNo
	 */
	public void deletebyEntryNo(int entryNo) {
		if (data == null) {
			System.out.println("No data to delete");
		}else {
			for (Contact contact : data) {
				if(contact.getEntryNo()==entryNo) {
					 data.remove(contact);
				}
			}
			System.out.println("Contact Deleted");
		}
	}
	/**
	 * Deletes contact by email
	 * @param email
	 */
	public void deletebyEmailAddress(String email) {
		if (data == null) {
			System.out.println("No data to delete");
		}else {
			for (Contact contact : data) {
			for(String em : contact.getEmailList()) {
					if(em.equals(email)) {
						data.remove(contact);
					}
					displayAllContacts();
					System.out.println("Contact removed");
				}
				
			}
		}
	}
	/**
	 * Displays all Contacts
	 */
	public String displayAllContacts() {
		String strn="";
		if(data == null) {
			System.out.println("No data to display");
		}else {
			for(Contact el : data) {
				strn += setArrayInfo(el.getEntryNo(), el.getFirstName(), el.getLastName(), el.getGender(), el.getAlias(), el.getDOB(), el.getEmailList(), el.getPhoneList(), el.getAddress());
				strn+="\n";
			}
			}
//		System.out.println(strn);
		return strn;
		}
	
	public String displayGuiContacts() {
		String strns = "";
		if(data == null) {
			System.out.println("No data to Display");
		}else {
			for(Contact el : data) {
			strns += setGuiArrayInfo(el.getEntryNo(),el.getFirstName(),el.getLastName(),el.getGender(),el.getEmailList());
			strns+="\n";
		}
		}
//	System.out.println(strn);
	return strns;
	}
			
	
	

	/**
	 * Writes to file
	 */
	public void write() {
		textforfile = "";
		
		try {
				PrintWriter pw = new PrintWriter(new FileWriter("Contacts.txt",false));
				for(Contact el: data) {
					updateArrayInfo(el.getEntryNo(), el.getFirstName(), el.getLastName(), el.getGender(), el.getAlias(), el.getDOB(), el.getEmailList(), el.getPhoneList(), el.getAddress());
				
		}
		for(String ele : dataString) {
			
			textforfile += ele+"\n";
//			pw.write(ele+"\n");
		}
		pw.write(textforfile);
		pw.close();
	}
	catch(IOException e) {
		e.printStackTrace();
	}
	}
	

	
		/**
		 * sets the contact to a string to write to the file
		 * @param entryNo
		 * @param firstname
		 * @param lastName
		 * @param gender
		 * @param alias
		 * @param dob
		 * @param emailList
		 * @param Phonelist
		 * @param addressList
		 */
		public void updateArrayInfo(int entryNo,String firstname,String lastName,Gender gender, String alias, Long dob,String[]emailList,String []Phonelist,String[]addressList) {
			
			this.str = entryNo + ":"+firstname+":"+lastName+":"+gender.toString()+":"+alias+":"+dob+":"+String.join(",", emailList)+":"+ String.join(",",Phonelist)+":"+String.join(";", addressList);
			//System.out.println(Arrays.toString(addressList));
			
	
			dataString.add(str);
			System.out.println(dataString);
			
			
		}
		/**
		 * sets the contact to a string
		 * @param entryNo
		 * @param firstname
		 * @param lastName
		 * @param gender
		 * @param alias
		 * @param dob
		 * @param emailList
		 * @param Phonelist
		 * @param addressList
		 * @return
		 */
		public String setArrayInfo(int entryNo,String firstname,String lastName,Gender gender, String alias, Long dob,String[]emailList,String []Phonelist,String[]addressList) {
			
			
			this.str = entryNo + ":"+firstname+":"+lastName+":"+gender.toString()+":"+alias+":"+dob+":"+String.join(",", emailList)+":"+ String.join(",",Phonelist)+":"+String.join(";", addressList);
			 return str;
		}
		
		
		public String setGuiArrayInfo(int entryNo,String firstname,String lastname,Gender gender,String[]emailList) {
			
			this.strnew = "                            "+entryNo+"                            "+firstname+"                            "+lastname+"                            "+gender.toString()+"                            "+String.join(",", emailList);
			
			return strnew;
		}
		
		 
		    
		    /**
		     * Reads the file and populates the database
		     */
		    public void readFile() {

		    	int entryNo = 0;
		    	 long dob = 0;
		        try {

		            FileReader fr = new FileReader("Contacts.txt");
		            BufferedReader br = new BufferedReader(fr);
		            String oneLine = "";

		            while ((oneLine = br.readLine()) != null) {
						
		                // Split line into tokens
		            	
		                tokens = oneLine.split(":");
		                dob = Long.parseLong(tokens[5]);
		                gen = Gender.valueOf(tokens[3]);
		                
		                contact = new Contact(tokens[1], tokens[2],gen,dob);
		                contact.setAlias(tokens[4]);
		                
		                entryNo = Integer.parseInt(tokens[0]);
		                

			               for(String email: tokens[6].split(",")) {
			            	   contact.addEmail(email);
			               
			            	   
			               }
			               
			               Phonelist = tokens[7].split(",");
			               
			               for(String phonenumbers : Phonelist) {
			            	   contact.addPhone(phonenumbers.charAt(0), Long.parseLong(phonenumbers.substring(1)));
//			            	   System.out.println(phonenumbers.charAt(0));
//			            	   System.out.println(Long.parseLong(phonenumbers.substring(1)));
			               }
			               
			               contact.setAddress(tokens[8]);
			               
			               
			               
		                
//		               
		                
		                data.add(contact);
		                
		                }
		            
		                
		               
		                
		              
		               
		        	   

		         	
		              
			            
					
		               br.close();
//		            }
		        } catch (IOException e) {
		            // print a meaningful message
		            System.out.println("An Error occured when trying to read the file");
		        }
		    }
		    

}


