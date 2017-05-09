package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter;

import com.vaadin.ui.Label;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.ExercisesViewModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.ButtonClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.ExerciseViewImpl;

public class ExercisesViewPresenter implements ButtonClickListener {
	
	ExercisesViewModel exercisesViewModel;
	ExerciseViewImpl exerciseViewImpl;
	
	public ExercisesViewPresenter(ExerciseViewImpl exerciseViewImpl){
		this.exercisesViewModel = new ExercisesViewModel();
		this.exerciseViewImpl = exerciseViewImpl;
	}
	
	@Override
	public void buttonClick() {
		
	}

	public String getTitle() {
		String a = exercisesViewModel.getExercises().get(0).getTitle();
		System.out.println(a);
		return a;
	}
	
	
	
	
	
	
}
