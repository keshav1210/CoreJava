package org.study;

import java.util.ArrayList;
import java.util.Iterator;
public class App1 {
	
public static void main(String[] args) {
	ArrayList <String>array=new ArrayList<String>();
	array.add("rahul");
	array.add("chahar");
	Iterator<String> itr=array.iterator();  
	while(itr.hasNext()){  
	System.out.println(itr.next());  
	}  
	}  

}
