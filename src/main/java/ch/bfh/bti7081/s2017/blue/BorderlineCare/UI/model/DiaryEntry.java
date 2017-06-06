package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.login.LoginAccount;

@Entity
public class DiaryEntry {

	@Id
	@GeneratedValue
	private int id;

	private LocalDate date;
	private String diaryStatus;
	private String diaryTitle;
	private String diaryEntry;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="LOGINACCOUNT_EMAIL")
	private LoginAccount loginAccount;

	public DiaryEntry() {
	}

	public DiaryEntry(LocalDate date, String diaryStatus, String diaryTitle, String diaryEntry) {
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

	public String getStatus() {
		return diaryStatus;
	}

	public void setStatus(String diaryStatus) {
		this.diaryStatus = diaryStatus;
	}

	public String getTitle() {
		return diaryTitle;
	}

	public void setTitle(String diaryTitle) {
		this.diaryTitle = diaryTitle;
	}

	public void setDiaryEntry(String diaryEntry) {
		this.diaryEntry = diaryEntry;
	}

	public String getDiaryEntry() {
		return diaryEntry;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
