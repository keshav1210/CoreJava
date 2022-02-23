import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

class Data<K,V>{
	private K k;
	private V v;
	public Data(K k, V v) {
		super();
		this.k = k;
		this.v = v;
	}
	public K getK() {
		return k;
	}
	public V getV() {
		return v;
	}
	@Override
	public String toString() {
		return "Data [k=" + k + ", v=" + v + "]";
	}
	
}
public class App {

	public static void main(String[] args) {
		Comparator<Data<Integer,String>> compare_key= new Comparator<Data<Integer,String>>(){

			@Override
			public int compare(Data<Integer, String> obj1, Data<Integer, String> obj2) {
				if(obj1.getK()<obj2.getK()) {
					return(-1);
				}else if (obj1.getK()>obj2.getK()) {
					return(1);
				}else
				return 0;
			}
		};
		Comparator<Data<Integer,String>> compare_name_length= new Comparator<Data<Integer,String>>(){

			@Override
			public int compare(Data<Integer, String> obj1, Data<Integer, String> obj2) {
				if(obj1.getV().length()< obj2.getV().length()) {
					return(-1);
				} else if(obj1.getV().length()>obj2.getV().length()) {
					return(1);
				
				}else
				return 0;
			}
			
		};

		Set<Data<Integer, String>> data= new TreeSet<>(compare_name_length);
		data.add(new Data<Integer, String>(0,"value"));
		data.add(new Data<Integer, String>(1,"johan"));
		data.add(new Data<Integer, String>(2,"mohan"));
		data.add(new Data<Integer, String>(3,"night"));
		for(Data<Integer, String> element:data){
			System.out.println(element);
		}
	}

}
