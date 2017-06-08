package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model;

import java.util.ArrayList;
import java.util.List;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.DB.DBConnector;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.login.LoginAccount;

/**
 * 
 * This Class provides methods to the diary view.
 * 
 * @author Kieliger
 *
 */
public class DiaryViewModel {
	
	private List<DiaryEntry> diaryEntry;
	
	
	
	public DiaryViewModel(){
		diaryEntry = new ArrayList<>();
		
		DBConnector dbConnector = DBConnector.getDBConnector();
		LoginAccount loginAccount = dbConnector.getLoginAccount();
		
		for (DiaryEntry diaryEntries : loginAccount.getDiaryEntries()) {
			diaryEntry.add(diaryEntries);
		}
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
		if(dateInput.trim().equals("") || radioInput == null || titleInput.trim().equals("") || diaryInput.trim().equals("")){
			return false;
		}
		return true;
	}
}
