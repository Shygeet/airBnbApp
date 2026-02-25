package exception;

import java.util.Arrays;

public class ViewDay4P1RangeSumQuery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {4,3,1,7};
		int sum=0;
		for (int i = 1; i < a.length; i++) {
			
			
				sum=a[i-1]+a[i];
				
					a[i]=sum;
				
			
		
		
	}
		System.out.println(Arrays.toString(a));

	}
}
