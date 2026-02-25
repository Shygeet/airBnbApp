package exception;

public class RichestCustomerWealth2DArray {

	public static void main(String[] args) {
		
		
		        // Step 1: Input 2D array representing accounts
		        int[][] accounts = {
		            {1, 2, 3},
		            {3, 2, 1},
		            {4, 5, 1}
		        };
		        System.out.println(accounts.length); // returns NO of row
		        System.out.println(accounts[0].length);//No of column in row one 
		        
		        // Step 2: Call function to get richest customer wealth
		        int maxWealth = findRichestCustomerWealth(accounts);

		        // Step 3: Output the result
		        System.out.println("The richest customer's wealth is: " + maxWealth);
		    }

		    // Step 4: Function to calculate richest customer wealth
		    public static int findRichestCustomerWealth(int[][] accounts) {
		        int maxWealth = 0;

		        // Step 5: Loop through each customer
		        for (int i = 0; i < accounts.length; i++) {
		            int currentWealth = 0;

		            // Step 6: Sum up wealth for each customer
		            for (int j = 0; j < accounts[i].length; j++) {
		                currentWealth += accounts[i][j];
		            }

		            // Step 7: Compare with max wealth found so far
		            if (currentWealth > maxWealth) {
		                maxWealth = currentWealth;
		            }
		        }

		        return maxWealth;
		    }
		

}
