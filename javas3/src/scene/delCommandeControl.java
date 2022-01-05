package scene;

import java.io.IOException;
import java.util.ArrayList;

import JavaObject.Commande;
import JavaObject.DAO;
import JavaObject.Tournee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class delCommandeControl {
	DAO d = new DAO();
	@FXML
	ComboBox<String> combolist;
	@FXML
	AnchorPane delCommande;
	private static Tournee tournee;

	@FXML
	public void initialize() {
		ArrayList<String> vehi = new ArrayList<String>();
		for (Commande elemt : tournee.getListCommande()) {
			vehi.add(elemt.getIdCommande() + " " + elemt.getLibelle() + " " + elemt.getPoids());
		}
		ObservableList<String> Ovehi = FXCollections.observableArrayList(vehi);
		combolist.getItems().addAll(Ovehi);

	}

	public void delVehiculeButton() throws IOException {
		String[] s = combolist.getSelectionModel().getSelectedItem().split(" ");
		boolean b = false;
		for (Commande elemt : tournee.getListCommande()) {
			if (Integer.parseInt(s[0]) == elemt.getIdCommande()) {
				b = d.supprimerCommandeTournee(elemt);
			}
		}
		if (b) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("infoTournee.fxml"));
			Pane mainpane = loader.load();
			delCommande.getChildren().setAll(mainpane);
		}
	}

	public void back() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("infoTournee.fxml"));
		Pane mainpane = loader.load();
		delCommande.getChildren().setAll(mainpane);
	}

	public static Tournee getTournee() {
		return tournee;
	}

	public static void setTournee(Tournee tournee) {
		delCommandeControl.tournee = tournee;
	}

}
