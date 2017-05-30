package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces;

import java.time.LocalDate;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.Contact;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.DiaryEntry;

public interface DiaryButtonClickListener {
	
	public void addButtonClick(LocalDate dateInput, String radioInput, String titleInput, String diaryInput);
	public void deleteButtonClick(DiaryEntry toDelete);

}
