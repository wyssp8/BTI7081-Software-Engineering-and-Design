 package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view;

import com.vaadin.ui.TabSheet;
import com.vaadin.ui.themes.ValoTheme;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.mainView.MainViewImpl;

public class NavigationViewImpl extends TabSheet {
	
	public NavigationViewImpl(MainViewImpl mainView, ContactViewImpl contactsViewImpl, DiaryViewImpl diaryViewImpl , SettingsViewImpl settingsView) {

	
		addTab(mainView,"Home");
		addTab(contactsViewImpl,"Contacts"); 
		addTab(diaryViewImpl,"Diary");
		addTab(diaryViewImpl,"S");
		addTab(settingsView,"Settings");
		setHeight(100.0f, Unit.PERCENTAGE);
        addStyleName(ValoTheme.TABSHEET_FRAMED);
        addStyleName(ValoTheme.TABSHEET_PADDED_TABBAR);;
	}


}
