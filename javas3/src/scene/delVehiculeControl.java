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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class delVehiculeControl {
	DAO d = new DAO();
	private Entreprise et = userPanelControl.getEt();
	@FXML
	ComboBox<String> combolist;
	@FXML
	AnchorPane delVehicule;

	@FXML
	public void initialize() {
		ArrayList<String> vehi = new ArrayList<String>();
		for (Vehicule elemt : et.getVehicule()) {
			vehi.add(elemt.getImmatriculation());
		}
		ObservableList<String> Ovehi = FXCollections.observableArrayList(vehi);
		combolist.getItems().addAll(Ovehi);

	}

	public void delVehiculeButton() throws IOException {
		String s = combolist.getSelectionModel().getSelectedItem();
		boolean b = false;

		Vehicule v = null;
		for (Vehicule elemt : et.getVehicule()) {
			if (s.equals(elemt.getImmatriculation())) {
				v = elemt;
			}
		}
		b = et.supprimerVehicule(v);

		if (b) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("userPanel.fxml"));
			Pane mainpane = loader.load();
			delVehicule.getChildren().setAll(mainpane);
		}
	}

	public void back() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("userPanel.fxml"));
		Pane mainpane = loader.load();
		delVehicule.getChildren().setAll(mainpane);
	}
}
