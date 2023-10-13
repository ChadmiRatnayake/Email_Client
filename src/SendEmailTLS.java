import javax.mail.*; 
import javax.mail.internet.InternetAddress; 
import javax.mail.internet.MimeMessage;
import java.util.Properties; 
 
public class SendEmailTLS { 
	private final String username = "ratnayakeassignment@gmail.com"; 
	private final String password = "lwrjrbpaaeqqjccf";
	private Session session;

	public SendEmailTLS(){
		// fixing mutliple time autheticating issue
		Properties prop = new Properties(); 
		prop.put("mail.smtp.host", "smtp.gmail.com"); 
		prop.put("mail.smtp.port", "587"); 
		prop.put("mail.smtp.auth", "true"); 
		prop.put("mail.smtp.starttls.enable", "true"); //TLS 
		 
		this.session = Session.getInstance(prop, 
		new javax.mail.Authenticator() { 
		protected PasswordAuthentication getPasswordAuthentication() { 
		return new PasswordAuthentication(username, password); 
		} 
		}); 
	}
 
	public void sendEmail(String receiverEmail, String subject, String content) {  
		try { 
		 
			Message message = new MimeMessage(session); 
			message.setFrom(new InternetAddress("chadmiratnayake@gmail.com")); 
			message.setRecipients( 
			Message.RecipientType.TO, 
			InternetAddress.parse(receiverEmail) 
			); 
			message.setSubject(subject); 
			message.setText(content); 
			 
			Transport.send(message); 
			 
			System.out.println("Done"); 
		 
		} catch (MessagingException e) { 
			e.printStackTrace(); 
		} 
	} 
 
}