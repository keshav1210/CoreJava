import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class App {

	public static void main(String[] args) {
	Queue<Integer>queue=new LinkedBlockingQueue<>(76);
	try {
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		queue.add(5);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	for(Integer element:queue) {
		System.out.println(element);
	}
}

}
