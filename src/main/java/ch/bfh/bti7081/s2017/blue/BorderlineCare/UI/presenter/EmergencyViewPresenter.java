package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.EmergencyViewModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.ButtonClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.EmergencyViewImpl;

public class EmergencyViewPresenter implements ButtonClickListener {

	public EmergencyViewPresenter(EmergencyViewImpl emergencyViewImpl, EmergencyViewModel emergencyViewModel) {
		emergencyViewImpl.addListener(this);
	}

	@Override
	public void buttonClick() {
		
	}

}
