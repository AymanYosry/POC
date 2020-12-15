/**
 * 
 */
package hackerrank.str.stringtokens;

/**
 * @author ayosry
 * @link https://www.hackerrank.com/challenges/java-string-tokens/problem 
 */
public class Solution
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		String str = new String("Hello, thanks for attempting this problem! Hope it will help you to learn java! Good luck and have a nice day!");
		tokenizeString(str);
	}

	private static void tokenizeString(String s)
	{
		String regx = "[ !,?._'@]+";
		//String regx = "[^[a-zA-Z0-9]]+";
		String[] tokens = s.split(regx);
		System.out.print(tokens.length);
		for (String token : tokens)
		{
			System.out.print("\n"+token);
		}
	}
}
