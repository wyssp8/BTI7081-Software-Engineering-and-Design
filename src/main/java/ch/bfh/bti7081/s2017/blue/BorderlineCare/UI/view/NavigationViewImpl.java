package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view;

import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class NavigationViewImpl extends TabSheet {

	public NavigationViewImpl(MainViewImpl mainView, ContactViewImpl contactsViewImpl, DiaryViewImpl diaryViewImpl) {
		addTab(mainView,"Home");
		addTab(contactsViewImpl,"Contacts"); 
		addTab(diaryViewImpl,"Diary");
		setHeight(100.0f, Unit.PERCENTAGE);
        addStyleName(ValoTheme.TABSHEET_FRAMED);
        addStyleName(ValoTheme.TABSHEET_PADDED_TABBAR);;
	}


}
