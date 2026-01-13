package review;

class Human extends Species {
	public void printHello() {
		System.out.println("Hello Humans");
	}
}
public class Main{
	public static void main(String args[]) {
		Species obj = new Species();
		obj.printHello(5);
		Human obj2 = new Human();
		obj2.printHello();
		obj2.printHello(5);
	}
}