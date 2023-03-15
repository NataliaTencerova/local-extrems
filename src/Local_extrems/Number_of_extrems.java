package Local_extrems;

import java.util.Locale;
import java.util.Scanner;
import java.util.Vector;

public class Number_of_extrems {

	static Scanner sc = new Scanner (System.in);
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		
		System.out.println("a: ");
		double a = sc.nextDouble();
		System.out.println("b: ");
		double b = sc.nextDouble();
		System.out.println("c: ");
		double c = sc.nextDouble();
		
		System.out.println("x1: ");
		double x1 = sc.nextDouble();
		System.out.println("x2: ");
		double x2 = sc.nextDouble();
		
//		double a = 1;
//		double b = 5;
//		double c = 0;
//		double x1 = -1;
//		double x2 = 1;
//		
		int numberMin = 0;
		int numberMax = 0;
		double deltaXone = 0;
		double deltaXtwo = 0;
		Vector<Double> function = new Vector<Double>();
		GetVector(a, b, c, x1, x2, function);		
//		System.out.println("function: "+function);
//		System.out.println("size" + (function.size()-1));
		for(int i = 1; i <= function.size()-2; i++) {
			deltaXone = function.get(i-1) - function.get(i);
			deltaXtwo = function.get(i) - function.get(i +1);
//			System.out.println("i>" + i);
//			System.out.println("vec> " + function.get(i-1) + "\tfirst function: \t"+deltaXone);
//			System.out.println("vec> " + function.get(i) + "\tsecond function: \t"+deltaXtwo);
			
			if (deltaXone < 0 && deltaXtwo > 0) {
				numberMax++;
			}
			else if (deltaXone > 0 && deltaXtwo < 0) {
				numberMin++;
			}
		}
		
		System.out.println("min: "+numberMin);
		System.out.println("max: "+numberMax);
	}
	
static  void GetVector(double a, double b, double c, double x1, double x2, Vector<Double> outFunction) {
		double delta = 1.0/1024;
		for(double x = x1-delta; x <= x2+delta ; x = x+delta) {
			outFunction.add(Math.cos(x) + (a * Math.cos(b * x + c)));
		}
//		outFunction.add(5.5);
//		System.out.println("function: \t\t"+outFunction);
	}
}