package xmlParser;



public class OregonNewsRoom {
	
	//all the attributes related to row
	private String row_id;
	private String row_uu_id;
	private String row_position;
	private String row_address;
	
	//all the rest of the attributes
	private String headline;
	private String agency;
	private String publishDate;
	private String publishYear;
	private String city;
	private String state;
	private String content;
	private String footerContent;
	private contact contact1;
	private contact contact2;
	private String dateEntered;
	private String enteredBy;
	private String date_last_modified;
	private String last_modified_by;
	
	public OregonNewsRoom(String row_id, String row_uu_id, String row_position, String row_address, String headline,
			String agency, String publishDate, String publishYear, String city, String state, String content,
			String footerContent, contact contact1, contact contact2, String dateEntered, String enteredBy,
			String date_last_modified, String last_modified_by) {
		
		super();
		this.row_id = row_id;
		this.row_uu_id = row_uu_id;
		this.row_position = row_position;
		this.row_address = row_address;
		this.headline = headline;
		this.agency = agency;
		this.publishDate = publishDate;
		this.publishYear = publishYear;
		this.city = city;
		this.state = state;
		this.content = content;
		this.footerContent = footerContent;
		this.contact1 = contact1;
		this.contact2 = contact2;
		this.dateEntered = dateEntered;
		this.enteredBy = enteredBy;
		this.date_last_modified = date_last_modified;
		this.last_modified_by = last_modified_by;
	}
	
	

	public String getRow_id() {
		return row_id;
	}



	public void setRow_id(String row_id) {
		this.row_id = row_id;
	}



	public String getRow_uu_id() {
		return row_uu_id;
	}



	public void setRow_uu_id(String row_uu_id) {
		this.row_uu_id = row_uu_id;
	}



	public String getRow_position() {
		return row_position;
	}



	public void setRow_position(String row_position) {
		this.row_position = row_position;
	}



	public String getRow_address() {
		return row_address;
	}



	public void setRow_address(String row_address) {
		this.row_address = row_address;
	}



	public String getHeadline() {
		return headline;
	}



	public void setHeadline(String headline) {
		this.headline = headline;
	}



	public String getAgency() {
		return agency;
	}



	public void setAgency(String agency) {
		this.agency = agency;
	}



	public String getPublishDate() {
		return publishDate;
	}



	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}



	public String getPublishYear() {
		return publishYear;
	}



	public void setPublishYear(String publishYear) {
		this.publishYear = publishYear;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public String getFooterContent() {
		return footerContent;
	}



	public void setFooterContent(String footerContent) {
		this.footerContent = footerContent;
	}



	public contact getContact1() {
		return contact1;
	}



	public void setContact1(contact contact1) {
		this.contact1 = contact1;
	}



	public contact getContact2() {
		return contact2;
	}



	public void setContact2(contact contact2) {
		this.contact2 = contact2;
	}



	public String getDateEntered() {
		return dateEntered;
	}



	public void setDateEntered(String dateEntered) {
		this.dateEntered = dateEntered;
	}



	public String getEnteredBy() {
		return enteredBy;
	}



	public void setEnteredBy(String enteredBy) {
		this.enteredBy = enteredBy;
	}



	public String getDate_last_modified() {
		return date_last_modified;
	}



	public void setDate_last_modified(String date_last_modified) {
		this.date_last_modified = date_last_modified;
	}



	public String getLast_modified_by() {
		return last_modified_by;
	}



	public void setLast_modified_by(String last_modified_by) {
		this.last_modified_by = last_modified_by;
	}



	@Override
	public String toString() {
		return "OregonNewsRoom [row_id=" + row_id + ", row_uu_id=" + row_uu_id + ", row_position=" + row_position
				+ ", row_address=" + row_address + ", headline=" + headline + ", agency=" + agency + ", publishDate="
				+ publishDate + ", publishYear=" + publishYear + ", city=" + city + ", state=" + state + ", content="
				+ content + ", footerContent=" + footerContent + ", contact1=" + contact1 + ", contact2=" + contact2
				+ ", dateEntered=" + dateEntered + ", enteredBy=" + enteredBy + ", date_last_modified="
				+ date_last_modified + ", last_modified_by=" + last_modified_by + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
