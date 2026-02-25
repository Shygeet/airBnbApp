package exception;

import java.util.ArrayList;
import java.util.List;

public class ViewDay2PNonContGroupsWithSum {

    public static void main(String[] args) {

        int a[] = {2, 3, 5};
        int target = 5;
 
        //                           ind      sum
       // main only call((2,3,5); 5 ; 0 ; [] ; 0)
        
        findGroups(a, target, 0, new ArrayList<>(), 0);
    }

    static void findGroups(int[] a, int target, int index,
                           List<Integer> current, int sum) {

    	
    	//step 1.sum=0 :skip
    	//step 2.sum=2 :skip
    	//sum=5,
        if (sum == target) {
            System.out.println(current);
            return;
        }

         //1.sum=0 :skip|| index =0
    	//step 2.sum=2 :skip||index 1
        if (sum > target || index == a.length) {
            return;
        }

        // INCLUDE current element
        //1.add: 2 [2]
    	//2. add:3 [3]
        current.add(a[index]);
        //                   ind      sum
        // call1((2,3,5); 5 ; 1 ; [2] ; 2)
        //call2((2,3,5); 5 ; 2 ; [3] ; 5)
        findGroups(a, target, index + 1, current, sum + a[index]);

        // EXCLUDE current element (backtrack)
     // call1: remove 2:empty[]
        current.remove(current.size() - 1);
        // call1((2,3,5); 5 ; 1 ; [] ; 2)
        findGroups(a, target, index + 1, current, sum);
    }
}
