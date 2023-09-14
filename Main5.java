public class Main5 {
    public static int findMajorityElement(int[] nums) {
        int majorit = nums[0]; // Инициализируем majorit значением первого элемента массива
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == majorit) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    majorit = nums[i];
                    count = 1;
                }
            }
        }
        return majorit;
    }
    public static void main(String[] args) {
        int[] nums = {2, 1, 2, 3, 4, 2, 1, 2, 2};
        int majorityElement = findMajorityElement(nums);
        System.out.println(majorityElement);
    }
}