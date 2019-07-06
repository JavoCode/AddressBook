package contact;

import java.io.IOException;
import java.util.ArrayList;

/**
* Manages the Functions of the Program
*
* @author J.Ellis
* @version 1.0.0
*/

public class AddressBook {
	
	private Contact contact;
	private int entryNum;
	private String firstName; 
	private String lastName;
	private Gender gender;
	private long dob;
	
	private DatabaseManager dataB = new DatabaseManager();
	
	/**
	 * Constructor of AddressBook takes a database
	 * @param dataB
	 */
	
	public AddressBook(DatabaseManager dataB) {
		this.dataB = dataB;
//		dataB.readFile();
	}
	
	/**
	 * Creates a new Contact given the parameters
	 * @param firstName
	 * @param lastName
	 * @param gender
	 * @param dob
	 * @param alias
	 * @param Address
	 * @param type
	 * @param number
	 * @param email
	 */
	public void NewContact(String firstName,String lastName,String gender,String dob,String alias, String Address, char type, Long number,String email) throws IOException {
		
		try {
		Gender gen = Gender.valueOf(gender);
		Long dobb = Long.parseLong(dob);
		Contact contact2 = new Contact(firstName,lastName,gen,dobb);
		
		
		contact2.setAddress(Address);
		contact2.setAlias(alias);
		
		contact2.addEmail(email);
		contact2.addPhone(type, number);
		
		 dataB.addNewContact(contact2);
		
		}catch(NumberFormatException n) {
			//n.printStackTrace();
			System.out.println("ERROR");
		}
	}
	
	
	/**
	 * Creates a null contact
	 */
	public void nullContact() {
		this.contact = new Contact(null,null,null,0);
	}
	
	/**
	 * Retrieves contact entry number
	 * @return an integer representing contact entry Number
	 */
	public int getContactEntryNum() {
		return contact.getEntryNo();
	}
	
	/**
	 * Retrieves the contact full name
	 * @return a string representing contact full name
	 */
	public String getContactName() {
		return contact.getName();
	}
	
	/**
	 * Retrieves contact age
	 * @return a integer representing the contact's age
	 */
	public int getContactAge() {
		return contact.getAge();
	}
	
	/**
	 * Updates the first name of the contact by using the entry number to locate the desired contact to update
	 * @param firstName
	 * @param entryNum
	 */
	
	public void updateFirstName(String firstName,int entryNum) {
		for(Contact el : dataB.getContactArrayList()) {
		if (el.getEntryNo()==entryNum)
		this.contact.setFirstName(firstName);
		}
	}
	/**
	 * Updates the last name of the contact by using the entry number to locate the desired contact to update
	 * @param lastName
	 * @param entryNum
	 */
	
	public void updateLastName(String lastName,int entryNum ){
//		if (dataB.checkEntryNo(this.entryNum)==true)
//		for(Contact el : dataB.getContactArrayList()) {
//		if(el.getEntryNo()==entryNum) {
//		el.setLastName(lastName);
//		}
//		}
		
		for(Contact el : dataB.getContactArrayList()) {
			if (el.getEntryNo()==entryNum) {
				el.setLastName(lastName);
			}
			else {
				System.out.println("NO");
			}
		}
	}
	
	/**
	 * sets the contact Gender 
	 * @param gender
	 */
	public void setGender(String gender) {
		contact.setGender(gender);
	}
	
	/**
	 * set contact date of birth using format yyyymmdd
	 * @param birthdate
	 */
	public void setDob(String birthdate) {
		contact.setBirthDate(birthdate);
	}
	
	/**
	 * updates the contact's full name
	 * @param name
	 */
	public void updateContactName(String name) {
		contact.updateName(name);
	}
	
	/**
	 * updates the contact's alias using a entry number to locate the desired contact to edit
	 * @param alias
	 * @param entryNum
	 */
	public void updateContactAlias(String alias,int entryNum) {
		for(Contact el : dataB.getContactArrayList())
		if (el.getEntryNo() == entryNum) {
		el.setAlias(alias);
		}
	}
	
	/**
	 * calls the contact method that sets alias
	 * @param alias
	 */
	public void setContactAlias(String alias) {
		contact.setAlias(alias);
	}
	
	/**
	 * 
	 * @param firstName
	 */
	public void setfirstName(String firstName) {
		firstName = this.firstName;
		contact.setFirstName(firstName);
	}
	
	/**
	 * 
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		lastName = this.lastName;
		contact.setLastName(lastName);
	}
	
	/**
	 * 
	 * @return
	 */
	
	public String getContactAlias() {
		return contact.getAlias();
	}
	/**
	 * 
	 * @param address
	 * @param entryNum
	 */
	public void updateContactAddress(String address, int entryNum) {
		for(Contact el : dataB.getContactArrayList())
			if (el.getEntryNo() == entryNum) {
		el.setAddress(address);
			}
	}
	/**
	 * 
	 * @param address
	 */
	public void setContactAddress(String address) {
		contact.setAddress(address);
	}
	/**
	 * 
	 * @return
	 */
	public String [] getContactAddress(int entryNo) {
		ArrayList<String>NewList = new ArrayList<>();
		
		for(Contact el : dataB.getContactArrayList()) {
			if(el.getEntryNo() == entryNo) {
				 for (String tt: el.getAddress()) {
					 NewList.add(tt);
				 }
			
			}
		}
		
		String [] test = NewList.toArray(new String[NewList.size()]);
		
		return test ;
	}
	/**
	 * 
	 * @param email
	 * @param entryNum
	 */
	public void addContactEmail( String email,int entryNum) {
		for(Contact el : dataB.getContactArrayList())
			if (el.getEntryNo() == entryNum) {
		el.addEmail(email);
			}
	}
	/**
	 * 
	 * @param email
	 * @param entryNum
	 */
	public void deleteContactEmail(String email,int entryNum) {
		contact.deleteEmail(email);
	}
	/**
	 * 
	 * @return
	 */
	public String [] getContactEmailList() {
		return contact.getEmailList();
	}
	/**
	 * 
	 * @param type
	 * @param number
	 * @param entryNum
	 */
	public void addContactPhone(char type, long number,int entryNum) {
		for(Contact el : dataB.getContactArrayList())
			if (el.getEntryNo() == entryNum) {
		el.addPhone(type, number);
			}
	}
	/**
	 * 
	 * @param number
	 * @param entryNum
	 */
	public void deleteContactPhone(long number,int entryNum) {
		for(Contact el : dataB.getContactArrayList())
			if (el.getEntryNo() == entryNum) {
		el.deletePhone(number);
			}
	}
	/**
	 * 
	 * @return
	 */
	public String [] getContactPhoneList() {
		return contact.getPhoneList();
	}
	/**
	 * 
	 * @param contact
	 */
	public void addNewContact(Contact contact) {
		dataB.addNewContact(contact);
	}
	/**
	 * 
	 */
	public void sortContactByEntryNo() {
		dataB.sortbyEntryNo();
	}
	/**
	 * 
	 */
	public void sortContactByFirstName() {
		dataB.sortbyFirstName();
	}
	/**
	 * 
	 */
	public void sortContactByLastName() {
		dataB.sortbyLastName();
	}
	/**
	 * 
	 * @param firstName
	 */
	public void searchViaFirstName(String firstName) {
		dataB.searchforFirstName(firstName);
	}
	/**
	 * 
	 * @param entryNo
	 */
	public void searchViaEntryNo(int entryNo) {
		dataB.searchforEntryNo(entryNo);
		
	}
	/**
	 * 
	 * @param LastName
	 */
	public void searchViaLastName(String LastName) {
		dataB.searchforLastName(LastName);
	}
	/**
	 * 
	 * @param entryNo
	 */
	public void deleteViaEntryNo(int entryNo) {
		for (int i=0;i<dataB.getContactArrayList().size();i++) {
		    if(dataB.getContactArrayList().get(i).getEntryNo()==entryNo) {
		    	dataB.getContactArrayList().remove(i);
//		    	System.out.println("true");
		    	}
		}
	}
	/**
	 * 
	 * @param email
	 */
	public void deleteViaEmail(String email) {
		for (int i=0;i<dataB.getContactArrayList().size();i++) {
		    for(String emailD : dataB.getContactArrayList().get(i).getEmailList()) {
		    	if(emailD.equals(email)) {
		    		dataB.getContactArrayList().remove(i);
		    	}
		    }
		}
		}
	/**
	 * 
	 * @param email
	 */
	public void searchViaEmail(String email) {
		dataB.searchViaEmail(email);
	}
	/**
	 * @return 
	 * 
	 */
	public String displayAllContacts() {
		return dataB.displayAllContacts();
	}
	/**
	 * 
	 * @return
	 */
	public char getType(int entryNo) {
		char typen = ' ';
		for(Contact el : dataB.getContactArrayList()) {
			if(el.getEntryNo()==entryNo) {
			String phonetype = el.phoneToString().substring(0);
			 typen = phonetype.charAt(0);
		}
	}
		return typen;
	
//	public void saveToFile() throws IOException {
//		dataB.updateContactFile();
//	}
//	
}
}


	
	
	
	
	
	
	


	

	
	
	
	
	
	

	

	
	
