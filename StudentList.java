import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
	public static void main(String[] args) {

		// Check arguments
		if(ArgumentCheck(args)){
			System.out.println(Constants.VALID_ARGUMENTS);
			return;
		}
		
		String fileContents = LoadData(Constants.STUDENTS_LIST);
		if (args[Constants.ZERO].equals(Constants.SHOW_ALL)) {
			System.out.println(Constants.LOADING);
			String words[] = fileContents.split(Constants.STUDENT_ENTRY_DELIMITER);
			for (String word : words) {
				System.out.println(word);
			}
			System.out.println(Constants.DATA_LOADED);
		} else if (args[Constants.ZERO].equals(Constants.SHOW_RANDOM)) {
			System.out.println(Constants.LOADING);
			String words[] = fileContents.split(Constants.STUDENT_ENTRY_DELIMITER);
			Random random = new Random();
			int randomIndex = random.nextInt(Constants.ZERO, words.length);
			System.out.println(words[randomIndex]);
			System.out.println(Constants.DATA_LOADED);
		} else if (args[Constants.ZERO].contains(Constants.ADD_ENTRY)) {
			System.out.println(Constants.LOADING);
			String argValue = args[Constants.ZERO].substring(Constants.ONE);
			UpdateContent(argValue, Constants.STUDENTS_LIST);
			System.out.println(Constants.DATA_LOADED);
		} else if (args[Constants.ZERO].contains(Constants.FIND_ENTRY)) {
			System.out.println(Constants.LOADING);
			String words[] = fileContents.split(Constants.STUDENT_ENTRY_DELIMITER);
			int indexLocation = Constants.NEGATIVE_ONE;
			String argValue = args[Constants.ZERO].substring(Constants.ONE);
			for (int index = Constants.ZERO; index < words.length; index++) {
				if (words[index].trim().equals(argValue.trim())) {
					indexLocation = index;
					break;
				}
			}
			if (indexLocation >= Constants.ZERO){
				System.out.println(Constants.FOUND_IT);
			} else {
				System.out.println(Constants.NOT_FOUND);
			}
			System.out.println(Constants.DATA_LOADED);
		} else if (args[Constants.ZERO].contains(Constants.SHOW_COUNT)) {
			System.out.println(Constants.LOADING);
			String words[] = fileContents.split(Constants.STUDENT_ENTRY_DELIMITER);
			System.out.println(words.length + Constants.WORDS_FOUND);
			System.out.println(Constants.DATA_LOADED);
		}
	}
	public static String LoadData(String fileName) {
		String line = null;
		try {
			BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(Constants.STUDENTS_LIST)));
			return fileReader.readLine();
		} catch (Exception e) {
		}
		return null;
	}

	public static void UpdateContent(String content, String fileName) {
		try {
			BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName, true));
			fileWriter.write(Constants.STUDENT_ENTRY_DELIMITER + content + Constants.UPDATE_CONTENT + new SimpleDateFormat(Constants.DATE_STYLE).format(new Date()));
			fileWriter.close();
		} catch (Exception e) {
		}
	}

	public static boolean ArgumentCheck(String[] args) {
		if (args == null || args.length != Constants.ONE){
			return true;
		} else if (args.length == Constants.ONE && !args[Constants.ZERO].equals(Constants.SHOW_ALL) && !args[Constants.ZERO].equals(Constants.SHOW_COUNT) && !args[Constants.ZERO].equals(Constants.SHOW_RANDOM) && !args[Constants.ZERO].equals(Constants.ADD_ENTRY) && !args[Constants.ZERO].equals(Constants.FIND_ENTRY)){
			return true;
		}
		return false;
	}
}