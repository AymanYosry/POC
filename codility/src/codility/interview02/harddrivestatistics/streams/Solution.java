/**
 * 
 */
package codility.interview02.harddrivestatistics.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Ayman
 * @link D:\DEV\workspace\POC\codility\interview_problems\02
 */
public class Solution
{
	public static void main(String[] args) throws IOException
	{
		String sampleLog = Files.lines(Paths.get("files/drive.log")).
				map(line -> line.trim() + "\n").
				reduce("",String::concat);
		
		System.out.println(sampleLog);
		System.out.println(solution(sampleLog));
	}

	private static String result = "";
	public static String solution(String S)
	{
		calcualteDriveStatistics(S).forEach((k, v) -> result += k + " " + v + "b\n");
		return result;
	}
	
	private static String logSeparator = "\\r?\\n";
	private static String recordSeparator = " ";
	private static String nameSeparator = "[.]";// or \\.
	private static Map<String, Integer> calcualteDriveStatistics(String driveLog)
	{
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

		String lines[] = driveLog.split(logSeparator);
		Stream.of(lines).
				map(record -> record.substring(0, record.length() - 1)). //remove b
				map(record -> record.split(recordSeparator)).
				collect(Collectors.toMap(
					record -> getFileType(record[0]), 
					record -> Integer.parseInt(record[1]), 
					(v1, v2) -> v1 + v2)).forEach((k, v) -> statMap.put(k,v));

		return statMap;
	}

	private static String getFileType(String fileName)
	{
		String fileType = "other";
		String music = "mp3 flac aac";
		String image = "jpg bmp gif";
		String movie = "mp4 avi mkv";

		String fileNameArgs[] =  fileName.split(nameSeparator);
		String fileExt = fileNameArgs[fileNameArgs.length - 1];
		if (music.matches(".*\\b" + fileExt + "\\b.*")) fileType = "music";
		else if (image.matches(".*\\b" + fileExt + "\\b.*")) fileType = "images";
		else if (movie.matches(".*\\b" + fileExt + "\\b.*")) fileType = "movies";
		
		return fileType;
	}
}