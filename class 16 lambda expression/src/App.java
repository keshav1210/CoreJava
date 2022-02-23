interface Brakets{
	void demo();
}
public class App {

	public static void main(String[] args) {
	//Thread thread=new Thread (()-> System.out.println("statment1 "));
		Thread thread=new Thread (()->{
			System.out.println("statment1 ");
		 System.out.println("statment2 ");
		});
		thread.start();
	}

}
