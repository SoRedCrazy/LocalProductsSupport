package scene;

import java.io.IOException;

import JavaObject.DAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class addEntrepriseControl {
	DAO d = new DAO();
	@FXML
	AnchorPane addEntreprise;
	@FXML
	private TextField siret, nom, prenom, rue, numRue, CPT, ville, pays, numTel, MDP;
	@FXML
	private Text titre;

	public void addEntrepriseButton() throws IOException {
		int numrue = -1;
		int cpt = -1;
		try {
			numrue = Integer.parseInt(numRue.getText());
			cpt = Integer.parseInt(CPT.getText());
		} catch (NumberFormatException e) {
			titre.setText("Erreur de paramettres");
		}

		if (cpt != -1 && numrue != -1) {
			boolean b = adminPanelControl.getAd().ajouterEntreprise(siret.getText(), prenom.getText(), nom.getText(),
					numrue, rue.getText(), cpt, ville.getText(), pays.getText(), numTel.getText(), MDP.getText());
			if (b != false) {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("adminPanel.fxml"));
				Pane mainpane = loader.load();
				addEntreprise.getChildren().setAll(mainpane);
			}
		}
	}

	public void back() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("adminPanel.fxml"));
		Pane mainpane = loader.load();
		addEntreprise.getChildren().setAll(mainpane);
	}
}
