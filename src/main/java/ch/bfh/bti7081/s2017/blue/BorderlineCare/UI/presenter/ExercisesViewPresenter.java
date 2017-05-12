package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.ExercisesViewModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.exercise.Exercise;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.ExerciseClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.ExerciseViewImpl;
/**
 * 
 * @author wyssp8
 *
 */
public class ExercisesViewPresenter implements ExerciseClickListener {
	
	private ExercisesViewModel exercisesViewModel;
	private ExerciseViewImpl exerciseViewImpl;
	private int exerciseNumber = 0;
	
	public ExercisesViewPresenter(ExerciseViewImpl exerciseViewImpl, ExercisesViewModel exercisesViewModel){
		this.exercisesViewModel = exercisesViewModel;
		this.exerciseViewImpl = exerciseViewImpl;
		exerciseViewImpl.addButtonClickListener(this);
		initExercise();
	}
	
	@Override
	public void nextButtonClick() {
		nextExercise();
	}
	
	@Override
	public void prevButtonClick() {
		prevExercise();
		
	}
	
	public void nextExercise(){
		exerciseNumber = (exerciseNumber+1) % exercisesViewModel.getExercises().size();
		initExercise();
	}
	
	public void prevExercise(){
		int amountOfExercises = exercisesViewModel.getExercises().size();
		exerciseNumber = (amountOfExercises+exerciseNumber-1) % amountOfExercises;
		initExercise();
	}
	
	public void initExercise(){
		Exercise currentExercise = exercisesViewModel.getExercises().get(exerciseNumber);
		exerciseViewImpl.setTitleText(currentExercise.getTitle());
		exerciseViewImpl.setDescriptionText(currentExercise.getDescription());
		exerciseViewImpl.setImagePath(currentExercise.getImagePath());
	}

}
