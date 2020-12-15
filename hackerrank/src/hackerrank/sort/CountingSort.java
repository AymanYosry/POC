package hackerrank.sort;

class CountingSort
{
	static int timeComplexity = 0;

	static void sort(char arr[])
	{
		int n = arr.length;
		// The output character array that will have sorted arr
		char output[] = new char[n];

		// Create a count array to store count of inidividul
		// characters and initialize count array as 0
		int MAX = 256;
		int count[] = new int[MAX];

		// store count of each character
		for (int i = 0; i < n; ++i)
			++count[arr[i]];

		// Change count[i] so that count[i] now contains actual
		// position of this character in output array
		for (int i = 1; i < MAX; ++i)
			count[i] += count[i - 1];

		// Build the output character array
		// To make it stable we are operating in reverse order.
		int k;
		for (int i = n - 1; i >= 0; i--)
		{
			k = count[arr[i]];
			output[k - 1] = arr[i];
			--count[arr[i]];
		}

		// Copy the output array to arr, so that arr now
		// contains sorted characters
		for (int i = 0; i < n; ++i)
			arr[i] = output[i];
	}
}
