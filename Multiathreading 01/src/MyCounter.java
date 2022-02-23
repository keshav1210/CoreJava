
public class MyCounter extends Thread {
	private int threadNo;
	public MyCounter(int threadNo) {
		this.threadNo=threadNo;
	}
	@Override
	public void run() {
		countMe();
	}
	public void countMe() {
		for(int i=1;i<=9;i++) {
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("the value of I is "+i+" and the thread number is "+threadNo);
			}
	}
	
	public static void main(String[] args) {
		MyCounter counter=new MyCounter(1);
		MyCounter counter2=new MyCounter(2);
		/*counter.run();*/
		counter.start();
		System.out.println("-------------------------------------------------------------------------------------");
		//counter2.run();
		counter2.start();
		
		
	

	}

}
