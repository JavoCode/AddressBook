package contact;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;

public class Authentication {
	
	private Formatter x;
	private String [] tokens;
	private UserDetails uDetails;
	private ArrayList<UserDetails>userList;
	private String loginStatus;
	
	
	
public Authentication() {	
	
	userList = new ArrayList<UserDetails>();
	
	 
		try {
			
			loginStatus = "Locked";
			
			FileReader fr = new FileReader("PasswordFile.txt");
			BufferedReader br = new BufferedReader(fr);
			String oneLine = "";
			
			while((oneLine = br.readLine()) != null) {
				
				tokens = oneLine.split(":");
				uDetails = new UserDetails();
				uDetails.setUserName(tokens[0]);
				uDetails.setPassword(tokens[1]);
				
				userList.add(uDetails);
//				
//				
			}
		}catch (IOException e) {
			
			
			System.out.println("An error occured when trying to read the file");
		}
		
}
		
		
	
	public boolean checkifUserAlreadyExist(String User) {
		for(int i = 0;i<userList.size();i++) {
			if(User.equals(userList.get(i).getUserName()))
				return true;
			
		}
		return false;
	}
	
	
	public void changePassword(String newPassword) {
		if(uDetails.getPassWord()==newPassword) {
			System.out.println("New Password cannot be the same as previous password");
		}else {
			uDetails.setPassword(newPassword);
		}
	}
	
//	public void checkValidPassword(String loginpassword) {
//		if(uDetails.getPassWord()==loginpassword) {
//			
//			
//		}else {
//			System.out.println("Incorrect Password");
//		}
//	}
	
	public boolean checkValidPassword(String User,String loginPassword) {
		
		for(UserDetails userD : userList) {
			if(User.equals(userD.getUserName()) &&loginPassword.equals(userD.getPassWord()))
				return true;
		}
		return false;
		
	}
	
	
	public boolean checkLoginStatus() {
		if(loginStatus.equals("Open")) {
			return true;
			
		}else
		return false;
	}
	
	public void setLoginstatus(){
		if(loginStatus.equals("Locked")) {
			loginStatus = "Open";
		}else {
			loginStatus = "Locked";
		}
		
	}
	
	

}


