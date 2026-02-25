package exception;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SortingAlgos {

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter count of numbers to be stored in List ");
        int listLength = scanner.nextInt();
        
        List<Integer> elements=new ArrayList<Integer>();
        
        for(int i=0;i<listLength;i++)
        {
        	
        	System.out.print("Enter number to be stored in the List ");
        	int n=scanner.nextInt();
        	elements.add(n);
        	
        	
        }
        System.out.print("Entered Numbered are:\n");
        for(int n : elements) {
        	System.out.println(n);
        }
		// TODO Auto-generated method stub
        
        
        System.out.print("Select Algorithm for Sorting:\n 1.Selection Sort \n 2.Bubble Sort \\n 3.Insertion Sort \\n 4.Quick Sort \\n 5.Merge Sort \\n 6.Heap Sort");
        int sortingAlgo=scanner.nextInt();
        int index;
        long startTime;
        long endTime;
        long elapsedTime;
        
        switch (sortingAlgo) {
        case 1:
        	startTime = System.nanoTime();
        	selectionSort(elements);
        	endTime = System.nanoTime();
        	
        	System.out.println("Sorted list is "+elements);
        	
        	elapsedTime = endTime - startTime;
            System.out.println("Elapsed time in nanoseconds: " + elapsedTime);
            System.out.println("Elapsed time in milliseconds: " + elapsedTime / 1_000_000);
            break;

        case 2:
        	startTime = System.nanoTime();
        	bubbleSort(elements);
        	endTime = System.nanoTime();
        	
        	System.out.println("Sorted list is "+elements);
        	
        	elapsedTime = endTime - startTime;
            System.out.println("Elapsed time in nanoseconds: " + elapsedTime);
            System.out.println("Elapsed time in milliseconds: " + elapsedTime / 1_000_000);
            break;
        case 3:
        	startTime = System.nanoTime();
        	insertionSort(elements);
        	endTime = System.nanoTime();
        	
        	System.out.println("Sorted list is "+elements);
        	
        	elapsedTime = endTime - startTime;
            System.out.println("Elapsed time in nanoseconds: " + elapsedTime);
            System.out.println("Elapsed time in milliseconds: " + elapsedTime / 1_000_000);
            break;
            
        case 4:
        	startTime = System.nanoTime();
        	quickSort(elements);
        	endTime = System.nanoTime();
        	
        	System.out.println("Sorted list is "+elements);
        	
        	elapsedTime = endTime - startTime;
            System.out.println("Elapsed time in nanoseconds: " + elapsedTime);
            System.out.println("Elapsed time in milliseconds: " + elapsedTime / 1_000_000);
            break;


        default:
            System.out.println("Invalid Selection.");
            break;
	}

  }

	private static void selectionSort(List<Integer> elements) 
	{
		for (int i = 0; i < elements.size()-1; i++)
		{
			
			int smallest=elements.get(i);
			for (int j = i+1; j < elements.size(); j++)
			{
				
				if(elements.get(i)>elements.get(j))
				{
					smallest=elements.get(j);
					Collections.swap(elements, i, j);
				}
				
			
				
			}
			
		}	
	}
	
	
	private static void bubbleSort(List<Integer> elements) 
	{ 
		for (int i = 0; i < elements.size(); i++)
		{
			
			int smallest=elements.get(i);
			for (int j = 0; j < elements.size()-i-1; j++)
			{
				smallest=elements.get(j);
				if(elements.get(j)>elements.get(j+1))
				{
					smallest=elements.get(j+1);
					Collections.swap(elements, j, j+1);
				}
				
			
				
			}
			
		}
		
	}
	
	private static void insertionSort(List<Integer> elements) 
	{ 
		for (int i = 1; i < elements.size(); i++)
		{
			
			int index=elements.get(i);
			for (int j = 0; j < i+1; j++)
			{
				
				if(index<elements.get(j))
				{
					
					Collections.swap(elements, i, j);
				}
				
			
				
			}
			
		}
		
	}
	
	private static void quickSort(List<Integer> elements) 
	{ 
		int arraySize=elements.size();
	    int mainPivot;
	    List<Integer> elementsSubArray1=new ArrayList<Integer>();
	    List<Integer> elementsSubArray2=new ArrayList<Integer>();
	    
		mainPivot=elements.get(arraySize/2);
		
		for (int i = 0; i <= arraySize/2; i++)
		{
			
				if(mainPivot>elements.get(i))
				{
					
					Collections.swap(elements, i, elements.indexOf(mainPivot));
				}
				
			
			
		}	
	}
	
	
}
