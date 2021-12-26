package scene;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import JavaObject.Admin;
import JavaObject.DAO;
import JavaObject.Tournee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class adminPanelControl {
	@FXML
	private AnchorPane adminPanel;
	@FXML
	private Text presentation;
	@FXML
	private TableView<TourneeClassPanel> tbData;
	@FXML
	public TableColumn<TourneeClassPanel, Integer> Id;

	@FXML
	public TableColumn<TourneeClassPanel, Date> date;

	@FXML
	public TableColumn<TourneeClassPanel, Button> plus;

	DAO d = new DAO();
	private static Admin ad;
	private static AnchorPane pane;

	@FXML
	public void initialize() {
		setPane(adminPanel);
		presentation.setText(presentation.getText() + " " + ad.getPrenom());

		Id.setCellValueFactory(new PropertyValueFactory<TourneeClassPanel, Integer>("Id"));
		date.setCellValueFactory(new PropertyValueFactory<TourneeClassPanel, Date>("date"));
		plus.setCellValueFactory(new PropertyValueFactory<TourneeClassPanel, Button>("button"));

		ArrayList<TourneeClassPanel> tclaspanel = new ArrayList<TourneeClassPanel>();
		for (Tournee elemt : d.listTournee()) {
			tclaspanel.add(new TourneeClassPanel(elemt.getIdTournee(), elemt.getDate(), true));
		}
		ObservableList<TourneeClassPanel> Ovehi = FXCollections.observableArrayList(tclaspanel);
		tbData.setItems(Ovehi);
	}

	public static void setPane(AnchorPane pane) {
		adminPanelControl.pane = pane;
	}

	public static Admin getAd() {
		return ad;
	}

	public static void setAd(Admin ad) {
		adminPanelControl.ad = ad;
	}

	public void addTourneeAdminPanelButton() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("addTourneeAdmin.fxml"));
		Pane mainpane = loader.load();
		adminPanel.getChildren().setAll(mainpane);
	}

	public void addVehiculeAdminPanelButton() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("addVehiculeAdmin.fxml"));
		Pane mainpane = loader.load();
		adminPanel.getChildren().setAll(mainpane);
	}

	public void supprimerVehiculeAdminPanelButton() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("delVehiculeAdmin.fxml"));
		Pane mainpane = loader.load();
		adminPanel.getChildren().setAll(mainpane);
	}

	public void addClientAdminPanelButton() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("addClient.fxml"));
		Pane mainpane = loader.load();
		adminPanel.getChildren().setAll(mainpane);
	}

	public void supprimerClientAdminPanelButton() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("delClient.fxml"));
		Pane mainpane = loader.load();
		adminPanel.getChildren().setAll(mainpane);
	}

	public void supprimerEntrepriseAdminPanelButton() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("delEntreprise.fxml"));
		Pane mainpane = loader.load();
		adminPanel.getChildren().setAll(mainpane);
	}

	public void modifEntrepriseAdminPanelButton() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("modifEntreprise.fxml"));
		Pane mainpane = loader.load();
		adminPanel.getChildren().setAll(mainpane);
	}

	public void modifClientAdminPanelButton() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifClient.fxml"));
		Pane mainpane = loader.load();
		adminPanel.getChildren().setAll(mainpane);
	}

	public void addEntrepriseAdminPanelButton() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("addEntreprise.fxml"));
		Pane mainpane = loader.load();
		adminPanel.getChildren().setAll(mainpane);
	}

	public static void ChangeInterfaceTournee(Pane mainpane) throws IOException {
		pane.getChildren().setAll(mainpane);
	}

}
