package codility.lesson03.missing.one;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * @author Ayman yosry
 * @https://app.codility.com/programmers/lessons/3-time_complexity/perm_missing_elem/
 */
public class Solution 
{

	public static void main(String[] args) 
	{
		@SuppressWarnings("unused")
		int arr2[] = {1,10,3,4,5,6,7,8,9};
		int arr[]= {3,1,2};
//		int missNo = solution(B1);
//		System.out.print(missNo);
		
		//int minvalue = Arrays.stream(arr).min().getAsInt(); 
		   
		int missNo = getMissingElementInRange(arr2);
		System.out.println(missNo);

	}

	/**
	 * get Missing Element in Range  [1, ..., n]
	 * @param arr
	 * @return
	 */
	static int minValue = 1;
	public static int getMissingElementInRange8(int []arr)
	{
		int XOR = Arrays.stream(arr).boxed().reduce(0, (x1, x2) -> x1 ^ minValue++ ^ x2);
		return XOR ^ minValue;
	}

	public static int getMissingElementInRange(int []arr)
	{
		int missingNo;
        int n = arr.length;
        if(n == 0) return 1;

        int minvalue = 1;  
		   
	    // here we xor of all the number 
	    int XOR = 0; 
	    for (int i = 0; i < n; i++) 
	    { 
	        XOR ^= (minvalue++) ^ arr[i]; 
	        //minvalue++; 
	    }
	    
	    missingNo = XOR ^ minvalue;
	    return missingNo;
	}
	
	
	/**
	 * get get Missing Element in Range  [x, ..., y]
	 * @param arr
	 * @return
	 */
	public static int getMissingElementInRange2(int []arr)
	{
		int missingNo;
        int n = arr.length;
        if(n == 0 || n == 1) return 1;

        int minvalue = Arrays.stream(arr).min().getAsInt(); 
		   
	    // here we xor of all the number 
	    int XOR = 0; 
	    for (int i = 0; i < arr.length; i++) 
	    { 
	    	XOR ^= (minvalue) ^ arr[i]; 
	        minvalue++; 
	    }
	    
	    missingNo = XOR ^ minvalue;
	    return missingNo;
	}

	public static int solution(int []A)
	{
		int missNo, sum, sequenceSum;
		int n = A.length;
		if(n == 0) return 1;
		if(n == 1) return 1;

		Arrays.sort(A);
		sum = Arrays.stream(A).sum();
		sequenceSum = A[n]*(A[n]+A[0])/2;
		
		missNo = sequenceSum - sum;
		return missNo;
	}
}
