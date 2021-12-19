package scene;

import java.io.IOException;

import JavaObject.Admin;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class adminPanelControl {
	@FXML
	private AnchorPane adminPanel;

	private static Admin ad;

	public static Admin getAd() {
		return ad;
	}

	public static void setAd(Admin ad) {
		adminPanelControl.ad = ad;
	}

	public void addTourneeAdminPanelButton() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("adminPanel.fxml"));
		Pane mainpane = loader.load();
		adminPanel.getChildren().setAll(mainpane);
	}

	public void addVehiculeAdminPanelButton() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("adminPanel.fxml"));
		Pane mainpane = loader.load();
		adminPanel.getChildren().setAll(mainpane);
	}

	public void supprimerVehiculeAdminPanelButton() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("adminPanel.fxml"));
		Pane mainpane = loader.load();
		adminPanel.getChildren().setAll(mainpane);
	}

	public void addClientAdminPanelButton() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("adminPanel.fxml"));
		Pane mainpane = loader.load();
		adminPanel.getChildren().setAll(mainpane);
	}

	public void supprimerClientAdminPanelButton() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("adminPanel.fxml"));
		Pane mainpane = loader.load();
		adminPanel.getChildren().setAll(mainpane);
	}

	public void supprimerEntrepriseAdminPanelButton() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("adminPanel.fxml"));
		Pane mainpane = loader.load();
		adminPanel.getChildren().setAll(mainpane);
	}

	public void modifEntrepriseAdminPanelButton() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("adminPanel.fxml"));
		Pane mainpane = loader.load();
		adminPanel.getChildren().setAll(mainpane);
	}

	public void modifClientAdminPanelButton() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("adminPanel.fxml"));
		Pane mainpane = loader.load();
		adminPanel.getChildren().setAll(mainpane);
	}

	public void addEntrepriseAdminPanelButton() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("adminPanel.fxml"));
		Pane mainpane = loader.load();
		adminPanel.getChildren().setAll(mainpane);
	}

}
