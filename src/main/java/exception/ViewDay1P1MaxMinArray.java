package exception;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ViewDay1P1MaxMinArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {0,23,2,4,50,45};
		int min=a[0];
		int max=a[0];
		
		for(int i=1; i<a.length;i++)
		{
			if(a[i]>max)
		  {
	        max=a[i];
	        
		  }
			if(a[i]<min) 
		  {
				min=a[i];
		  }
		}
         
		    System.out.println(max);
		    System.out.println(min);
		
		    
		    // using stream
		    int max2 = Arrays.stream(a).max().getAsInt();
            int min2 = Arrays.stream(a).min().getAsInt();
	        System.out.println("Using Streams " +max2);
	        System.out.println("Using Streams "+ min2);
	        
	        
	        //"Using Collections "
	        List<Integer> list = Arrays.stream(a)
                    .boxed()
                    .collect(Collectors.toList());

            System.out.println("Using Collection "+Collections.max(list));
            System.out.println("Using Collection "+Collections.min(list));
	        
	        
	        
	}

}
