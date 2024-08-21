package Task25;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class FileSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the path address of the directory:");
        String userInput = scanner.nextLine();

        Path path = Paths.get(userInput);

        if (Files.isDirectory(path)) {
            try {
                printDirectory(path,0);
            } catch (IOException e) {
                System.err.println("Error reading the directory: " + e.getMessage());
            }
        } else {
            System.out.println("The provided path is not a directory.");
        }
    }
    private static void printDirectory(Path path, int level) throws IOException {
        printWithIndent(path, level);
        try (Stream<Path> paths = Files.list(path)) {
            paths.forEach(filePath -> {
                try {
                    if (Files.isDirectory(filePath)) {
                        printDirectory(filePath, level + 1);
                    } else {
                        printWithIndent(filePath, level + 1);
                    }
                } catch (IOException e) {
                    System.err.println("Error reading " + filePath + ": " + e.getMessage());
                }
            });
        }
    }

    private static void printWithIndent(Path path, int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }
        System.out.println("|__"+path.getFileName());
    }
}
