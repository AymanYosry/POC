package hackerrank.dst.stack;

public class Solution
{
	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		String S1[] = { "{[()]}", "{[(])}", "{{[[(())]]}}" };
		String S2[] = { "{{([])}}", "{{)[](}}" };
		String S3[] = { "{(([])[])[]}", "{(([])[])[]]}", "{(([])[])[]}[]" };
		String S[] = S3;
		for (String s : S)
			System.out.println(isBalanced(s));
	}

	private static String isBalanced(String s)
	{
		int n = s.length();
		if (n == 0) return "YES";
		if (n % 2 != 0) return "NO";
		
		boolean balanced = areParenthesisBalanced(s.toCharArray());
		if (balanced) return "YES";
		else return "NO";
	}

	/*
	 * Return true if expression has balanced Parenthesis
	 */
	static boolean areParenthesisBalanced(char exp[])
	{
		Stack<Character> st = new Stack<>();

		for (int i = 0; i < exp.length; i++)
		{
			if (exp[i] == '{' || exp[i] == '(' || exp[i] == '[') st.push(exp[i]);
			if (exp[i] == '}' || exp[i] == ')' || exp[i] == ']')
			{
				if (st.isEmpty()) return false;
				char bracket = st.pop().charValue();
				if (!isMatchingPair(bracket, exp[i])) return false;
			}
		}

		if (st.isEmpty()) return true; /* balanced */
		else return false;
	}

	/*
	 * Returns true if character1 and character2 are matching left and right
	 * Parenthesis
	 */
	private static boolean isMatchingPair(char character1, char character2)
	{
		if (character1 == '(' && character2 == ')') return true;
		else if (character1 == '{' && character2 == '}') return true;
		else if (character1 == '[' && character2 == ']') return true;
		else return false;
	}

	@SuppressWarnings("unused")
	private static String badIsBalanced(String s)
	{
		final int openCurlBracket = '{', closeCurlBracket = '}';
		final int oepenSquareBracket = '[', closeSquareBracket = ']';
		final int openCircleBracket = '(', closeCircleBracket = ')';

		int n = s.length();
		if (n == 0) return "YES";
		if (n % 2 != 0) return "NO";
		int start, end;

		// for (int i = 0, j = n - 1; i < n / 2 && j >= n / 2; i++, j--)
		for (int i = 0, j = n - 1; j > i; i++, j--)
		{
			start = s.charAt(i);
			end = s.charAt(j);
			switch (start)
			{
			case openCurlBracket:
				if (end != closeCurlBracket) return "NO";
				break;
			case oepenSquareBracket:
				if (end != closeSquareBracket) return "NO";
				break;
			case openCircleBracket:
				if (end != closeCircleBracket) return "NO";
				break;
			}
		}

		return "YES";
	}
}
