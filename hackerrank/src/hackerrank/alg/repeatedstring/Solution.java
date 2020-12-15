package hackerrank.alg.repeatedstring;

/**
 * @author Ayman Yosry
 * @link https://www.hackerrank.com/challenges/repeated-string/problem
 */
public class Solution {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//long n = 1000000000000L;
		long n =11;
		//String s = "aba";//"a";
		//String s = "a";
		String s = "abcac";
		long result = repeatedString(s, n);
		System.out.println("No. of Occurance of 'a' is: " + result);
	}

	static long repeatedString(String s, long n) {
		long letterFrequency = repeat(s,(n/s.length()));
		String repeatedReminder = s.substring(0,(int) (n%s.length()));
		letterFrequency += repeatedReminder.codePoints().filter(ch -> ch=='a').count();
		return letterFrequency;
    }
	
	private static long repeat(String s, long n) {
		long letterFrequency = s.codePoints().filter(ch -> ch=='a').count(); 
		return letterFrequency*n;
	}
	@SuppressWarnings("unused")
	private static String repeat2(String s, long n) {
		String repeted="";
		//long occurance = 
		for(int i=0; i<n; i++) repeted+=s;
		return repeted;
	}
}
