package scene;

import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;

import JavaObject.DAO;
import JavaObject.Tournee;
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

public class addTourneeAdminControl {
	@FXML
	private AnchorPane addTourneeAdmin;
	@FXML
	private ComboBox<String> Camion;
	@FXML
	private TextField date, HeureDebut, heureFin;
	@FXML
	private Text textpresentation;
	DAO d = new DAO();

	@FXML
	public void initialize() {
		ArrayList<String> vehi = new ArrayList<String>();
		for (Vehicule elemt : d.listVehicule()) {
			vehi.add(elemt.getImmatriculation());
		}
		ObservableList<String> Ovehi = FXCollections.observableArrayList(vehi);
		Camion.getItems().addAll(Ovehi);
	}

	public void addTourneeAdminButton() throws IOException {
		java.sql.Date datet = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			java.util.Date d = sdf.parse(date.getText());
			datet = new java.sql.Date(d.getTime());
		} catch (ParseException e) {
			textpresentation.setText("Erreur de le format date");
		}

		java.sql.Time tdebut = null;
		String[] words = HeureDebut.getText().split(":");
		if (words.length >= 2) {
			tdebut = Time.valueOf(LocalTime.of(Integer.parseInt(words[0]), Integer.parseInt(words[1]),
					Integer.parseInt(words[2]), 1000));
		} else {
			textpresentation.setText("Erreur de le format date debute");
		}

		java.sql.Time tfin = null;
		words = heureFin.getText().split(":");
		if (words.length >= 2) {
			tfin = Time.valueOf(LocalTime.of(Integer.parseInt(words[0]), Integer.parseInt(words[1]),
					Integer.parseInt(words[2]), 1000));
		} else {
			textpresentation.setText("Erreur de le format date fin");
		}

		Vehicule v = null;
		String imma = Camion.getSelectionModel().getSelectedItem();
		for (Vehicule elemt : d.listVehicule()) {
			if (elemt.getImmatriculation().equals(imma)) {
				v = elemt;
			}
		}

		if (datet != null && tdebut != null && tfin != null && v != null) {
			Tournee t = d.ajouterTournee(datet, tdebut, tfin, v);
			if (t != null) {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("adminPanel.fxml"));
				Pane mainpane = loader.load();
				addTourneeAdmin.getChildren().setAll(mainpane);
			} else {
				textpresentation.setText("Erreur d'envoie au serveur");
			}
		} else {
			textpresentation.setText("Erreur de vehicule");
		}

	}

	public void back() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("adminPanel.fxml"));
		Pane mainpane = loader.load();
		addTourneeAdmin.getChildren().setAll(mainpane);
	}

}
