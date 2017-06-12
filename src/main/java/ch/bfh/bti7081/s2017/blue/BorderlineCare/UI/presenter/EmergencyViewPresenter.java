package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter;

import com.vaadin.server.Page;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.ContactModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.EmergencyViewModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.SettingsViewModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.EmergencyButtonClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.mainView.EmergencyViewImpl;

/**
 * 
 * This presenter handles clicking the Call and Message Button in the view.
 * 
 * @author frutiger
 *
 */
public class EmergencyViewPresenter implements EmergencyButtonClickListener {

	private SettingsViewModel settingsViewModel;

	public EmergencyViewPresenter(EmergencyViewImpl emergencyViewImpl, SettingsViewModel settingsViewModel) {
		this.settingsViewModel = settingsViewModel;
		emergencyViewImpl.addEmergencyButtonClickListener(this);
	}

	@Override
	public void messageButtonClick() {
		String destination;
		try {
			destination = settingsViewModel.getMessageLink();
			Page.getCurrent().open(destination, null);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Override
	public void callButtonClick() {
		String destination;
		try {
			destination = settingsViewModel.getCallLink();
			Page.getCurrent().open(destination, null);
		} catch (Exception e) {
			e.getMessage();
		}

	}

}
