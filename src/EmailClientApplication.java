import java.text.SimpleDateFormat; 
import java.util.ArrayList; 
import java.util.Date; 
import java.util.HashMap; 
 
public class EmailClientApplication { 
 
	private String currentDate; 
	private ArrayList<IBirthdayGreetable> birthdayGreetingRecipients; 
	private HashMap<String,ArrayList<String>> sentEmailsHashMap; 
	private static EmailClientApplication instance = null;
	// implementing singleton design pattern
	public static EmailClientApplication getInstance(){
		if (instance == null){
			instance = new EmailClientApplication();
		}
		return instance;
	}
	private EmailClientApplication() { 
		this.birthdayGreetingRecipients = new ArrayList<IBirthdayGreetable>(); 
		this.sentEmailsHashMap = new HashMap<String,ArrayList<String>>(); 
	} 
	 
	public HashMap<String,ArrayList<String>> getSentEmails(){ 
		return this.sentEmailsHashMap; 
	} 
	 
	public ArrayList<IBirthdayGreetable> getBirthdayGreetingRecipients(){
		return this.birthdayGreetingRecipients;
	}
	public void havingBirthday(String givenDate) { 
		boolean birthdaysNone = true; 
		for (IBirthdayGreetable friend : birthdayGreetingRecipients) { 
			if (friend.getBirthday().equals(givenDate)) { 
			Recipient recipient = (Recipient) friend; 
			System.out.println(recipient.getName() + "\n"); 
			birthdaysNone = false; 
			} 
		} 
		if (birthdaysNone) { 
			System.out.println("None of the friends is having birthdays"); 
		} 
	} 
	 
	// case 4 
	public void detailsOfSentEmails(String currentDate) { 
		try { 
			for (String details : sentEmailsHashMap.get(currentDate)) { 
				System.out.println(details); 
		} 
		}catch(NullPointerException e) { 
			System.out.println("Emails are not sent on this date"); 
		} 
	} 
	 
	public void startEmailClient() { 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd"); 
		currentDate = dateFormat.format(new Date()); 
		retrieveSentEmails(); 
		try { 
			if(!(sentEmailsHashMap.containsKey(currentDate))) { 
				sendGreetings(); 
		} 
		}catch(NullPointerException e) { 
			e.printStackTrace(); 
		} 
	} 
	 
	private void sendGreetings() { 
	// fixing loop issue
	SendEmailTLS sendMail = new SendEmailTLS(); 
	for (IBirthdayGreetable friend : birthdayGreetingRecipients) { 
		if (friend.getBirthday().substring(5).equals(currentDate.substring(5))) { 
			sendMail.sendEmail(friend.getEmail(), "Birthday Greetings", friend.birthdayGreeting()); 
			saveSentEmails(friend.getEmail(), "Birthday Greetings", friend.birthdayGreeting()); 
			} 
		} 
		System.out.println("Birthday Greetings are sent"); 
	} 
		 
	public void saveSentEmails(String receiverEmail, String subject, String content) { 
	try { 
		if(sentEmailsHashMap.containsKey(currentDate)) { 
			sentEmailsHashMap.get(currentDate).add(receiverEmail+","+subject+","+content); 
		} 
		else { 
			ArrayList<String> details = new ArrayList<String>(); 
			details.add(receiverEmail+","+subject+","+content); 
			sentEmailsHashMap.put(currentDate, details); 
		} 
	}catch(NullPointerException e) { 
		ArrayList<String> details = new ArrayList<String>(); 
		details.add(receiverEmail+","+subject+","+content); 
		sentEmailsHashMap.put(currentDate, details); 
		} 
	} 

	private void retrieveSentEmails() { 
		HashMap<String,ArrayList<String>> temp = Serialization.retrieveSentEmails();
		if (temp != null){
			sentEmailsHashMap = temp;
		}
	} 
	 
	 
} 
