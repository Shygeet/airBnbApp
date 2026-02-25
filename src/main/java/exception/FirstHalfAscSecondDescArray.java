package exception;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class FirstHalfAscSecondDescArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter count of numbers to be stored in List ");
        int listLength = scanner.nextInt();
        
        List<Integer> elements =new ArrayList<Integer>();
        for(int i=0;i<listLength;i++)
        {
        	
        	System.out.print("Enter number to be stored in List ");
        	int n=scanner.nextInt();
        	elements.add(n);
        	
        	
        }
        System.out.print("Entered Numbered are:\n");
        for(int n : elements) {
        	System.out.println(n);
        }

        
     // Sort first half in ascending order
        for (int i = 0; i < (listLength/2) - 1; i++) {
            for (int j = i + 1; j < listLength/2; j++) {
                if (elements.get(i) > elements.get(j)) {
                    // Swap
                    int temp = elements.get(i);
                    elements.set(i, elements.get(j));
                    elements.set(j, temp);
                }
            }
        }

        // Sort second half in descending order
        for (int i = listLength/2; i < listLength - 1; i++) {
            for (int j = i + 1; j < listLength; j++) {
                if (elements.get(i) < elements.get(j)) {
                    // Swap
                	int temp = elements.get(i);
                    elements.set(i, elements.get(j));
                    elements.set(j, temp);
                }
            }
        }
       
       Collections.sort(elements.subList(0, listLength));
        //Collections.sort(elements.subList(listLength/2,listLength),Collections.reverseOrder());
        System.out.println("Sorted elements are :"+elements);
        
        
        HashMap<Integer, Boolean> map = new HashMap<>();

        System.out.println("Array after removing duplicates:");
        for (int value : elements) {
            if (!map.containsKey(value)) {
                System.out.print(value + " ");
                map.put(value, true);  // Mark as seen
            }
        }
        
	}

}
