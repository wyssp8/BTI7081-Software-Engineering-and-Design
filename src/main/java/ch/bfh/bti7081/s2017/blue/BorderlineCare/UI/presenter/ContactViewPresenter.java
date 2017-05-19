package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PopupView;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.Contact;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.ContactModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.ButtonClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.ContactViewImpl;

public class ContactViewPresenter implements ContactButtonClickListener{
	
	private ContactModel contactModel;
	private ContactViewImpl contactViewImpl;
	private List<Contact> contacts;
	private PopupView popup;

	
	
	public ContactViewPresenter(ContactModel model, ContactViewImpl view){
		this.contactModel = model;
		this.contactViewImpl = view;
		contacts = contactModel.getContacts();
		contactViewImpl.initializeContacts(contacts);
		contactViewImpl.addContactButtonClickListeneer(this);
		contactViewImpl.initializeDeletePopup();
		contactViewImpl.initNewContactPopup();
	}
	
	
	public List<Contact> getContacts(){
		return this.contacts;
	}
	

	@Override
	public Contact deleteButtonClick(PopupView popup, Contact toDelete) {
		popup = contactViewImpl.getDeleteContactPopup();
		popup.setPopupVisible(true);
		return toDelete;
	}
	
	@Override
	public void deleteContact(){
		this.contacts.remove(0);
		contactViewImpl.initializeContacts(this.contacts);
	}


	@Override
	public void saveButtonClick(String stringInput, int integerInput) {
		this.contacts.add(new Contact(stringInput, integerInput));
		contactViewImpl.initializeContacts(this.contacts);
		contactViewImpl.getContactPopup().setPopupVisible(false);
	}
	
	@Override
	public void cancelButtonClick(){
		contactViewImpl.getContactPopup().setPopupVisible(false);
	}



}
