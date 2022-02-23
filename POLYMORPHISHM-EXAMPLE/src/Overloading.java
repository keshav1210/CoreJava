// method overloading examples

public class Overloading {
	
public void add(int a,int b) {
	System.out.println(a+b);
}
//******************************************************

private void add(double a,double b) {
	System.out.println(a+b);
}

//*******************************************************
public  void add(double a,int b) {
	System.out.println(a+b);
}

//******************************************************
protected void add(int a , int b, int c) {
	System.out.println(a+b+c);
}
//********************************************************
//we can not overload with changing of return type 
/*public int add(int a,int b) {
	System.out.println(a+b);
}
*/


public static Object main() {
	Overloading over=new Overloading();
	System.out.println("i am in main method");
	return over;
}

public static void main(String[] args) {
Overloading over=new Overloading();
over.add(20, 30);
over.add(20.5, 30.5);
over.add(20.5, 5);
over.add(12, 13, 15);
Overloading.main();
}
}
