package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.annotations.Theme;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.UserError;
import com.vaadin.shared.data.sort.SortDirection;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.Column;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.PopupView.Content;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.components.grid.HeaderRow;
import com.vaadin.ui.components.grid.MultiSelectionModel;
import com.vaadin.ui.renderers.ButtonRenderer;
import com.vaadin.ui.renderers.ImageRenderer;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.Contact;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.ContactButtonClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.interfaces.ContactView;

public class ContactViewImpl extends CustomComponent implements ContactView {

	private static final long serialVersionUID = -1924986860210433106L;
	private Grid<Contact> grid;
	private List<Contact> contacts;
	private List<ContactButtonClickListener> contactButtonClickListeners = new ArrayList<>();
	private PopupView newContactPopup, deleteContactPopup;
	private VerticalLayout newContactPopupContent = new VerticalLayout();
	private VerticalLayout deleteContactPopupContent = new VerticalLayout();
	private VerticalLayout layout = new VerticalLayout();
	private Button deleteP, save, cancel, delete, newContactButton;
	private Label label;
	private TextField tfName, tfPhoneNumber;

	public ContactViewImpl() {
		grid = new Grid<>();
		// create two columns, set the ID's and add the captions
		Column<Contact, ?> columnName = grid.addColumn(Contact::getName);
		columnName.setId("Name");
		columnName.setCaption("Name");
		Column<Contact, ?> columnPhoneNumber = grid.addColumn(Contact::getPhoneNumber);
		columnPhoneNumber.setId("Phonenumber");
		columnPhoneNumber.setCaption("Phonenumber");
		
		HeaderRow header = grid.prependHeaderRow();
		header.join(header.getCell("Name"), header.getCell("Phonenumber")).setText("My Contacts");
		
		
		MultiSelectionModel<Contact> selectionModel = (MultiSelectionModel<Contact>) grid.setSelectionMode(SelectionMode.MULTI);
		selectionModel.selectAll();
		
		delete = new Button("delete");
		
		

//		// add a new column to the grid with the function to delete the entire
//		// contact
//		// and therefore the entire column
//		Column<Contact, String> delete = grid.addColumn(contacts -> "delete",
//				new ButtonRenderer<Contact>(clickEvent -> {
//					for (ContactButtonClickListener listener : contactButtonClickListeners) {
//						deleteContactPopup = new PopupView(null, deleteContactPopupContent);
//						layout.addComponent(deleteContactPopup);
//						Contact toDelete = clickEvent.getItem();
//						listener.deleteButtonClick(deleteContactPopup, toDelete);
//					}
//				}));
//		delete.setId("delete");
		newContactPopup = new PopupView(null, newContactPopupContent);
		newContactButton = new Button("+ new Contact", click -> {
			newContactPopup.setPopupVisible(true);
		});
//		header.getCell("delete").setComponent(newContactPopup);
		
		deleteContactPopup = new PopupView(null, deleteContactPopupContent);
		layout.addComponents(grid, newContactPopup, newContactButton, deleteContactPopup);
		setCompositionRoot(layout);

	}

	public void initializeContacts(List<Contact> contacts) {
		grid.setItems(contacts);
	}

	public void initializeDeletePopup() {
		label = new Label("Are your sure to delete this contact?");
		deleteP = new Button("delete");
		cancel = new Button("cancel");
		cancel.addClickListener(clickEvent -> {
			for (ContactButtonClickListener listener : contactButtonClickListeners) {
				listener.cancelButtonClick();
			}
		});
		deleteContactPopupContent.addComponents(label, deleteP, cancel);
	}

	public void initNewContactPopup() {
		tfName = new TextField("Name:");
		tfName.setIcon(FontAwesome.USER);
		tfName.setRequiredIndicatorVisible(true);
		
		tfPhoneNumber = new TextField("Phonenumber:");
		tfPhoneNumber.setIcon(FontAwesome.PHONE);
		tfPhoneNumber.setRequiredIndicatorVisible(true);
		save = new Button("save");
		save.addClickListener(clickEvent -> {
			for (ContactButtonClickListener listener : contactButtonClickListeners) {
				String stringInput = getNameField().getValue();
				try {
					int integerInput = Integer.parseInt(getPhoneNUmberField().getValue());
					listener.saveButtonClick(stringInput, integerInput);
				} catch (NumberFormatException e) {
					Notification.show("Phonenumber must consist only of numbers", Notification.TYPE_WARNING_MESSAGE);
				}
			}
		});
		cancel = new Button("cancel");
		cancel.addClickListener(clickEvent -> {
			for (ContactButtonClickListener listener : contactButtonClickListeners) {
				listener.cancelButtonClick();
			}
		});
		newContactPopupContent.addComponents(tfName, tfPhoneNumber, save, cancel);
	}

	public void defaultSort() {
		grid.sort("Name", SortDirection.ASCENDING);
	}

	@Override
	public void addContactButtonClickListeneer(ContactButtonClickListener clickListener) {
		contactButtonClickListeners.add(clickListener);

	}

	public PopupView getContactPopup() {
		return this.newContactPopup;
	}

	public PopupView getDeleteContactPopup() {
		return this.deleteContactPopup;
	}

	public Button getSaveButton() {
		return this.save;
	}

	public TextField getNameField() {
		return this.tfName;
	}

	public TextField getPhoneNUmberField() {
		return this.tfPhoneNumber;
	}

	public Button getDeleteButton() {
		return this.deleteP;
	}

}
