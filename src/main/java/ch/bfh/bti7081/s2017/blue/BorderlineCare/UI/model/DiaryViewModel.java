package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.vaadin.ui.Button;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.DiaryViewImpl;

public class DiaryViewModel {
	
	private List<DiaryEntry> diaryEntry;
	private DiaryViewImpl diaryViewImpl;
	
	public DiaryViewModel(){
		diaryEntry = new ArrayList<>();
		diaryEntry.add(new DiaryEntry(LocalDate.now(), "Good", "Test Title1", "TestEintrag1"));
		diaryEntry.add(new DiaryEntry(LocalDate.now(), "Medium", "Test Title2", "TestEintrag2"));
		diaryEntry.add(new DiaryEntry(LocalDate.now(), "Bad", "Test Title3", "TestEintrag3"));
		
	}
	
	public List<DiaryEntry> getDiaryEntry(){
		return this.diaryEntry;
	}
	
	public DiaryEntry getLatestDiaryEntry(){
		return diaryEntry.get(diaryEntry.size()-1);
	}
}
