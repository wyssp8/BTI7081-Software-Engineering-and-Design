package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.vaadin.ui.Button;

public class DiaryViewModel {
	
	private List<DiaryEntry> diaryEntry;
	
	public DiaryViewModel(){
		diaryEntry = new ArrayList<>();
		diaryEntry.add(new DiaryEntry(LocalDate.now(), "Good", "Test Title", "TestEintrag"));
		
	}
	
	public List<DiaryEntry> getDiaryEntry(){
		return this.diaryEntry;
	}

}
