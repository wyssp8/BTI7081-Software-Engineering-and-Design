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

public class ContactViewImpl extends CustomComponent implements ContactView {

	private Grid<Contact> grid;
	private List<Contact> contacts;
	private List<ContactButtonClickListener> contactButtonClickListeners = new ArrayList<>();
	private PopupView popup;
	HorizontalLayout deletePopupContent, newContactPopup;
	VerticalLayout layout = new VerticalLayout();
	

	public ContactViewImpl() {
		grid = new Grid<>();
		// create two columns, set the ID's and add the captions
		Column<Contact, ?> columnName = grid.addColumn(Contact::getName);
		columnName.setId("Name");
		columnName.setCaption("Name");
		Column<Contact, ?> columnPhoneNumber = grid.addColumn(Contact::getPhoneNumber);
		columnPhoneNumber.setId("Phonenumber");
		columnPhoneNumber.setCaption("Phonenumber");
		// add a header to the grid with a button for creating new contacts...
		HeaderRow header = grid.prependHeaderRow();
		header.join(header.getCell("Name"), header.getCell("Phonenumber")).setText("My Contacts");
		Button newContactButton = new Button("new Contact");
		newContactButton.addClickListener(clickevent -> {
			for (ContactButtonClickListener listener : contactButtonClickListeners) {
				listener.newContactButtonClick();
			}
		});
		
		// add a new column to the grid with the function to delete the entire contact
		// and therefore the entire column
		Column<Contact, String> delete = grid.addColumn(contacts -> "delete",
				new ButtonRenderer<Contact>(clickEvent -> {
					for (ContactButtonClickListener listener : contactButtonClickListeners) {
						// contacts.remove(clickEvent.getItem());
						listener.deleteButtonClick();
					}
					grid.setItems(contacts);
				}));

		delete.setId("delete");
		header.getCell("delete").setComponent(newContactButton);
		grid.getEditor().setEnabled(true);
		layout.addComponent(grid);
		setCompositionRoot(layout);

	}
	
	
	

	public void initializeContacts(List<Contact> contacts) {
		grid.setItems(contacts);
	}

	public void initializeDeletePopup() {
		deletePopupContent = new HorizontalLayout();
		deletePopupContent.addComponent(new Label("Are you sure to delete this Contact?"));
		deletePopupContent.addComponent(new Button("delete"));
		deletePopupContent.addComponent(new Button("cancel"));
		popup = new PopupView(null, deletePopupContent);
		layout.addComponent(popup);
	}

	// for test reasens, same content as other deltePopupContent...
	public void initNewContactPopup() {
		newContactPopup = new HorizontalLayout();
		newContactPopup.addComponent(new Label("Are you sure to delete this Contact?"));
		newContactPopup.addComponent(new Button("delete"));
		newContactPopup.addComponent(new Button("cancel"));
		popup = new PopupView(null, newContactPopup);
		layout.addComponent(popup);
	}

	@Override
	public void addContactButtonClickListeneer(ContactButtonClickListener clickListener) {
		contactButtonClickListeners.add(clickListener);

	}

	public PopupView getPopuop() {
		return this.popup;
	}

}
