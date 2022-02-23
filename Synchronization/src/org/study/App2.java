package org.study;
class Table1{  
	  
	 synchronized static void printTable(int n){  
	   for(int i=1;i<=10;i++){  
	     System.out.println(n*i);  
	     try{  
	       Thread.sleep(400);  
	     }catch(Exception e){}  
	   }  
	 }  
	}  
	  
	class MyThread3 extends Thread{  
	public void run(){  
	Table1.printTable(1);  
	}  
	}  
	  
	class MyThread4 extends Thread{  
	public void run(){  
	Table1.printTable(10);  
	}  
	}  
	  
	class MyThread5 extends Thread{  
	public void run(){  
	Table1.printTable(100);  
	}  
	}  
	  
	  
	  
	  
	class MyThread6 extends Thread{  
	public void run(){  
	Table1.printTable(1000);  
	}  
	}  
	  
	public class App2{  
	public static void main(String t[]){  
	MyThread3 t3=new MyThread3();  
	MyThread4 t4=new MyThread4();  
	MyThread5 t5=new MyThread5();  
	MyThread6 t6=new MyThread6();  
	t3.start();  
	t4.start();  
	t5.start();  
	t6.start();  
	}  
	}  