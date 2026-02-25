package exception;

public class ViewDay3P2FirstNegativeInWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a[] = {22, 3,45,-7,-1,17, 5};
		int k = 3;
		recMethod(a, k, 0);
	}

	private static void recMethod(int[] a, int k, int start) {
		
		
		// TODO Auto-generated method stub
		// Base condition: no more windows
				//**************************************
		        if (start + k > a.length) {
		            //System.out.println("Max Sum = " + maxSum);
		            return;
		        }
		        
		     // Calculate sum of current window & print number
		        //****************************************
		        
		        for (int i = start; i < start + k; i++) {
		            if(a[i]<0) {
		            	System.out.println("negative after "+(start+1)+" iteration "+a[i]);
		            	break;
		            }
		        }
		
		        recMethod(a, k, start+1);
	}
	
	/*
	 * private static void firstNegativeInWindow(int[] a, int k) {
	 * 
	 * Queue<Integer> q = new LinkedList<>();
	 * 
	 * for (int i = 0; i < a.length; i++) {
	 * 
	 * // Step 1: add negative numbers' indices if (a[i] < 0) { q.add(i); }
	 * 
	 * // Step 2: process window when size reaches k if (i >= k - 1) {
	 * 
	 * // Remove elements out of window while (!q.isEmpty() && q.peek() < i - k + 1)
	 * { q.poll(); }
	 * 
	 * // Print result for current window if (!q.isEmpty()) {
	 * System.out.println(a[q.peek()]); } else { System.out.println(0); } } } }
	 */

}
