/** Checks if a given string is a palindrome. */
public class Palindrome {

	public static void main(String[]args) {
    	System.out.println(isPalindrome(args[0]));
    }
	
	/** Checks if the given string is a palindrome. */
	public static boolean isPalindrome(String s) {
		if (s.length() < 2) return true;

		boolean polindrom = s.charAt(0) == s.charAt(s.length() - 1);
		if (s.length() == 2) return (!polindrom) ? false : true;
		
		String newS = s.substring(1, s.length() - 2);
		return (!polindrom) ? false : true && isPalindrome(newS);
    }
}