import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    // 136. Single Number
    public int singleNumber(int[] nums) {
        int res = nums[0];
        for (int i=1; i<nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }

    // 268. Missing Number
    public int missingNumber(int[] nums) {
        int sum = nums[0], max = nums[0];
        int n = nums.length;
        for (int i=1; i<n; i++) {
            sum += nums[i];
            max = Math.max(nums[i], max);
        }
        if (max == n)
            return n*(n+1)/2-sum;
        return n;
    }

    // 217. Contains Duplicate
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> l = new HashSet<>();
        for (int i : nums) {
            if (l.contains(i))
                return true;
            else
                l.add(i);
        }
        return false;
    }

    // 448. Find All Numbers Disappeared in an Array
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            int x = Math.abs(nums[i]) - 1;
            nums[x] = nums[x] < 0 ? nums[x] : -nums[x];
        }
        for (int i=0; i<nums.length; i++) {
            if (nums[i] > 0)
                res.add(i+1);
        }
        return res;
    }

    // 70. Climbing Stairs
    public int climbStairs(int n) {
        if (n == 1 || n == 2)
            return n;
        int x1 = 1, x2 = 2, x = 3;
        while (x<=n) {
            x2 = x1 + x2;
            x1 = x2 - x1;
            x++;
        }
        return x2;
    }

    // 121. Best Time to Buy and Sell Stock
    public int maxProfit(int[] prices) {
        int buy = prices[0], sell = 0;
        for (int i=0; i<prices.length; i++) {
            buy = Math.min(buy, prices[i]);
            sell = Math.max(sell, prices[i] - buy);
        }
        return sell;
    }

    
}
