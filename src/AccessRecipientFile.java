

import java.io.BufferedReader; 
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader; 
import java.io.FileWriter; 
import java.io.IOException; 
import java.util.ArrayList; 
 
class AccessRecipientFile { 
 
	 
	private ArrayList<Recipient> recipientList; 
	 
	private RecipientObject recipientObject; 
	 
	public AccessRecipientFile() {
		recipientObject = new RecipientObject();
		recipientList = new ArrayList<Recipient>();
	}

	public void addRecipient(String recipientData) { 
		try { 
		FileWriter writer = new FileWriter("clientList.txt", true); 
		BufferedWriter buffer = new BufferedWriter(writer); 
		buffer.write("\n"+recipientData); 
		buffer.close(); 
		writer.close(); 
		} catch (IOException e) { 
		e.printStackTrace(); 
		} 
		 
		Recipient recipient = recipientObject.createRecipientObject(recipientData); 
		recipientList.add(recipient); 
	} 
	 
	public void readClientList() { 
		try { 
			FileReader fileReader = new FileReader("clientList.txt"); 
			BufferedReader bufferedReader = new BufferedReader(fileReader); 
			String recipientData; 
			while((recipientData = bufferedReader.readLine()) != null) { 
				if (!recipientData.equals("")) { 
					recipientList.add(recipientObject.createRecipientObject(recipientData)); 
				} 
			} 
			bufferedReader.close(); 
		} catch(FileNotFoundException fn){
			System.out.println("ClientList.txt will be created after adding contacts");
		}catch(IOException e) { 
			e.printStackTrace(); 
		} 
	} 
	 
 
}