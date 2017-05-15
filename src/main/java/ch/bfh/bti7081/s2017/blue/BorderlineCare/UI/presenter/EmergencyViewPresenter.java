package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter;

import com.vaadin.server.Page;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.EmergencyViewModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.EmergencyButtonClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.mainView.EmergencyViewImpl;
/**
 * 
 * This presenter handles clicking the Call and Message Button in the view.
 * 
 *  @author frutiger
 *
 */
public class EmergencyViewPresenter implements EmergencyButtonClickListener {

	private EmergencyViewModel emergencyViewModel;
	
	public EmergencyViewPresenter(EmergencyViewImpl emergencyViewImpl, EmergencyViewModel emergencyViewModel) {
		this.emergencyViewModel = emergencyViewModel;
		emergencyViewImpl.addEmergencyButtonClickListener(this);
	}

	@Override
	public void messageButtonClick() {
		String destination = emergencyViewModel.getMessageLink();
		Page.getCurrent().open(destination,null);
	}

	@Override
	public void callButtonClick() {
		String destination = emergencyViewModel.getCallLink();
		Page.getCurrent().open(destination,null);
	}


}
