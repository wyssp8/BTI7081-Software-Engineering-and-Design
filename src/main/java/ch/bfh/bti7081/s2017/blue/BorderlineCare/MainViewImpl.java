package ch.bfh.bti7081.s2017.blue.BorderlineCare;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

public class MainViewImpl extends CustomComponent implements MainView, ClickListener{
	
	private String name;
	private List<ButtonClickListener> listeners = new ArrayList<ButtonClickListener>();
	
	private Button button;
	private EmergencyViewImpl emergencyViewImpl;
	
	public MainViewImpl(){
		VerticalLayout layout = new VerticalLayout();
        button = new Button("test");
        layout.addComponent(button);
        button.addClickListener(this);
        emergencyViewImpl = new EmergencyViewImpl();
        layout.addComponent(emergencyViewImpl);
        setCompositionRoot(layout);
	}

	@Override
	public void setName(String name) {
		button.setCaption(name);
	}

	@Override
	public void addListener(ButtonClickListener clickListener) {
		listeners.add(clickListener);
	}


	@Override
	public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {
		for(ButtonClickListener listener : listeners){
			listener.buttonClick();
		}
	}
	
}
