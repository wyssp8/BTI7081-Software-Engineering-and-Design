package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter;

import java.util.ArrayList;
import java.util.List;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.Contact;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.DiaryEntry;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.DiaryViewModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.MainViewModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.ButtonClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.DiaryViewImpl;

public class DiaryViewPresenter implements ButtonClickListener {
	

	DiaryViewModel diaryViewModel;
	DiaryViewImpl diaryViewImpl;
	private List<DiaryEntry> diaryEntry;


	public DiaryViewPresenter(DiaryViewModel diaryViewModel, DiaryViewImpl diaryViewImpl){
		this.diaryViewModel = diaryViewModel;
		this.diaryViewImpl = diaryViewImpl;
		diaryViewImpl.addListener(this);
		diaryViewImpl.setName("Clear Textarea");
		diaryEntry = new ArrayList<>();
		diaryViewImpl.initializeDiaryEntry(diaryViewModel.getDiaryEntry());
	}

	@Override
	public void buttonClick() {
		diaryViewImpl.txtArea.clear();
		
	}
}
