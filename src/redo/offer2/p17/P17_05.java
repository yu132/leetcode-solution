package redo.offer2.p17;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P17_05  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月15日  
 *  
 */
public class P17_05 {

    class Solution {
        public String[] findLongestSubarray(String[] array) {
            int n = array.length;
            int[] count = new int[2 * n + 1];
            int pre = 0, max = 0, start = 0;
            count[n] = 1;
            for (int i = 0; i < array.length; ++i) {
                int val = Character.isDigit(array[i].charAt(0)) ? -1 : 1;
                pre += val;
                int index = pre + n;
                if (count[index] == 0) {
                    count[index] = i + 2;
                } else {
                    int s = count[index] - 1;
                    if (i - s + 1 > max) {
                        max = i - s + 1;
                        start = s;
                    }
                }
            }
            return Arrays.copyOfRange(array, start, start + max);
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(null,
            s.findLongestSubarray(new String[] {"F", "G", "6", "7", "a"}));
    }

}
