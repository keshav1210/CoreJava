
public class App {
   static public int balance=0;
   public void withdraw(int amount) {
	synchronized (this) {
		if(balance<=0)
		try {
			System.out.println("waiting for balance updation ");
			System.out.println("____________________________");
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	   balance=balance-amount;
	   System.out.println(" successfully withrawal ");
	   System.out.println("*****************************************************");
	   System.out.print("*");
	   System.out.println("     your current balance is :"+balance +"                 *");
	   System.out.println("*****************************************************");
	   		
   }
   
 
public void deposit(int amount) {
	   System.out.println("we are depositing the ammount ");
	   balance =balance + amount; 
	   System.out.println("deposited amount : " +amount);
	   System.out.println("__________________________________");
	   synchronized (this) {
		   notifyAll();
	   }
   }
	public static void main(String[] args) {
	App app= new App();
	Thread thread1=new Thread (new Runnable() {

		@Override
		public void run() {
			app.withdraw(1000);
			
		}
		
	});
	thread1.start();
	Thread thread2=new Thread (new Runnable() {

		@Override
		public void run() {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			app.deposit(2000);
			
		}
	});thread2.start();

}
}
