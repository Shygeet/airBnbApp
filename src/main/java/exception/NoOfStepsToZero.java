package exception;

import java.util.Scanner;

public class NoOfStepsToZero {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int num=s.nextInt();
		 int steps = 0;

	        while (num > 0) {
	            // Step 1: If even, divide by 2
	            if (num % 2 == 0) {
	                num = num / 2;
	            }
	            // Step 2: If odd, subtract 1
	            else {
	                num = num - 1;
	            }
	            steps++; // Count this step
	        }
	        System.out.println(steps);
	}
   
}
