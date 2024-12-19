package arrays;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ThreeSum {

    public static void main(String[] args) {
        List<List<Integer>> list = threeSum(new int[]{-1, 0, 1, 2, -1, -4});

        System.out.println(list);
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        if (nums.length < 3) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {

            // -1,0,1,2,-1,-4
            // sort -> -4 -1 -1 0 1 2
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            twoSum(nums, i + 1, result, -nums[i]);
        }

        return result;
    }

    public static void twoSum(int[] nums, int start, List<List<Integer>> result, int target) {

        int i = start;
        int j = nums.length - 1;

        while (i < j) {

            int sum = nums[i] + nums[j];

            if (sum == target) {

                List<Integer> list = new ArrayList<>();

                list.add(-target);
                list.add(nums[i]);
                list.add(nums[j]);

                result.add(list);

                while (i < j && nums[i] == nums[i + 1]) {
                    i++;
                }

                while (j > i && nums[j] == nums[j - 1]) {
                    j--;
                }

                i++;
                j--;

            } else if (sum > target) {
                j--;
            } else {
                i++;
            }

        }

    }

}
