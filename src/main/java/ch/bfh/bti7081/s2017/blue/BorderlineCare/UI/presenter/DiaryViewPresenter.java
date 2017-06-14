package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.vaadin.ui.Notification;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.Notification.Type;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.DB.DBConnector;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.Contact;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.DiaryEntry;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.DiaryViewModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.login.LoginAccount;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.DiaryButtonClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.DiaryViewImpl;

/**
 * 
 * This presenter handles clicking the Add and Delete Button in the View.
 * 
 * @author Kieliger
 *
 */

public class DiaryViewPresenter implements DiaryButtonClickListener {
	

	private DiaryViewModel diaryViewModel;
	private DiaryViewImpl diaryViewImpl;
	//private DiaryEntry diaryEntry;
	//private Set<DiaryEntry> diaryEntrySet;
	//private DBConnector dbconnector;

	public DiaryViewPresenter(DiaryViewModel model, DiaryViewImpl view){
		this.diaryViewModel = model;
		this.diaryViewImpl = view;
		//diaryEntrySet = DBConnector.getDBConnector().getLoginAccount().getDiaryEntries();

		initializeDiaryEntryGrid(); //Lädt die Einträge von der DB ins Grid
		diaryViewImpl.addDiaryButtonClickListener(this);
		
}

	public Set<DiaryEntry> getDiaryEntry() {
		return DBConnector.getDBConnector().getLoginAccount().getDiaryEntries();
	}
	
	@Override
	public void addButtonClick(String dateInput, String radioInput, String titleInput, String diaryInput) {
		if(diaryViewModel.validateDiaryEntry(dateInput, radioInput, titleInput, diaryInput)){
			
			/*diaryEntrySet.add(new DiaryEntry(dateInput, radioInput, titleInput, diaryInput, dbconnector.getLoginAccount()));
			logger.log(Level.INFO,"write data to DB");
			diaryViewImpl.initializeDiaryEntryGrid(this.diaryEntrySet); //Inhalt wird ins Grid geschrieben
			dbconnector.writeDataToDB();*/
			
			initializeDiaryEntryGrid();
			DiaryEntry diary = new DiaryEntry();
			diary.setDate(dateInput);
			diary.setStatus(radioInput);
			diary.setTitle(titleInput);
			diary.setDiaryEntry(diaryInput);
			diary.setLoginAccount(DBConnector.getDBConnector().getLoginAccount());
			
			DBConnector.getDBConnector().getLoginAccount().getDiaryEntries().add(diary);
			DBConnector.getDBConnector().writeDataToDB();
			initializeDiaryEntryGrid();
			

		}
		else {
			Notification.show("Please fill out all field", Type.WARNING_MESSAGE);
		}		
	}

	
	public void deleteButtonClick(Set<DiaryEntry> toDelete) {
		diaryViewImpl.getDeleteButton().addClickListener(clickEvent -> {
			deleteSelected(toDelete);
		});
	}
	
	@Override
	public void deleteDiaryEntry(DiaryEntry toRemove) {
		DBConnector.getDBConnector().getLoginAccount().getDiaryEntries().remove(toRemove);
	}
	

	public void deleteDiaryEntries(Set<DiaryEntry> diaryEntries) {
		DBConnector.getDBConnector().getLoginAccount().getDiaryEntries().removeAll(diaryEntries);
		for (DiaryEntry diaryEntry : diaryEntries) {
			DBConnector.getDBConnector().deleteDiaryEntryFromDB(diaryEntry);
		}
	}
	
	@Override
	public void deleteSelected(Set<DiaryEntry> toDelete) {
		
		Set<DiaryEntry> tmp = new HashSet<>();
		for (DiaryEntry diaryEntry : toDelete) {
			for (DiaryEntry c : DBConnector.getDBConnector().getLoginAccount().getDiaryEntries()) {
				if (diaryEntry.getId() == c.getId()) {
					tmp.add(c);
				}
			}
		}

		deleteDiaryEntries(tmp);
		DBConnector.getDBConnector().writeDataToDB();	
		initializeDiaryEntryGrid();
	}
	
	@SuppressWarnings("unchecked")
	public void initializeDiaryEntryGrid() {
		diaryViewImpl.getGrid().setItems(DBConnector.getDBConnector().getLoginAccount().getDiaryEntries());
	}
}
