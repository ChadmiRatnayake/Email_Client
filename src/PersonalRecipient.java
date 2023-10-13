

public class PersonalRecipient extends Recipient implements IBirthdayGreetable{ 
	 
	private String nickname; 
	private String birthday; 
	 
	public PersonalRecipient(String name, String nickname, String email, String birthday) { 
		super(name, email); 
		this.nickname = nickname; 
		this.birthday = birthday; 
	} 
	 
	public String getNickname() { 
		return nickname; 
	} 
	 
	@Override 
	public String birthdayGreeting() { 
		return "Wish you a Happy Birthday, hugs and love on your birthday. Chadmi Ratnayake"; 
	} 
	 
	@Override 
	public String getBirthday() { 
		return birthday; 
	} 
	 
	} 