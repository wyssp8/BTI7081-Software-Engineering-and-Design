package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view;

import java.util.List;

import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.Contact;

public class ContactViewImpl extends CustomComponent{
	
	private Grid<Contact> grid;
	private List<Contact> contacts;
	
	public ContactViewImpl(){
		grid = new Grid<>();
		grid.addColumn(Contact::getName).setCaption("Name");
		grid.addColumn(Contact::getPhoneNumber).setCaption("Phonenumber");
		VerticalLayout layout = new VerticalLayout();
		layout.addComponent(grid);
		setCompositionRoot(layout);
		
	}
	
	public void initializeContacts(List<Contact> contacts){
		grid.setItems(contacts);
	}

}
