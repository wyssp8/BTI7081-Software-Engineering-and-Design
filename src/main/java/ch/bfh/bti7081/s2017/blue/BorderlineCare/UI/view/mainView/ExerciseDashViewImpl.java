package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.mainView;

import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;

public class ExerciseDashViewImpl extends DashView {

	public ExerciseDashViewImpl() {
		VerticalLayout layout = new VerticalLayout();
		layout.addComponent(new Button("New Exercise"));
		setCompositionRoot(layout);
	}
}
