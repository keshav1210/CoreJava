package org.example.ovrriding;

class Message{
	
	protected void msg() {
		System.out.println("in message class ");
	}
	
	
	/* void msg() {
			System.out.println("in message class ");
		}*/
}

public class Overriding extends Message {
	public void msg() {
		System.out.println("in  overriding class ");
	}
	
	
	
	/*protected  void msg() {
		System.out.println("in message overriding ");
	}
	*/
public static void main(String[] args) {
	Overriding override=new Overriding();
	override.msg();
	
	
	/*Message message=new Message();
	message.msg();
	*/
}
}
