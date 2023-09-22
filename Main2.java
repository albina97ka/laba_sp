import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main2 {

    public static void sequentialCopy(String sourcePath, String destinationPath) {
        try (FileReader reader = new FileReader(sourcePath);
             FileWriter writer = new FileWriter(destinationPath)) {
            int character;
            while ((character = reader.read()) != -1) {
                writer.write(character);
            }
            System.out.println("Последовательное завершено успешно!");
        } catch (IOException e) {
            System.err.println("Произошла ошибка при последовательном копировании: " + e.getMessage());
        }
    }

    public static void parallelCopy(String sourcePath, String destinationPath) {
        Thread copyThread = new Thread(() -> {
            try (FileReader reader = new FileReader(sourcePath);
                 FileWriter writer = new FileWriter(destinationPath)) {
                int character;
                while ((character = reader.read()) != -1) {
                    writer.write(character);
                }
                System.out.println("Параллельное завершено успешно!");
            } catch (IOException e) {
                System.err.println("Произошла ошибка при параллельном копировании: " + e.getMessage());
            }
        });

        copyThread.start();
        try {
            copyThread.join();
        } catch (InterruptedException e) {
            System.err.println("Произошла ошибка при ожидании завершения параллельного потока копирования: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String sourceFile1 = "file1";
        String destinationFile1 = "file2";
        String sourceFile2 = "file1";
        String destinationFile2 = "file2";

        long startTime = System.currentTimeMillis();
        sequentialCopy(sourceFile1, destinationFile1);
        sequentialCopy(sourceFile2, destinationFile2);
        long endTime = System.currentTimeMillis();
        long sequentialTime = endTime - startTime;

        startTime = System.currentTimeMillis();
        parallelCopy(sourceFile1, destinationFile1);
        parallelCopy(sourceFile2, destinationFile2);
        endTime = System.currentTimeMillis();
        long parallelTime = endTime - startTime;

        System.out.println("Последовательное копирование: " + sequentialTime + " мс");
        System.out.println("Параллельное копирование: " + parallelTime + " мс");
    }
}
