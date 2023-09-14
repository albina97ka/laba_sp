import java.util.Random;

public class Main2 {
    public static void main(String[] args) {
        int[] numbers = new int[10000];
        Random random = new Random();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(10000);
        }

        int min = numbers[0];
        int min_3 = numbers[0];
        int min_7 = numbers[0];
        int min_21 = numbers[0];

        for (int number : numbers) {
            if (number < min) {
                min = number;
            } else if (number % 3 == 0 && number < min_3) {
                min_3 = number;
            } else if (number % 7 == 0 && number < min_7) {
                min_7 = number;
            } else if (number % 21 == 0 && number < min_21) {
                min_21 = number;
            }
        }

        int R1 = min * min_21;
        int R2 = min_3 * min_7;

        if (R1 > R2) {
            System.out.println(R1);
        } else if (R2 > R1) {
            System.out.println(R2);
        } else {
            System.out.println("-1");
        }
    }
}