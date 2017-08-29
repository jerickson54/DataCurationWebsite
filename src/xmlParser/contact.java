package xmlParser;

public class contact {
	private String name;
	private String title;
	private String agency;
	private String email;
	private String phoneNumber;
	
	public contact() {
		super();
		name = "";
		title = "";
		agency = "";
		email = "";
		phoneNumber = "";
	}
	
	public contact(String name, String title, String agency, String email, String phoneNumber) {
		super();
		this.name = name;
		this.title = title;
		this.agency = agency;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
	

	public String getName() {
		return name;
	}



	public String getTitle() {
		return title;
	}

	

	public String getAgency() {
		return agency;
	}

	
	public String getEmail() {
		return email;
	}

	

	public String getPhoneNumber() {
		return phoneNumber;
	}


	@Override
	public String toString() {
		return name + '\t' + " Email " + email + '\t'
				+ " Phone Number " + phoneNumber;
	}
	
	
	
	

}
