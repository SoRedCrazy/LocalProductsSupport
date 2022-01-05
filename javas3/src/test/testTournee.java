package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import JavaObject.DAO;
import JavaObject.Tournee;

public class testTournee {

	Tournee t = new Tournee(1, null, null, null, null);
	DAO d = new DAO();

	@Test
	public void testAddCommande() {
		t.addCommande("chocolat", 3, null, null, null, null);
		assertTrue("Erreur", t.getListCommande().size() == 1);
		assertEquals("Erreur", t.getPoids(), 3);
		assertEquals("Erreur", t.getListCommande().get(0).getLibelle(), "chocolat");
		assertFalse("Erreur", t.getListCommande().isEmpty());
	}

	@Test
	public void testDelCommande() {
		t.delCommande(d.listCommande(t.getIdTournee()).get(0));
		assertTrue("Erreur", t.getListCommande().isEmpty());
		assertEquals("Erreur", t.getPoids(), 0);
		assertEquals("Erreur", t.toString(), "");
		assertFalse("Erreur", t.getListCommande().size() != 0);
	}

	@Test
	public void testModifCommande() {
		t.addCommande("chocolat", 3, null, null, null, null);
		t.modifCommande(d.listCommande(t.getIdTournee()).get(0), "lait", 2, null, null);
		assertTrue("Erreur", t.getListCommande().get(0).getLibelle() != "chocolat");
		assertEquals("Erreur", t.getPoids(), 2);
		assertFalse("Erreur", t.getListCommande().get(0).getLibelle() != "lait");
	}
}
