package scene;

import java.io.IOException;
import java.sql.Time;
import java.time.LocalTime;

import JavaObject.Commande;
import JavaObject.Tournee;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class modifCommandeControl {
	private static Commande c;
	private static Tournee t;

	@FXML
	private TextField libelle, poid, heureDebut, heureFin;
	@FXML
	private Text titre;
	@FXML
	private AnchorPane modifCommande;

	@FXML
	public void initialize() {
		titre.setText(titre.getText().replace("$IDCOMMANDE", Integer.toString(c.getIdCommande())));
	}

	public static Commande getC() {
		return c;
	}

	public static void setC(Commande c) {
		modifCommandeControl.c = c;
	}

	public static Tournee getT() {
		return t;
	}

	public static void setT(Tournee t) {
		modifCommandeControl.t = t;
	}

	public void modifCommandeButton() throws IOException {
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

		boolean b = t.modifCommande(c, libelle.getText(), poid, tdebut, tfin);
		if (b) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("infoTournee.fxml"));
			Pane mainpane = loader.load();
			modifCommande.getChildren().setAll(mainpane);
		} else {
			titre.setText("erreur d'envoie");
		}
	}
}
