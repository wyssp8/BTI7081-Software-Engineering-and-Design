package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model;

import java.time.LocalDate;

import com.vaadin.ui.Button;

public class DiaryEntry {
	
	private LocalDate date;
	private Button diaryStatus;
	private String diaryTitle;
	private String diaryEntry;
	
	
	public DiaryEntry(LocalDate date, Button diaryStatus, String diaryTitle, String diaryEntry){
		this.date = date;
		this.diaryStatus = diaryStatus;
		this.diaryTitle = diaryTitle;
		this.diaryEntry = diaryEntry;		
	}
	

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public Button getStatus() {
		return diaryStatus;
	}
	
	public void setStatus(Button diaryStatus) {
		this.diaryStatus = diaryStatus;
	}
	
	public String getTitle() {
		return diaryTitle;
	}
	
	public void setTitle(String diaryTitle) {
		this.diaryTitle = diaryTitle;
	}

	public String getDiaryEntry() {
		return diaryEntry;
	}

	public void setDiaryEntry(String diaryEntry) {
		this.diaryEntry = diaryEntry;
	}
	
}
