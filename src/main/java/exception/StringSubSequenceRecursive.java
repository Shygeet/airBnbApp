package exception;

import java.util.ArrayList;

public class StringSubSequenceRecursive {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String str = "abc";
        ArrayList<String> result = subseqRet("", str);

        System.out.println("All subsequences of \"" + str + "\":");
        for (String s : result) {
            System.out.println(s);
        }

	}
	
	 static ArrayList<String> subseqRet(String p, String up) {
	        // Base case: if nothing is left to process
	        if (up.isEmpty()) {
	            ArrayList<String> list = new ArrayList<>();
	            list.add(p);   // add the processed part
	            return list;
	        }

	        char ch = up.charAt(0);

	        
			/*
			 * subseqRet(p, up) returns an ArrayList<String> containing every subsequence
			 * you can form from the string up appended to the already-built prefix p.
			 * 
			 * At each step it looks at the first character of up and branches into two
			 * recursive calls: one that includes that character and one that excludes it.
			 * When up is empty, p is a complete subsequence and is returned as a
			 * single-element list.
			 */
	        // Include the current character
	        ArrayList<String> left = subseqRet(p + ch, up.substring(1));

	        // Exclude the current character
	        ArrayList<String> right = subseqRet(p, up.substring(1));

	        // Combine both
	        left.addAll(right);
	        return left;
	    }

}
