import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class App {

	public static void main(String[] args) {
	vehical v=new vehical("bike",1245);
	vehical c=new vehical("car",1456);
	try(FileOutputStream os=new FileOutputStream("STUDYEASY\\vehical.dat")) {
		try(ObjectOutputStream ob=new ObjectOutputStream(os)){
			ob.writeObject(v);
			ob.writeObject(c);
			System.out.println("object writen ");
		}
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}

}
