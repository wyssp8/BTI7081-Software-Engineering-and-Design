package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.DiaryViewModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.MainViewModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.ButtonClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.DiaryViewImpl;

public class DiaryViewPresenter implements ButtonClickListener {
	
	
	// TODO Auto-generated method stub
	DiaryViewModel diaryViewModel;
	DiaryViewImpl diaryViewImpl;


	public DiaryViewPresenter(DiaryViewModel diaryViewModel, DiaryViewImpl diaryViewImpl){
		this.diaryViewModel = diaryViewModel;
		this.diaryViewImpl = diaryViewImpl;
		diaryViewImpl.addListener(this);
		diaryViewImpl.setName("Clear Textarea");
	}

	@Override
	public void buttonClick() {
		diaryViewImpl.txtArea.clear();
		
	}
}
