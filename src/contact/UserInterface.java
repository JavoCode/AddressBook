package contact;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class UserInterface{
	
	private static AddressBook Ab;
	private static DatabaseManager Dm;

    public static void main (String[] args){
      new Menu(Ab, Dm).setVisible(true);

   }
}
