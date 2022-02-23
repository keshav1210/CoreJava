import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class App {

	public static void main(String[] args) {
		LinkedList<String> demo= new LinkedList<>();
		demo.add("india");
		demo.add("japan");
		demo.add("australia");
		demo.add("austria");
		demo.add("USA");
		demo.add("france");
		demo.add(3, "canada");
	  new App().printing(demo);
	  demo.remove(5);
	  System.out.println("***************************");
	  new App().printing(demo);
	  Collections.reverse(demo);
	  System.out.println("***************************");
	  new App().printing(demo);
	
	}
 void printing(LinkedList<String> list) {
	 /*for(String element:list) {
		 System.out.println("countries are "+ element);*/// for each loop 
	 // using itrator 
	/* Iterator<String> iterator =list.iterator();
	 while(iterator.hasNext()) {
		 System.out.println("countries are "+ iterator.next());
	 }*/
	//	 now using list iterator 
	 ListIterator<String> iterator =list.listIterator();
	 while(iterator.hasNext()) {
		 System.out.println("countries are "+ iterator.next());
	 }
 }
}
