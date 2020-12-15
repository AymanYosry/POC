package codility.lesson02.oddoccurrence;

import java.util.Arrays;

/**
 * 
 * @author ayosry
 * @link https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/
 */
public class Solution {

	@SuppressWarnings("unused")
	public static void main(String[] args) 
	{
		int A[]={9,3,9,3,9,7,9};
		int B[]={9,3,9,3,9,3,9,3,5,3,9};
		System.out.println(solution(B));
		//System.out.println(solution2(B));
	}
	
	private static int solution(int[] a)
	{
		return oddOccurrence8(a);
	}

	private static int oddOccurrence8(int... arr)
	{
		int XOR = Arrays.stream(arr).boxed().reduce(0, (x1, x2) -> x1 ^ x2);
		return XOR;
	}
	
	public static int oddOccurrence(int[] A)
	{
		int XOR = 0;
		for (int a : A)
		{
			System.out.print(XOR +" ^ "+ a +" = ");
			XOR ^= a; 
			System.out.println(XOR);
		}
		return XOR;
	}
	
	public static int oddOccurrence1(int[] A)
	{
		int unPairedIndex = 0;
		for (int i=0; i<A.length; i++)
		{
			if(i+2 == A.length) break;
			if(A[i] != A[i+2]) unPairedIndex = i+2; 
		}
		return A[unPairedIndex];
	}


	public static int oddOccurrence2(int[] A)
	{
		int unPaired = 0;
		int paired[] = new int[A.length*2];
		int sortedPaired[] = new int[A.length*2];
		int j=0;
		for(int i=0; i<A.length; i++)
		{
			if(A[i]==A[i+2]) 
			{
				paired[j++]=i;
				paired[j++]=i+2;
			}
			else
			{
				sortedPaired = paired.clone();
				Arrays.sort(sortedPaired);
				if(Arrays.binarySearch(sortedPaired, i)<0) 
				{
					unPaired = A[i];
				}
				else if(Arrays.binarySearch(sortedPaired, i+2)<0)
				{
					unPaired = A[i+2];
				}
				break;
			}
		}
		return unPaired;
	}
}
