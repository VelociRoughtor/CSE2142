import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
	public static void main(String[] args) {

		// Check arguments
		if(args == null || args.length != 1){
			System.out.println("Available inputs : a | r | c | ?StudentName | +StudentName");
			return;
		}
		if (args[0].equals("a")) {
			System.out.println("Loading data ...");
			try {
				BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
				String fileContents = fileReader.readLine();
				String words[] = fileContents.split(", ");
				for (String word : words) {
					System.out.println(word);
				}
			} catch (Exception e) {
			}
			System.out.println("Data Loaded.");
		} else if (args[0].equals("r")) {
			System.out.println("Loading data ...");
			try {
				BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
				String fileContents = fileReader.readLine();
				// System.out.println(r);
				String words[] = fileContents.split(", ");
				Random random = new Random();
				int randomIndex = random.nextInt(0, words.length);
				System.out.println(words[randomIndex]);
			} catch (Exception e) {
			}
			System.out.println("Data Loaded.");
		} else if (args[0].contains("+")) {
			System.out.println("Loading data ...");
			try {
				BufferedWriter fileReader = new BufferedWriter(new FileWriter("students.txt", true));
				String argValue = args[0].substring(1);
				Date newDate = new Date();
				String dateStyle = "dd/mm/yyyy-hh:mm:ss a";
				DateFormat dateFormat = new SimpleDateFormat(dateStyle);
				String now = dateFormat.format(newDate);
				fileReader.write(", " + argValue + "\nList last updated on " + now);
				fileReader.close();
			} catch (Exception e) {
			}

			System.out.println("Data Loaded.");
		} else if (args[0].contains("?")) {
			System.out.println("Loading data ...");
			try {
				BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
				String fileContents = fileReader.readLine();
				String words[] = fileContents.split(", ");
				boolean done = false;
				String argValue = args[0].substring(1);
				for (int index = 0; index < words.length && !done; index++) {
					if (words[index].equals(argValue)) {
						System.out.println("We found it!");
						done = true;
					}
				}
			} catch (Exception e) {
			}
			System.out.println("Data Loaded.");
		} else if (args[0].contains("c")) {
			System.out.println("Loading data ...");
			try {
				BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
				String fileContents = fileReader.readLine();
				char characters[] = fileContents.toCharArray();
				boolean in_word = false;
				int count = 0;
				for (char character : characters) {
					if (character == ' ') {
						if (!in_word) {
							count++;
							in_word = true;
						} else {
							in_word = false;
						}
					}
				}
				System.out.println(count + " word(s) found ");
			} catch (Exception e) {
			}
			System.out.println("Data Loaded.");
		}
	}
}