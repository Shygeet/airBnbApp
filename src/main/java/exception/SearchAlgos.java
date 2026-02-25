package exception;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchAlgos {

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter count of numbers to be stored in List ");
        int listLength = scanner.nextInt();
        
        List<Integer> elements=new ArrayList<Integer>();
        
        for(int i=0;i<listLength;i++)
        {
        	
        	System.out.print("Enter "+i+1+ "th numbetr to be stored in List ");
        	int n=scanner.nextInt();
        	elements.add(n);
        	
        	
        }
        System.out.print("Entered Numbered are:\n");
        for(int n : elements) {
        	System.out.println(n);
        }
		// TODO Auto-generated method stub
        
        System.out.print("Enter Number to be searched:");
        int searchNum=scanner.nextInt();
        System.out.print("Select Algorithm for this search:\n 1.Linear Search\n 2.Binary Search");
        int searchAlgo=scanner.nextInt();
        int index;
        long startTime;
        long endTime;
        long elapsedTime;
        
        switch (searchAlgo) {
        case 1:
        	startTime = System.nanoTime();
        	index= linearSearch(elements,searchNum);
        	//recursiveLinearSearch(elements,searchNum,0);
        	endTime = System.nanoTime();
        	if(index==-1)
        	{
        		System.out.println("Number Not found.");
        	}
        	else
        	{
        		System.out.println("Entered No is found at index "+index);
        	}
        	
        	elapsedTime = endTime - startTime;
            System.out.println("Elapsed time in nanoseconds: " + elapsedTime);
            System.out.println("Elapsed time in milliseconds: " + elapsedTime / 1_000_000);
            break;

        case 2:
        	startTime = System.nanoTime();
        	//index= binarySearch(elements,searchNum);
        	recursiveBinarySearch(elements,searchNum,0,elements.size()-1);
        	endTime = System.nanoTime();
			
//			  if(index==-1) { System.out.println("Number Not found."); } else {
//			  System.out.println("Entered No is found at index "+index); }
			 
        	
        	elapsedTime = endTime - startTime;
            System.out.println("Elapsed time in nanoseconds: " + elapsedTime);
            System.out.println("Elapsed time in milliseconds: " + elapsedTime / 1_000_000);
            break;


        default:
            System.out.println("Invalid Selection.");
            break;
    }
        

	}
	
	public static int linearSearch(List<Integer> elements, int target) 
	{
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i) == target)
                return i;
        }
        return -1; // Not found
        
	}
	public static boolean recursiveLinearSearch(List<Integer> elements, int target, int index) {
	    if (index == elements.size()) {
	    	System.out.println("Number Not found.");
	        return false; // target not found
	        
	    }
	    if (elements.get(index) == target) {
	    	System.out.println("Number found at." + index);
	        return true; // target found
	        
	    }
	    return recursiveLinearSearch(elements, target, index + 1);
	}
	
	public static boolean recursiveBinarySearch(List<Integer> elements, int target,int start,int end) {
		 if (start > end) {
	            return false; // base case: not found
	        }

	        int mid = start + (end - start) / 2;

	        if (elements.get(mid) == target) {
	        	System.out.println("Found at position " + mid);
	            return true; // found
	        } else if (elements.get(mid) > target) {
	            return recursiveBinarySearch(elements, target, start, mid - 1); // search left half
	        } else {
	            return recursiveBinarySearch(elements, target, mid + 1, end); // search right half
	        }
	}

	public static int binarySearch(List<Integer> elements, int target) 
	{
		int low = 0, high = elements.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (elements.get(mid) == target)
                return mid;
            else if (elements.get(mid) < target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1; // Not found
        
	}
}




