package scene;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import JavaObject.DAO;
import JavaObject.Entreprise;
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

public class userPanelControl {
	@FXML
	private AnchorPane userPanel;

	private static Entreprise et;

	@FXML
	private TableView<TourneeClassPanel> tbData;
	@FXML
	public TableColumn<TourneeClassPanel, Integer> Id;

	@FXML
	public TableColumn<TourneeClassPanel, Date> date;

	@FXML
	public TableColumn<TourneeClassPanel, Button> plus;

	DAO d = new DAO();
	private static AnchorPane pane;

	@FXML
	public void initialize() {
		setPane(userPanel);

		Id.setCellValueFactory(new PropertyValueFactory<TourneeClassPanel, Integer>("Id"));
		date.setCellValueFactory(new PropertyValueFactory<TourneeClassPanel, Date>("date"));
		plus.setCellValueFactory(new PropertyValueFactory<TourneeClassPanel, Button>("button"));

		ArrayList<TourneeClassPanel> tclaspanel = new ArrayList<TourneeClassPanel>();
		for (Tournee elemt : d.listTourneeentreprise(et.getSiret())) {
			tclaspanel.add(new TourneeClassPanel(elemt.getIdTournee(), elemt.getDate(), false));
		}
		ObservableList<TourneeClassPanel> Ovehi = FXCollections.observableArrayList(tclaspanel);
		tbData.setItems(Ovehi);
	}

	public static AnchorPane getPane() {
		return pane;
	}

	public static void setPane(AnchorPane pane) {
		userPanelControl.pane = pane;
	}

	public static Entreprise getEt() {
		return et;
	}

	public static void setEt(Entreprise et) {
		userPanelControl.et = et;
	}

	public void ajouterTourneeUserPanelButton() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("addTourneeUser.fxml"));
		Pane mainpane = loader.load();
		userPanel.getChildren().setAll(mainpane);
	}

	public void ajouterVehiculeUserPanelButton() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("AddVehicule.fxml"));
		Pane mainpane = loader.load();
		userPanel.getChildren().setAll(mainpane);
	}

	public void supprimerVehiculeUserPanelButton() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("delVehicule.fxml"));
		Pane mainpane = loader.load();
		userPanel.getChildren().setAll(mainpane);
	}

	public static void ChangeInterfaceTournee(Pane mainpane) throws IOException {
		pane.getChildren().setAll(mainpane);
	}

}
