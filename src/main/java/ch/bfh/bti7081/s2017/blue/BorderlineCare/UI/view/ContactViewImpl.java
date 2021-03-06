package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.data.sort.SortDirection;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.Column;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.components.grid.HeaderRow;
import com.vaadin.ui.components.grid.MultiSelectionModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.Contact;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.ContactButtonClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.interfaces.ContactView;

/*
 * 
 * @author ludes2
 * 
 */
@SuppressWarnings("deprecation")
public class ContactViewImpl extends CustomComponent implements ContactView {

	private static final long serialVersionUID = -1924986860210433106L;
	private Grid<Contact> grid;
	private List<ContactButtonClickListener> contactButtonClickListeners = new ArrayList<>();
	private PopupView newContactPopup;
	private PopupView deleteContactPopup;
	private VerticalLayout newContactPopupContent = new VerticalLayout();
	private VerticalLayout deleteContactPopupContent = new VerticalLayout();
	private VerticalLayout layout = new VerticalLayout();
	private HorizontalLayout buttonLayout = new HorizontalLayout();
	private Button deleteP; 
	private Button save;
	private Button cancel;
	private Button deleteSelected;
	private Button newContactButton;
	private Label label;
	private TextField tfName;
	private TextField tfPhoneNumber; 

	public ContactViewImpl() {
		grid = new Grid<>();
		Column<Contact, ?> columnName = grid.addColumn(Contact::getName);
		columnName.setId("Name");
		columnName.setCaption("Name");
		Column<Contact, ?> columnPhoneNumber = grid.addColumn(Contact::getPhoneNumber);
		columnPhoneNumber.setId("Phonenumber");
		columnPhoneNumber.setCaption("Phonenumber");

		HeaderRow header = grid.prependHeaderRow();
		header.join(header.getCell("Name"), header.getCell("Phonenumber")).setText("My Contacts");
		deleteSelected = new Button("deleteSelected");

		MultiSelectionModel<Contact> selectionModel = (MultiSelectionModel<Contact>) grid
				.setSelectionMode(SelectionMode.MULTI);
		selectionModel.selectAll();

		selectionModel.addMultiSelectionListener(event -> {
			Set<Contact> toDelete = new HashSet<>();
			for (Contact itemId : grid.getSelectedItems()) {
				toDelete.add(itemId);		
			}
			deleteSelected.addClickListener(clieckEvent -> {
				for (ContactButtonClickListener listener : contactButtonClickListeners) {
					deleteContactPopup = new PopupView(null, deleteContactPopupContent);
					layout.addComponent(deleteContactPopup);
					deleteContactPopupContent.setParent(null);
					listener.deleteButtonClick(deleteContactPopup, toDelete);
				}
			});
		});

		newContactPopup = new PopupView(null, newContactPopupContent);
		newContactButton = new Button("new Contact", click -> {
			newContactPopup.setPopupVisible(true);
		});
		
		buttonLayout.addComponents(newContactButton, deleteSelected);
		layout.addComponents(grid, newContactPopup, buttonLayout);
		setCompositionRoot(layout);
	}


	public void initializeDeletePopup() {
		label = new Label("Are your sure that you want to delete these contacts?");
		deleteP = new Button("delete");
		cancel = new Button("cancel");
		cancel.addClickListener(clickEvent -> {
			for (ContactButtonClickListener listener : contactButtonClickListeners) {
				listener.cancelButtonClick();
			}
		});
		deleteContactPopupContent.addComponents(label, deleteP, cancel);
	}

	@SuppressWarnings("deprecation")
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
				String nameInput = getNameField().getValue();
				try {
					String numberInput = getPhoneNUmberField().getValue();
					listener.saveButtonClick(nameInput, numberInput);
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
	public Button getDeleteSelected(){
		return this.deleteSelected;
	}
	
	public VerticalLayout getDeletePopupContent(){
		return this.deleteContactPopupContent;
	}
	public Grid getGrid(){
		return this.grid;
	}

}
