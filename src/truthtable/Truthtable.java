/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package truthtable;

import java.io.File;
import java.io.InputStream;
import javafx.beans.value.ChangeListener;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.scene.web.WebEngine;
import static javafx.concurrent.Worker.State;

public class Truthtable extends Application
{
	public static void main(String[] args)
	{
		Application.launch(args);
	}

	@Override
	public void start(final Stage stage)
	{
		// Create the WebView
		WebView webView = new WebView();

		// Create the WebEngine
		final WebEngine webEngine = webView.getEngine();

		// LOad the Start-Page
                String stream = getClass().getResource("web/index.html").toExternalForm();
                webEngine.load(stream);
		// Update the stage title when a new web page title is available
		webEngine.getLoadWorker().stateProperty().addListener((ObservableValue<? extends State> ov, State oldState, State newState) -> {
                    if (newState == State.SUCCEEDED)
                    {
                        //stage.setTitle(webEngine.getLocation());
                        stage.setTitle("Truth Table");
                    }
                });

		// Create the VBox
		VBox root = new VBox();
		// Add the WebView to the VBox
		root.getChildren().add(webView);

		// Set the Style-properties of the VBox
		root.setStyle("-fx-padding: 10;" +
				"-fx-border-width: 2;" +
				"-fx-border-insets: 5;" +
				"-fx-border-radius: 5;");

		// Create the Scene
		Scene scene = new Scene(root);
		// Add  the Scene to the Stage
		stage.setScene(scene);
		// Display the Stage
		stage.show();
	}
}

