package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter;

import java.util.HashSet;

import java.util.Set;

import com.vaadin.ui.PopupView;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.DB.DBConnector;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.Contact;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.ContactModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.DiaryEntry;
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
		//dbconnector = DBConnector.getDBConnector();

		//this.contacts = dbconnector.getLoginAccount().getContacts();
		//initializeContacts(this.contacts);
		initializeContacts();

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
		//this.contacts.remove(toRemove);
		DBConnector.getDBConnector().getLoginAccount().getContacts().remove(toRemove);
	}

	@Override
	public void deleteContacts(Set<Contact> contacts) {
		/*this.contacts.removeAll(contacts);
		for (Contact contact : contacts) {
			dbconnector.deleteDataFromDB(contact);
		}*/
		
		DBConnector.getDBConnector().getLoginAccount().getContacts().removeAll(contacts);
		for (Contact contact : contacts) {
			DBConnector.getDBConnector().deleteDataFromDB(contact);
		}
	}

	/*
	 * 
	 * 
	 */
	@Override
	public void saveButtonClick(String stringInput, int integerInput) {
		initializeContacts();
		Contact contact = new Contact();
		contact.setName(stringInput);
		contact.setPhoneNumber(integerInput);
		contact.setLoginAccount(DBConnector.getDBConnector().getLoginAccount());
		DBConnector.getDBConnector().getLoginAccount().getContacts().add(contact);
		DBConnector.getDBConnector().writeDataToDB();
		initializeContacts();
		contactViewImpl.getContactPopup().setPopupVisible(false);
		/*
		this.contacts.add(new Contact(stringInput, integerInput, dbconnector.getLoginAccount()));
		dbconnector.writeDataToDB();
		initializeContacts(this.contacts);
		contactViewImpl.getContactPopup().setPopupVisible(false);*/
	}

	@Override
	public void cancelButtonClick() {
		contactViewImpl.getContactPopup().setPopupVisible(false);
	}

	/*
	 * @param the Set of contact selected on the Grid.
	 *
	 */
	@Override
	public void deleteSelected(Set<Contact> toDelete) {
		/*System.out.println("Contacts in DB: ");
		for (Contact contact : this.contacts) {
			System.out.println("-> " + contact.getName());
		}
		System.out.println("Contacts selected in toDelete: ");
		for (Contact contact : toDelete) {
			System.out.println("-> " + contact.getName());
		}

		Set<Contact> tmp = new HashSet<>();
		for (Contact contact : toDelete) {
			for (Contact c : this.contacts) {
				if (contact.getId() == c.getId()) {
					tmp.add(c);
				}
			}
		}
		for (Contact contact : tmp) {
			System.out.println("-> " + contact.getName());
		}
		deleteContacts(tmp);

		initializeContacts(this.contacts);

		dbconnector.writeDataToDB();

		contactViewImpl.getContactPopup().setPopupVisible(false);*/
		
		Set<Contact> tmp = new HashSet<>();
		for (Contact contact : toDelete) {
			for (Contact c : DBConnector.getDBConnector().getLoginAccount().getContacts()) {
				if (contact.getId() == c.getId()) {
					tmp.add(c);
				}
			}
		}
		deleteContacts(tmp);
		DBConnector.getDBConnector().writeDataToDB();	
		initializeContacts();
		contactViewImpl.getContactPopup().setPopupVisible(false);
	}

	/*
	public void initializeContacts(Set<Contact> contacts) {
		contactViewImpl.getGrid().setItems(this.contacts);
	}*/
	
	@SuppressWarnings("unchecked")
	public void initializeContacts() {
		contactViewImpl.getGrid().setItems(DBConnector.getDBConnector().getLoginAccount().getContacts());
	}

}
