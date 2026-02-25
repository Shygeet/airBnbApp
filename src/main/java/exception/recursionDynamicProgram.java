package exception;

import java.util.Scanner;

public class recursionDynamicProgram {

	public static void main(String[] args) 
	{
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Select operation for this item:\n 1.Factorial\n 2.Sum of Digit \n 3.prod of digit \n 4.Reverse Number \n 5.Linear Search \n 6.Array sorted or not");
		System.out.println();
		int PerformOperation=sc.nextInt();
		System.out.println("Enter the number");
		int num = sc.nextInt();
        
 
        
        switch (PerformOperation)
   	 {
   	 case 1 :int fact =factorial(num);
   	 System.out.println(fact);
   	 break;
   	 
   	 case 2: int sum=sumOfDigit(num);
   	 System.out.println("SUm of digit is "+sum);
   	 break;
   	 
   	 case 3: int product=productOfDigit(num);
   	 System.out.println("Product of digit is "+product);
   	 break;
   	 
   	 case 4: int reverse=revOfNO(num);
  	 System.out.println("Reverse of No is "+reverse);
  	 break;
  	 
   
   	 }
	}
	
	 

	private static int revOfNO(int num) {
		// TODO Auto-generated method stub
		
		if(num/10==0)
			return num*10;
		
		else
		{
			return (num%10)*10 + revOfNO(num/10); 
			
		}
	}



	private static int productOfDigit(int num) {
		// TODO Auto-generated method stub
		if(num%10!=num)
		{
			return num%10*productOfDigit(num/10);
		}
		else
			return num;
	}



	private static int sumOfDigit(int num) {
		
		
		if(num>0)
		{
			return num%10+sumOfDigit(num/10);
		}
		else
			return 0;
		
		// TODO Auto-generated method stub
		
	}



	private static int factorial(int num) {
		// TODO Auto-generated method stub
		if(num<=1)
		{
			return 1;
		}
		else {
			return num*factorial(num-1);
			
		}
		
	}

}
