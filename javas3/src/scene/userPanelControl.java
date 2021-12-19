package scene;

import java.io.IOException;

import JavaObject.Entreprise;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class userPanelControl {
	@FXML
	private AnchorPane userPanel;

	private static Entreprise et;

	public static Entreprise getEt() {
		return et;
	}

	public static void setEt(Entreprise et) {
		userPanelControl.et = et;
	}

	public void ajouterTourneeUserPanelButton() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("addTourneeUser.fxml"));
		Pane mainpane = loader.load();
		userPanel.getChildren().setAll(mainpane);
	}

	public void ajouterVehiculeUserPanelButton() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("AddVehicule.fxml"));
		Pane mainpane = loader.load();
		userPanel.getChildren().setAll(mainpane);
	}

	public void supprimerVehiculeUserPanelButton() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("delVehicule.fxml"));
		Pane mainpane = loader.load();
		userPanel.getChildren().setAll(mainpane);
	}

}
