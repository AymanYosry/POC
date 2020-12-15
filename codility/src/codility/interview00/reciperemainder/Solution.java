package codility.interview00.reciperemainder;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 
 * @author Ayman Yosry
 * @problem The problem discuss to calculate remaing grames
 */
public class Solution {

	public static void main(String[] args) {
		int productProportions[] = { 1, 2, 3 };
		int availableGrams[] = { 25, 18, 72 };

		int[] remainder = calculateRemainders(productProportions, availableGrams);
		System.out.println(Arrays.stream(remainder).mapToObj(String::valueOf).collect(Collectors.joining(", ")));
	}

	static int[] calculateRemainders(int[] proportions, int[] availableGrams) {
		int[] remaining_grams = new int[proportions.length];

		int numOfProp[] = new int[proportions.length];

		for (int i = 0; i < proportions.length; i++) {
			numOfProp[i] = availableGrams[i] / proportions[i];
		}

		Arrays.sort(numOfProp);
		int minNumOfProp = numOfProp[0];

		for (int i = 0; i < proportions.length; i++) {
			remaining_grams[i] = availableGrams[i] - (minNumOfProp * proportions[i]);
		}
		return remaining_grams;

	}

}
