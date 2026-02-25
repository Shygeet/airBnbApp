package exception;

import java.util.stream.IntStream;

public class ArrayOperations {

	public static void main(String[] args) 
	{
		int[] array = {10, 20, 30, 40, 50, 60, 70, 80};

        // Print alternate elements using IntStream and filter
        IntStream.range(0, array.length)
                 .filter(i -> i % 2 == 0 || i==0) // filters alternate indices (0, 2, 4,...)
                 .map(i -> array[i])      // maps the index to array elements
                 .forEach(System.out::println); // prints the filtered elements
        
        
        int[] numbers = {1, 2, 3, 4, 5};
        int sum = 0;
   // int result = 10 / 0;
        for (int i = 0; i <= numbers.length-1; i++) {
            sum += numbers[i];
        }
        
        System.out.println("Sum: " + sum);
    

	}

}
