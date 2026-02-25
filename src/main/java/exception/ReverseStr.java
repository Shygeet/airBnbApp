package exception;

import java.util.Scanner;

public class ReverseStr {

	public static void main(String[] args) {
		Scanner s = new Scanner (System.in);
	    System.out.println("Enter String:");
	    String a= s.nextLine();
	    s.close();
	    String rev="";
	    
	    int len=a.length();
	    for(int i=len-1;i>=0;i--)
	    {
	    	rev=rev+ a.charAt(i);
	    }
	    System.out.println("reverse String:"+rev);
	    rev="";
	    char arr[]=a.toCharArray();
	    for(int i=arr.length-1;i>=0;i--)
	    {
	    	rev=rev+ a.charAt(i);
	    }
	    System.out.println("reverse String:"+rev);
	    
	}

}
