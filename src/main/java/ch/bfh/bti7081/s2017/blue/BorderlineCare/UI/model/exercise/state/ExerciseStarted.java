package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.exercise.state;

public class ExerciseStarted implements State {

	@Override
	public String getTitle() {
		return "In progress";
	}

	@Override
	public boolean isCancelButtonVisible() {
		return true;
	}

	@Override
	public boolean isStartButtonVisible() {
		return false;
	}

	@Override
	public boolean isDoneButtonVisible() {
		return true;
	}

	@Override
	public String getStateStyle() {
		return "in-progress-label";
	}


}
