package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.Page;
import com.vaadin.server.Resource;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.EmergencyViewModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.ButtonClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.mainView.EmergencyViewImpl;

public class EmergencyViewPresenter implements ButtonClickListener {

	private EmergencyViewModel emergencyViewModel;
	
	public EmergencyViewPresenter(EmergencyViewImpl emergencyViewImpl, EmergencyViewModel emergencyViewModel) {
		this.emergencyViewModel = emergencyViewModel;
		emergencyViewImpl.addButtonClickListener(this);
	}

	@Override
	public void buttonClick() {
		String destination = emergencyViewModel.getDestinationLink();
		Page.getCurrent().open(destination,null);
	}


}
