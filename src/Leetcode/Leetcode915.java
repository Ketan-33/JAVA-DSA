package Leetcode;

public class Leetcode915 {
    public static void main(String[] args) {
        int[] nums = {5,0,3,8,6};
        System.out.println(partitionDisjoint(nums));
        int[] nums1 = {1,1,1,0,6,12};
        System.out.println(partitionDisjoint(nums1));
    }
        public static int partitionDisjoint(int[] nums) {
            int currMax = nums[0];
            int possibleMax = nums[0];
            int length = 1;

            for (int i = 1; i < nums.length; ++i) {
                if (nums[i] < currMax) {
                    length = i + 1;
                    currMax = possibleMax;
                } else {
                    possibleMax = Math.max(possibleMax, nums[i]);
                }
            }

            return length;
        }

}
