package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.data.Binder;
import com.vaadin.data.Binder.Binding;
import com.vaadin.data.HasValue;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.Column;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.components.grid.HeaderCell;
import com.vaadin.ui.components.grid.HeaderRow;
import com.vaadin.ui.renderers.ButtonRenderer;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.Contact;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.ButtonClickListener;

public class ContactViewImpl extends CustomComponent{
	
	private Grid<Contact> grid;
	private List<Contact> contacts;
	private List<ButtonClickListener> buttonClickListeners = new ArrayList<>();
	
	
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
				new ButtonRenderer<Object>(clickEvent -> {
					contacts.remove(clickEvent.getItem());
					grid.setItems(contacts);
				}));
		
		delete.setId("delete");
		Button deleteButton = new Button("new Contact");
		header.getCell("delete").setComponent(deleteButton);
		
		grid.getEditor().setEnabled(true);
		
		VerticalLayout layout = new VerticalLayout();
		layout.addComponent(grid);
		setCompositionRoot(layout);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public void initializeContacts(List<Contact> contacts){
		grid.setItems(contacts);
	}
	
	public void addListener(ButtonClickListener clickListener){
		buttonClickListeners.add(clickListener);
	}

}
