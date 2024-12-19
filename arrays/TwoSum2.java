package arrays;

class TwoSum2 {

    public static void main(String[] args) {

        // test case are designed in such a way that atleast one answer exists
        int res[] = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(res[0] + " " + res[1]);
    }

    public static int[] twoSum(int[] numbers, int target) {

        int[] res = {-1, -1};

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                res[0] = left + 1;   // Assuming we want 1-based indices
                res[1] = right + 1;
                return res;          // Immediate return when we find the correct pair
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }

        return res;

    }
}
