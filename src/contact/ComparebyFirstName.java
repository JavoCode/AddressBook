package contact;

import java.util.Comparator;


	public class ComparebyFirstName implements Comparator <Contact>{
		public int compare(Contact first, Contact second) {
			return first.getFirstName().compareTo(second.getFirstName());
		}
	}

