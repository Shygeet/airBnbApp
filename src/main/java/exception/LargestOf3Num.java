package exception;

import java.util.Scanner;

public class LargestOf3Num {

	public static void main(String[] args) {
		Scanner s = new Scanner (System.in);
	    System.out.println("Enter three numbers:");
	    int n1= s.nextInt();
	    int n2= s.nextInt();
	    int n3= s.nextInt();
	    s.close();
	    
	    int largerOf2=n1>n2 ? n1:n2;
	    int largerOf3=largerOf2>n3 ? largerOf2:n3;
	    
	    System.out.println("Largest of 3 Nos is: "+largerOf3);
	    

	}

}
