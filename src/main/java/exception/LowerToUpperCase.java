package exception;

import java.util.Scanner;

public class LowerToUpperCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner (System.in);
	    System.out.println("Enter String:");
	    String a= s.nextLine();
	    s.close();
	    String upper="";
	    
	    for (int i = 0; i < a.length(); i++) {
            char ch = a.charAt(i);

            // Check if character is lowercase (a-z)
            if (ch >= 'a' && ch <= 'z') {
                // Convert to uppercase by subtracting 32 from ASCII value
                ch = (char)(ch - 32);
            }

            upper += ch;
        }

        System.out.println("Original String: " + a);
        System.out.println("Uppercase String: " + upper);

	}

}
