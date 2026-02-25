package exception;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ViewDay1P6RotateArrayBy1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {0,23,2,4,50,45};
		int temp=a[0];
		
		for(int i=0; i<a.length-1;i++)
		{
			a[i]=a[i+1];
		}
		a[a.length-1]=temp;
		for(int j :a) {
			System.out.println(j);
		}
		
		
		List<Integer> list = Arrays.asList(0,23,2,4,50,45);
		Collections.rotate(list, -1); // left rotate
	}

}
