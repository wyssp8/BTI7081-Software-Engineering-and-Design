package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model;

import java.util.ArrayList;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.exercise.DailyExercise;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.exercise.Exercise;

public class ExercisesViewModel {

	ArrayList<Exercise> exercises = new ArrayList<Exercise>();
	
	public ExercisesViewModel(){
		exercises.add(new DailyExercise("Test Exercise 1", "this is what you have to do", "path"));
		exercises.add(new DailyExercise("Test Exercise 2", "this is what you have to do", "path"));
		exercises.add(new DailyExercise("Test Exercise 3", "this is what you have to do", "path"));
	}
	
	public void addExercise(Exercise exercise){
		exercises.add(exercise);
	}
	
	public ArrayList<Exercise> getExercises() {
		return exercises;
	}
}
