package scene;

import java.io.IOException;
import java.util.ArrayList;

import JavaObject.DAO;
import JavaObject.Vehicule;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class delVehiculeAdminControl {
	DAO d = new DAO();
	@FXML
	ComboBox<String> combolist;
	@FXML
	AnchorPane delVehiculeAdmin;

	@FXML
	public void initialize() {
		ArrayList<String> vehi = new ArrayList<String>();
		for (Vehicule elemt : d.listVehicule()) {
			vehi.add(elemt.getImmatriculation());
		}
		ObservableList<String> Ovehi = FXCollections.observableArrayList(vehi);
		combolist.getItems().addAll(Ovehi);

	}

	public void delVehiculeButton() throws IOException {
		String s = combolist.getSelectionModel().getSelectedItem();
		Vehicule v = new Vehicule(s, 0);
		boolean b = d.supprimerVehicule(v);
		if (b) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("adminPanel.fxml"));
			Pane mainpane = loader.load();
			delVehiculeAdmin.getChildren().setAll(mainpane);
		}
	}

	public void back() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("adminPanel.fxml"));
		Pane mainpane = loader.load();
		delVehiculeAdmin.getChildren().setAll(mainpane);
	}

}
