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
	// fx:id="personPickView"
	private StackPane loginView; // Value injected by FXMLLoader

	@FXML
	private PersonLoginView loginViewController;

	@FXML
	// fx:id="welcomeArea"
	private StackPane welcomeView; // Value injected by FXMLLoader

	@FXML
	private PersonWelcomeView welcomeViewController;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	@Override
	protected void beforeViewModelInitialization() {
	}

	@Override
	protected void afterViewModelInitialization() {

		final PersonLoginViewModel personLoginViewModel = new PersonLoginViewModel();

		loginViewController.setViewModel(personLoginViewModel);

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
