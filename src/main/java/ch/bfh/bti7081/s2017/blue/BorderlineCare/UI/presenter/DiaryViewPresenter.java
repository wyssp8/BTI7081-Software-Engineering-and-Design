package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter;


import java.util.Iterator;
import java.util.Set;

import com.vaadin.ui.Notification;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.DB.DBConnector;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.Contact;
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
	private Set<DiaryEntry> diaryEntry;
	private DBConnector dbconnector;

	public DiaryViewPresenter(DiaryViewModel model, DiaryViewImpl view){
		this.diaryViewModel = model;
		this.diaryViewImpl = view;
		dbconnector = DBConnector.getDBConnector();
		diaryEntry = dbconnector.getLoginAccount().getDiaryEntries();

		diaryViewImpl.initializeDiaryEntryGrid(diaryEntry); //Lädt die Einträge von der DB ins Grid
		diaryViewImpl.addDiaryButtonClickListener(this);
		
}

	public Set<DiaryEntry> getDiaryEntry() {
		return this.diaryEntry;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void addButtonClick(String dateInput, String radioInput, String titleInput, String diaryInput) {
		if(diaryViewModel.validateDiaryEntry(dateInput, radioInput, titleInput, diaryInput)){
			diaryEntry.add(new DiaryEntry(dateInput, radioInput, titleInput, diaryInput, dbconnector.getLoginAccount()));
			dbconnector.writeDataToDB();
			diaryViewImpl.initializeDiaryEntryGrid(this.diaryEntry); //Inhalt wird ins Grid geschrieben
		}
		else {
			Notification.show("Please fill out all field", Notification.TYPE_WARNING_MESSAGE);
		}		
	}

	
	
	@Override
	public void deleteDiaryEntry(DiaryEntry toRemove) {
		this.diaryEntry.remove(toRemove);
	}
	
	@Override
	public void deleteSelected(Set<DiaryEntry> diaryEntry) {
		Iterator<DiaryEntry> iterator = diaryEntry.iterator();
		while (iterator.hasNext()) {
			DiaryEntry c = iterator.next();
			if (this.diaryEntry.contains(c)) {
				deleteDiaryEntry(c);
			}
		}
		
		diaryViewImpl.getDeleteButton().addClickListener(clickEvent -> {
			deleteSelected(diaryEntry);		
		});
		//dbconnector.writeDataToDB();
		//diaryViewImpl.initializeDiaryEntry(this.diaryEntry);
	}
}
