package JavaObject;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class TestAdmin {

	Admin a = new Admin("Gangneux", "Alexis", "mdp", "Gangneux.alexis@..fr");
	DAO d = new DAO();

	@Test
	public void testAjouterEntreprise() {
		a.ajouterEntreprise(null, null, null, null, null, null, null, null, null, null);
		ArrayList<Entreprise> list = d.listEntreprise();
		assertFalse(list.isEmpty());
	}

	Entreprise e = new Entreprise(null, null, null, null, null, null, null, null, null, null);

	@Test
	public void testSupprimerEntreprise() {
		a.supprimerEntreprise(e);
		ArrayList<Entreprise> list = d.listEntreprise();
		assertTrue(list.isEmpty());
	}

	@Test
	public void testAjouterClient() {
		a.ajouterClient(null, null, null, null, null, null, null, null);
		ArrayList<Client> list = d.listClient();
		assertFalse(list.isEmpty());

	}

	Client c = new Client(0, null, null, null, null, null, null, null, null);

	@Test
	public void testSupprimerClient() {
		a.supprimerClient(null);
		ArrayList<Client> list = d.listClient();
		assertTrue(list.isEmpty());
	}

	@Test
	public void testModifierEntreprise() {

	}

	@Test
	public void testModifierClient() {

	}

	@Test
	public void testConnexion() {

	}

}
