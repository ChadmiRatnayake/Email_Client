

public abstract class Recipient {
	
	private String name; 
	private String email; 
	private static int countRecipientObjects; 
	 
	public Recipient (String name, String email) { 
		this.name = name; 
		this.email = email; 
		++countRecipientObjects; 
	} 
	 
	public String getName() { 
		return this.name; 
	} 
	 
	public String getEmail() { 
		return this.email; 
	} 
	 
	public static int getCountOfRecipientObject() { 
		return countRecipientObjects; 
	} 

}
