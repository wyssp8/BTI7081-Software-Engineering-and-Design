package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.mainView;

import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;
/**
 * 
 * This View adds all the subviews to the Main View.
 * 
 * @author frutiger
 *
 */
public class MainViewImpl extends CustomComponent {
	
	private static final long serialVersionUID = -5619296784263138892L;
	private EmergencyViewImpl emergencyViewImpl;

	public MainViewImpl(ExerciseDashViewImpl exerciseDashViewImpl, DiaryDashViewImpl diaryDashViewImpl,EmergencyViewImpl emergencyViewImpl){
		this.emergencyViewImpl = emergencyViewImpl;
		HorizontalLayout layout = new HorizontalLayout();
		VerticalLayout layoutDashView = new VerticalLayout();
		layoutDashView.addComponent(diaryDashViewImpl);
		layoutDashView.addComponent(exerciseDashViewImpl);
		layout.addComponent(layoutDashView);
        layout.addComponent(emergencyViewImpl);
        layout.setSizeFull();
        setCompositionRoot(layout);
	}

	public void resetView() {
		emergencyViewImpl.resetView();
		
	}
	
}
