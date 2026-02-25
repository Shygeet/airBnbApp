package exception;

public class LargestPalindromeSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s="asdjaj asdjajajd";
		System.out.println(longestPalindrome(s));
		
		

	}
	public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandFromCenter(s, i, i);     // Odd length
            int len2 = expandFromCenter(s, i, i + 1); // Even length
            int len = Math.max(len1, len2);

            if (len > end - start) {
                // Update start and end indices of the longest palindrome found
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private static int expandFromCenter(String s, int left, int right) {
        // Expand as long as palindrome condition holds
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1; // Final length of the palindrome
    }
}

