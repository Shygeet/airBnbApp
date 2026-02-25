package exception;

public class ViewDay3P1MaxSumSubarrayOfSizeK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a[] = {22, 3,45,7,1,17, 5};
		int k = 3;

        recMethod(a, k, 0, Integer.MIN_VALUE);
		/*
		 * int sumArrSize = 3; int arrSum=0; int windowStartIndex=0; int
		 * MaxSumValue=Integer.MIN_VALUE;
		 * 
		 * RecMethod(a,sumArrSize,arrSum,windowStartIndex,MaxSumValue);
		 */
        
        

	}
	
	static void recMethod(int[] a, int k, int start, int maxSum) {

        // Base condition: no more windows
		//**************************************
        if (start + k > a.length) {
            System.out.println("Max Sum = " + maxSum);
            return;
        }

        // Calculate sum of current window & // Update max sum
        //****************************************
        int currentSum = 0;
        for (int i = start; i < start + k; i++) {
            currentSum += a[i];
        }
        maxSum = Math.max(maxSum, currentSum);

        // Recursive call for next window
        //****************************************
        recMethod(a, k, start + 1, maxSum);
    }
	 // First window
		/*
		 * for (int i = 0; i < k; i++) { windowSum += a[i]; }
		 * 
		 * maxSum = windowSum;
		 * 
		 * // Slide window for (int i = k; i < a.length; i++) { windowSum += a[i]; //
		 * add next windowSum -= a[i - k]; // remove previous maxSum = Math.max(maxSum,
		 * windowSum); }
		 */
	/*
	 * static void RecMethod(int a[],int sumArrSize,int arrSum,int
	 * windowStartIndex,int MaxSumValue) { int j=0; for(int i=windowStartIndex;
	 * i<a.length;i++) { arrSum+=a[i]; j++; if(j==sumArrSize-1 & i<a.length) {
	 * MaxSumValue=Math.max(MaxSumValue,arrSum); arrSum=0; windowStartIndex++;
	 * RecMethod(a,sumArrSize,arrSum,windowStartIndex,MaxSumValue); }
	 * 
	 * } System.out.println(MaxSumValue); }
	 */

}
