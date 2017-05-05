package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter;

import com.vaadin.external.org.slf4j.Logger;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.MainViewModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.ButtonClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.mainView.MainViewImpl;

public class MainViewPresenter {

	MainViewModel model;
	MainViewImpl impl;
	
	
	public MainViewPresenter(MainViewModel model, MainViewImpl view){
		this.model = model;
		this.impl = view;
	}



}
