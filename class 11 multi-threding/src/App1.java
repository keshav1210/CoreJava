
// creating the thread by extending thred class 
class Mycounter extends Thread{
	private int threadno;

	public Mycounter(int threadno) {
		this.threadno = threadno;
	}
     @Override
    public void run() {
    	countme();
    }
	public void countme() {
		for(int i=0;i<9;i++) {
			try {
				sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("numbers are "+i+" thread numbers are "+threadno);
		}
			
	}
	
	
}
public class App1 {

	public static void main(String[] args) {
	  Mycounter mycounter1=new Mycounter(1);
	  Mycounter mycounter2=new Mycounter(2);
	  long starttime=System.currentTimeMillis();
	  mycounter1.countme();
	  System.out.println("************************************");
	  mycounter2.countme();
	long endtime=System.currentTimeMillis();
	System.out.println("time duration is "+(endtime-starttime));
	System.out.println("now using symenteously running thread with the help of start function ");
	mycounter1.start();
	System.out.println("##################################################");
	mycounter2.start();

	}

}
