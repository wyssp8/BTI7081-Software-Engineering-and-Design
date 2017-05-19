package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.ExercisesViewModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.exercise.DailyExercise;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.exercise.Exercise;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.exercise.state.ExcerciseDone;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.exercise.state.ExerciseCanceled;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.exercise.state.ExerciseStarted;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.exercise.state.State;
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
	private DailyExercise currentDailyExercise;
	private int exerciseNumberDaily = 0;
	private int exerciseNumberCalm = 0;
	
	public ExercisesViewPresenter(ExerciseViewImpl exerciseViewImpl, ExercisesViewModel exercisesViewModel){
		this.exercisesViewModel = exercisesViewModel;
		this.exerciseViewImpl = exerciseViewImpl;
		exerciseViewImpl.addButtonClickListener(this);
		initExerciseCalm();
		initExerciseDaily();
	}
	
	@Override
	public void nextButtonClickCalm() {
		nextExerciseCalm();
	}
	
	@Override
	public void prevButtonClickCalm() {
		prevExerciseCalm();
		
	}
	
	@Override
	public void prevButtonClickDaily() {
		prevExerciseDaily();
	}

	@Override
	public void nextButtonClickDaily() {
		nextExerciseDaily();
	}
	
	public void nextExerciseCalm(){
		exerciseNumberCalm = (exerciseNumberCalm+1) % exercisesViewModel.getExercisesCalm().size();
		initExerciseCalm();
	}
	
	public void prevExerciseCalm(){
		int amountOfExercises = exercisesViewModel.getExercisesCalm().size();
		exerciseNumberCalm = (amountOfExercises+exerciseNumberCalm-1) % amountOfExercises;
		initExerciseCalm();
	}
	
	public void initExerciseCalm(){
		Exercise currentExercise = exercisesViewModel.getExercisesCalm().get(exerciseNumberCalm);
		exerciseViewImpl.setTitleTextCalm(currentExercise.getTitle());
		exerciseViewImpl.setDescriptionTextCalm(currentExercise.getDescription());
		exerciseViewImpl.setImagePathCalm(currentExercise.getImagePath());
	}
	
	public void nextExerciseDaily(){
		exerciseNumberDaily = (exerciseNumberDaily+1) % exercisesViewModel.getExercisesDaily().size();
		initExerciseDaily();
	}
	
	public void prevExerciseDaily(){
		int amountOfExercises = exercisesViewModel.getExercisesDaily().size();
		exerciseNumberDaily = (amountOfExercises+exerciseNumberDaily-1) % amountOfExercises;
		initExerciseDaily();
	}
	
	public void initExerciseDaily(){
		currentDailyExercise = (DailyExercise) exercisesViewModel.getExercisesDaily().get(exerciseNumberDaily);
		exerciseViewImpl.setImagePathDaily(currentDailyExercise.getImagePath());
		exerciseViewImpl.setTitleTextDaily(currentDailyExercise.getTitle());
		exerciseViewImpl.setDescriptionTextDaily(currentDailyExercise.getDescription());
		
		State currentState = currentDailyExercise.getState();
		exerciseViewImpl.setDailyExerciseStateDescription(currentState.getTitle());
		exerciseViewImpl.setDailyExerciseStartButtonVisibility(currentState.isStartButtonVisible());
		exerciseViewImpl.setDailyExerciseCancelButtonVisibility(currentState.isCancelButtonVisible());
		exerciseViewImpl.setDailyExerciseDoneButtonVisibility(currentState.isDoneButtonVisible());
		exerciseViewImpl.setStateStyle(currentState.getStateStyle());
	}


	@Override
	public void exerciseDone() {
		currentDailyExercise.setState(new ExcerciseDone());
		initExerciseDaily();
	}

	@Override
	public void exerciseStarted() {
		currentDailyExercise.setState(new ExerciseStarted());
		initExerciseDaily();
	}

	@Override
	public void exerciseCanceled() {
		currentDailyExercise.setState(new ExerciseCanceled());
		initExerciseDaily();
	}


}
