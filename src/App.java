import java.util.Scanner; 
public class App { 
	 
	public static void main(String[] args) { 
		EmailClientApplication emailClient = EmailClientApplication.getInstance(); 
		AccessRecipientFile accessRecipientFile =  new AccessRecipientFile();
		accessRecipientFile.readClientList(); 
		emailClient.startEmailClient(); 
		 
		Scanner scanner = new Scanner(System.in); 
		System.out.println("Enter option type: \n" 
		+ "1 - Adding a new recipient\n" 
		+ "2 - Sending an email\n" 
		+ "3 - Printing out all the recipients who have birthdays\n" 
		+ "4 - Printing out details of all the emails sent\n" 
		+ "5 - Printing out the number of recipient objects in the application"); 
		 
		int option = scanner.nextInt(); 
		scanner.nextLine(); 
		 
		 
		switch(option){ 
			case 1: 
				// input format - Official: nimal,nimal@gmail.com,ceo 
				// Use a single input to get all the details of a recipient
				System.out.println("Use Following format: Official: nimal,nimal@gmail.com,ceo "); 
				String recipient = scanner.nextLine(); 
				// code to add a new recipient 
				// store details in clientList.txt file 
				// Hint: use methods for reading and writing files 
				accessRecipientFile.addRecipient(recipient); 
				break; 
			case 2: 
				// input format - email, subject, content 
				String receiverEmail, subject, content; 
				System.out.println("Enter the email address of the reciever: "); 
				receiverEmail = scanner.nextLine(); 
				System.out.println("Enter the subject of the email: "); 
				subject = scanner.nextLine(); 
				System.out.println("Enter the content of the email: "); 
				content = scanner.nextLine(); 
				// code to send an email 
				SendEmailTLS sendEmail = new SendEmailTLS(); 
				sendEmail.sendEmail(receiverEmail, subject, content); 
				emailClient.saveSentEmails(receiverEmail, subject, content); 
				System.out.println("Email is sent."); 
				break; 
			case 3: 
				// input format - yyyy/MM/dd (ex: 2018/09/17) 
				System.out.println("Date should be entered in the format - yyyy/MM/dd (ex: 2018/09/17): "); 
				// code to print recipients who have birthdays on the given date 
				String givenDate = scanner.nextLine(); 
				emailClient.havingBirthday(givenDate); 
				break; 
			case 4: 
				// input format - yyyy/MM/dd (ex: 2018/09/17) 
				System.out.println("Date should be entered in the format - yyyy/MM/dd (ex: 2018/09/17): "); 
				// code to print the details of all the emails sent on the input date 
				String date = scanner.nextLine(); 
				emailClient.detailsOfSentEmails(date); 
				break; 
			case 5: 
				System.out.println(Recipient.getCountOfRecipientObject()); 
				// code to print the number of recipient objects in the application 
				break; 
		 
		} 
		 
		// start email client 
		// code to create objects for each recipient in clientList.txt 
		// use necessary variables, methods and classes 
		
		scanner.close(); 
		 
		Serialization.saveSentEmailsToHardDisk(emailClient.getSentEmails()); 
		} 
} 
