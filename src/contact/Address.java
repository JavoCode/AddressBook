package contact;


/**
* Manages the Address Data
*
* @author J.Ellis
* @version 1.0.0
*/

public class Address {
private String address;

/**
* The Constructor accepts a string containing the parts of a address separated
* by semicolons
*
* @param address String representation of the address separated by semicolons
*/
public Address(String address) {
 this.address = address;
}

/**
* Returns the Country from the String address
*
* @return A string representing the country
*/
public String getCountry() {
 String[] country = address.split(";");
 return country[country.length-1];
}

/**
* Returns an array of lines in an address. The last element of the arrray is
* the country
*
* @return an array of Strings representing an address
*/
public String[] getAddress() {
int length = 0;
//Splits the address string and stores it in an array
String [] address1 = address.split(";");
//Iterates through array
for(int i =0; i<address1.length;i++) {
	//Increases length counter if the condition is met
	if (address1[i].isEmpty()==false) {
		length++;
	}
}
//Creates array setting the length to the length counter
String[] PrintAddress = new String[length];
int j = 0;
//Iterates through Array
for(int i=0;i<address1.length;i++) {
	if (address1[i].isEmpty()==false) {
		PrintAddress[j] = address1[i];
		j++;
	}
}
return PrintAddress;
}


/**
* Returns a string with the address lines separated by new lines.
*
* @return a string with the address
*/
public String toString() {
 String[] addressprint = address.split(";", 3);
 return "Street: " + addressprint[0] + "\n" + "Town: " + addressprint[1] + "\n" + "Country: " + getCountry();
}
}
