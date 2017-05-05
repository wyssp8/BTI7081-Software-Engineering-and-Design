package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.ButtonClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.interfaces.EmergencyView;

public class EmergencyViewImpl extends CustomComponent implements ClickListener, EmergencyView {

	private List<ButtonClickListener> listeners = new ArrayList<ButtonClickListener>();
	
	private Button button;
	
	public EmergencyViewImpl(){
		VerticalLayout layout = new VerticalLayout();
        button = new Button("test");
        layout.addComponent(button);
        button.addClickListener(this);
        setCompositionRoot(layout);
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
