package contact;



/**
* Manages Name information
*
* @author J.Ellis
* @version 1.0.0
*/
public class Name {
private String firstName, lastName;

/**
* Constructor accepts the first name and last name as parameters and sets the
* relevant attributes accordingly
*
* @param firstName the unique id for first name given
* @param lastName  the unique id for last name given
*/
public Name(String firstName, String lastName) {
 this.firstName = firstName;
 this.lastName = lastName;
}

/**
* Returns the first name
*
* @return A string representing first name
*/
public String getFirstName() {
 return firstName;
}

/**
* Returns the last name
*
* @return A string representing the last name
*/
public String getLastName() {
 return lastName;
}

/**
* Changes the last name to parameter value
*
* @param newName A string containing the last name
*/
public void changeLastName(String newName) {
 this.lastName = newName;
}
}
