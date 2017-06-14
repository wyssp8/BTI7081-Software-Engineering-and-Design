package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
/**
 * Links the diary Model with the diary view in the dashboard.
 * 
 * @author frutiger
 *
 */
public class DiaryDashViewPresenter implements ButtonClickListener {

	private final static Logger logger = Logger.getLogger(DiaryDashViewPresenter.class.getName());
	private DiaryViewModel diaryViewModel;
	private DiaryDashViewImpl diaryDashViewImpl;
	private NavigationViewImpl navigationViewImpl;
	private DiaryEntry diaryEntry;

	public DiaryDashViewPresenter(DiaryViewModel model, DiaryDashViewImpl view, NavigationViewImpl navView) {
		this.diaryViewModel = model;
		this.diaryDashViewImpl = view;
		this.navigationViewImpl = navView;
		diaryDashViewImpl.addListener(this);
		try {
			diaryEntry = diaryViewModel.getLatestDiaryEntry();
			diaryDashViewImpl.setLatestDate(diaryEntry.getDate().toString());
			diaryDashViewImpl.setDescriptionText(diaryEntry.getDiaryEntry());
		} catch (Exception e) {
			logger.log(Level.INFO, "No diary entry set");
		}
	}

	@Override
	public void buttonClick() {
		logger.log(Level.INFO, "Move to Diary");
		navigationViewImpl.selectDiaryTab();
	}

}
