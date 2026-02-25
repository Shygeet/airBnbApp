package exception;

import java.util.Scanner;

public class SwapNo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * int count = 0; for (int j = 1; j <= 3; j++) { for (int i = 1; i <= 5; i++) {
		 * System.out.println("Count for i = " + i + ": " + j);
		 * 
		 * } }
		 */
		            
		     

		 Scanner s = new Scanner (System.in);
		 /* System.out.println("Enter numbers:");
       int a= s.nextInt();
       int b= s.nextInt();
      
       
		
		 * System.out.println("Numbers before swapping:a=" +a+", b="+b); b=a+b-(a=b);
		 * System.out.println("Numbers after swapping:a=" +a+", b="+b);
		 */
       
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
       
       
	}

}
