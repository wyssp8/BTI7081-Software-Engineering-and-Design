package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.vaadin.server.Page;
import com.vaadin.ui.PopupView;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.DB.DBConnector;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.Contact;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.DiaryEntry;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.DiaryViewModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.ButtonClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.DiaryButtonClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.DiaryViewImpl;

public class DiaryViewPresenter implements DiaryButtonClickListener {
	

	private DiaryViewModel diaryViewModel;
	private DiaryViewImpl diaryViewImpl;
	private List<DiaryEntry> diaryEntry;

	private DBConnector dbconnector;

	public DiaryViewPresenter(DiaryViewModel model, DiaryViewImpl view){
		this.diaryViewModel = model;
		this.diaryViewImpl = view;
		diaryEntry = diaryViewModel.getDiaryEntry();

		dbconnector = DBConnector.getDBConnector();
		diaryViewImpl.initializeDiaryEntry(diaryViewModel.getDiaryEntry());
		diaryViewImpl.addDiaryButtonClickListener(this);
		diaryViewImpl.initAddDiaryEntry();
}

	public List<DiaryEntry> getDiaryEntry() {
		return this.diaryEntry;
	}
	
	public void addButtonClick(String dateInput, String radioInput, String titleInput, String diaryInput) {
		
		dbconnector.getLoginAccount().getDiaryEntries().add(new DiaryEntry(dateInput, radioInput, titleInput, diaryInput, dbconnector.getLoginAccount()));
		diaryEntry.add(new DiaryEntry(dateInput, radioInput, titleInput, diaryInput, dbconnector.getLoginAccount()));
		dbconnector.writeDataToDB();
		diaryViewImpl.initializeDiaryEntry(diaryViewModel.getDiaryEntry()); //Inhalt wird ins Grid geschrieben
		
	}

	@Override
	public void deleteButtonClick(DiaryEntry toDelete) {
		
		diaryEntry.remove(toDelete);
		//dbconnector.writeDataToDB();
		diaryViewImpl.initializeDiaryEntry(diaryViewModel.getDiaryEntry());
	}
}
