package exception;

import java.util.Arrays;

public class ViewDay1P3SumArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {0,23,2,4,50,45};
		int sum=0;
		
		
		for(int i=0; i<a.length;i++)
		{
			sum+=a[i];
		}
		System.out.println(sum);
		
		int sum2 = Arrays.stream(a).sum();
		System.out.println("Using Stream "+sum2);
		
		
		

	}

}
