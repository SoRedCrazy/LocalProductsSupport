package scene;

import java.sql.Date;

import javafx.scene.control.Button;

public class TourneeClassPanel {

	private int id;
	private Date date;
	private Button button;

	public TourneeClassPanel(int id, Date date) {
		super();
		this.id = id;
		this.date = date;
		this.button = new Button("plus");
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
