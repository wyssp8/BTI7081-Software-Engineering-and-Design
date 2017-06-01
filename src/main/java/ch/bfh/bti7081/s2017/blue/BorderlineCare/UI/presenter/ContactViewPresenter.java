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

public class ContactViewPresenter implements ContactButtonClickListener {

	private ContactModel contactModel;
	private ContactViewImpl contactViewImpl;
	private List<Contact> contacts;
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

	public List<Contact> getContacts() {
		return this.contacts;
	}

	@Override
	public void deleteButtonClick(PopupView popup, Set<Contact> toDelete) {
		popup = contactViewImpl.getDeleteContactPopup();
		popup.setPopupVisible(true);
		contactViewImpl.getDeleteButton().addClickListener(clickEvent -> {
			deleteSelected(toDelete);
		});
	}

	@Override
	public void deleteContact(Contact contact) {
		this.contacts.remove(contact);
//		contactViewImpl.initializeContacts(this.contacts);
//		contactViewImpl.getContactPopup().setPopupVisible(false);
	}

	@Override
	public void saveButtonClick(String stringInput, int integerInput) {
		this.contacts.add(new Contact(stringInput, integerInput, dbconnector.getLoginAccount()));
		dbconnector.writeDataToDB();
		contactViewImpl.initializeContacts(this.contacts);
		contactViewImpl.getContactPopup().setPopupVisible(false);
	}

	@Override
	public void cancelButtonClick() {
		contactViewImpl.getContactPopup().setPopupVisible(false);
	}

	@Override
	public void deleteSelected(Set<Contact> contacts) {
		Iterator<Contact> i = contacts.iterator();
		while (i.hasNext()) {
			Contact c = i.next();
			for (Contact contact : this.contacts) {
				if (contact.equals(c)) {
					deleteContact(contact);
				}
			}
		}
		contactViewImpl.initializeContacts(this.contacts);
		contactViewImpl.getContactPopup().setPopupVisible(false);

	}
	
	
	

//	@Override
//	public void deleteSelected(Set<Contact> contacts) {
//		ArrayList<Contact> tmp = new ArrayList<>();
//		Iterator<Contact> iterator = contacts.iterator();
//		while(iterator.hasNext()){
//			Contact c = iterator.next();
//			tmp.add(c);
//			contacts.remove(c);
//		}
//		for(int i=0; i<tmp.size(); i++){
//			if(tmp.get(i).equals(this.contacts.get(i))){
//				this.contacts.remove(i);
//			}
//		}
//	}

}
