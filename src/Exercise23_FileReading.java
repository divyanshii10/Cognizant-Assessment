import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exercise23_FileReading {
    public static void main(String[] args) {
        File file = new File("output.txt");
        
        if (!file.exists()) {
            System.out.println("File output.txt does not exist. Please run Exercise 22 first.");
            return;
        }
        
        System.out.println("Contents of output.txt:");
        try (Scanner fileReader = new Scanner(file)) {
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }
}
