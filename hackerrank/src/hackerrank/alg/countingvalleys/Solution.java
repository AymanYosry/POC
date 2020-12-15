package hackerrank.alg.countingvalleys;

/**
 * @author Ayman Yosry
 * @link https://www.hackerrank.com/challenges/counting-valleys/problem
 */
public class Solution {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 32;
		String s = "UDDDUDUUUDDDUDUUDUUUUDDDUDUUDDDU";

		int result = countingValleysBest(n, s);
		System.out.println("No. of Valleys are: " + result);
	}

	/**
	 * 
	 */
	static int countingValleys(int n, String s) {
		int valleys = 0;
		int previousStep = 0, currentStep = 0;
		char steps[] = s.toCharArray();
		for (char step : steps) {
			previousStep = currentStep;
			currentStep += (step == 'U') ? 1 : -1;
			if (previousStep < 0 && currentStep == 0)
				++valleys;
		}
		return valleys;
	}

	static int countingValleys2(int n, String s) {
		int valleys = 0;
		int level = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'U') {
				level++;
			} else if (s.charAt(i) == 'D') {
				if (level == 0) {
					valleys++;
				}
				level--;
			}
		}
		return valleys;
	}

	static int countingValleysBest(int n, String s) {
		int valleys = 0;
		int level = 0;
		for (char step : s.toCharArray()) {
			level += (step == 'U') ? 1 : -1;
			if (step == 'U' && level == 0)
				++valleys;
		}
		return valleys;
	}
}
