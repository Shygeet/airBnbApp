package exception;

import java.util.Scanner;

public class PatternRowNoThencloumnrowrelthenprint {

	public static void main(String[] args) {
		
		triangle(4, 0);
		
		 Scanner s = new Scanner (System.in);
	       System.out.println("enter no for pattern");
	       int n=s.nextInt();
	       for(int i=1;i<2*n;i++)
	       {
	    	   for(int j=1;j<2*n;j++)
	    	   {
	    		   int min=(2*n)-Math.min(Math.min(i, j), Math.min((2*n)-i, (2*n)-j));
	    		   System.out.print(min+" ");
	    	   }
	    	   System.out.println();
	       }
		// TODO Auto-generated method stub
	}    
	      

	    	    static void triangle(int r, int c) {
	    	        if (r == 0) {
	    	            return;
	    	        }

	    	        if (c < r) {
	    	            System.out.print("*");
	    	            triangle(r, c + 1);
	    	        } else {
	    	            System.out.println();
	    	            triangle(r - 1, 0);
	    	        }
	    	    
	    	


	}

}
