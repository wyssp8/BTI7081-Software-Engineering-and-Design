package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.vaadin.ui.Button;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.DiaryViewImpl;
/**
 * 
 * @author Martin
 *
 */
public class DiaryViewModel {
	
	private List<DiaryEntry> diaryEntry;
	private DiaryViewImpl diaryViewImpl;
	
	public DiaryViewModel(){
		diaryEntry = new ArrayList<>();		
	}
	
	public List<DiaryEntry> getDiaryEntry(){
		return this.diaryEntry;
	}
	
	public DiaryEntry getLatestDiaryEntry(){
		return diaryEntry.get(diaryEntry.size()-1);
	}

	/**
	 * 
	 * 
	 * @param dateInput
	 * @param radioInput
	 * @param titleInput
	 * @param diaryInput
	 * @return
	 */
	public boolean validateDiaryEntry(String dateInput, String radioInput, String titleInput, String diaryInput) {
		if(dateInput.trim().equals("") || radioInput.trim().equals("") || titleInput.trim().equals("") || diaryInput.trim().equals("")){
			return false;
		}
		return true;
		
	}
}
