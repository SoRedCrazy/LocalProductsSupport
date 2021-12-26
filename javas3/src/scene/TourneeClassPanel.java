package scene;

import java.io.IOException;
import java.sql.Date;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class TourneeClassPanel {

	private int id;
	private Date date;
	private Button button;
	private boolean b;
	private static AnchorPane pane;

	public static AnchorPane getPane() {
		return pane;
	}

	public static void setPane(AnchorPane pane) {
		TourneeClassPanel.pane = pane;
	}

	public TourneeClassPanel(int id, Date date, boolean b) {
		super();
		this.id = id;
		this.date = date;
		this.b = b;
		this.button = new Button("voir");
		this.getButton().setOnAction((ActionEvent event) -> {
			infoTourneeControl.setIdTournee(id);
			infoTourneeControl.setAdmin(this.b);
			FXMLLoader loader = new FXMLLoader(getClass().getResource("infoTournee.fxml"));
			Pane mainpane = null;
			try {
				mainpane = loader.load();
				if (this.b) {

					adminPanelControl.ChangeInterfaceTournee(mainpane);
				} else {
					userPanelControl.ChangeInterfaceTournee(mainpane);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Button getButton() {
		return button;
	}

	public void setButton(Button button) {
		this.button = button;
	}

}
