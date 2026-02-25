package exception;

import java.util.Arrays;

public class ViewDay2P2SegregateEvenOdd {

	public static void main(String[] args) {
		
		// Using Two Pointer 
		int a[]= {0,23,2,4,50,45};
		int left = 0, right = a.length - 1;

		while (left < right) {
		    while ((a[left] & 1) == 0 && left < right)
		        left++;

		    while ((a[right] & 1) == 1 && left < right)
		        right--;

		    int temp = a[left];
		    a[left] = a[right];
		    a[right] = temp;
		}
		
		System.out.println(Arrays.toString(a));
		// TODO Auto-generated method stub
		
		/*array index bound due to this approach
		 * int evenArray[]= {};
		int oddArray[]= {};
		int indexEven=0;
		int indexodd=0;
		
		for(int i=0; i<a.length;i++)
		{
			
			 * if(a[i]%2==0) { even++; } else { odd++; }
			 
			if ((a[i] & 1) == 0)// using bitwise
			{
				evenArray[indexEven]=a[i];
			    indexEven++;
			}
			    
			else
			{
				oddArray[indexodd]=a[i];
		        indexodd++;
			}
				
		}*/
		int evenCount = 0, oddCount = 0;
        for (int i = 0; i < a.length; i++) {
            if ((a[i] & 1) == 0)
                evenCount++;
            else
                oddCount++;
        }

        // Step 2: create arrays
        int evenArray[] = new int[evenCount];
        int oddArray[]  = new int[oddCount];

        // Step 3: fill even & odd arrays
        int indexEven = 0, indexOdd = 0;
        for (int i = 0; i < a.length; i++) {
            if ((a[i] & 1) == 0)
                evenArray[indexEven++] = a[i];
            else
                oddArray[indexOdd++] = a[i];
        }

        // Step 4: merge back into original array
        int k = 0;
        for (int i = 0; i < evenArray.length; i++)
            a[k++] = evenArray[i];

        for (int i = 0; i < oddArray.length; i++)
            a[k++] = oddArray[i];

        // Output
        System.out.println("Even Array: " + Arrays.toString(evenArray));
        System.out.println("Odd Array:  " + Arrays.toString(oddArray));
        System.out.println("Merged Array: " + Arrays.toString(a));
	}

}
