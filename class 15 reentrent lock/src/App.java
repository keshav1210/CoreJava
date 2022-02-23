import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class App {
	static int count=0;
	 static Lock lock = new ReentrantLock();
	public static void main(String[] args)throws InterruptedException {
		
    Thread thread1=new Thread(new Runnable() {

		@Override
		public void run() {
        lock.lock();
		for(int i=0;i<=1000;i++) {
			App.count++;
		}
		lock .unlock();
			
		}
    	
    });
    Thread thread2=new Thread(new Runnable() {

		@Override
		public void run() {
			 lock.lock();
				for(int i=0;i<=1000;i++) {
					App.count++;
				}
				lock .unlock();
					
				
		}
    	
    });
    thread1.start();
    thread2.start();
    thread1.join();
    thread2.join();
    System.out.println("count value is "+App.count);
		
	}

}
