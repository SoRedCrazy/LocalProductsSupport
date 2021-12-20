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

	@FXML
	public void initialize() {
		presentation.setText(presentation.getText() + " " + ad.getPrenom());

		Id.setCellValueFactory(new PropertyValueFactory<>("Id"));
		date.setCellValueFactory(new PropertyValueFactory<>("date"));
		plus.setCellValueFactory(new PropertyValueFactory<>("plus"));

		ArrayList<TourneeClassPanel> tclaspanel = new ArrayList<TourneeClassPanel>();
		for (Tournee elemt : d.listTournee()) {
			tclaspanel.add(new TourneeClassPanel(elemt.getIdTournee(), elemt.getDate()));
		}
		ObservableList<TourneeClassPanel> Ovehi = FXCollections.observableArrayList(tclaspanel);
		tbData.setItems(Ovehi);
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
		FXMLLoader loader = new FXMLLoader(getClass().getResource("adminPanel.fxml"));
		Pane mainpane = loader.load();
		adminPanel.getChildren().setAll(mainpane);
	}

	public void supprimerVehiculeAdminPanelButton() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("adminPanel.fxml"));
		Pane mainpane = loader.load();
		adminPanel.getChildren().setAll(mainpane);
	}

	public void addClientAdminPanelButton() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("adminPanel.fxml"));
		Pane mainpane = loader.load();
		adminPanel.getChildren().setAll(mainpane);
	}

	public void supprimerClientAdminPanelButton() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("adminPanel.fxml"));
		Pane mainpane = loader.load();
		adminPanel.getChildren().setAll(mainpane);
	}

	public void supprimerEntrepriseAdminPanelButton() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("adminPanel.fxml"));
		Pane mainpane = loader.load();
		adminPanel.getChildren().setAll(mainpane);
	}

	public void modifEntrepriseAdminPanelButton() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("adminPanel.fxml"));
		Pane mainpane = loader.load();
		adminPanel.getChildren().setAll(mainpane);
	}

	public void modifClientAdminPanelButton() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("adminPanel.fxml"));
		Pane mainpane = loader.load();
		adminPanel.getChildren().setAll(mainpane);
	}

	public void addEntrepriseAdminPanelButton() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("adminPanel.fxml"));
		Pane mainpane = loader.load();
		adminPanel.getChildren().setAll(mainpane);
	}

}
