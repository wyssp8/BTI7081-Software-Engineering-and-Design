package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model;

import java.util.ArrayList;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.exercise.DailyExercise;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.exercise.Exercise;
/**
 * 
 * @author wyssp8
 *
 */
public class ExercisesViewModel {

	private ArrayList<Exercise> exercises = new ArrayList<Exercise>();
	
	public ExercisesViewModel(){
		exercises.add(new DailyExercise("Puzzle", "this is what you have to do", "puzzle.png"));
		exercises.add(new DailyExercise("Read a book", "this is what you have to do", "reading.png"));
		exercises.add(new DailyExercise("Walk", "this is what you have to do", "walking.png"));
		exercises.add(new DailyExercise("Write a letter", "Please open the door", "letter.png"));
		exercises.add(new DailyExercise("Write a diary", "Please open the door", "diary.png"));
		exercises.add(new DailyExercise("Clean you room", "Please open the door", "cleaning.png"));
	}
	
	public void addExercise(Exercise exercise){
		exercises.add(exercise);
	}
	
	public ArrayList<Exercise> getExercises() {
		return exercises;
	}
}
