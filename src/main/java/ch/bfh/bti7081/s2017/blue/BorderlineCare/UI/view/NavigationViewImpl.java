package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view;

import com.vaadin.ui.TabSheet;
import com.vaadin.ui.themes.ValoTheme;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.mainView.MainViewImpl;

public class NavigationViewImpl extends TabSheet {
	
	private static final long serialVersionUID = -437591943449535630L;

	public NavigationViewImpl(MainViewImpl mainView, ContactViewImpl contactsViewImpl, DiaryViewImpl diaryViewImpl, ExerciseViewImpl exerciseViewImpl) {
		addTab(mainView,"Home");
		addTab(contactsViewImpl,"Contacts"); 
		addTab(diaryViewImpl,"Diary");
		addTab(exerciseViewImpl, "Exercises");
		setHeight(100.0f, Unit.PERCENTAGE);
        addStyleName(ValoTheme.TABSHEET_FRAMED);
        addStyleName(ValoTheme.TABSHEET_PADDED_TABBAR);;
	}


}
