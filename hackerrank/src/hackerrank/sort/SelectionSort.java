package hackerrank.sort;

/**
 * Selection Sort Algorithm:
 * 
 * arr[] = 64 25 12 22 11
 * Find the minimum element in arr[0...4] and place it at beginning
 * 11 25 12 22 64
 * 
 * Find the minimum element in arr[1...4] and place it at beginning of arr[1...4]
 * 11 12 25 22 64
 * 
 * Find the minimum element in arr[2...4] and place it at beginning of arr[2...4]
 * 11 12 22 25 64
 * 
 * Find the minimum element in arr[3...4] and place it at beginning of arr[3...4]
 * 11 12 22 25 64 
 */
class SelectionSort
{
	static int timeComplexity = 0;
	static void sort(int arr[])
	{
		int n = arr.length;

		// One by one move boundary of unsorted subarray
		for (int i = 0; i < n - 1; i++)
		{
			// Find the minimum element in unsorted array
			int min_idx = i;
			for (int j = i + 1; j < n; j++)
			{
				if (arr[j] < arr[min_idx]) min_idx = j;
				timeComplexity++;
			}

			// Swap the found minimum element with the first
			// element
			int temp = arr[min_idx];
			arr[min_idx] = arr[i];
			arr[i] = temp;
		}
	}
}
