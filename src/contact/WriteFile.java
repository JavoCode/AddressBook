package contact;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Formatter;


public class WriteFile {

    private Formatter x;
    private String separator = ":";
    private DatabaseManager data;
   
    
//    public WriteFile(String filepath) {
//	     this.path = filepath;
//	     }
	
//	     public WriteFile(String filepath, boolean append_value) {
//	     this.path = filepath;
//	     this.append_to_file = append_value;
//	     }
	
	     public void updateUserDetails(String username,String password) throws IOException {
	    String str = username+":"+password;	 
	     FileWriter write = new FileWriter("PasswordFile.txt", true);
	     PrintWriter printline = new PrintWriter(write);
	    printline.write(str+"\n");
	    printline.flush();
	    printline.close();
	     }				    
	     
	    

//    public void OpenFile() {
//		try {
//			x = new Formatter("PasswordFile.txt");
//		}catch (Exception e) {
//			System.out.println("File Open Error ");
//		}
//	}
//	
//	public void updateUserDetails(String userName, String password) {
//		x.format("%s%s%s"+"%n",userName,":",password );
//	}
//	
//	public void closeFile() {
//		x.close();
//	}
//	
}

