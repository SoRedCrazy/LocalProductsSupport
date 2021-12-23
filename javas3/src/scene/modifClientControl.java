package scene;

import java.io.IOException;
import java.util.ArrayList;

import JavaObject.Client;
import JavaObject.DAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class modifClientControl {
	DAO d = new DAO();
	@FXML
	AnchorPane modifClient;
	@FXML
	private TextField nom, prenom, rue, numRue, CPT, ville, pays, numTel;
	@FXML
	private Text titre;
	@FXML
	ComboBox<String> combolist;
	ArrayList<Client> cl = d.listClient();

	public void initialize() {
		ArrayList<String> cl = new ArrayList<String>();
		for (Client elemt : this.cl) {
			cl.add(elemt.getIdClient() + " " + elemt.getNom() + " " + elemt.getPrenom());
		}
		ObservableList<String> Ovehi = FXCollections.observableArrayList(cl);
		combolist.getItems().addAll(Ovehi);

	}

	public void modifClientButton() throws IOException {
		int numrue = -1;
		int cpt = -1;
		String[] s = combolist.getSelectionModel().getSelectedItem().split(" ");
		try {
			numrue = Integer.parseInt(numRue.getText());
			cpt = Integer.parseInt(CPT.getText());
		} catch (NumberFormatException e) {
			titre.setText("Erreur de paramettres");
		}

		if (cpt != -1 && numrue != -1) {
			boolean b = false;
			for (Client elemt : cl) {
				if (elemt.getIdClient() == Integer.parseInt(s[0]))
					b = adminPanelControl.getAd().ModifClient(elemt, prenom.getText(), nom.getText(), numrue,
							rue.getText(), cpt, ville.getText(), pays.getText(), numTel.getText());
			}
			if (b != false) {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("adminPanel.fxml"));
				Pane mainpane = loader.load();
				modifClient.getChildren().setAll(mainpane);
			} else {
				titre.setText("Erreur d'envoie");
			}
		}
	}

	public void back() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("adminPanel.fxml"));
		Pane mainpane = loader.load();
		modifClient.getChildren().setAll(mainpane);
	}
}
