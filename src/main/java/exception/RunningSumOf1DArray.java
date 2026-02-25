package exception;

public class RunningSumOf1DArray {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int a[] = {2, 3, 4, 5, 2};
		int b[] = new int[a.length]; // Allocate memory for result array
		
		int sum = 0;
		for (int i = 0; i < a.length; i++)
		{
			sum += a[i];
			b[i] = sum;
		}
		
		// Print running sum array
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + " ");
		}
		

	}

}
