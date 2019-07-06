package contact;

import java.util.Comparator;

public class CompoarebyLastName implements Comparator <Contact>{
	public int compare(Contact first, Contact second) {
		return first.getLastName().compareTo(second.getLastName());
	}
}
