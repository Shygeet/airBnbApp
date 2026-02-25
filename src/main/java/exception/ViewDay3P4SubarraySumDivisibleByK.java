package exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ViewDay3P4SubarraySumDivisibleByK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {4,3,1,7,5,2,1,2};
		int target = 8;
		int minArray[]=new int[a.length];
		List<int[]> result = new ArrayList<>();
		
		for (int i = 0; i < a.length; i++) {
            int sum = 0;

            for (int j = i; j < a.length; j++) {
                sum += a[j];

                if (sum%target==0) {
                    // print subarray from i to j
                	 int[] subarray = Arrays.copyOfRange(a, i, j + 1);
                     result.add(subarray);
                    //System.out.println(Arrays.toString(Arrays.copyOfRange(a, i, j + 1)));
                }

                
            }
        }
		/////////////////////////////////////////////////

        System.out.println("No of subarray divisible by  " + target + ":");
        
                System.out.println(result.size());
         
        //////////////////////////////////
        System.out.println("All subarray divisible by  = " + target + ":");
        for (int[] sub : result) {
          
                System.out.println(Arrays.toString(sub));
            
        }

	}

}
