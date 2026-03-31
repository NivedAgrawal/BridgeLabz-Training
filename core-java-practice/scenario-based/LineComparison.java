package scenerio_based;

import java.util.Scanner;

public class LineComparison {
	int x1;
	int y1;
	int x2;
	int y2;

	public LineComparison() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter : (x1,y1) then (x2,y2)");
		x1 = sc.nextInt();
		y1 = sc.nextInt();
		x2 = sc.nextInt();
		y2 = sc.nextInt();
	}

	public double calculateLength() {
		double ans = 0;
		ans = Math.sqrt((Math.pow((x2 - x1), 2) + (Math.pow((y2 - y1), 2))));
		return ans;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Line Comparison Computation Program on Master Branch");
		System.out.println("Enter cordinates of line 1");
		LineComparison line1 = new LineComparison();
		Double lengthLine1 = line1.calculateLength();
		LineComparison line2 = new LineComparison();
		Double lengthLine2 = line2.calculateLength();
		System.out.printf("Length of line : %.2f \n", lengthLine1);
		System.out.printf("Length of line : %.2f \n", lengthLine2);
		System.out.println("Lines are equal :" + lengthLine1.equals(lengthLine2));
		System.out.print(
				lengthLine1 < lengthLine2 ? "line1 < line2" : (lengthLine1 > lengthLine2) ? "line1>line2" : "equal");
	}
}
