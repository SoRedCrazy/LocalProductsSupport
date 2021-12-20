package scene;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class startApp extends Application {
	public static void main(String[] args) {
		startApp.launch(args);
	}

	@Override
	public void start(Stage main1) throws Exception {
		AnchorPane root = FXMLLoader.load(getClass().getResource("Loginscene.fxml"));
		Scene sc = new Scene(root, 854, 480);
		main1.setScene(sc);
		main1.show();
	}

}
