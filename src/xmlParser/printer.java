package xmlParser;


import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;



import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;

public class printer {
	
	//used to store all the data
	private static ArrayList<OregonNewsRoom> allData = new ArrayList<OregonNewsRoom>();

	
	

	public static void parseFromXML() {
		// all the attributes to retrieve then build innto oregonNewsRoom
		// objects

		
		String row_id;
		String row_uu_id;
		String row_position;
		String row_address;

		String headline;
		String agency;
		String publishDate;
		String publishYear;

		String city;
		String state;
		String content = "";
		String footerContent = "";

		String dateEntered = "";
		String enteredBy = "";
		String date_last_modified = "";
		String last_modified_by = "";

		try {
			allData.clear();
			DOMParser parser = new DOMParser();
			URL url =printer.class.getResource("../../");
			
			parser.parse(url.getPath() + "/oregonNewsroom.xml");
			
			
			
			
			
			
			Document d = parser.getDocument();

			// root object type
			NodeList nList = d.getElementsByTagName("row");

			for (int i = 0; i < nList.getLength(); ++i) {
				Node n = nList.item(i);
				Element e = (Element) n;

				// these statement is used to retrieve result stuff
				row_id = e.getAttribute("_id");
				row_uu_id = e.getAttribute("_uuid");
				row_position = e.getAttribute("_position");
				row_address = e.getAttribute("_address");

				headline = e.getElementsByTagName("headline").item(0).getTextContent();
				agency = e.getElementsByTagName("agency").item(0).getTextContent();
				publishDate = e.getElementsByTagName("publish_date").item(0).getTextContent();
				publishYear = e.getElementsByTagName("publish_year").item(0).getTextContent();

				city = e.getElementsByTagName("city").item(0).getTextContent();
				state = e.getElementsByTagName("state").item(0).getTextContent();
				// content might be empty
				if (e.getElementsByTagName("content").getLength() > 0)
					content = e.getElementsByTagName("content").item(0).getTextContent();

				footerContent = e.getElementsByTagName("footer_content").item(0).getTextContent();

				contact contact1 = null;
				contact contact2 = null;
				// will need to parse to get info from contacts
				// make sure the element actually exists
				if (e.getElementsByTagName("contact1").getLength() > 0)
					contact1 = parseContact(e.getElementsByTagName("contact1").item(0).getTextContent());
				if (e.getElementsByTagName("contact2").getLength() > 0)
					contact2 = parseContact(e.getElementsByTagName("contact2").item(0).getTextContent());
				
				if (e.getElementsByTagName("date_entered").getLength() > 0)
				dateEntered = e.getElementsByTagName("date_entered").item(0).getTextContent();
				if (e.getElementsByTagName("entered_by").getLength() > 0)
				enteredBy = e.getElementsByTagName("entered_by").item(0).getTextContent();
				if (e.getElementsByTagName("date_last_modified").getLength() > 0)
				date_last_modified = e.getElementsByTagName("date_last_modified").item(0).getTextContent();
				if (e.getElementsByTagName("last_modified_by").getLength() > 0)
				last_modified_by = e.getElementsByTagName("last_modified_by").item(0).getTextContent();
				
				OregonNewsRoom temp = new OregonNewsRoom(row_id,  row_uu_id,  row_position,  row_address,  headline,
			 agency,  publishDate,  publishYear,  city,  state,  content,
			 footerContent,  contact1,  contact2,  dateEntered,  enteredBy,
			 date_last_modified,  last_modified_by);
				allData.add(temp);
				
				

			}

		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		
	
		

	}

	public static contact parseContact(String initialString) {
		String contactName = "";
		String contactTitle = "";
		String contactAgency = "";
		String contactEmail = "";
		String contactPhoneNumber = "";

		if (initialString.isEmpty())
			return null;

		int index = initialString.indexOf('|');
		contactName = initialString.substring(0, index);
		// got name, now lets shorten the string
		initialString = initialString.substring(index + 1);
		index = initialString.indexOf('|');
		contactTitle = initialString.substring(0, index);
		// got title, now lets shorten the string
		initialString = initialString.substring(index + 2);
		index = initialString.indexOf('|');
		contactAgency = initialString.substring(0, index);
		// got agency now lets shorten the string
		initialString = initialString.substring(index + 1);
		index = initialString.indexOf('|');
		contactEmail = initialString.substring(0, index);
		// got email now lets get phone number
		initialString = initialString.substring(index + 1);
		contactPhoneNumber = initialString;

		return new contact(contactName, contactTitle, contactAgency, contactEmail, contactPhoneNumber);
	}
	
	public static ArrayList<OregonNewsRoom> getAll(){
		return allData;
	}
	

	
	public static int getRandom(){
		Random rand = new Random();
		int randomNum = rand.nextInt(allData.size()) + 1;
		return randomNum;
	}
	
	public static void printAll(){
		
		for(OregonNewsRoom t:allData)
			System.out.println(t);
	}
}
