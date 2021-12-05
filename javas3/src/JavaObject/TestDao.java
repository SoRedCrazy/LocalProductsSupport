package JavaObject;

public class TestDao {

	public static void main(String[] args) {
		
		DAO d=new DAO();
		Client cl=new Client(11,"henry","boisgard",3,"rue",37200,"ville","pays",060);
		d.delclient(cl);
		System.out.println(cl.toString());
	}

}
