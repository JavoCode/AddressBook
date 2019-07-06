package contact;

import java.io.IOException;

import java.util.Scanner; 
import java.util.ArrayList;
import java.util.Collections;

public class TextUI {
	
	public static void main(String[]args) throws IOException {
		
		DatabaseManager DataMan = new DatabaseManager();
		AddressBook ABook = new AddressBook(DataMan);
		Authentication AU = new Authentication();
		UserDetails UD = new UserDetails();
		String status = "Locked";
		DataMan.readFile();	

		Scanner scan  = new Scanner(System.in);
		
		String choice = null;
		String username;
		String password;  
		String address = null;
		String stats = null;
		int choiceN = 0;
		String choiceL = null;
		int count = 0;
		int entryNum = 0;
		String firstName = null;
		String lastName = null;
		Gender gend = null;
		String alias = null;
		Long dob = (long) 0;
		Long number = (long)0;
		Character type = (Character) null;
		
		
		do {
		System.out.println("Enter your username");
		username = scan.nextLine();
		
		System.out.println("Enter password");
		password = scan.nextLine();
		
		
		if(AU.checkValidPassword(username,password) == true) {	
			stats = "Open";
			count = 3;
		}else {
			System.out.println("Invalid Password");
			count++;
		}
		}while(!(count == 3));
			
		if(stats == "Open") {
		
		
		
			do {
			
					
		System.out.println("------------- 1 - Add New Contact------------------");
		System.out.println("------------- 2 - Contact Search by Entry Number---");
		System.out.println("--------------3 - Contact searh by Email-----------");
		System.out.println("------------- 4 - Delete a Contact by Entry Number-");
		System.out.println("------------- 5 - Delete a Contact by email--------");
		System.out.println("------------- 6 - Display Contacts--------");
		System.out.println("------------- 7 - Edit Contact Details----");
		System.out.println("------------- 8 - Sort by Entry Number----");
		System.out.println("------------- 9 - Sort by Last Name ------");
		System.out.println("------------- 10 - exit -------------------");
		System.out.println("============= 11 - Save ===================");
		
		choice = scan.nextLine();
		choiceN = Integer.parseInt(choice);
//		DataMan.readFile();
		
		switch(choiceN){
		
		case 1 : 
			ABook.nullContact();
			System.out.println("Enter the first Name: ");
			 firstName = scan.nextLine();
			
			
			System.out.println("Last Name:");
			lastName = scan.nextLine();
			
			
			System.out.println("Gender: ");
			String gender = scan.nextLine();
			gend = Gender.valueOf(gender);
			
			System.out.println("alias: ");
			 alias = scan.nextLine();
			
			
			System.out.println("Enter the first Line of your address");
			address = scan.nextLine() + ";";
			
			System.out.println("Enter the 2nd line of your address");
			address+= scan.nextLine()+ ";";
			
			System.out.println("Enter the 3rd line of your address ");
			address+= scan.nextLine()+";";
			
			System.out.println("Enter the 4th and final line of your address");
			address+= scan.nextLine();
			
			
			System.out.println("Date of birth: ");
			String Dob = scan.nextLine();
			 dob = Long.parseLong(Dob);
			 
			 System.out.println("Add Phone number");
			 String num = scan.nextLine();
			 number = Long.parseLong(num);
			 
			 System.out.println("Enter M for Mobile, W for work, H for Home");
			 String typeNum = scan.nextLine();
			 type = typeNum.charAt(0);
			
			 
			 System.out.println("Enter an email");
			 String email = scan.nextLine();
			 
			
			ABook.NewContact(firstName, lastName, gender, Dob,alias,address,type,number,email);
			
			System.out.println("Contact Created");
			
			break;
		case 2 :
			System.out.println("Enter the Entry Number you wish to look for");
			String entryNo;
			entryNo = scan.nextLine();
			entryNum =Integer.parseInt(entryNo);
//			ABook.searchViaEntryNo(entryNum);
			System.out.println(DataMan.searchforEntryNo(entryNum));
			break;
			
		case 3 : 
			
			System.out.println("Enter the email of the contact");
			String emailS = scan.nextLine();
			ABook.searchViaEmail(emailS);
			break;
			
		case 4 : 
			
			System.out.println("Enter the entry Number of the contact you wish to delete");
			entryNo = scan.nextLine();
			int entryNum2 = Integer.parseInt(entryNo);
			ABook.deleteViaEntryNo(entryNum2);
			System.out.println(DataMan.displayAllContacts());

			break;
			
			
		case 5 : 
			System.out.println("Enter the email of the contact you wish to delete");
			email = scan.nextLine();
			ABook.deleteViaEmail(email);
			System.out.println(DataMan.displayAllContacts());
			break;
			
		case 6 :
			System.out.println(DataMan.displayAllContacts());
			break;

		case 7 : 
			
			System.out.println("Enter the Entry Number of the contact you wish to edit");
			String entryNom = scan.nextLine();
			int entryNo1 = Integer.parseInt(entryNom);
		do {
			
			
		
			System.out.println("A - Edit Last Name");
			System.out.println("B - Edit alias");
			System.out.println("C - Add a phone number");
			System.out.println("D - Delete a number");
			System.out.println("E - Add a email");
			System.out.println("F - Exit");
			System.out.println("S = Save");
			choiceL = scan.nextLine();
			
			
				switch(choiceL) {
				case "A" : 
					System.out.println("Last Name: ");
					String newLastName = scan.nextLine();
					ABook.updateLastName(newLastName, entryNo1);
					
					break;
				case "B": 
					System.out.println("Alias: ");
					String editalias = scan.nextLine();
					ABook.updateContactAlias(editalias, entryNo1);
					
					break;
				case "C" : 
					System.out.println("Enter Phone number");
					String editPhone = scan.nextLine();
					System.out.println("Enter number type");
					String typeEdit = scan.nextLine();
					Long numNew = Long.parseLong(editPhone);
				
					ABook.addContactPhone(typeEdit.charAt(0), numNew, entryNo1);
					break;
					
				case "D" : 
					System.out.println("Enter number you wish to delete");
					String delNumber = scan.nextLine();
					Long delnumD = Long.parseLong(delNumber);
					
					ABook.deleteContactPhone(delnumD, entryNo1);
					break;
					
				case "E":
					System.out.println("Enter the email you wish to add");
					String addemail = scan.nextLine();
					
					ABook.addContactEmail( addemail, entryNo1);		
					break;
				case "F" : 
					System.exit(0);
					
				case "S" : 
					
//					DataMan.updateArrayInfo(ABook.getContactEntryNum() ,firstName, lastName, gend, alias, dob, ABook.getContactEmailList(),ABook.getType(),ABook.getContactPhoneList(), ABook.getContactAddress());
					DataMan.write();
					

					break;
				}
		}while(! (choiceL == "F"));
						
				
		case 8 : 
			 
			 ABook.sortContactByEntryNo();
		
		case 9 : 
			ABook.sortContactByLastName();
			
		case 10 :
			System.exit(0);
			break;
		case 11 : 

		
//			DataMan.updateArrayInfo(ABook.getContactEntryNum() ,firstName, lastName, gend, alias, dob, ABook.getContactEmailList(),ABook.getContactPhoneList(), ABook.getContactAddress(ABook.getContactEntryNum()));
			
			DataMan.write();
	
		}


		}while(!(choiceN == 10));
		

	


	

	}else {
		AU.setLoginstatus();
	}
}
}

