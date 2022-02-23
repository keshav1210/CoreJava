package org.study;

public class Bracket {
	 void generate() {
		for (int i=1;i<=10;i++) {
			if(i<=5) {
			System.out.print("[");
			}
			else {
				System.out.print("]");
			}
		}
			System.out.println();
			
	}

	public static void main(String[] args) {
		Bracket b=new Bracket();
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i=1;i<=5;i++) {
					b.generate();
				}
				
			}
			
		}).start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i=1;i<=5;i++) {
					b.generate();
				}
				
			}
			
		}).start();

	}

}
