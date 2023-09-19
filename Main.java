import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] vector = new int[]{1, 2, 3, 4, 5};
        int mul = 2;

        for (int i = 0; i < vector.length; i++) {
            vector[i] *= mul;
        }
        System.out.println(Arrays.toString(vector));
    }
}
