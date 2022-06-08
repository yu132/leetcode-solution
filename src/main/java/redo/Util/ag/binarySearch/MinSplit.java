package redo.Util.ag.binarySearch;

/**  
 * @ClassName: MinSplit  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月11日  
 *  
 */
public class MinSplit {

    public int minSplit(int[] nums, int k) {
        int low = 0, high = sum(nums);
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (check(nums, mid, k)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static int sum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    public boolean check(int[] nums, int maxSum, int k) {
        int sum = 0, countSplit = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > maxSum) {
                return false;
            }
            if (sum + nums[i] > maxSum) {
                ++countSplit;
                sum = nums[i];
            }
        }
        ++countSplit;
        return countSplit >= k;
    }

}
