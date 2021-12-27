package scene;

import java.io.IOException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;

import JavaObject.Client;
import JavaObject.DAO;
import JavaObject.Tournee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class addCommandeControl {
	private static Tournee tournee;
	DAO d = new DAO();
	ArrayList<Client> cl = d.listClient();

	@FXML
	private AnchorPane addCommande;
	@FXML
	private ComboBox<String> combolist;
	@FXML
	private TextField libelle, heureDebut, heureFin, poid;
	@FXML
	private Text titre;

	@FXML
	public void initialize() {
		ArrayList<String> cl = new ArrayList<String>();
		for (Client elemt : this.cl) {
			cl.add(elemt.getIdClient() + " " + elemt.getNom() + " " + elemt.getPrenom());
		}
		ObservableList<String> Ovehi = FXCollections.observableArrayList(cl);
		combolist.getItems().addAll(Ovehi);

	}

	public static Tournee getTournne() {
		return tournee;
	}

	public static void setTournne(Tournee tournne) {
		addCommandeControl.tournee = tournne;
	}

	public void addCommandeButton() throws IOException {
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

		int poid = -1;
		try {
			poid = Integer.parseInt(this.poid.getText());
		} catch (NumberFormatException e) {
			titre.setText("Erreur de paramettres niveau poids");
		}

		boolean b = false;
		String[] s = combolist.getSelectionModel().getSelectedItem().split(" ");
		for (Client elemt : this.cl) {
			if (elemt.getIdClient() == Integer.parseInt(s[0])) {
				b = tournee.addCommande(libelle.getText(), poid, tdebut, tfin, elemt,
						d.getSiretTournee(tournee.getIdTournee()));
			}
		}
		if (b) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("infoTournee.fxml"));
			Pane mainpane = loader.load();
			addCommande.getChildren().setAll(mainpane);
		} else {
			titre.setText("erreur d'envoie");
		}
	}

	public void back() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("infoTournee.fxml"));
		Pane mainpane = loader.load();
		addCommande.getChildren().setAll(mainpane);
	}

}
