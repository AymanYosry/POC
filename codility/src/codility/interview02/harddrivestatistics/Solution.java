/**
 * 
 */
package codility.interview02.harddrivestatistics;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author ayosry
 * @link D:\DEV\workspace\POC\codility\interview_problems\02
 */
public class Solution
{
	public static void main(String[] args)
	{
		String sampleLog = "" + "my.song.mp3 11b\n" + "greatSong.flac 1000b\n" + "note3.txt 5b\n" + "video.mp4 200b\n"
				+ "game.exe 100b\n" + "mov!e.mkv 10000b";
		// Output should be like
		// music 1011b
		// Images 0b
		// Movies 10200b
		// Other 105b
		System.out.println(solution(sampleLog));
		//System.out.println("asd nemr qet".matches(".*\\bnemr\\b.*"));
	}

	public static String solution(String S)
	{
		String result = "";
		for (Map.Entry<String, Integer> elment : calcualteDriveStatistics(S).entrySet())
		{
			result += elment.getKey() + " " + elment.getValue() + "b\n";
		}
		return result;
	}

	private static Map<String, Integer> calcualteDriveStatistics(String driveLog)
	{
		String music = "mp3 flac aac";
		String image = "jpg bmp gif";
		String movie = "mp4 avi mkv";

		Map<String, Integer> statMap = new LinkedHashMap<>()
		{
			private static final long serialVersionUID = 1L;
			{
				put("music", 0);
				put("images", 0);
				put("movies", 0);
				put("other", 0);
			}
		};

		String logSeparator = "\\r?\\n";
		String recordSeparator = " ";
		String nameSeparator = "[.]";// or \\.

		String driveInfo[] = driveLog.split(logSeparator);
		String fileInfo[] = null, fileName[] = null, fileType = "";
		int fileSize = 0;

		for (int i = 0; i < driveInfo.length; i++)
		{
			fileInfo = driveInfo[i].split(recordSeparator);
			fileSize = Integer.parseInt(fileInfo[1].substring(0, fileInfo[1].length() - 1));
			fileName = fileInfo[0].split(nameSeparator);
			fileType = fileName[fileName.length - 1];
			if (music.matches(".*\\b" + fileType + "\\b.*")) fileType = "music";
			else if (image.matches(".*\\b" + fileType + "\\b.*")) fileType = "images";
			else if (movie.matches(".*\\b" + fileType + "\\b.*")) fileType = "movies";
			else fileType = "other";

			fileSize += statMap.get(fileType);
			statMap.put(fileType, fileSize);
		}
		return statMap;
	}
}