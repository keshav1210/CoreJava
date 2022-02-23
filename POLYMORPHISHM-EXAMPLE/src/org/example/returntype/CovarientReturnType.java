package org.example.returntype;

class A{    
A get(){return this;}    
}  

    
class CovarientReturnType extends A{    
@Override  
CovarientReturnType get(){
System.out.println("welcome to covariant return type");
return null;
}    

    
public static void main(String args[]){    
new CovarientReturnType().get();    
}    
}    