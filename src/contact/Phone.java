package contact;


/**
* Manages Phone Data
*
* @author J.Ellis
* @version 1.0.0
*
*/
public class Phone {
private long number;
private char type;



/**
* The Constructor accepts a 10 digit phone number, and type (H = home, W =
* work, M = Mobile) as its parameters
*
* @param number An integer containing 10 digits that represents the phone
*               number
* @param type   A character that represents the type of number
*/
public Phone(long number, char type) {
 this.number = number;
 this.type = type;
}

/**
* Returns the area code portion of the number.
*
* @return An integer representing the area code
*/
public int getAreaCode() {
	//converts the area code to integer
 return Integer.parseInt((Long.toString(getNumber())).substring(0,3));
}

/**
* Returns the type of number
*
* @return A String representing number type
*/
public char getType() {
 return type;
}

/**
* Returns the 10 digit number
*
* @return A Long representing the 10 digit number
*/
public long getNumber() {

 return  number;
}

/**
* Returns a String formatted as "(876)123-4567"
*
* @return A string representing the 10 digit number
*/
public String toString() {

//	System.out.println(getType()+getAreaCode()+Long.toString(getNumber()).substring(3,6)+Long.toString(getNumber()).substring(6));
 return  getType()+getAreaCode()+Long.toString(getNumber()).substring(3,6)+Long.toString(getNumber()).substring(6);
 		
		 }
}
