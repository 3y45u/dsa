package dp;

import java.util.HashMap;
import java.util.Map;

public class LC494 {

    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> dp = new HashMap<>();
        return solve(0, 0, nums, target, dp);
    }

    public int solve(int i, int sum, int[] nums, int target, Map<String, Integer> dp) {
        String key = i + "-" + sum;

        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        if (i == nums.length) {
            return sum == target ? 1 : 0;
        }

        int add = solve(i + 1, sum + nums[i], nums, target, dp);
        int sub = solve(i + 1, sum - nums[i], nums, target, dp);

        dp.put(key, add + sub);

        return dp.get(key);

    }
}
