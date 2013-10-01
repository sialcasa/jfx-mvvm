package de.saxsys.jfx;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import de.saxsys.jfx.exampleapplication.view.maincontainer.MainContainerView;
import de.saxsys.jfx.exampleapplication.viewmodel.maincontainer.MainContainerViewModel;
import de.saxsys.jfx.mvvm.viewloader.MVVMViewLoader;
import de.saxsys.jfx.mvvm.viewloader.MVVMViewNames;
import de.saxsys.jfx.mvvm.viewloader.MVVMViewTuple;

/**
 * Entry point of the application.
 * 
 * @author sialcasa
 * 
 */
public class Starter extends Application {

	public static void main(final String[] args) {
		launch(args);
	}

	@Override
	public void start(final Stage stage) throws Exception {
		final MVVMViewTuple tuple = new MVVMViewLoader()
				.loadViewTuple(MVVMViewNames.MAINCONTAINER.getResource());

		// Locate code-behind with view
		final MainContainerView personLoginView = (MainContainerView) tuple
				.getCodeBehind();

		// Locate View for loaded FXML file
		final Parent view = tuple.getView();

		// Create and set ViewModel
		final MainContainerViewModel personLoginViewModel = new MainContainerViewModel();
		personLoginView.setViewModel(personLoginViewModel);

		final Scene scene = new Scene(view);
		stage.setScene(scene);
		stage.show();
	}

}
