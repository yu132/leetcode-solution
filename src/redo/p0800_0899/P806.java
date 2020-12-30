package redo.p0800_0899;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P806  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月21日  
 *  
 */
public class P806 {

    class Solution {
        public int[] numberOfLines(int[] widths, String s) {
            int lines = 1, leftUnit = 100;
            for (char ch : s.toCharArray()) {
                if (leftUnit < widths[ch - 'a']) {
                    ++lines;
                    leftUnit = 100;
                }
                leftUnit -= widths[ch - 'a'];
            }
            return new int[] {lines, 100 - leftUnit};
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new int[] {3, 60}, s.numberOfLines(new int[] {10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
            10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, "abcdefghijklmnopqrstuvwxyz"));
        Assert.assertArrayEquals(new int[] {2, 4}, s.numberOfLines(new int[] {4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
            10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, "bbbcccdddaaa"));
    }

}
