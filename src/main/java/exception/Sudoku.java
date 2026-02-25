package exception;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sudoku {

	public static void main(String[] args) 
	
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter count of number of rows and columns/It should be of same dimension ");
        int rowColumn = scanner.nextInt();
        
        ArrayList<ArrayList<String>> elements = new ArrayList<>();
        
        for(int i=0;i<rowColumn;i++)
        {
        	
        	ArrayList<String> row = new ArrayList<>();
            System.out.println("Enter elements for row " + (i + 1) + ":");
            for (int j = 0; j < rowColumn; j++) {
                row.add(scanner.nextLine());
            }
            elements.add(row);
            
           
        	
        	
        }
        System.out.println("Enter elements are :"); 
        for (ArrayList<String> row : elements) {
            System.out.println(row);
        }

	}

}
