package hackerrank.alg.comparetriplets;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 
 * @author Ayman Yosry
 * @link https://www.hackerrank.com/challenges/compare-the-triplets/problem
 */
public class Solution {

	public static void main(String[] args) {
		List<Integer> a = Stream.of(17, 28, 30).collect(Collectors.toList());
		List<Integer> b = Stream.of(99, 16, 8).collect(Collectors.toList());
		List<Integer> result = compareTriplets(a, b);
		System.out.println(
				"The Comparison ==> " + result.stream().map(Object::toString).collect(Collectors.joining(" ")) + "\n");
	}

	private static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) 
	{
		int result[] = {0,0}; 
		int i=0;
		for (Integer num : a) {
			if (num > b.get(i))
				result[0]++;
			else if(num < b.get(i))
				result[1]++;
			i++;
		} 
		return Arrays.stream(result).boxed().collect(Collectors.toList());
	}
}