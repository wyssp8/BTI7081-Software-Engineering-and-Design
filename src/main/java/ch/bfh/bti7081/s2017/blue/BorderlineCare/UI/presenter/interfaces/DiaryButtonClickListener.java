package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces;

import java.util.Set;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.DiaryEntry;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.login.LoginAccount;

public interface DiaryButtonClickListener {
	
	public void addButtonClick(String dateInput, String radioInput, String titleInput, String diaryInput);
	public void deleteDiaryEntry(DiaryEntry toDelete);
	public void deleteSelected(Set<DiaryEntry> diaryEntry);
}
