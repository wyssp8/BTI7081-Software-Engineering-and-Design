package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view;
import com.vaadin.ui.Accordion;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.Contact;

public class SettingsViewImpl extends CustomComponent {

	private static final long serialVersionUID = 1L;

	private VerticalLayout layout = new VerticalLayout();
	Accordion accordion = new Accordion();

	/**
	 * final TextField name = new TextField();
	 */

	private Label title = new Label("Settings");
	private TextField login = new TextField();
	private PasswordField password = new PasswordField();

	private Button btOkAcc = new Button("ok");
	private Button btCancAcc = new Button("cancel");
	private Button btEContSave = new Button("Save");

	private ComboBox<Contact> eContact1 = new ComboBox<>();
	private ComboBox<Contact> eContact2 = new ComboBox<>();
	private ComboBox<Contact> eContact3 = new ComboBox<>();

	public ComboBox<Contact> geteContact1() {
		return eContact1;
	}

	public void seteContact1(ComboBox<Contact> eContact1) {
		this.eContact1 = eContact1;
	}

	public ComboBox<Contact> geteContact2() {
		return eContact2;
	}

	public void seteContact2(ComboBox<Contact> eContact2) {
		this.eContact2 = eContact2;
	}

	public ComboBox<Contact> geteContact3() {
		return eContact3;
	}

	public void seteContact3(ComboBox<Contact> eContact3) {
		this.eContact3 = eContact3;
	}

	public Label getTitle() {
		return title;
	}

	public void setTitle(Label title) {
		this.title = title;
	}

	public TextField getLogin() {
		return login;
	}

	public void setLogin(TextField login) {
		this.login = login;
	}

	public PasswordField getPassword() {
		return password;
	}

	public void setPassword(PasswordField password) {
		this.password = password;
	}

	public SettingsViewImpl() {

		/**
		 * Create the first tab, specify caption when adding
		 */
		Layout tab1 = new VerticalLayout();
		Layout tab2 = new VerticalLayout();

		tab1.addComponents(login, password, btOkAcc, btCancAcc);
		tab2.addComponents(eContact1, eContact2, eContact3, btEContSave);

		accordion.addTab(tab1, "Change Account");
		accordion.addTab(tab2, "Change Emergency Contacts");

		
		/**
		 * Ok button to save new emergency contacts
		 */
		btEContSave.addClickListener(e -> {
			layout.addComponents(new Label("Contacts saved"));

		});

		setCompositionRoot(accordion);

	}

}
