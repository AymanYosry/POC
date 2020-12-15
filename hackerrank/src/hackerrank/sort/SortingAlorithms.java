package hackerrank.sort;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author Ayman Yosry https://www.geeksforgeeks.org/sorting-algorithms/#algo
 */
public class SortingAlorithms
{
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException
	{
		TestCase input01 = readTestCase("001");
		TestCase input02 = readTestCase("002");
		TestCase input03 = readTestCase("003");
		TestCase input04 = readTestCase("004");

		System.out.println("Array before sorting: ");
		printArray(input01.intArr);

		selectionSort(input01);
		bubbleSort(input02);
		mergeSort(input03);
		binaryInsertionSort(input04);
		countingSort(input01);
	}

	private static void selectionSort(TestCase input)
	{
		SelectionSort.sort(input.intArr);
		System.out.println("...................................\n" + "Selection Sort -> \tTime Complexity O(n^2): "
				+ SelectionSort.timeComplexity + "\tAuxiliary Space: O(1) ");
		printArray(input.intArr);
	}

	private static void bubbleSort(TestCase input)
	{
		BubbleSort.sort(input.intArr);
		System.out.println("...................................\n" + "Bubble Sort -> \tTime Complexity O(n^2): "
				+ BubbleSort.timeComplexity + "\tAuxiliary Space: O(1) ");
		printArray(input.intArr);

		BubbleSort.sort(input.intArr, input.intArr.length);
		System.out.println("Bubble Recursive Sort -> \tTime Complexity O(n^2): " + BubbleSort.timeComplexityRecursive
				+ "\tAuxiliary Space: O(?) ");
		printArray(input.intArr);
	}

	private static void mergeSort(TestCase input)
	{
		MergeSort.sort(input.intArr, 0, input.intArr.length - 1);
		System.out.println("...................................\n" + "Merge Sort -> \tTime Complexity O(n * log(n)): "
				+ MergeSort.timeComplexity + "\tAuxiliary Space: O(n) ");
		printArray(input.intArr);
	}

	private static void countingSort(TestCase input)
	{
		System.out.println("...................................");
		printArray(input.chrArr);
		CountingSort.sort(input.chrArr);
		System.out.println("Counting Sort -> \tTime Complexity O(n + k): " + CountingSort.timeComplexity
				+ "\tAuxiliary Space: O(n + k) ");
		printArray(input.chrArr);
	}

	private static void binaryInsertionSort(TestCase input)
	{
		BinaryInsertionSort.sort(input.intArr);
		System.out.println(
				"...................................\n" + "Binary Insertion Sort -> \tTime Complexity O(n * log(n)): "
						+ BinaryInsertionSort.timeComplexity + "\tAuxiliary Space: O(n) ");
		printArray(input.intArr);
	}

	private static void printArray(char[] arr)
	{
		String printStatment = "";
		for (char a : arr)
			printStatment += (a + ", ");
		printStatment = printStatment.substring(0, printStatment.lastIndexOf(","));
		System.out.println("[" + printStatment + "]");
	}

	private static void printArray(int[] arr)
	{
		String printStatment = "";
		for (int a : arr)
			printStatment += (a + ", ");
		printStatment = printStatment.substring(0, printStatment.lastIndexOf(","));
		System.out.println("[" + printStatment + "]");
	}

	private static TestCase readTestCase(String testCaseNo) throws IOException
	{
		TestCase input = new TestCase();
		String sampleInput[] = Files.lines(Paths.get("files/sort/input" + testCaseNo + ".txt")).toArray(String[]::new);
		input.intArr = Stream.of(sampleInput[0].split(" ")).mapToInt(Integer::parseInt).toArray();
		input.chrArr = sampleInput[1].toCharArray();
		return input;
	}
}
