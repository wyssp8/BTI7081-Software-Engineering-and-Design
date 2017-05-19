package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.exercise;

import java.util.List;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.exercise.state.ExercisePending;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.exercise.state.State;

/**
 * 
 * @author wyssp8
 *
 */
public class DailyExercise extends Exercise {

	private State state;
	
	public DailyExercise(String title, String description, String path) {
		super(title, description, path);
		setState(new ExercisePending());
	}

	public void setState(State state) {
		this.state = state;
	}

	public State getState() {
		return state;
	}

}
