package org.study.ob;
// BOUNDED TYPE PARAMETER
class Data<K, V>{
	private K key;
	private V value;
	
	public Data(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}
	@Override
	public String toString() {
		return "Data [key=" + key + ", value=" + value + "]";
	}
	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	public <E extends String,N extends Number> void display(E element,N number) {
		System.out.println("Elements: "+element+" "+"Numbers: "+number);
	}
}

public class App4 {
public static void main(String[] args) {
Data <Integer,String>data=new Data<Integer,String>(1, "value");	
data.display("marks", 25);
}
}
