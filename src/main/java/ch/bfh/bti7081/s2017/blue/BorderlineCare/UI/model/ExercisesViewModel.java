package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model;

import java.util.ArrayList;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.exercise.CalmDownExercise;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.exercise.DailyExercise;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.exercise.Exercise;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.exercise.state.ExcerciseDone;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.exercise.state.ExercisePending;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.exercise.state.State;

/**
 * 
 * @author wyssp8
 *
 */
public class ExercisesViewModel {

	private ArrayList<Exercise> calmDownExercises = new ArrayList<Exercise>();
	private ArrayList<Exercise> dailyExercises = new ArrayList<Exercise>();

	public ExercisesViewModel() {
		calmDownExercises.add(new CalmDownExercise("Puzzle", "this is what you have to do", "puzzle.png"));
		calmDownExercises.add(new CalmDownExercise("Read a book", "this is what you have to do", "reading.png"));
		calmDownExercises.add(new CalmDownExercise("Walk", "this is what you have to do", "walking.png"));
		calmDownExercises.add(new CalmDownExercise("Write a letter", "Please open the door", "letter.png"));
		calmDownExercises.add(new CalmDownExercise("Write a diary", "Please open the door", "diary.png"));
		calmDownExercises.add(new CalmDownExercise("Clean you room", "Please open the door", "cleaning.png"));
		
		dailyExercises.add(new DailyExercise("Take a Walk", "Go outside and take a walk", "walking.png"));
		dailyExercises.add(new DailyExercise("Diary entry", "Write your daily diary entry.", "diary.png"));
		dailyExercises.add(new DailyExercise("Reading", "Read 10 pages of your book.", "reading.png"));
		
		
	}

	public void addExercise(Exercise exercise) {
		calmDownExercises.add(exercise);
	}

	public ArrayList<Exercise> getExercisesCalm() {
		return calmDownExercises;
	}
	
	public ArrayList<Exercise> getExercisesDaily() {
		return dailyExercises;
	}

}
