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

	
	
	public ContactViewPresenter(ContactModel model, ContactViewImpl view){
		this.contactModel = model;
		this.contactViewImpl = view;
		contacts = new ArrayList<>();
		contactViewImpl.initializeContacts(contactModel.getContacts());
		contactViewImpl.addContactButtonClickListeneer(this);
		contactViewImpl.initializeDeletePopup();
		contactViewImpl.initNewContactPopup();
	}
	
	
	public List<Contact> getContacts(){
		return this.contacts;
	}
	
	public void remove() {
		contacts.remove(0);
	}
	

	@Override
	public void deleteButtonClick() {
		
	}


	@Override
	public void newContactButtonClick() {
		contactViewImpl.getPopuop().setVisible(true);
		
	}



}
