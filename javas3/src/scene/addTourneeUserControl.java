package scene;

import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
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

public class addTourneeUserControl {
	@FXML
	private TextField date, heureDebut, heureFin;
	@FXML
	private AnchorPane addTourneeUser;
	@FXML
	private Text titre;
	@FXML
	private ComboBox<String> combolist;

	DAO d = new DAO();
	private Entreprise et = userPanelControl.getEt();

	@FXML
	public void initialize() {
		ArrayList<String> vehi = new ArrayList<String>();
		for (Vehicule elemt : et.getVehicule()) {
			vehi.add(elemt.getImmatriculation());
		}
		ObservableList<String> Ovehi = FXCollections.observableArrayList(vehi);
		combolist.getItems().addAll(Ovehi);
	}

	public void addTourneeUserButton() throws IOException {
		java.sql.Date datet = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			java.util.Date d = sdf.parse(date.getText());
			datet = new java.sql.Date(d.getTime());
		} catch (ParseException e) {
			titre.setText("Erreur de le format date");
		}

		java.sql.Time tdebut = null;
		String[] words = heureDebut.getText().split(":");
		if (words.length >= 2) {
			tdebut = Time.valueOf(LocalTime.of(Integer.parseInt(words[0]), Integer.parseInt(words[1]),
					Integer.parseInt(words[2]), 1000));
		} else {
			titre.setText("Erreur de le format date debute");
		}

		java.sql.Time tfin = null;
		words = heureFin.getText().split(":");
		if (words.length >= 2) {
			tfin = Time.valueOf(LocalTime.of(Integer.parseInt(words[0]), Integer.parseInt(words[1]),
					Integer.parseInt(words[2]), 1000));
		} else {
			titre.setText("Erreur de le format date fin");
		}

		Vehicule v = null;
		String imma = combolist.getSelectionModel().getSelectedItem();
		for (Vehicule elemt : et.getVehicule()) {
			if (elemt.getImmatriculation().equals(imma)) {
				v = elemt;
			}
		}

		if (datet != null && tdebut != null && tfin != null && v != null) {
			boolean b = et.ajouterTournee(datet, tdebut, tfin, v);
			if (b) {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("userPanel.fxml"));
				Pane mainpane = loader.load();
				addTourneeUser.getChildren().setAll(mainpane);
			} else {
				titre.setText("Erreur d'envoie au serveur");
			}
		} else {
			titre.setText("Erreur de vehicule");
		}

	}

	public void back() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("userPanel.fxml"));
		Pane mainpane = loader.load();
		addTourneeUser.getChildren().setAll(mainpane);
	}
}
