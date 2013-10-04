package de.saxsys.jfx;

import java.util.List;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import com.cathive.fx.guice.GuiceApplication;
import com.google.inject.Inject;
import com.google.inject.Module;

import de.saxsys.jfx.mvvm.viewloader.MVVMViewLoader;
import de.saxsys.jfx.mvvm.viewloader.MVVMViewNames;
import de.saxsys.jfx.mvvm.viewloader.MVVMViewTuple;

/**
 * Entry point of the application.
 * 
 * @author sialcasa
 * 
 */
public class Starter extends GuiceApplication {

	// Get the MVVM View Loader
	@Inject
	private MVVMViewLoader viewLoader;

	public static void main(final String[] args) {
		launch(args);
	}

	@Override
	public void start(final Stage stage) throws Exception {
		final MVVMViewTuple tuple = viewLoader
				.loadViewTuple(MVVMViewNames.MAINCONTAINER.getResource());

		// Locate View for loaded FXML file
		final Parent view = tuple.getView();

		final Scene scene = new Scene(view);
		stage.setScene(scene);
		stage.show();
	}

	@Override
	public void init(List<Module> arg0) throws Exception {
		// TODO Auto-generated method stub

	}

}
