package JavaObject;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

public class TestDao {

	public static void main(String[] args) {

		DAO d = new DAO();
		Client cl = new Client(2, "julien", "boisgard", 3, "grevy", 37200, "azay", "France", "0604186555");
		Entreprise en = new Entreprise("000000fdf00", 3, "grevy", 37200, "ville", "france", "boisgard", "julien",
				"0604186555", "azerty37");
		Vehicule ve = new Vehicule("test", 50);

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2021);
		cal.set(Calendar.MONTH, Calendar.DECEMBER);
		cal.set(Calendar.DAY_OF_MONTH, 6);
		Date d1 = new Date(cal.getTime().getTime());
		cal.set(Calendar.HOUR, 3);
		cal.set(Calendar.MINUTE, 00);
		cal.set(Calendar.SECOND, 00);
		Time t1 = new Time(cal.getTime().getTime());
		cal.set(Calendar.HOUR, 13);
		Time t2 = new Time(cal.getTime().getTime());
		LocalDate localDate = LocalDate.of(2015, 3, 2);

		Tournee te = new Tournee(1, d1, t1, t2, ve);
		Commande co = d.ajouterCommandeTournee("poire", 10, t1, t2, cl, en, te);
		ArrayList<Commande> t = d.listCommande(te);
		System.out.println(t.size());
		for (Commande elmt : t) {
			System.out.println(elmt.toString());
		}

	}

}
