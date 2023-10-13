

public abstract class Recipient {
	
	private String name; 
	private String email; 
	private static int countRecipientObjects; 
	 
	public Recipient (String name, String email) { 
		this.name = name; 
		this.email = email; 
		countRecipientObjects++; 
	} 
	 
	public String getName() { 
		return name; 
	} 
	 
	public String getEmail() { 
		return email; 
	} 
	 
	public static int getCountOfRecipientObject() { 
		return countRecipientObjects; 
	} 

}
