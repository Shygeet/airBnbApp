package exception;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stubn
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter First Number: ");
        int n1 = scanner.nextInt();
        
        System.out.println("Enter Second Number: ");
        int n2 = scanner.nextInt();
        
        System.out.println("Enter count of Series: ");
        int c = scanner.nextInt();
        System.out.println(n1);
        System.out.println(n2);
        Fibonacci.recursionFibbo(n1,n2,c);
        for (int i=0;i<c;i++)
        {
        	
        	int sum=n1+n2;
        	n1=n2;
        	n2=sum;
        	System.out.println(n2);
        	
        }
        
        
        scanner.close();

	}


    static void recursionFibbo(int firstNo,int secNO,int count)
   {
    	 for (int i=0;i<count;i++)
         {
         	
         	int sum=firstNo+secNO;
         	firstNo=secNO;
         	secNO=sum;
         	System.out.println(sum);
         	recursionFibbo(firstNo,secNO,i++);
         	
         }
   }
	

}
