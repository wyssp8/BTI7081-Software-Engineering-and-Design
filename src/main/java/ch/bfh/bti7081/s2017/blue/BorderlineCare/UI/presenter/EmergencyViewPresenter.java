package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.Page;
import com.vaadin.server.Resource;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.EmergencyViewModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.ButtonClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.CallButtonClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.MessageButtonClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.mainView.EmergencyViewImpl;

public class EmergencyViewPresenter implements CallButtonClickListener,MessageButtonClickListener {

	private EmergencyViewModel emergencyViewModel;
	
	public EmergencyViewPresenter(EmergencyViewImpl emergencyViewImpl, EmergencyViewModel emergencyViewModel) {
		this.emergencyViewModel = emergencyViewModel;
		emergencyViewImpl.addCallButtonClickListener(this);
		emergencyViewImpl.addMessageButtonClickListener(this);
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
