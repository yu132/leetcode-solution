package redo.Util.newcommutil;

/**
 * @author Administrator
 */
public class ArrsFastUtil {

    /**
     * 求前缀和，返回对应的前缀和数组
     * <p>
     * 返回数组长度为原数组的长度加一
     * sum[start, end) = sum[end] - sum[start]
     *
     * @param nums
     * @return
     */
    int[] prefixSum(int[] nums) {
        int[] prefix = new int[nums.length + 1];
        for (int i = 0; i < nums.length; ++i) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        return prefix;
    }

    /**
     * 返回从start到end(不包含)的范围和
     *
     * @param prefixSumArr
     * @param start
     * @param end
     * @return
     */
    int sumRangeWithPrefix(int[] prefixSumArr, int start, int end) {
        return prefixSumArr[end] - prefixSumArr[start];
    }

}
