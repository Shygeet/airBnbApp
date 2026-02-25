package exception;

import java.util.Arrays;

public class ViewDay1P5COuntEvenOdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {0,23,2,4,50,45};
		int even=0;
		int odd=0;
		
		for(int i=0; i<a.length;i++)
		{
			/*
			 * if(a[i]%2==0) { even++; } else { odd++; }
			 */
			if ((a[i] & 1) == 0)// using bitwise
			    even++;
			else
			    odd++;
		}
		
		System.out.println("evens are "+even+" Odds are "+odd);
		
		long evenn = Arrays.stream(a).filter(x -> x % 2 == 0).count();
		long oddd  = Arrays.stream(a).filter(x -> x % 2 != 0).count();

		System.out.println("Evens are " + evenn + " Odds are " + oddd);
		
		
	}

}
