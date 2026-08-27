class Solution {
    public void rotate(int[] nums, int k) {

        if (nums == null || nums.length <= 1) return;

        int n = nums.length;
        k = k % n;   // always normalize k

        // DO NOT return when k == 0
        // Because logic still works correctly

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
