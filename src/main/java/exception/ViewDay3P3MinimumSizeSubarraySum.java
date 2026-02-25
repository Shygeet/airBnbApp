package exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ViewDay3P3MinimumSizeSubarraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a[] = {4,3,5,12,5,2,1,2};
		int target = 8;
		int minArray[]=new int[a.length];
		List<int[]> result = new ArrayList<>();
		
		
		//recMethod(a,minArray);
		
		//System.out.println("All groups with sum " + target + ":");

        for (int i = 0; i < a.length; i++) {
            int sum = 0;

            for (int j = i; j < a.length; j++) {
                sum += a[j];

                if (sum == target) {
                    // print subarray from i to j
                	 int[] subarray = Arrays.copyOfRange(a, i, j + 1);
                     result.add(subarray);
                    //System.out.println(Arrays.toString(Arrays.copyOfRange(a, i, j + 1)));
                }

                if (sum > target) {
                    break; // optimization (works for positive numbers)
                }
            }
        }
        int minLength = Integer.MAX_VALUE;
        int maxLength = Integer.MIN_VALUE;
        for (int[] sub : result) {
            minLength = Math.min(minLength, sub.length);
        }
        for (int[] sub : result) {
            maxLength = Math.max(maxLength, sub.length);
        }
        
        System.out.println("No of subarray with sum = " + target + ":");
        
                System.out.println(result.size());
         
        //////////////////////////////////
        System.out.println("Minimum-length subarray(s) with sum = " + target + ":");
        for (int[] sub : result) {
            if (sub.length == minLength) {
                System.out.println(Arrays.toString(sub));
            }
        }
        ////////////////
        System.out.println("Max-length subarray(s) with sum = " + target + ":");
        for (int[] sub : result) {
            if (sub.length == maxLength) {
                System.out.println(Arrays.toString(sub));
            }
        }
        // Fix start index
		/*
		 * static void findSubarrays(int[] a, int target, int start) 
		 * { 
		 * if (start ==a.length) return;
		 * 
		 * expandSubarray(a, target, start, start, 0);
		 * 
		 * findSubarrays(a, target, start + 1); }
		 * 
		 * // Expand end index static void expandSubarray(int[] a, int target, int
		 * start, int end, int sum) { if (end == a.length || sum > target) return;
		 * 
		 * sum += a[end];
		 * 
		 * if (sum == target) { result.add(Arrays.copyOfRange(a, start, end + 1)); }
		 * 
		 * expandSubarray(a, target, start, end + 1, sum); }
		 */

	}

}
