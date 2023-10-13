

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream; 
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream; 
import java.util.ArrayList; 
import java.util.HashMap; 
 
public class Serialization { 
 
	//serialization 
	public static void saveSentEmailsToHardDisk(HashMap<String,ArrayList<String>> sentEmailsHashMap) { 
		try { 
			FileOutputStream fileOutputStream = new FileOutputStream("sentEmails.ser"); 
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream); 
			objectOutputStream.writeObject(sentEmailsHashMap); 
			objectOutputStream.close(); 
			fileOutputStream.close(); 
		}catch (IOException e){ 
			e.printStackTrace(); 
		} 
	} 

	//deserialization
	public static HashMap<String,ArrayList<String>> retrieveSentEmails() { 
		try { 
			FileInputStream fileInputStream = new FileInputStream("sentEmails.ser"); 
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream); 
			HashMap<String,ArrayList<String>> sentEmailsHashMap = (HashMap<String,ArrayList<String>>) objectInputStream.readObject(); 
			objectInputStream.close(); 
			return sentEmailsHashMap;
		}catch(FileNotFoundException fn){
			return new HashMap<String,ArrayList<String>>();
		}catch(IOException | ClassNotFoundException e) { 
			e.printStackTrace(); 
		}
		return null; 
	} 
 
} 