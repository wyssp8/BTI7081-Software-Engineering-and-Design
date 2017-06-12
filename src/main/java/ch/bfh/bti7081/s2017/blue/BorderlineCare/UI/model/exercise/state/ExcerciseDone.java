package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.exercise.state;

import com.vaadin.ui.themes.ValoTheme;

public class ExcerciseDone implements State {

	@Override
	public String getTitle() {
		return "Done";
	}


	@Override
	public boolean isCancelButtonVisible() {
		return false;
	}

	@Override
	public boolean isStartButtonVisible() {
		return false;
	}

	@Override
	public boolean isDoneButtonVisible() {
		return false;
	}


	@Override
	public String getStateStyle() {
		return ValoTheme.LABEL_SUCCESS;
	}
	
	


}
