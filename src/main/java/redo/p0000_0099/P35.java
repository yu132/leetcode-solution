package redo.p0000_0099;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: P35  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月17日  
 *  
 */
public class P35 {

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


    class Solution {
        public int searchInsert(int[] nums, int target) {// lower bound
            int low = 0, high = nums.length;
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (nums[mid] < target) {// upper bound => (nums[mid] <= target)
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();

        assertEquals(2, s.searchInsert(new int[] {1, 3, 5, 6}, 5));
        assertEquals(1, s.searchInsert(new int[] {1, 3, 5, 6}, 2));
        assertEquals(4, s.searchInsert(new int[] {1, 3, 5, 6}, 7));
        assertEquals(0, s.searchInsert(new int[] {1, 3, 5, 6}, 0));
    }

}
