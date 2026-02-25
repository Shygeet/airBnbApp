package exception;

import java.util.Arrays;

public class ViewDay2P3PairWithSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a[]= {0,1,47,3,5,3,77,9};
		int target=12;
		int sum=0;
		/*int windowSize;
		int resultSet[]= new int[8];
		
		for(int i=0; i<a.length;i++)
		{
			windowSize=1;
			for(int j=i; j<windowSize-1;j++)
			{
				sum+=a[j];
				resultSet[j]=a[j];
				if(sum==target) {
					System.out.println(Arrays.toString(resultSet));
				}
				windowSize++;
			}
		}*/
		
		
        System.out.println("Pairs with sum " + target + ":");

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] + a[j] == target) {
                    System.out.println("(" + a[i] + ", " + a[j] + ")");
                }
            }
		
	}
	}
}
