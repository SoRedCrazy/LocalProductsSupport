package scene;

import java.io.IOException;

import JavaObject.Client;
import JavaObject.DAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class addClientControl {
	@FXML
	private AnchorPane addclient;
	@FXML
	private TextField nom, prenom, rue, numRue, CPT, ville, pays, tel;
	DAO d = new DAO();
	@FXML
	private Text titre;

	public void addClientButton() throws IOException {
		int numrue = -1;
		int cpt = -1;
		try {
			numrue = Integer.parseInt(numRue.getText());
			cpt = Integer.parseInt(CPT.getText());
		} catch (NumberFormatException e) {
			titre.setText("Erreur de paramettres");
		}

		if (cpt != -1 && numrue != -1) {
			Client c = d.ajouterclient(prenom.getText(), nom.getText(), numrue, rue.getText(), cpt, ville.getText(),
					pays.getText(), tel.getText(), adminPanelControl.getAd().getEmail());
			if (c != null) {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("adminPanel.fxml"));
				Pane mainpane = loader.load();
				addclient.getChildren().setAll(mainpane);
			}
		}

	}

	public void back() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("adminPanel.fxml"));
		Pane mainpane = loader.load();
		addclient.getChildren().setAll(mainpane);
	}
}
