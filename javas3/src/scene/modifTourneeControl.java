package scene;

import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;

import JavaObject.DAO;
import JavaObject.Tournee;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class modifTourneeControl {
	@FXML
	private AnchorPane modifTournee;
	@FXML
	private TextField date, heureDebut, heureFin;
	@FXML
	private Text titre;

	private static Tournee t;
	DAO d = new DAO();

	public void initialize() {
		titre.setText(titre.getText().replace("$ID", Integer.toString(t.getIdTournee())));
	}

	public void modifTourneeButton() throws IOException {
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

		java.sql.Date datet = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			java.util.Date d = sdf.parse(date.getText());
			datet = new java.sql.Date(d.getTime());
		} catch (ParseException e) {
			titre.setText("Erreur de le format date");
		}
		boolean b = false;
		if (infoTourneeControl.isAdmin()) {
			t.setDate(datet);
			t.setHoraireDebut(tdebut);
			t.setHoraireFin(tfin);
			b = d.modifTournee(t);
		} else {
			b = userPanelControl.getEt().modifierTournee(datet, tdebut, tfin, t);
		}
		if (b) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("infoTournee.fxml"));
			Pane mainpane = loader.load();
			modifTournee.getChildren().setAll(mainpane);
		} else {
			titre.setText("Erreur d'envoie  des modification");
		}
	}

	public void back() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("infoTournee.fxml"));
		Pane mainpane = loader.load();
		modifTournee.getChildren().setAll(mainpane);
	}

	public static Tournee getTournee() {
		return t;
	}

	public static void setTournee(Tournee tournee) {
		modifTourneeControl.t = tournee;
	}

}
