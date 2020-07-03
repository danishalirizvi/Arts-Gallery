package Entities;

public class ContactForm {
	
	int form_Id;
	int customer_Id;
	String subject;
	
	public ContactForm(int artist_Id, int customerID, String subject) {
		form_Id = artist_Id;
                customer_Id = customerID;
                this.subject = subject;
	}

	
	

}
