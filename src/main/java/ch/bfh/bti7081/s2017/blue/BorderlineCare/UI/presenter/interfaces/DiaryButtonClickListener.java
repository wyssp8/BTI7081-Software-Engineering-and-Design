package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces;

import java.time.LocalDate;

public interface DiaryButtonClickListener {
	
	public void smileyGoodButtonClick();
	public void smileyMediumButtonClick();
	public void smileyBadButtonClick();
	public void addButtonClick(LocalDate dateInput, String radioInput, String titleInput, String diaryInput);
}
