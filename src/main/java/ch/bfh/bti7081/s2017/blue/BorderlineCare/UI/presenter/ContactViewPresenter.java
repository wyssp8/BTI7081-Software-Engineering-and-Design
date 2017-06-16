package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter;

import java.util.HashSet;
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

	public ContactViewPresenter(ContactModel model, ContactViewImpl view) {
		this.contactModel = model;
		this.contactViewImpl = view;
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
	 *@param the Popup which will be showed by clicking on the Button 'delete'
	 *@param the Set of Contact selected in the Grid
	 */
	@Override
	public void deleteButtonClick(PopupView popup, Set<Contact> toDelete) {
		popup = contactViewImpl.getDeleteContactPopup();
		popup.setPopupVisible(true);
		contactViewImpl.getDeleteButton().addClickListener(clickEvent -> {
			deleteSelected(toDelete);
		});
	}


	@Override
	public void deleteContact(Contact toRemove) {
		DBConnector.getDBConnector().getLoginAccount().getContacts().remove(toRemove);
	}

	@Override
	public void deleteContacts(Set<Contact> contacts) {
		DBConnector.getDBConnector().getLoginAccount().getContacts().removeAll(contacts);
		for (Contact contact : contacts) {
			DBConnector.getDBConnector().deleteDataFromDB(contact);
		}
	}

	/*
	 * 
	 * @param the input from the user in the Name TextField
	 * @param the input from the user in the Phonenumber TextFiled
	 */

	public void saveButtonClick(String stringInput, String numberInput) {
		initializeContacts();
		Contact contact = new Contact();
		contact.setName(stringInput);
		contact.setPhoneNumber(numberInput);
		contact.setLoginAccount(DBConnector.getDBConnector().getLoginAccount());
		DBConnector.getDBConnector().getLoginAccount().getContacts().add(contact);
		DBConnector.getDBConnector().writeDataToDB();
		initializeContacts();
		contactViewImpl.getContactPopup().setPopupVisible(false);
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

	@SuppressWarnings("unchecked")
	public void initializeContacts() {
		contactViewImpl.getGrid().setItems(DBConnector.getDBConnector().getLoginAccount().getContacts());
	}

}
