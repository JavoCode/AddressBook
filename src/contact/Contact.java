package contact;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;



/**
* Manages Contact Data
*
* @author J.Ellis
* @version 1.0.0
*/

public class Contact extends Person implements Comparable{

private Address address;
private static int nextentryNo = 1;
private int entryNo = 0;
private static ArrayList<String> aliasArray;
private ArrayList<String> emails = new ArrayList<String>();
private Phone phone;
private ArrayList<Phone> phoneList = new ArrayList<Phone>();
private String alias;
/**
* Constructor accepts the first name, last name, gender and date of birth as
* parameters. Generates a unique identifier (entry number) for each contact.
* Gender is a string "Male" or "Female". Date of birth is represented using
* yyyymmdd format.
*
* @param firstName String representation of the contact's first name
* @param lastName  String representation of the contact's last name
* @param gender    String representation of gender. ("Male" or "Female")
* @param DOB       long representation of the contact's date of birth.
*     Format:
*                  yyyymmdd
*/
public Contact(String firstName, String lastName, Gender gender, long DOB) {
 super(firstName, lastName, gender, DOB);
 entryNo = nextentryNo;
 this.firstName = firstName;
 this.lastName = lastName;
 nextentryNo++;
 
 
}

/**
* Return the entry number for the contact. The entry number is automatically
* generated when the Contact object is created as a serial number (starting
* value 1).
*
* @return an integer representing the entry number of the contact
*/
public int getEntryNo() {
 return entryNo;
}

/**
*Calculates and returns the contact’s age.
*
* @return an integer representation of the contact's age
*/
public int getAge() {
 int year, month, day;
 year = Integer.parseInt((Long.toString(getDOB())).substring(0, 4));
 month = Integer.parseInt((Long.toString(getDOB())).substring(4, 6));
 day = Integer.parseInt((Long.toString(getDOB())).substring(6));

 LocalDate birthDate = LocalDate.of(year, month, day);
 LocalDate now = LocalDate.now();

 Period diff = Period.between(birthDate, now);
 int years = diff.getYears();
 return years;

 
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public void setGender(String gender) {
	this.gender = Gender.valueOf(gender);
}

public void setBirthDate(String birthdate) {
	this.dob = Long.parseLong(birthdate);
}

/**
* Returns contact's name in the form of "Brown, John"
*
* @return A string with the contact's name
*/
public String getName() {
	
 return lastName + "," + firstName;
}
/**
 * Return the first name of contact
 * @return A string with the first name
 */
public String getFirstName() {
	return firstName;
}

/**
 * Return the contact's last name
 * @return A string representing the contact's last name
 */
public String getLastName() {
	return lastName;
}

/**
* Changes the last name of the contact
*
* @param name A string representing the new last name
*/
public void updateName(String name) {
 this.lastName = name;
}

/**
* Sets the contact’s alias and checks if the given alias already exist.
*
* @param Newalias a unique string id that represents the contact alias
*/
public void setAlias(String Newalias) {
	//Creates an arrayList aliasArray
 aliasArray = new ArrayList<String>();
 this.alias = Newalias;
 //Iterates through aliasArray
 for (int i = 0; i < aliasArray.size(); i++) {
	 //Checks if the alias already exist. If alias exist an output is print else
	 //the new alias is stored in alias array
   if (aliasArray.get(i).equals(Newalias)) {
     System.out.println("Alias already exist");
   } else {
     aliasArray.add(Newalias);
   }
 }
}

/**
* Return the contact’s alias.
*
* @return a String containing the contact's alias
*/
public String getAlias() {
 return alias;
}

/**
* Accepts a string with the parts of the address separated by semicolons
*
* @param address String with the contact's address separated by semicolons
*     (see
*                details on Address class).
*/
public void setAddress(String address) {
 this.address = new Address(address);
}

/**
* Return an array containing the lines in an address not including blank
* lines. The last element in the array is the country.
*
* @return an array of strings representing the contact's address. The last
*         element in the array is the country.
*/
public String[] getAddress() {
 return address.getAddress();
}

/**
* Add an email address to a set of email address for the contact. Each
* contact can have an infinite number of email addresses.
*
* @param email a string representation a contact's email
*/
public void addEmail(String email) {
	emails.add(email);
}

/**
* Delete the email address given as a parameter from the set of email
* addresses for the contact.
*
* @param email a string representation of the contact's email
*/
public void deleteEmail(String email) {
 emails.remove(email);
}

/**
* Return an array of the email addresses for the contact.
*
* @return an array of all the contact's email
*/
public String[] getEmailList() {
 String[] emailList = new String[emails.size()];
 for (int i = 0; i < emails.size(); i++) {
   emailList[i] = emails.get(i);
 }
 return emailList;
}

/**
* Add a phone number to the list of phone numbers that the contact has. The
* method accepts two parameters. The first is for the type of number (H=Home,
* W=Work, M=Mobile). The second parameter is the phone number where the first
* three digits are the area code. For example, 8767024455. A contact can have
* up to 5 phone numbers.
*
* @param type   character representing the type of number
* @param number long representing the contact's phone number
*/
public void addPhone(char type, long number) {
	if(phoneList.size()<5) {

 this.phone = new Phone(number, type);
 phoneList.add(phone);
	}
	
}

/**
* Deletes the phone number given as a parameter from the list of phone
* numbers.
*
* @param number long representing the contact's phone numbers
*
*/
public void deletePhone(long number) {
	//Iterates through phoneList checking
 for (int i = 0; i < phoneList.size(); i++) {
	 //Checks if parameter is equal to the phone number stored.
   if (phoneList.get(i).getNumber() == number) {
	   //Number is removed if condition is met 
     phoneList.remove(i);
   }
 }
}

/**
* Returns an array of strings representing the contact's phone numbers. Each
* phone number is formatted as specified by the toString method of the phone
* class
*
* @return a string array of phone list
*/

public String[] getPhoneList() {
	//Creates array with size of phoneList arrayList
 String[] PrintPhone = new String[phoneList.size()];
 //Iterates through phoneList arrayList
 for (int i = 0; i < phoneList.size(); i++) {
	 //moves each element in arrayList to array
   PrintPhone[i] = phoneList.get(i).toString();
 }
 return PrintPhone;
}

public String getPhone() {
	
	return String.valueOf(phone.getNumber()) ;
	
}

public String toString() {
	return  firstName + " " + lastName + " " + alias + " "+ getEmailList()+" "+ getPhoneList();
}

@Override
public int compareTo(Object other) {
	Integer entryNum1 = this.getEntryNo();
	Integer entryNum2 = ((Contact)other).getEntryNo();
	// TODO Auto-generated method stub
	return entryNum1.compareTo(entryNum2);
}

public String getType() {

	String c = Character.toString(phone.getType());
	return c;
}


public String phoneToString() {
	return phone.toString();
}
}
