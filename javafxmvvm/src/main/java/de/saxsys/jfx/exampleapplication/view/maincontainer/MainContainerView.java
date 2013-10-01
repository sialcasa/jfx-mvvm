package de.saxsys.jfx.exampleapplication.view.maincontainer;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import de.saxsys.jfx.exampleapplication.view.personlogin.PersonLoginView;
import de.saxsys.jfx.exampleapplication.view.personwelcome.PersonWelcomeView;
import de.saxsys.jfx.exampleapplication.viewmodel.maincontainer.MainContainerViewModel;
import de.saxsys.jfx.exampleapplication.viewmodel.personlogin.PersonLoginViewModel;
import de.saxsys.jfx.exampleapplication.viewmodel.personwelcome.PersonWelcomeViewModel;
import de.saxsys.jfx.mvvm.base.MVVMView;

public class MainContainerView extends MVVMView<MainContainerViewModel> {

	@FXML
	// Injection of the login which is declared in the FXML File
	private StackPane loginView; // Value injected by FXMLLoader

	@FXML
	// Inject the Code behind instance of the loginView by using the
	// nameconvention ...Controller
	private PersonLoginView loginViewController;

	@FXML
	// Injection of the login which is declared in the FXML File
	private StackPane welcomeView; // Value injected by FXMLLoader

	@FXML
	// Inject the Code behind instance of the welcomeView by using the
	// nameconvention ...Controller
	private PersonWelcomeView welcomeViewController;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	@Override
	protected void beforeViewModelInitialization() {
	}

	@Override
	protected void afterViewModelInitialization() {

		// Create the view model for the person login view
		final PersonLoginViewModel personLoginViewModel = new PersonLoginViewModel();

		loginViewController.setViewModel(personLoginViewModel);

		// When the login button of the loginView, the pickedPersonProperty is
		// going to have the index of the selected person
		personLoginViewModel.pickedPersonProperty().addListener(
				new ChangeListener<Number>() {
					@Override
					public void changed(ObservableValue<? extends Number> arg0,
							Number oldValue, Number newValue) {

						PersonWelcomeViewModel personWelcomeViewModel = new PersonWelcomeViewModel(
								newValue.intValue());
						welcomeViewController
								.setViewModel(personWelcomeViewModel);
					}
				});

		welcomeView.setVisible(true);
	}

}
