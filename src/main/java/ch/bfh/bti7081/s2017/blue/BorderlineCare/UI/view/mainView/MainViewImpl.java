package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.mainView;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.ButtonClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.interfaces.EmergencyView;

import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

public class MainViewImpl extends CustomComponent {
	

	
	public MainViewImpl(ExerciseDashViewImpl exerciseDashViewImpl, DiaryDashViewImpl diaryDashViewImpl,EmergencyViewImpl emergencyViewImpl){
		HorizontalLayout layout = new HorizontalLayout();
		VerticalLayout layoutDashView = new VerticalLayout();
		layoutDashView.addComponent(diaryDashViewImpl);
		layoutDashView.addComponent(exerciseDashViewImpl);
		layout.addComponent(layoutDashView);
        layout.addComponent(emergencyViewImpl);
        layout.setSizeFull();
        setCompositionRoot(layout);
	}
	
}
