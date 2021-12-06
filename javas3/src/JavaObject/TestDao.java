package JavaObject;

public class TestDao {

	public static void main(String[] args) {
		
		DAO d=new DAO();
		Entreprise et=new Entreprise(6516, 3, "ruegrevy", 37500, "azayh", "france", "julien", "nom", 00000, "azerty37");
		boolean t=d.supprimerEntreprise(et);
		
		System.out.println(t);
	}

}
