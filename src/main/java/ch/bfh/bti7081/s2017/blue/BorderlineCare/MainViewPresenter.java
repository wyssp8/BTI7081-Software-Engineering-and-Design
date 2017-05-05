package ch.bfh.bti7081.s2017.blue.BorderlineCare;

import com.vaadin.external.org.slf4j.Logger;

public class MainViewPresenter implements ButtonClickListener {

		// TODO Auto-generated method stub
	MainViewModel model;
	MainViewImpl impl;
	
	
	public MainViewPresenter(MainViewModel model, MainViewImpl view){
		this.model = model;
		this.impl = view;
		view.addListener(this);
		view.setName("Presenter");
	}

	@Override
	public void buttonClick() {
		impl.setName("Yay");
	}
}
