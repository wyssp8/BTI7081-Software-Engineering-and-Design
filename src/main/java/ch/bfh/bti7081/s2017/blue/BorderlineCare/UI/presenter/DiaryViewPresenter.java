package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.vaadin.server.Page;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.DiaryEntry;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.DiaryViewModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.ButtonClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.DiaryButtonClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.DiaryViewImpl;

public class DiaryViewPresenter implements DiaryButtonClickListener {
	

	private DiaryViewModel diaryViewModel;
	private DiaryViewImpl diaryViewImpl;



	public DiaryViewPresenter(DiaryViewModel diaryViewModel, DiaryViewImpl diaryViewImpl){
		this.diaryViewModel = diaryViewModel;
		this.diaryViewImpl = diaryViewImpl;

		diaryViewImpl.initializeDiaryEntry(diaryViewModel.getDiaryEntry());
		diaryViewImpl.addDiaryButtonClickListener(this);

}

	
	public void addButtonClick() {
		
		diaryViewImpl.initializeDiaryEntry(diaryViewModel.getDiaryEntry()); //Inhalt wird ins Grid geschrieben
		diaryViewModel.setDiaryEntry();
		
	}


	@Override
	public void smileyGoodButtonClick() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void smileyMediumButtonClick() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void smileyBadButtonClick() {
		// TODO Auto-generated method stub
		
	}
}
