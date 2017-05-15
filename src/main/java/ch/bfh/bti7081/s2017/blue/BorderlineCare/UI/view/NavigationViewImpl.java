 package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.themes.ValoTheme;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.mainView.ExerciseDashViewImpl;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.mainView.MainViewImpl;

public class NavigationViewImpl extends TabSheet implements View {
	
	//Name of the View
	public static final String NAME = "HomeView";
	
	public NavigationViewImpl(MainViewImpl mainView, ContactViewImpl contactsViewImpl, DiaryViewImpl diaryViewImpl, ExerciseViewImpl exerciseViewImpl,SettingsViewImpl settingsView) {

	
		addTab(mainView,"Home");
		addTab(contactsViewImpl,"Contacts");
		addTab(diaryViewImpl,"Diary");
		addTab(exerciseViewImpl,"Exercises");
		addTab(settingsView,"Settings");
		setHeight(100.0f, Unit.PERCENTAGE);
        addStyleName(ValoTheme.TABSHEET_FRAMED);
        addStyleName(ValoTheme.TABSHEET_PADDED_TABBAR);;
	}

	@Override
	public void enter(ViewChangeEvent arg0) {
		// TODO Auto-generated method stub
		
	}


}
