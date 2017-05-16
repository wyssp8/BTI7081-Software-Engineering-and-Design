package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.vaadin.ui.Button;

public class DiaryViewModel {
	
	private List<DiaryEntry> diaryEntry;
	private Button buttonSatus;
	
	public DiaryViewModel(){
		diaryEntry = new ArrayList<>();
		buttonSatus = new Button("Test");
		diaryEntry.add(new DiaryEntry(LocalDate.now(), buttonSatus, "Test Title", "TestEntry"));
		
	}
	
	public List<DiaryEntry> getDiaryEntry(){
		return this.diaryEntry;
	}

}
