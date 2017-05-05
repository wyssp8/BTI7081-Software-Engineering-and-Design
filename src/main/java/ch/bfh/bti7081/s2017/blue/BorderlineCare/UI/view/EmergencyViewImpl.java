package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view;

import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class EmergencyViewImpl extends CustomComponent {

	public EmergencyViewImpl(){
		VerticalLayout layout = new VerticalLayout();
        Label label = new Label("Hallo");
        layout.addComponent(label);
        setCompositionRoot(layout);
	}
}
