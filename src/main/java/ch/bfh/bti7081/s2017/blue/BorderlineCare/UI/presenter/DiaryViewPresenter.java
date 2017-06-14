package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter;

import java.util.HashSet;
import java.util.Set;

import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.DB.DBConnector;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.DiaryEntry;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.DiaryViewModel;
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

	public DiaryViewPresenter(DiaryViewModel model, DiaryViewImpl view){
		this.diaryViewModel = model;
		this.diaryViewImpl = view;
		initializeDiaryEntryGrid(); //Load the diary entries from the database
		diaryViewImpl.addDiaryButtonClickListener(this);
}
	
	/**
	 * Add Diary Entry with the user input
	 */
	@Override
	public void addButtonClick(String dateInput, String radioInput, String titleInput, String diaryInput) {
		if(diaryViewModel.validateDiaryEntry(dateInput, radioInput, titleInput, diaryInput)){
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
			Notification.show("Please fill out all fields", Type.WARNING_MESSAGE);
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
	
	/**
	 * Delete selected row in Grid
	 */
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
	
	
	/**
	 * Fills the Grid with the Diary Entries from the database
	 */
	@SuppressWarnings("unchecked")
	public void initializeDiaryEntryGrid() {
		diaryViewImpl.getGrid().setItems(DBConnector.getDBConnector().getLoginAccount().getDiaryEntries());
	}
}
