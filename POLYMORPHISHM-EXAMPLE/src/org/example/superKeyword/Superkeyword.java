package org.example.superKeyword;
//super is used to refer immediate parent class instance variable
class ParentClass{
	int a=12;
	
}
class childClass extends ParentClass{
	int b=30;
	 public void show(){
		 System.out.println(super.a+b);
	 }
}


public class Superkeyword {
	
	
public static void main(String[] args) {
	childClass childClass=new childClass();
childClass.show();
}
}
