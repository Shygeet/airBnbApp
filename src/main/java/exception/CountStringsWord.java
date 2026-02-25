package exception;

import java.util.Arrays;
import java.util.Scanner;

public class CountStringsWord {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.out.println("Enter the String :");
		Scanner scan=new Scanner(System.in);
		String str=scan.nextLine();
		int count =1;
		scan.close();
		for (int i=0;i< str.length();i++)
		{
			char currentChar = str.charAt(i);
			
			
			if (currentChar == ' ')
			{
				count++;
			}
			
		}
		long wordCount = Arrays.stream(str.split("\\s+"))  // Splitting by one or more spaces
                .filter(word -> !word.isEmpty())  // Filter out any empty strings (if any)
                .count();
		
		System.out.println("No of words in String is "+count);
		System.out.println("No of words in String is "+wordCount);

	}

}
