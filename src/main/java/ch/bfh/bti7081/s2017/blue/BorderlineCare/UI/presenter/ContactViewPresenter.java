package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.vaadin.ui.PopupView;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.DB.DBConnector;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.Contact;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.ContactModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.ContactViewImpl;

/*
 * 
 * @author Sandro
 * 
 */
public class ContactViewPresenter implements ContactButtonClickListener {

	private ContactModel contactModel;
	private ContactViewImpl contactViewImpl;
	private Set<Contact> contacts;
	private DBConnector dbconnector;

	public ContactViewPresenter(ContactModel model, ContactViewImpl view) {
		this.contactModel = model;
		this.contactViewImpl = view;
		dbconnector = DBConnector.getDBConnector();
		contacts = contactModel.getContacts();
		contactViewImpl.initializeContacts(contacts);
		contactViewImpl.addContactButtonClickListeneer(this);
		contactViewImpl.initializeDeletePopup();
		contactViewImpl.initNewContactPopup();
		contactViewImpl.defaultSort();
	}

	public Set<Contact> getContacts() {
		return this.contacts;
	}

	/*
	 *
	 *
	 */
	@Override
	public void deleteButtonClick(PopupView popup, Set<Contact> toDelete) {
		popup = contactViewImpl.getDeleteContactPopup();
		popup.setPopupVisible(true);
		contactViewImpl.getDeleteButton().addClickListener(clickEvent -> {
			deleteSelected(toDelete);		
		});
	}
	

	/*
	 * 
	 * 
	 */
	@Override
	public void deleteContact(Contact toRemove) {
		this.contacts.remove(toRemove);
//		contactViewImpl.initializeContacts(this.contacts);
//		contactViewImpl.getContactPopup().setPopupVisible(false);
		//dbconnector.writeDataToDB();
		
	}

	/*
	 * 
	 * 
	 */
	@Override
	public void saveButtonClick(String stringInput, int integerInput) {
		dbconnector.getLoginAccount().getContacts().add(new Contact(stringInput, integerInput, dbconnector.getLoginAccount()));
		contacts.add(new Contact(stringInput, integerInput, dbconnector.getLoginAccount()));
		dbconnector.writeDataToDB();
		contactViewImpl.initializeContacts(this.contacts);
		contactViewImpl.getContactPopup().setPopupVisible(false);
	}

	@Override
	public void cancelButtonClick() {
		contactViewImpl.getContactPopup().setPopupVisible(false);
	}


	/*
	 @param the Set of contact selected on the Grid.
	 *
	 */
	@Override
	public void deleteSelected(Set<Contact> contacts) {
		// for(Contact contact : contacts){
		// for(Contact c : this.contacts){
		// if(contact.getId() == c.getId()){
		// deleteContact(c);
		// }
		// }
		// }

		Iterator<Contact> iterator = contacts.iterator();
		while (iterator.hasNext()) {
			Contact c = iterator.next();
			if (this.contacts.contains(c)) {
				deleteContact(c);
			}
		}
		contactViewImpl.initializeContacts(this.contacts);
		contactViewImpl.getContactPopup().setPopupVisible(false);

	}

	

}
