package scene;

import java.io.IOException;

import JavaObject.Admin;
import JavaObject.DAO;
import JavaObject.Entreprise;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class LoginControleur {
	DAO d = new DAO();
	@FXML
	TextField mail, mdp;
	@FXML
	AnchorPane Loginscene;

	public void connection() throws IOException {

		if (!mail.getText().contains("@")) {
			Entreprise ent = null;
			for (Entreprise elmt : d.listEntreprise()) {
				if (mail.getText().equals(elmt.getSiret()) && mdp.getText().equals(elmt.getMdp())) {
					ent = elmt;
				}
			}
			if (ent != null) {
				userPanelControl.setEt(ent);
				FXMLLoader loader = new FXMLLoader(getClass().getResource("userPanel.fxml"));
				Pane mainpane = loader.load();
				Loginscene.getChildren().setAll(mainpane);
			}

		} else {
			Admin ad = null;
			for (Admin elmt : d.listAdmin()) {
				if (mail.getText().equals(elmt.getEmail()) && mdp.getText().equals(elmt.getPassword())) {
					ad = elmt;
				}
			}
			if (ad != null) {
				adminPanelControl.setAd(ad);
				FXMLLoader loader = new FXMLLoader(getClass().getResource("adminPanel.fxml"));
				Pane mainpane = loader.load();
				Loginscene.getChildren().setAll(mainpane);
			}
		}

	}
}
