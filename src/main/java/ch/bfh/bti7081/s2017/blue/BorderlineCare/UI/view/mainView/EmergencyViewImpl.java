package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.mainView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.FileResource;
import com.vaadin.server.Resource;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.ButtonClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.interfaces.EmergencyView;

public class EmergencyViewImpl extends CustomComponent implements EmergencyView,ClickListener {

	private Button image;
	List<ButtonClickListener> listeners = new ArrayList<ButtonClickListener>();

	public EmergencyViewImpl(){
		VerticalLayout layout = new VerticalLayout();
		String basepath = VaadinService.getCurrent()
        .getBaseDirectory().getAbsolutePath();

		//Image as a file resource
		FileResource resource = new FileResource(new File(basepath +
              "/WEB-INF/images/phone-receiver-medium.png"));
		//Show the image in the application
		image = new Button("");
		image.addStyleName(ValoTheme.BUTTON_LINK);
		image.setIcon(resource);
		image.addClickListener(this);
        layout.addComponent(image);
        setCompositionRoot(layout);
	}

	@Override
	public void addButtonClickListener(ButtonClickListener clickListener) {
		listeners.add(clickListener);
	}

	@Override
	public void buttonClick(ClickEvent event) {
		for(ButtonClickListener listener : listeners){
			listener.buttonClick();
		}
	}

}
