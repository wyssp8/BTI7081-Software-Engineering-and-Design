package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.themes.ValoTheme;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.ButtonClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.interfaces.MainView;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.mainView.MainViewImpl;

public class LoginViewImpl extends CustomComponent implements ClickListener{
	
	private List<ButtonClickListener> listeners = new ArrayList<ButtonClickListener>();
	private Button button;
	private TextArea loginName;
	
	
	public LoginViewImpl() {
		
		VerticalLayout vLayout = new VerticalLayout();
		//TextArea
		loginName = new TextArea("Login");
		loginName.setWidth("50%");
		loginName.setValue("Username");

		
		
		//Button
		button = new Button("Login");
		button.addClickListener(this);
		
		
		//Add all components
		vLayout.addComponent(button);
		vLayout.addComponent(loginName);


		setCompositionRoot(vLayout);

	}

	
	
	
	
	public void addListener(ButtonClickListener clickListener) {
		listeners.add(clickListener);
	}


	public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {
		for(ButtonClickListener listener : listeners){
			listener.buttonClick();
		}
	}

}
