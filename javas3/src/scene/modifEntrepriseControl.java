package scene;

import java.io.IOException;
import java.util.ArrayList;

import JavaObject.DAO;
import JavaObject.Entreprise;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class modifEntrepriseControl {
	DAO d = new DAO();
	@FXML
	AnchorPane modifEntreprise;
	@FXML
	private TextField nom, prenom, rue, numRue, CPT, ville, pays, numTel, MDP;
	@FXML
	private Text titre;
	@FXML
	ComboBox<String> combolist;
	ArrayList<Entreprise> ent = d.listEntreprise();

	public void initialize() {
		ArrayList<String> ent = new ArrayList<String>();
		for (Entreprise elemt : this.ent) {
			ent.add(elemt.getSiret());
		}
		ObservableList<String> Ovehi = FXCollections.observableArrayList(ent);
		combolist.getItems().addAll(Ovehi);

	}

	public void modifEntrepriseButton() throws IOException {
		int numrue = -1;
		int cpt = -1;
		String s = combolist.getSelectionModel().getSelectedItem();
		try {
			numrue = Integer.parseInt(numRue.getText());
			cpt = Integer.parseInt(CPT.getText());
		} catch (NumberFormatException e) {
			titre.setText("Erreur de paramettres");
		}

		if (cpt != -1 && numrue != -1) {
			boolean b = false;
			for (Entreprise elemt : ent) {
				if (elemt.getSiret() == s)
					b = adminPanelControl.getAd().ModifEntreprise(elemt, prenom.getText(), nom.getText(), numrue,
							rue.getText(), cpt, ville.getText(), pays.getText(), numTel.getText(), MDP.getText());
			}
			if (b != false) {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("adminPanel.fxml"));
				Pane mainpane = loader.load();
				modifEntreprise.getChildren().setAll(mainpane);
			} else {
				titre.setText("Erreur d'envoie");
			}
		}
	}

	public void back() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("adminPanel.fxml"));
		Pane mainpane = loader.load();
		modifEntreprise.getChildren().setAll(mainpane);
	}
}
