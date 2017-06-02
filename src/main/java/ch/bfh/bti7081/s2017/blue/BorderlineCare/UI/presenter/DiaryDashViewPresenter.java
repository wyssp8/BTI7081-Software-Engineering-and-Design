package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.vaadin.server.Page;
import com.vaadin.ui.PopupView;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.Contact;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.DiaryEntry;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.DiaryViewModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.ButtonClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.DiaryButtonClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.DiaryViewImpl;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.NavigationViewImpl;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.mainView.DiaryDashViewImpl;

public class DiaryDashViewPresenter implements ButtonClickListener {

	private DiaryViewModel diaryViewModel;
	private DiaryDashViewImpl diaryDashViewImpl;
	private NavigationViewImpl navigationViewImpl;
	private DiaryEntry diaryEntry;

	public DiaryDashViewPresenter(DiaryViewModel model, DiaryDashViewImpl view, NavigationViewImpl navView) {
		this.diaryViewModel = model;
		this.diaryDashViewImpl = view;
		this.navigationViewImpl = navView;
		diaryEntry = diaryViewModel.getLatestDiaryEntry();
		diaryDashViewImpl.addListener(this);
		diaryDashViewImpl.setLatestDate(diaryEntry.getDate().toString());
		diaryDashViewImpl.setDescriptionText(diaryEntry.getDiaryEntry());
	}

	@Override
	public void buttonClick() {
		navigationViewImpl.selectDiaryTab();
	}

}
