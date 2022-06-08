package redo.Util.ag.array.minSumCut;

/**  
 * @ClassName: MinSumCutUtil  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月20日  
 *  
 */
public class MinSumCutUtil {

    /*
     * 将数组切分成k份，使得每个切分后的子数组和的最大值最小
     * 
     * 一看到最大值最小这样的描述，应当立即想到二分查找答案
     * 通过验证答案正确与否进行二分
     */

    public static int minSplit(int[] nums, int k) {
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

    public static boolean check(int[] nums, int maxSum, int k) {
        int sum = 0, countSplit = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > maxSum) {
                return false;
            }
            if (sum + nums[i] > maxSum) {
                ++countSplit;
                sum = nums[i];
            } else {
                sum += nums[i];
            }
        }
        ++countSplit;
        return countSplit <= k;
    }

}
