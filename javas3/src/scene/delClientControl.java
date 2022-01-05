package scene;

import java.io.IOException;
import java.util.ArrayList;

import JavaObject.Client;
import JavaObject.DAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class delClientControl {
	DAO d = new DAO();
	@FXML
	ComboBox<String> combolist;
	@FXML
	AnchorPane delClient;
	ArrayList<Client> cl = d.listClient();

	@FXML
	public void initialize() {
		ArrayList<String> cl = new ArrayList<String>();
		for (Client elemt : this.cl) {
			cl.add(elemt.getIdClient() + " " + elemt.getNom() + " " + elemt.getPrenom());
		}
		ObservableList<String> Ovehi = FXCollections.observableArrayList(cl);
		combolist.getItems().addAll(Ovehi);

	}

	public void delClientButton() throws IOException {
		boolean b = false;
		String[] s = combolist.getSelectionModel().getSelectedItem().split(" ");
		for (Client elemt : this.cl) {
			if (elemt.getIdClient() == Integer.parseInt(s[0])) {
				b = adminPanelControl.getAd().supprimerClient(elemt);
			}
		}

		if (b) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("adminPanel.fxml"));
			Pane mainpane = loader.load();
			delClient.getChildren().setAll(mainpane);
		}
	}

	public void back() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("adminPanel.fxml"));
		Pane mainpane = loader.load();
		delClient.getChildren().setAll(mainpane);
	}
}
