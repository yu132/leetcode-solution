package redo.Util.ag.subSeq.longestIncSeq;

/**  
 * @ClassName: LIS  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月19日  
 *  
 */
public class LIS {

    public int lengthOfLIS(int[] nums) {
        int[] stack = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            if (len == 0 || num > stack[len - 1]) {
                stack[len++] = num;
            } else {
                stack[lowerBound(stack, num, 0, len - 1)] = num;
            }
        }
        return len;
    }

    public int lowerBound(int[] nums, int target, int start, int end) {
        int low = start, high = end;
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

}
