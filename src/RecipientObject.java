
public class RecipientObject {
	private EmailClientApplication emailClient;

	
	public RecipientObject() {
		this.emailClient = EmailClientApplication.getInstance();
	}


	public Recipient createRecipientObject(String recipientData) { 
		 
		String[] dataList = recipientData.split(":",2); 
		String[] recipientDetails = dataList[1].split(","); 
		Recipient recipient = null; 
		//fixing code redundancy issue
		switch(dataList[0]) { 
			case "Official": 
				recipient = new OfficialRecipient(recipientDetails[0], recipientDetails[1], recipientDetails[2]); 
				return recipient; 
			case "Office_friend": 
				recipient = new OfficialFriend(recipientDetails[0], recipientDetails[1], recipientDetails[2], recipientDetails[3]);   
			case "Personal": 
				recipient = new PersonalRecipient(recipientDetails[0], recipientDetails[1], recipientDetails[2], recipientDetails[3])
		; 
		} 
		if (recipient!= null){
			emailClient.getBirthdayGreetingRecipients().add((IBirthdayGreetable)recipient);
		}
		return recipient; 
	}

}
