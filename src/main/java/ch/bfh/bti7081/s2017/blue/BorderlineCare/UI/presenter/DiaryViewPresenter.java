package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter;

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
	private List<DiaryEntry> diaryEntry;


	public DiaryViewPresenter(DiaryViewModel diaryViewModel, DiaryViewImpl diaryViewImpl){
		this.diaryViewModel = diaryViewModel;
		this.diaryViewImpl = diaryViewImpl;

		diaryEntry = new ArrayList<>();
		diaryViewImpl.initializeDiaryEntry(diaryViewModel.getDiaryEntry());
		diaryViewImpl.addDiaryButtonClickListener(this);
}

	@Override
	public void smileyGoodButtonClick() {
		diaryViewImpl.getTextArea().clear();
	}

	@Override
	public void smileyMediumButtonClick() {
		diaryViewImpl.getTextArea().clear();
	}
	
	@Override
	public void smileyBadButtonClick() {
		diaryViewImpl.getTextArea().clear();
	}

}
