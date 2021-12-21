package scene;

import java.io.IOException;
import java.util.ArrayList;

import JavaObject.DAO;
import JavaObject.Entreprise;
import JavaObject.Vehicule;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class addVehiculeAdminControl {
	@FXML
	private AnchorPane addVehiculeAdmin;
	@FXML
	private ComboBox<String> entreprise;
	@FXML
	private TextField immatriculation, poid;
	@FXML
	private Text presentation;
	DAO d = new DAO();

	@FXML
	public void initialize() {
		ArrayList<String> ent = new ArrayList<String>();
		for (Entreprise elemt : d.listEntreprise()) {
			ent.add(elemt.getSiret());
		}
		ObservableList<String> Ovehi = FXCollections.observableArrayList(ent);
		entreprise.getItems().addAll(Ovehi);

	}

	public void addVehiculeButton() throws IOException {
		String imma = immatriculation.getText();
		String siret = entreprise.getSelectionModel().getSelectedItem();
		int poids = -1;
		try {
			poids = Integer.parseInt(poid.getText());
		} catch (NumberFormatException e) {
			presentation.setText("Erreur de le format int pour le poids");
		}

		if (poids != -1) {
			Vehicule v = d.ajouterVehicule(imma, poids, siret);

			if (v != null) {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("adminPanel.fxml"));
				Pane mainpane = loader.load();
				addVehiculeAdmin.getChildren().setAll(mainpane);
			} else {
				presentation.setText("Erreur envoie base de donnée");
			}
		}
	}

	public void back() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("adminPanel.fxml"));
		Pane mainpane = loader.load();
		addVehiculeAdmin.getChildren().setAll(mainpane);
	}
}
