package exception;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RemoveDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the String :");
		Scanner scan=new Scanner(System.in);
		String str=scan.nextLine();
		scan.close();
		
		Set<Character> set=new HashSet<>();
		StringBuffer sbf= new StringBuffer();
		
		for (int i=0;i< str.length();i++)
		{
			Character c = str.charAt(i);
			if (!set.contains(c))
			{
				set.add(c);
				sbf.append(c);
			}
			
		}
		
		System.out.println("String withot duplicate is "+sbf.toString());
		
	}

}
