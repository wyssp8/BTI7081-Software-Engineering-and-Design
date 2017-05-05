package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.mainView;

import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;

public class DiaryDashViewImpl extends DashView {

	public DiaryDashViewImpl() {
		VerticalLayout layout = new VerticalLayout();
		layout.addComponent(new Button("New Diary"));
		setCompositionRoot(layout);
	}

}
