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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class delEntrepriseControl {
	DAO d = new DAO();
	@FXML
	private ComboBox<String> combolist;
	@FXML
	private AnchorPane delEntreprise;

	@FXML
	public void initialize() {
		ArrayList<String> ent = new ArrayList<String>();
		for (Entreprise elemt : d.listEntreprise()) {
			ent.add(elemt.getSiret());
		}
		ObservableList<String> Ovehi = FXCollections.observableArrayList(ent);
		combolist.getItems().addAll(Ovehi);

	}

	public void delEntrepriseButton() throws IOException {
		String s = combolist.getSelectionModel().getSelectedItem();
		boolean b = adminPanelControl.getAd().supprimerEntreprise(s);

		if (b) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("adminPanel.fxml"));
			Pane mainpane = loader.load();
			delEntreprise.getChildren().setAll(mainpane);
		}
	}

	public void back() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("adminPanel.fxml"));
		Pane mainpane = loader.load();
		delEntreprise.getChildren().setAll(mainpane);
	}
}
