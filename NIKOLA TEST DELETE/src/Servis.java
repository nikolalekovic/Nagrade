import java.io.FileNotFoundException;
import java.io.IOException;

public class Servis {
	
	public String InsertMail(String name, String lastname, Boolean checkbox) throws FileNotFoundException
	{
		return name+" "+lastname+" "+checkbox;
	}
	
	public String GetLastMail()
	{
		return null;
		
	}
	
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

	}
}
