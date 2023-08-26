import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArraySolutions {
    // 136. Single Number
    public static int singleNumber(int[] nums) {
        int res = nums[0];
        for (int i=1; i<nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }

    // 268. Missing Number
    public static int missingNumber(int[] nums) {
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
    public static boolean containsDuplicate(int[] nums) {
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
    public static List<Integer> findDisappearedNumbers(int[] nums) {
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
    public static int climbStairs(int n) {
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
    public static int maxProfit(int[] prices) {
        int buy = prices[0], sell = 0;
        for (int i=0; i<prices.length; i++) {
            buy = Math.min(buy, prices[i]);
            sell = Math.max(sell, prices[i] - buy);
        }
        return sell;
    }

    // 53. Maximum Subarray
    public static int maxSubArray(int[] nums) {
        int curSum = nums[0], maxSum = nums[0];
        for (int i=1; i<nums.length; i++) {
            curSum = Math.max(curSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }

    // 338. Counting Bits
    public static int[] countBits(int n) {
        int[] ans = new int[n+1];
        ans[0] = 0;
        if (n == 0)
            return ans;
        ans[1] = 1;
        for (int i=1; i<n; i++) {
            int e = (int)Math.pow(2, i);
            if (e > n)
                return ans;
            ans[e] = 1;
            for (int j=1; j<e; j++) {
                if (e + j > n)
                    return ans;
                ans[e + j] = 1 + ans[j];
            }
        }
        return ans;
    }

    // 2022. Convert 1D Array Into 2D Array
    public static int[][] construct2DArray(int[] original, int m, int n) {
        int idx = 0;
        int[][] res = new int[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                res[i][j] = original[idx++];
            }
        }
        return res;
    }

    // 169. Majority Element
    public static int majorityElement(int[] nums) {
        int count = 1, major = nums[0];
        for (int i=1; i<nums.length; i++) {
            if (count == 0)
                major = nums[i];
            count += (nums[i] == major) ? 1 : -1;
        }
        return major;
    }

    // 238. Product of Array Except Self
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = nums[0];
        for (int i=1; i<n; i++)
            res[i] = res[i-1] * nums[i];
        int right = 1;
        for (int i=n-1; i>0; i--) {
            res[i] = res[i-1] * right;
            right = right * nums[i];
        }
        res[0] = right;
        return res;
    }

    // 905. Sort Array By Parity
    public static int[] sortArrayByParity(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (right >= left) {
            if (nums[right] % 2 == 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            } else
                right--;
        }
        return nums;
    }

    // 581. Shortest Unsorted Continuous Subarray
    public static int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int max = nums[0], min = nums[n-1], l = -1, r = -2;
        for (int i=1; i<n; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[n-i-1]);
            if (nums[i] < max)
                r = i;
            if (nums[n-i-1] > min)
                l = n - i - 1;
        }
        return r - l + 1;
    }

    // 1679. Max Number of K-Sum Pairs
    public static int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i : nums) {
            if (map.containsKey(i) && map.get(i)>0) {
                ans++;
                map.put(i, map.get(i) - 1);
            } else
                map.put(k - i, map.getOrDefault(k - i, 0) + 1);
        }
        return ans;
    }

    // 1209. Remove All Adjacent Duplicates in String II
    public static String removeDuplicates(String s, int k) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> count = new Stack<>();
        stack.push(s.charAt(0));
        count.push(1);
        for (int i=1; i<s.length(); i++) {
            if (!stack.isEmpty() && stack.peek() == s.charAt(i)) {
                if (count.peek() == k-1) {
                    count.pop();
                    stack.pop();
                } else {
                    count.push(count.pop()+1);
                }
            } else {
                stack.push(s.charAt(i));
                count.push(1);
            }
        }
        s = "";
        while (!stack.isEmpty()) {
            char c = stack.pop();
            int j = count.pop();
            for (int i=0; i<j; i++)
                s = c + s;
        }
        return s;
    }

}
