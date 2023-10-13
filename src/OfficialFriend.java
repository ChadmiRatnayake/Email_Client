

public class OfficialFriend extends OfficialRecipient implements IBirthdayGreetable{ 
	 
	private String birthday; 
	 
	public OfficialFriend(String name, String email, String designation, String birthday) { 
		super(name, email, designation); 
		this.birthday = birthday; 
	} 
	 
	@Override 
	public String birthdayGreeting() { 
		return "Wish you a Happy Birthday. Chadmi Ratnayake"; 
	} 
	 
	@Override 
	public String getBirthday() { 
		return birthday; 
	} 
	 
	}
