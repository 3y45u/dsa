package arrays;

import java.util.HashMap;

class TwoSum {

    public static void main(String[] args) {

        int[] res = twoSum(new int[]{-1, -2, -3, -4, 5}, 1);

        System.out.println(res[0] + "\n" + res[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;

        int n = nums.length;


        /* brute force
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i != j){
                    if(nums[i] + nums[j] == target){
                        res[0] = Math.min(i, j);
                        res[1] = Math.max(i, j);
                        break;
                    }
                }
            }
        }
         */
        // TC O(n) : SC O(n)
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int rem = target - nums[i];

            if (map.containsKey(rem)) {
                res[0] = i;
                res[1] = map.get(rem);
                break;
            }

            map.put(nums[i], i);
        }

        return res;
    }
}
