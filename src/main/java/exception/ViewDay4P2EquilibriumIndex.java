package exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ViewDay4P2EquilibriumIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a[] = {0, 0, 0, 2, 0};
		List<Integer> eqIndexes=new ArrayList<>();
		
		for (int i = 0; i < a.length; i++) {
			int leftSum=0;
			int rightSum=0;
			for (int j = i; j < a.length; j++) {
				rightSum+=a[j];
			}
			
            for (int k = i; k >= 0; k--) {
            	leftSum+=a[k];
			}
			

              if(leftSum==rightSum) {
            	  eqIndexes.add(i);
              }
				
			
		
		
	}
		System.out.println(eqIndexes.toString());

	}

}
