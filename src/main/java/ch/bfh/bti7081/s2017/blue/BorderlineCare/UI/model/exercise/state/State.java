package ch.bfh.bti7081.s2017.blue.BorderlineCare.UI.model.exercise.state;

import com.vaadin.shared.ui.colorpicker.Color;

public interface State {
   public String getTitle();
   public boolean isCancelButtonVisible();
   public boolean isStartButtonVisible();
   public boolean isDoneButtonVisible();
   public String getStateStyle();
}
