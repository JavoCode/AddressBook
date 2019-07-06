package contact;


/**
* Manages the person data
*
* @author J.Ellis
* @version 1.0.0
*/

public class Person {

protected Gender gender;

protected long dob;
protected Name name;
protected String firstName, lastName;
/**
* Constructor accepts first name, last name, gender and date of birth as
* parameters and sets the relevant attributes accordingly. Date of birth
* specified as a number(yyyymmdd).
*
* @param firstName A unique String Id that represents the first Name of a
*                  Person
* @param lastName  A unique String Id that represents the last name of a person
* @param gender    A enumerated value used to represent the gender of the
*                  person
* @param dob      Represents the date of birth of a person
*/
public Person(String firstName, String lastName, Gender gender, long dob) {
 this.firstName = firstName;
 this.lastName = lastName;
 this.dob = dob;
 this.name = new Name(firstName, lastName);
 this.gender = gender;
}

/**
* Returns the name of the person in the format of first name, last name
*
* @return a string representing the person's name
*/
public String getName() {
 return firstName + " " + lastName;
}

/**
* Returns the Gender as a String
*
* @return Returns gender as a String "Male" or "Female"
*/
public Gender getGender() {
 if (this.gender.equals(Gender.MALE) ){
   gender =  Gender.MALE;
 } else if (this.gender.equals(Gender.FEMALE)) {
	 gender = Gender.FEMALE;
 }
return gender;
 }

/**
* Returns the date of Birth as a number
*
* @return returns the DOB
*/
public long getDOB() {
 return dob;
}

/**
* Changes the last name of a person
*
* @param newName String that accepts the new last name;
*/
public void changeLastName(String newName) {
	
	this.lastName = newName;
 
}
}
