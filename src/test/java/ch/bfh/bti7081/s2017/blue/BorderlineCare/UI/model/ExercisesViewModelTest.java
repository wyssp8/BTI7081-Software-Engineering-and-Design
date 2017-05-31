package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class ExercisesViewModelTest {

	@Test
	public void testGetRandomExercise() {
		int countSameExercise = 0;
		for (int i = 0; i < 10; i++) {
			ExercisesViewModel model = new ExercisesViewModel();
			if (model.getRandomExercise().equals(model.getRandomExercise())) {
				countSameExercise++;
			}
		}
		assertTrue(countSameExercise < 8);
	}

}
