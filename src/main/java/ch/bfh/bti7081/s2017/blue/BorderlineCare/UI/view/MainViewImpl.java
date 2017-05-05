package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.ButtonClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.interfaces.EmergencyView;

import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

public class MainViewImpl extends CustomComponent {
	

	private String name;
	
	private EmergencyViewImpl emergencyViewImpl;
	
	public MainViewImpl(EmergencyViewImpl emergencyViewImpl){
		VerticalLayout layout = new VerticalLayout();
		this.emergencyViewImpl = emergencyViewImpl;
        layout.addComponent(emergencyViewImpl);
        setCompositionRoot(layout);
	}
	
}
