package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.interfaces;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.ButtonClickListener;

public interface MainView {
	public void setName(String name);
	public void addListener(ButtonClickListener clickListener);
}
