package Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class NotesApp {

	public static void main(String[] args) {

		while (true) {
			System.out.println("\n1. Add Note\n2. View Notes\n3. Exit");
			Scanner sc = new Scanner(System.in);
			System.out.println("Choose an option: ");
			String choice = sc.nextLine();

			switch (choice) {
			case "1":
				System.out.println("Write your Note: ");
				String note = sc.nextLine();
				try {
					FileWriter writer = new FileWriter("Notes.txt", true);
					writer.write(note + System.lineSeparator());
					System.out.println("Note saved successfully");
					writer.close();
				} catch (IOException e) {
					System.out.println("ERROR:" + e.getMessage());
				}
				break;
				
			case "2":
				System.out.println("Your Notes");
				try {
					BufferedReader reader = new BufferedReader(new FileReader("Notes.txt"));
					String line;
					while ((line = reader.readLine()) != null) {
						System.out.println(line);
					}
					reader.close();
				} catch (IOException e) {
					System.out.println("ERROR: " + e.getMessage());
				}
				break;

			case "3":
				System.out.println("Goodbye");
				sc.close();
				System.exit(0);
				break;

			default:
				System.out.println("Invalid Option, try again");
			}
		}
	}
}
