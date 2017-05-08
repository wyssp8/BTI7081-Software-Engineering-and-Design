package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.interfaces;

import com.vaadin.server.Resource;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.ButtonClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.CallButtonClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.MessageButtonClickListener;

public interface EmergencyView {
	public void addCallButtonClickListener(CallButtonClickListener clickListener);
	public void addMessageButtonClickListener(MessageButtonClickListener clickListener);
}
