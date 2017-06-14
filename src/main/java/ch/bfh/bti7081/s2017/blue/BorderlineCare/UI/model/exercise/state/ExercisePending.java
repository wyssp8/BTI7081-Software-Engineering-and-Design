package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.exercise.state;
/**
 * Exercise has not been started yet.
 * @author frutiger
 *
 */
public class ExercisePending implements State {

	@Override
	public String getTitle() {
		return "Ready";
	}

	@Override
	public boolean isCancelButtonVisible() {
		return false;
	}

	@Override
	public boolean isStartButtonVisible() {
		return true;
	}

	@Override
	public boolean isDoneButtonVisible() {
		return false;
	}

	@Override
	public String getStateStyle() {
		return "ready-label";
	}

}
