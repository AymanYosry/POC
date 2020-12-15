package codility.lesson05.dna;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author ayosry
 * @link https://app.codility.com/programmers/lessons/5-prefix_sums/genomic_range_query/
 */
public class Solution
{

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException
	{
		for (int i = 1; i <= 1; i++)
		{
			TestCase test = readTestCase("dna", "0"+i);
			System.out.println(test.DNA);
			int result[] = solution(test.DNA, test.P, test.Q);
			printArray(result);
			printArray(test.expectedOutput);
			System.out.println("---");
		}
	}
	
	private static int[] solution(String S, int P[], int Q[])
	{
		return minimalImpactFactor(S, P, Q);
	}
	
	private static int[] minimalImpactFactor(String DNA, int P[], int Q[])
	{
		int M = P.length;
		int factors[] = new int[M];
		String nucleotideSequence;
		for(int i = 0; i < M; i++)
		{
			nucleotideSequence = DNA.substring(P[i], Q[i] + 1);
			if(nucleotideSequence.contains("A")) factors[i] = 1;
			else if(nucleotideSequence.contains("C")) factors[i] = 2;
			else if(nucleotideSequence.contains("G")) factors[i] = 3;
			else if(nucleotideSequence.contains("T")) factors[i] = 4;
		}
		
		return factors;
	}

	private static TestCase readTestCase(String problem, String testCaseNo) throws IOException
	{
		TestCase input = new TestCase();

		String sampleInput[] = Files.lines(Paths.get("files/" + problem + "/sample" + testCaseNo + ".txt"))
				.toArray(String[]::new);
		input.DNA = sampleInput[0];
		input.P = Stream.of(sampleInput[1].split(" ")).mapToInt(Integer::parseInt).toArray();
		input.Q = Stream.of(sampleInput[2].split(" ")).mapToInt(Integer::parseInt).toArray();
		input.expectedOutput = Stream.of(sampleInput[3].split(" ")).mapToInt(Integer::parseInt).toArray();

		return input;
	}

	private static void printArray(int[] arr)
	{
		String printStatment = "";
		for (int a : arr)
			printStatment += (a + ", ");
		printStatment = printStatment.substring(0, printStatment.lastIndexOf(","));
		System.out.println("[" + printStatment + "]");
	}


}
