package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter;

import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.ExercisesViewModel;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.exercise.Exercise;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.presenter.interfaces.ButtonClickListener;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.NavigationViewImpl;
import ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.view.mainView.ExerciseDashViewImpl;

public class ExerciseDashViewPresenter implements ButtonClickListener{

	private ExerciseDashViewImpl exerciseDashViewImpl;
	private ExercisesViewModel exerciseModel;
	private NavigationViewImpl navigationViewImpl;
	
	public ExerciseDashViewPresenter(ExerciseDashViewImpl exerciseDashViewImpl, ExercisesViewModel exerciseModel,
			NavigationViewImpl navigationViewImpl) {
		super();
		this.exerciseDashViewImpl = exerciseDashViewImpl;
		this.exerciseModel = exerciseModel;
		this.navigationViewImpl = navigationViewImpl;
		exerciseDashViewImpl.addListener(this);
		Exercise randomExercise = exerciseModel.getRandomExercise();
		exerciseDashViewImpl.setDescriptionTextDaily(randomExercise.getDescription());
		exerciseDashViewImpl.setTitleTextDaily(randomExercise.getTitle());
		exerciseDashViewImpl.setImagePathDaily(randomExercise.getImagePath());
	}


	@Override
	public void buttonClick() {
		navigationViewImpl.selectExercisesTab();
	}
	
	
	
}
