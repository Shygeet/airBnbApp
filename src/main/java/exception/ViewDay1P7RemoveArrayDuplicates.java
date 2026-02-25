package exception;

import java.util.LinkedHashSet;
import java.util.Set;

public class ViewDay1P7RemoveArrayDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {0,23,2,4,2,23};
		 
		for(int i=0; i<a.length;i++)
		{
			for(int j=1; j<a.length;j++)
			{
				if(a[i]==a[j] && i!=j)
				{
					a[j]=0;
				}
			}
		}
		for(int p :a) {
			System.out.println(p);
		}
		
		// uSing Set
		Set<Integer> set = new LinkedHashSet<>();
		  
	        for (int i : a) {
	            set.add(i);
	        }
	       System.out.println(set);
	        int[] result = new int[set.size()];
	        int index = 0;
	        for (int i : set) {
	            result[index++] = i;
	        }

	        for (int i : result) {
	            System.out.print(i + " ");
	        }
	}

}
