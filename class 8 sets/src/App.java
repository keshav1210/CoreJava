import java.util.HashSet;
import java.util.Set;

public class App {

	public static void main(String[] args) {
		Set<String> set=new HashSet<>();
		set.add("keshav");
		set.add("murari");
		set.add("suraj");
		set.add("keshav");
		for(String list:set) {
			System.out.println(list);
		}
	}

}
