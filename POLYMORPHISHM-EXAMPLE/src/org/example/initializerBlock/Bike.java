package org.example.initializerBlock;

class Bike{  
    final int speed;  
    {
      speed =30;
      }
      
        
    Bike(){System.out.println("constructor is invoked");
    System.out.println("**************************************************");}  
   
    {
    System.out.println("instance initializer block invoked");
    System.out.println(speed);
    }  
       
    public static void main(String args[]){  
    Bike b1=new Bike();  
    Bike  b2=new Bike();  
    }      
}  