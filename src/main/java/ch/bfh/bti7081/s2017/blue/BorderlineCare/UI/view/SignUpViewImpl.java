package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.VerticalLayout;

public class SignUpViewImpl extends CustomComponent implements View {
	public static final String NAME = "SignUpView";
	
	public void SignUpViewImpl(){
		VerticalLayout vLayout = new VerticalLayout();
		vLayout.setSizeFull();
		setCompositionRoot(vLayout);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
}
