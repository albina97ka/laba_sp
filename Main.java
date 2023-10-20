import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String fileName = "file1"; // замените на путь к вашему файлу

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            Pattern pattern = Pattern.compile("X{1,}", Pattern.DOTALL);

            StringBuilder text = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                text.append(line);
            }

            Matcher matcher = pattern.matcher(text);

            int mathMax = 0;

            while (matcher.find()) {
                int math = matcher.group().length();
                if (math > mathMax) {
                    mathMax = math;
                }
            }

            System.out.println("Длина самой длинной последовательности символов X: " + mathMax);
        } catch (IOException e) {
            System.out.println("Произошла ошибка при работе с файлом.");
        }
    }
}