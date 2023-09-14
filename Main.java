import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int[] sequence = new int[1000];

        for (int i = 0; i < sequence.length; i++) {
            sequence[i] = random.nextInt(10000);
        }

        int max = 0;
        int max_2 = 0;
        int max_7 = 0;
        int max_14 = 0;

        for (int number : sequence) {
            if (number > max) {
                max = number;
            } else if (number % 2 == 0 && number > max_2) {
                max_2 = number;
            } else if (number % 7 == 0 && number > max_7) {
                max_7 = number;
            } else if (number % 14 == 0 && number > max_14) {
                max_14 = number;
            }
        }

        int R1 = max * max_14;
        int R2 = max_2 * max_7;

        if (R1 > R2) {
            System.out.println(R1);
        } else if (R2 > R1) {
            System.out.println(R2);
        } else {
            System.out.println("-1");
        }
    }
}