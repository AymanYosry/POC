package hackerrank.dic.ransomnote;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * 
 * @author Ayman Yosry
 * @link https://www.hackerrank.com/challenges/ctci-ransom-note/problem
 */
public class Solution
{
	private Map<String, Integer> noteMap = new Hashtable<>();
	private Map<String, Integer> magazineMap = new Hashtable<>();

	// Best but not work in Hackerrank
	public void isMagazineReplica(String magazine, String note)
	{
		String regx = "[ ]+";
		String ronsomeArr[] = note.split(regx);
		String magazineArr[] = magazine.split(regx);
		String word = "";
		int wordFrequency = 0;
		for (int i = 0; i < ronsomeArr.length; i++)
		{
			word = ronsomeArr[i];
			if (noteMap.containsKey(word))
			{
				wordFrequency = (Integer) (noteMap.get(word)).intValue();
				noteMap.put(word, ++wordFrequency);
			}
			else
			{
				noteMap.put(word, 1);
			}
		}

		for (int i = 0; i < magazineArr.length; i++)
		{
			word = magazineArr[i];
			if (magazineMap.containsKey(word))
			{
				wordFrequency = (Integer) (magazineMap.get(word)).intValue();
				magazineMap.put(word, ++wordFrequency);
			}
			else
			{
				magazineMap.put(word, 1);
			}
		}

		String isReplica = "Yes";
		for (Map.Entry<String, Integer> entry : noteMap.entrySet())
		{
			if (!(magazineMap.containsKey(entry.getKey())
					&& ((Integer) (magazineMap.get(entry.getKey()))).intValue() >= entry.getValue()))
				isReplica = "No";
		}
		System.out.print(isReplica);
	}

	public void isMagazineReplica1(String magazine, String note)
	{
		String ronsomeArr[] = Pattern.compile(" ").splitAsStream(note).toArray(String[]::new); // note.split("
																								// ");
		String magazineArr[] = Pattern.compile(" ").splitAsStream(magazine).toArray(String[]::new); // magazine.split("
																									// ");
		String word = "";
		int wordFrequency = 0;
		for (int i = 0; i < ronsomeArr.length; i++)
		{
			word = ronsomeArr[i];
			if (noteMap.containsKey(word))
			{
				wordFrequency = (Integer) (noteMap.get(word)).intValue();
				noteMap.put(word, ++wordFrequency);
			}
			else
			{
				noteMap.put(word, 1);
			}
		}

		for (int i = 0; i < magazineArr.length; i++)
		{
			word = magazineArr[i];
			if (magazineMap.containsKey(word))
			{
				wordFrequency = (Integer) (magazineMap.get(word)).intValue();
				magazineMap.put(word, ++wordFrequency);
			}
			else
			{
				magazineMap.put(word, 1);
			}
		}

		String isReplica = "Yes";
		for (Map.Entry<String, Integer> entry : noteMap.entrySet())
		{
			if (!(magazineMap.containsKey(entry.getKey())
					&& ((Integer) (magazineMap.get(entry.getKey()))).intValue() >= entry.getValue()))
				isReplica = "No";
		}
		System.out.print(isReplica);
	}

	@SuppressWarnings("unused")
	private static Stream<String> stream3()
	{
		return Pattern.compile(",").splitAsStream("b,l,a");
	}

	public boolean isMagazineReplica2(String magazine, String note)
	{
		String ronsomeArr[] = note.split(" ");
		String magazineArr[] = magazine.split(" ");

		Arrays.asList(ronsomeArr).forEach(element -> {
			if (noteMap.containsKey(element))
			{
				int value = (Integer) (noteMap.get(element)).intValue();
				noteMap.put(element, ++value);
			}
			else
			{
				noteMap.put(element, 1);
			}
		});
		Arrays.asList(magazineArr).forEach(element -> {
			if (magazineMap.containsKey(element))
			{
				int value = (Integer) (magazineMap.get(element)).intValue();
				magazineMap.put(element, ++value);
			}
			else
			{
				magazineMap.put(element, 1);
			}
		});
		System.out.println("#########################################");
		magazineMap.forEach((k, v) -> System.out.println("key : " + k + " val : " + v));
		System.out.println("#########################################");
		noteMap.forEach((k, v) -> System.out.println("key : " + k + " val : " + v));
		System.out.println("#########################################");

		// noteMap.forEach((k,v) -> {isReplica = (magazineMap.containsKey(k) &&
		// ((Integer)(magazineMap.get(k))).intValue() == v)? true:false;});
		for (Map.Entry<String, Integer> entry : noteMap.entrySet())
		{
			if (!(magazineMap.containsKey(entry.getKey())
					&& ((Integer) (magazineMap.get(entry.getKey()))).intValue() >= entry.getValue()))
				return false;
		}

		return true;
	}

	public static void main(String[] args)
	{
		// Scanner scanner = new Scanner(System.in);
		// int m = 6; //scanner.nextInt();
		// int n = 4;//scanner.nextInt();

		// Eat whitespace to beginning of next line
		// scanner.nextLine();

		String magazine = "apgo clm w lxkvg mwz elo bg elo lxkvg elo apgo apgo w elo bg";// "h
																							// ghq
																							// g
																							// xxy
																							// wdnr
																							// anjst
																							// xxy
																							// wdnr
																							// h
																							// h
																							// anjst
																							// wdnr";//"avtq
																							// ekpvq
																							// z
																							// rdvzf
																							// m
																							// zu
																							// bof
																							// pfkzl
																							// ekpvq
																							// pfkzl
																							// bof
																							// zu
																							// ekpvq
																							// ekpvq
																							// ekpvq
																							// ekpvq
																							// z";//"give
																							// me
																							// one
																							// grand
																							// today
																							// night";//"two
																							// times
																							// three
																							// is
																							// not
																							// four";//"give
																							// me
																							// one
																							// grand
																							// today
																							// night";
		String ronsom = "elo lxkvg bg mwz clm w";// "m z z avtq zu bof pfkzl
													// pfkzl pfkzl rdvzf rdvzf
													// avtq ekpvq rdvzf
													// avtq";//"two times two is
													// four";//"give one grand
													// today";
		// scanner.close();
		Solution s = new Solution();
		// s.magazineNoteAnalysis(magazine, ronsome);
		// if (s.isMagazineReplica(magazine, ronsom))
		// System.out.println("Yes");
		// else
		// System.out.println("No");
		s.isMagazineReplica1(magazine, ronsom);
		// stream3().forEach(System.out::println);

	}
}
