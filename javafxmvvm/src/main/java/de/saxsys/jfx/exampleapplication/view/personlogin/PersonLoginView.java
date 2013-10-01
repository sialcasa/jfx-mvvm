package de.saxsys.jfx.exampleapplication.view.personlogin;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import de.saxsys.jfx.exampleapplication.viewmodel.personlogin.PersonLoginViewModel;
import de.saxsys.jfx.mvvm.base.MVVMView;

/**
 * Code behind the fxml for visualization of the {@link PersonLoginView}. After
 * the {@link PersonLoginViewModel} is set, the view binds to the
 * {@link PersonLoginViewModel}.
 * 
 * @author alexander.casall
 */
public class PersonLoginView extends MVVMView<PersonLoginViewModel> {

	@FXML
	private ChoiceBox<String> personsChoiceBox;

	@FXML
	private VBox layoutVbox;

	@Override
	public void initialize(final URL arg0, final ResourceBundle arg1) {
	}

	@Override
	public void beforeViewModelInitialization() {
	}

	@Override
	public void afterViewModelInitialization() {
		personsChoiceBox.itemsProperty().bind(getViewModel().personsProperty());
	}

	@FXML
	void loginButtonPressed(final ActionEvent event) {
		final int personId = personsChoiceBox.getSelectionModel()
				.getSelectedIndex();
		getViewModel().pickedPersonProperty().set(personId);
	}

}
