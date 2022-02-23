package org.study.ob;

import java.util.ArrayList;
import java.util.List;

// wildcard
class Vehical{
	private int id;

	public Vehical(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "vehical [id=" + id + "]";
	}
	
}
class Car extends Vehical{
 private String carModel;
	public Car(int id, String carModel) {
		super(id);
		this.carModel=carModel;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	@Override
	public String toString() {
		return "Car [carModel=" + carModel + "]";
	}
	
	
}

public class App5 {

	public static void main(String[] args) {
	List<Vehical> list=new ArrayList<Vehical>();
	list.add(new Vehical(10));
	list.add(new Vehical(11));
	display(list);
	}
public static void display(List<?> list) {
	for(Object element:list) {
		System.out.println(element);
	}
}
}
