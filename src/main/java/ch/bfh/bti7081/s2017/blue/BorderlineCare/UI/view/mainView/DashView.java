package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.mainView;

import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

/**
 * 
 * Abstract Class defines the look of a DashView
 * 
 * @author frutiger
 *
 */
public abstract class DashView extends CustomComponent {

	private static final long serialVersionUID = -5210050279071716429L;
	protected VerticalLayout verticalLayout;
	protected Panel panel;
	
	public DashView(){
		verticalLayout = new VerticalLayout();
		panel = new Panel();
		verticalLayout.addComponent(panel);
	}
	
	public void setPanelTitle(String panelTitle){
		panel.setCaption(panelTitle);
	}

}
