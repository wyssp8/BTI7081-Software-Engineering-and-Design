package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DiaryViewModel {
	
	private List<DiaryEntry> diaryEntry;
	private LocalDate date;
	
	public DiaryViewModel(){
		diaryEntry = new ArrayList<>();
		diaryEntry.add(new DiaryEntry(date.now(), "TestEntry"));
		
	}
	
	public List<DiaryEntry> getDiaryEntry(){
		return this.diaryEntry;
	}

}
