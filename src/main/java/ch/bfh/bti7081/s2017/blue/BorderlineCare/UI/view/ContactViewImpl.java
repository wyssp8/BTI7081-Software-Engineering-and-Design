package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.renderers.ButtonRenderer;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.Contact;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.ButtonClickListener;

public class ContactViewImpl extends CustomComponent{
	
	private Grid<Contact> grid;
	private List<Contact> contacts;
	private List<ButtonClickListener> buttonClickListeners = new ArrayList<>();
	private Button button;
	
	public ContactViewImpl(){
		grid = new Grid<>();
		grid.addColumn(Contact::getName).setCaption("Name");
		grid.addColumn(Contact::getPhoneNumber).setCaption("Phonenumber");
		
		Label label = new Label ("click Button to change text");
		
		button = new Button("new Contact");
		button.addClickListener( new ClickListener(){

			@Override
			public void buttonClick(ClickEvent event) {
				button.setCaption("you clicked me");
			}		
	});
		
		grid.addColumn(contacts -> "delete", 
				new ButtonRenderer(clickEvent -> {
					contacts.remove(clickEvent.getItem());
					grid.setItems(contacts);
				}));
		
		
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
