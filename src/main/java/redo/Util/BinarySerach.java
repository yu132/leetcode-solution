package redo.Util;

import redo.Util.ag.binarySearch.BinarySearchUtil;

/**
 * @author 余定邦
 * @ClassName: BinarySerach
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2020年12月21日
 * @see BinarySearchUtil
 */
public class BinarySerach {

    /*
     * 有几个需要解释的地方
     * 1.为什么要令high = nums.length，因为如果插入位置在最后的时候，只有high = nums.length才能取到low = nums.length
     * 否则到nums.length - 1就直接返回了
     *
     * 2.(low + high) >>> 1 防止low和high过大导致的溢出
     *
     * 3.对于lowerbound，即下界，使用的是nums[mid] < target，将返回第一个大于或者等于target的值
     *   对于upperbound，即上界，返回的是nums[mid] <= target，将返回第一个大于target的值
     *
     * 4.为什么最后返回low，这个是习惯所致，由于while的条件为low < high，因此最后low和high一定是相等的，返回谁都行
     *
     */

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

    public int upperBound(int[] nums, int target, int start, int end) {
        int low = start, high = end;
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (nums[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

}
