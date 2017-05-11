package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.vaadin.server.ExternalResource;
import com.vaadin.server.Resource;

/**
 * This Class provides methods to the emergency view.
 * 
 * @author chef
 *
 */

public class EmergencyViewModel {

	private final static Logger logger = Logger.getLogger(EmergencyViewModel.class.getName());

	public String getCallLink() {
		String phoneNumber = "079 283 05 47";
		String fullLink = "tel:" + phoneNumber;
		logger.log(Level.INFO, "Link to open: " + fullLink);
		return fullLink;
	}

	public String getMessageLink() {
		String phoneNumber = "0792830547";
		String body = "I need help.";
		String fullLink = "sms://" + phoneNumber + "?body=" + body; 
		logger.log(Level.INFO, "Link to open: " + fullLink);
		return fullLink;
	}

}
