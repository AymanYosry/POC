package hackerrank.sort;

import java.util.Arrays;

class MergeSort
{
	static int timeComplexity = 0;

	static void sort(int arr[], int left, int right)
	{
		if (left < right)
		{
			// Find the middle point
			int mid = (left + right) / 2;

			// Sort first and second halves
			sort(arr, left, mid);
			sort(arr, mid + 1, right);

			// Merge the sorted halves
			merge(arr, left, mid, right);
		}
	}

	private static void merge(int[] arr, int left, int mid, int right)
	{
		// Find sizes of two subarrays to be merged
		/* Copy data to temp arrays */
		int L[] = Arrays.copyOfRange(arr, left, mid+1);
		int R[] = Arrays.copyOfRange(arr, mid+1, right+1);
		int nL = L.length;
		int nR = R.length;
		
		/* Merge the temp arrays */
		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarry array
		int k = left;
		while (i < nL && j < nR)
		{
			if (L[i] <= R[j])
			{
				arr[k++] = L[i++];
			}
			else
			{
				arr[k++] = R[j++];
			}
			timeComplexity++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < nL)
		{
			arr[k++] = L[i++];
		}

		/* Copy remaining elements of R[] if any */
		while (j < nR)
		{
			arr[k++] = R[j++];
		}
	}
}
