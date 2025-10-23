package Lesson12.FirstPart.MaxMin;

import java.util.List;

public class For {
    public static void main(String[] args) {
        List<Integer> nums = List.of(10, 2, 33, 4, 25);
        int max = nums.get(0);
        int min = nums.get(0);

        for (int num : nums) {
            if (num > max) {
                max = num;
            }
            else if (num < min) {
                min = num;
            }
        }
        System.out.println("Min = " + min);
        System.out.println("Max = " + max);
    }
}
