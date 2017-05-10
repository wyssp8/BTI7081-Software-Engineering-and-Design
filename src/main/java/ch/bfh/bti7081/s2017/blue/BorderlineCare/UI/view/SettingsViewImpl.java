package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view;

import com.vaadin.ui.Accordion;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;


// Stilll Missing: implement save contatcts and password function 

public class SettingsViewImpl extends CustomComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private VerticalLayout layout = new VerticalLayout();
	Accordion accordion = new Accordion();

	// final TextField name = new TextField();
	public Label title = new Label("Settings");
	public TextField login = new TextField();
	public PasswordField password = new PasswordField();

	public TextField contact1 = new TextField("Emergency Contact 1");
	public TextField contact2 = new TextField("Emergency Contact 2");
	public TextField contact3 = new TextField("Emergency Contact 3");

//	private Button btAccChang = new Button("Change Account");
	private Button btOkAcc = new Button("ok");
	private Button btCancAcc = new Button("cancel");
//	private Button btECont = new Button("Emergency Contacts");
	private Button btEContSave = new Button("Save");
	private Button bteContCanc = new Button("cancel");

	public SettingsViewImpl() {

		// Create the first tab, specify caption when adding
		Layout tab1 = new VerticalLayout();
		Layout tab2 = new VerticalLayout();

		tab1.addComponents(login, password, btOkAcc, btCancAcc);
		tab2.addComponents(contact1, contact2, contact3, btEContSave, bteContCanc);

		accordion.addTab(tab1, "Change Account");
		accordion.addTab(tab2, "Change Emergency Contacts");

//		btAccChang.addClickListener(e -> {
//			layout.addComponents(login, password, btOkAcc, btCancAcc);
//		});

		// ok account change
		btOkAcc.addClickListener(f -> {
			layout.addComponents(new Label("will login with another account"));
		});

		// cancel account change
		btCancAcc.addClickListener(g -> {
			layout.removeComponent(password);
			layout.removeComponent(login);
			layout.removeComponent(btOkAcc);
			layout.removeComponent(btCancAcc);
		});

//		// add emergency contacts
//		btECont.addClickListener(g -> {
//			layout.addComponents(contact1, contact2, contact3, btEContSave, bteContCanc);
//		});

		// Ok button to save new emergency contacts
		btEContSave.addClickListener(e -> {
			layout.addComponents(new Label("Contacts saved"));

		});

		// Cancel Button for the emergency contacts
		bteContCanc.addClickListener(e -> {
			layout.removeComponent(contact1);
			layout.removeComponent(contact2);
			layout.removeComponent(contact3);
			layout.removeComponent(btEContSave);
			layout.removeComponent(bteContCanc);

		});

		// layout.addComponents(title, btAccChang, btECont);
		setCompositionRoot(accordion);

	}

}
