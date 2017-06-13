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
	
	private List<DiaryEntry> diaryEntries;
	
	public DiaryViewModel(){
		diaryEntries = new ArrayList<>();
		
		DBConnector dbConnector = DBConnector.getDBConnector();
		LoginAccount loginAccount = dbConnector.getLoginAccount();
		
		for (DiaryEntry diaryEntry : loginAccount.getDiaryEntries()) {
			diaryEntries.add(diaryEntry);
		}
	}
	
	public List<DiaryEntry> getDiaryEntries(){
		return this.diaryEntries;
	}
	
	/**
	 * Get the newest diary Entry
	 * @return
	 * @throws Exception No diary Entry available
	 */
	public DiaryEntry getLatestDiaryEntry() throws Exception{
		if(diaryEntries.isEmpty()){
			throw new Exception("No diary entry");
		}
		return diaryEntries.get(diaryEntries.size()-1);
	}

	/**
	 * Validate Diary entry input
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
