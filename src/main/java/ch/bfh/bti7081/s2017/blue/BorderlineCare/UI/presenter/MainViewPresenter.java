package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.MainViewModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.mainView.MainViewImpl;

public class MainViewPresenter {

	private MainViewModel mainViewModel;
	private MainViewImpl mainViewImpl;
	
	
	public MainViewPresenter(MainViewImpl view){
    	this.mainViewModel = new MainViewModel();
		this.mainViewImpl = view;
	}



}
