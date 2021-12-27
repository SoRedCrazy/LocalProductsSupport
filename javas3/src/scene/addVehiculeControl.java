package scene;

import java.io.IOException;

import JavaObject.DAO;
import JavaObject.Entreprise;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class addVehiculeControl {
	DAO d = new DAO();
	private Entreprise et = userPanelControl.getEt();

	@FXML
	private TextField imma, poid;
	@FXML
	private AnchorPane addVehicule;
	@FXML
	private Text titre;

	public void addVehiculeButton() throws IOException {
		String immatriculation = imma.getText();
		int poids = -1;
		try {
			poids = Integer.parseInt(poid.getText());
		} catch (NumberFormatException e) {
			titre.setText("Erreur de le format int pour le poids");
		}

		if (poids != -1) {
			boolean b = et.ajouterVehicule(immatriculation, poids);
			if (b) {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("userPanel.fxml"));
				Pane mainpane = loader.load();
				addVehicule.getChildren().setAll(mainpane);
			} else {
				titre.setText("Erreur d'envoie");
			}
		}
	}

	public void back() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("userPanel.fxml"));
		Pane mainpane = loader.load();
		addVehicule.getChildren().setAll(mainpane);
	}
}
