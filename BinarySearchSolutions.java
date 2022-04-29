public class BinarySearchSolutions {
    // 704. Binary Search
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l<=r) {
            int mid = l + (r-l)/2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] < target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return -1;
    }

    // 744. Find Smallest Letter Greater Than Target
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0, r = letters.length - 1;
        while (l <= r) {
            int mid = l + (r-l)/2;
            if (letters[mid] <= target)
                l = mid+1;
            else
                r = mid-1;
        }
        return letters[l%letters.length];
    }

    // 852. Peak Index in a Mountain Array
    public int peakIndexInMountainArray(int[] arr) {
        int l = 1, r = arr.length - 2;
        while (l <= r) {
            int mid = l + (r-l)/2;
            if (arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1])
                return mid;
            if (arr[mid] < arr[mid-1])
                r = mid - 1;
            if (arr[mid] < arr[mid+1])
                l = mid + 1;
        }
        return -1;
    }
}
