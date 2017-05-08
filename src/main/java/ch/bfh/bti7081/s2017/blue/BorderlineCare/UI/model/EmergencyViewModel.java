package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model;

import com.vaadin.server.ExternalResource;
import com.vaadin.server.Resource;


public class EmergencyViewModel {

	public String getCallLink() {
		String phoneNumber = "079 283 05 47";
		return "tel:" + phoneNumber;
	}
	
	public String getMessageLink() {
		String phoneNumber = "0792830547";
		String body = "I need help.";
		return "sms://" + phoneNumber + "?body=" + body;
	}

}
