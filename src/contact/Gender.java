package contact;



/**
* Creates Gender enum Class
*
* @author J.Ellis
* @version 1.0.0
*
*/

public enum Gender {

MALE,
FEMALE;
	
	public String toString() {
		switch(this) {
			case MALE: return "MALE";
			case FEMALE: return "FEMALE";
		default : throw new IllegalArgumentException();
		}
		
	}
}
