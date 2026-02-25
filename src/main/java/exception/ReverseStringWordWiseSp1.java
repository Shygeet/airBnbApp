package exception;

import java.util.Scanner;

public class ReverseStringWordWiseSp1 {

	public static void main(String[] args) 
	{
		Scanner s = new Scanner (System.in);
	    System.out.println("Enter String:"); // ab abc
	    String a= s.nextLine();
	    s.close();
	    String rev="";
	    
	    String[] words = a.split(" ");

	    for (String word : words) {
	        System.out.println(new StringBuffer(word).reverse());
	    }

	}

}
