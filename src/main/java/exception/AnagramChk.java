package exception;

import java.util.Arrays;
import java.util.Scanner;

public class AnagramChk {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the String :");
		Scanner scan=new Scanner(System.in);
		String str1=scan.nextLine();
		String str2=scan.nextLine();
		
		char[] arr1=str1.trim().toCharArray();
		char[] arr2=str2.trim().toCharArray();
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		if(Arrays.equals(arr1, arr2))
		{
			System.out.println("Anagram");
		
		}
		else
		{
			System.out.println("Not a Anagram");
		}

	}

}
