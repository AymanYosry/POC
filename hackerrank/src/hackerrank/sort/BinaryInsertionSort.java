package hackerrank.sort;

import java.util.Arrays;

class BinaryInsertionSort
{
	static int timeComplexity = 0;
	static void sort(int arr[]) 
	{
		int n = arr.length;

		// One by one move boundary of unsorted subarray
		for (int i = 1; i < n; i++)
		{
			int x = arr[i]; 
			  
            // Find location to insert using binary search 
            int j = Math.abs(Arrays.binarySearch(arr, 0, i, x) + 1); 
  
            //Shifting array to one location right 
            System.arraycopy(arr, j, arr, j+1, i-j); 
  
            //Placing element at its correct location 
            arr[j] = x; 
		}
	}
}
