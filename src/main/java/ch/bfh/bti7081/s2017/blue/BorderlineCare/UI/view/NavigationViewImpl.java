 package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view;

import java.io.File;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import com.vaadin.server.FileResource;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.mainView.ExerciseDashViewImpl;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.mainView.MainViewImpl;

public class NavigationViewImpl extends TabSheet implements View {
	
	//Name of the View1
	public static final String NAME = "HomeView";
	private String basepath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();
	private ExerciseViewImpl exerciseviewImpl;
	private DiaryViewImpl diaryViewImpl;
	
	public NavigationViewImpl(MainViewImpl mainView, ContactViewImpl contactsViewImpl, DiaryViewImpl diaryViewImpl, ExerciseViewImpl exerciseViewImpl,SettingsViewImpl settingsView) {

		this.exerciseviewImpl = exerciseViewImpl;
		this.diaryViewImpl = diaryViewImpl;
		addTab(mainView,"Home", new FileResource(new File(basepath + "/WEB-INF/images/icons/home.png")));
		addTab(contactsViewImpl,"Contacts", new FileResource(new File(basepath + "/WEB-INF/images/icons/contacts.png")));
		addTab(diaryViewImpl,"Diary", new FileResource(new File(basepath + "/WEB-INF/images/icons/diary.png")));
		addTab(exerciseViewImpl,"Exercises", new FileResource(new File(basepath + "/WEB-INF/images/icons/exercises.png")));
		addTab(settingsView,"Settings", new FileResource(new File(basepath + "/WEB-INF/images/icons/settings.png")));
		setHeight(100.0f, Unit.PERCENTAGE);
        addStyleName(ValoTheme.TABSHEET_FRAMED);
        addStyleName(ValoTheme.TABSHEET_PADDED_TABBAR);
	}

	@Override
	public void enter(ViewChangeEvent arg0) {
		// Get the user name from the session
		String username = getSession().getAttribute("user").toString();
		
		//Create new tab with username
		VerticalLayout l1 = new VerticalLayout();
	    addTab(l1,username);
	    
	    //Show login message
		Notification.show("Logged in successully", "hey "+username, Notification.Type.HUMANIZED_MESSAGE);	
		
	}

	public void selectExercisesTab() {
		setSelectedTab(exerciseviewImpl);
	}

	public void selectDiaryTab() {
		setSelectedTab(diaryViewImpl);
	}


}
