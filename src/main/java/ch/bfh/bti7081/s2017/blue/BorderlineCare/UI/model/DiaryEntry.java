package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model;

import java.time.LocalDate;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.DiaryViewImpl;

public class DiaryEntry {
	
	private LocalDate date;
	private String diaryEntry;
	private DiaryViewImpl diaryViewImpl;
	private LocalDate localDate;
	
	
	
	
	public DiaryEntry(LocalDate date, String diaryEntry){
		this.date = date;
		this.diaryEntry = diaryEntry;		
	}
	


	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getDiaryEntry() {
		return diaryEntry;
	}

	public void setDiaryEntry(String diaryEntry) {
		this.diaryEntry = diaryEntry;
	}
}
