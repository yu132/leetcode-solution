package redo.offer;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P11  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月4日  
 *  
 */
public class P11 {

    class Solution {
        public int minArray(int[] numbers) {
            int low = 0, high = numbers.length - 1;
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (numbers[mid] < numbers[high]) {
                    high = mid;
                } else if (numbers[mid] > numbers[high]) {
                    low = mid + 1;
                } else {
                    --high;
                }
            }
            return numbers[low];
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(1, s.minArray(new int[] {3, 4, 5, 1, 2}));
        Assert.assertEquals(0, s.minArray(new int[] {2, 2, 2, 0, 1}));
    }

}
