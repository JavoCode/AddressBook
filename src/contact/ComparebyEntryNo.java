package contact;

import java.util.Comparator;

public class ComparebyEntryNo implements Comparator <Contact>{
	
		public int compare(Contact first, Contact second) {
			// TODO Auto-generated method stub
			Integer EntryNo1 = first.getEntryNo();
			Integer EntryNo2 = second.getEntryNo();
			return EntryNo1.compareTo(EntryNo2); 
		}
		

}
