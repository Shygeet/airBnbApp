package exception;

import java.util.Scanner;

public class ReverseNo {
	
	public static void main(String[] args)
	{
		Scanner s = new Scanner (System.in);
	    System.out.println("Enter number:");
	    int a= s.nextInt();
	    s.close();
	    
	    StringBuffer sb= new StringBuffer(String.valueOf(a));
	    StringBuffer rev2 = sb.reverse();
	    System.out.println("reverse number:"+rev2);
	    
	    int rev=0;
	    while(a!=0)
	    {
	    	rev=rev*10+ a%10;
	    	a=a/10;
	    	
	    }
	    System.out.println("reverse number:"+rev);
	}

}
