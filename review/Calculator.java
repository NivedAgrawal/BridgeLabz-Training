package review;

public class Calculator {
	public void add(int a,int b,int c) {
		System.out.println("Add three no output"+(a+b+c));
	}
	public void add(int a,int b) {
		System.out.println("Add two no output"+(a+b));
	}
	public static void main(String args) {
		Calculator c = new Calculator();
		c.add(2,3);
		c.add(2,3,4);
	}
}
