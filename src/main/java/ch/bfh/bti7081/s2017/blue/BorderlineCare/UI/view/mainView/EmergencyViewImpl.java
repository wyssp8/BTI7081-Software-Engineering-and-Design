package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.mainView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.vaadin.annotations.Theme;
import com.vaadin.event.ContextClickEvent;
import com.vaadin.event.ContextClickEvent.ContextClickListener;
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
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.EmergencyButtonClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.interfaces.EmergencyView;

/**
 * 
 * This view displays two buttons, one for doing a emergency call and another
 * one to write a emergency message.
 * 
 * @author frutiger
 *
 */
public class EmergencyViewImpl extends CustomComponent implements EmergencyView {

	private List<EmergencyButtonClickListener> emergencyButtonListeners = new ArrayList<EmergencyButtonClickListener>();
	private Button emergencyCallButton;
	private Button emergencyMessageButton;

	public EmergencyViewImpl() {
		VerticalLayout layout = new VerticalLayout();

		String basepath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();

		FileResource phoneImage = new FileResource(new File(basepath + "/WEB-INF/images/phone-receiver-medium.png"));
		emergencyCallButton = new Button("Emergency call");
		emergencyCallButton.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		emergencyCallButton.addStyleName(ValoTheme.BUTTON_ICON_ALIGN_TOP);
		emergencyCallButton.setIcon(phoneImage);
		emergencyCallButton.addClickListener(e -> {
			for (EmergencyButtonClickListener listener : emergencyButtonListeners) {
				listener.callButtonClick();
			}
		});
		emergencyCallButton.setHeight("200px");
		emergencyCallButton.setWidth("400px");
		layout.addComponent(emergencyCallButton);

		FileResource messageImage = new FileResource(
				new File(basepath + "/WEB-INF/images/chat-bubbles-with-ellipsis.png"));
		emergencyMessageButton = new Button("Emergency message");
		emergencyMessageButton.addStyleName(ValoTheme.BUTTON_BORDERLESS);
		emergencyMessageButton.addStyleName(ValoTheme.BUTTON_ICON_ALIGN_TOP);
		emergencyMessageButton.setIcon(messageImage);
		emergencyMessageButton.addClickListener(e -> {
			for (EmergencyButtonClickListener listener : emergencyButtonListeners) {
				listener.messageButtonClick();
			}
		});
		emergencyMessageButton.setHeight("200px");
		emergencyMessageButton.setWidth("400px");
		layout.addComponent(emergencyMessageButton);

		setCompositionRoot(layout);
	}

	@Override
	public void addEmergencyButtonClickListener(EmergencyButtonClickListener clickListener) {
		emergencyButtonListeners.add(clickListener);
	}

}
