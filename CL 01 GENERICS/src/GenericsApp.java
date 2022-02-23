/*
 * T-type
 * E-element
 * K-key
 * N-number
 * v-value
 */
public class GenericsApp<T>{
	private T a;
	
public void show() {
	System.out.println(a);
}
public <T extends Number> double add(T one,T two) {
return one.doubleValue() + two.doubleValue(); 
	
}

	public static void main(String[] args) {
		GenericsApp<String> gen=new GenericsApp<String>();
		GenericsApp<Integer> genric=new GenericsApp<Integer>();
		gen.a="hello";
		genric.a=20;
		gen.show();
		genric.show();
		GenericsApp<Character> genricsapp=new GenericsApp<Character>();
		genricsapp.a='a';
		genricsapp.show();
       GenericsApp<Boolean> gn=new GenericsApp<Boolean>();
       gn.a=true;
       gn.show();
      System.out.println(gen.add(12, 13));
      System.out.println(12.555+52.858);
       
	}

}
