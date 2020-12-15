package hackerrank.str.anagrams;

/**
 * String
 * @author Ayman Yosry
 * @link https://www.hackerrank.com/challenges/anagram/problem
 */
public class Solution1 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		String s1 = "abddddchhhccchhhhddd";
		String s2 = "cdehd";
		String s3 = "aaabbb";
		String s4 = "ab";
		String s5 = "mnop";
		String s6 = "xyyx";
		String s7 = "xaxbbbxx";
		//Test cases
		/* Input
		hhpddlnnsjfoyxpciioigvjqzfbpllssuj
		xulkowreuowzxgnhmiqekxhzistdocbnyozmnqthhpievvlj
		dnqaurlplofnrtmh
		aujteqimwfkjoqodgqaxbrkrwykpmuimqtgulojjwtukjiqrasqejbvfbixnchzsahpnyayutsgecwvcqngzoehrmeeqlgknnb
		lbafwuoawkxydlfcbjjtxpzpchzrvbtievqbpedlqbktorypcjkzzkodrpvosqzxmpad
		drngbjuuhmwqwxrinxccsqxkpwygwcdbtriwaesjsobrntzaqbe
		ubulzt
		vxxzsqjqsnibgydzlyynqcrayvwjurfsqfrivayopgrxewwruvemzy
		xtnipeqhxvafqaggqoanvwkmthtfirwhmjrbphlmeluvoa
		gqdvlchavotcykafyjzbbgmnlajiqlnwctrnvznspiwquxxsiwuldizqkkaawpyyisnftdzklwagv
		*/
		/* Output
		10
		13
		5
		26
		15 
		-1
		3
		13
		13
		-1
		 */
		String s = s7;
		System.out.println(s + "\n" + anagram(s));
	}

	static int anagram(String s) {
		int length = s.length();
		if (length % 2 != 0)
			return -1;
		String firstPart = s.substring(0, length / 2);
		String secondPart = s.substring(length / 2, length);
		int frequencyDelta = calculateDelta(firstPart, secondPart);
		return frequencyDelta;
	}

	static int calculateDelta(String first, String second) {
		int firstLetterFrquency[] = new int[26], secondLetterFrquency[] = new int[26];
		int frequencyDelta = 0;
		for (char letter : first.toCharArray())
			firstLetterFrquency[letter - 'a']++;
		for (char letter : second.toCharArray())
			secondLetterFrquency[letter - 'a']++;
		int delta = 0;
		for (int i = 0; i < 26; i++) {
			delta = secondLetterFrquency[i] - firstLetterFrquency[i];
			if (delta > 0)
				frequencyDelta += delta;
		}
		// delCounter += Math.abs( - secondLetterFrquency[i]);

		return frequencyDelta;

	}

}
