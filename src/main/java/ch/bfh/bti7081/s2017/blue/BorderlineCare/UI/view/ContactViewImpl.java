package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.Column;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.components.grid.HeaderRow;
import com.vaadin.ui.renderers.ButtonRenderer;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.Contact;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.ContactButtonClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.interfaces.ContactView;

public class ContactViewImpl extends CustomComponent implements ContactView{
	
	private Grid<Contact> grid;
	private List<Contact> contacts;
	private List<ContactButtonClickListener> contactButtonClickListeners = new ArrayList<>();
	private PopupView popup;
	HorizontalLayout popupContent;
	
	
	public ContactViewImpl(){
		grid = new Grid<>();
		Column<Contact, ?> columnName = grid.addColumn(Contact::getName);
		columnName.setId("Name");
		columnName.setCaption("Name");
		
		Column<Contact, ?> columnPhoneNumber = grid.addColumn(Contact::getPhoneNumber);
		columnPhoneNumber.setId("Phonenumber");
		columnPhoneNumber.setCaption("Phonenumber");
		
		HeaderRow header = grid.prependHeaderRow();
		header.join(header.getCell("Name"),
					header.getCell("Phonenumber")).setText("My Contacts");
		
		Column<Contact, String> delete = grid.addColumn(contacts -> "delete", 
				new ButtonRenderer<Contact>(clickEvent -> {
					for(ContactButtonClickListener listener : contactButtonClickListeners){
						// contacts.remove(clickEvent.getItem());
						listener.deleteButtonClick();
						
					}
					grid.setItems(contacts);
				}));
		
		delete.setId("delete");
		Button newContactButton = new Button("new Contact");
		header.getCell("delete").setComponent(newContactButton);
		
		grid.getEditor().setEnabled(true);
		
		VerticalLayout layout = new VerticalLayout();
		layout.addComponent(grid);
		setCompositionRoot(layout);
		
	}
	
	
	
	public void initializeContacts(List<Contact> contacts){
		grid.setItems(contacts);
	}
	
	public void initializePopup(){
		popupContent = new HorizontalLayout();
		popupContent.addComponent(new Label("Are you sure to delete this Contact?"));
		popupContent.addComponent(new Button("delete"));
		popupContent.addComponent(new Button("cancel"));
		popup = new PopupView(null, popupContent);
	}
	
	@Override
	public void addContactButtonClickListeneer(ContactButtonClickListener clickListener) {
		contactButtonClickListeners.add(clickListener);
		
	}

}
