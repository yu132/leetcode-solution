package redo.p1600_1699;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1640  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月30日  
 *  
 */
public class P1640 {

    class Solution {
        public boolean canFormArray(int[] arr, int[][] pieces) {
            int[] start = new int[101];
            Arrays.fill(start, -1);
            for (int i = 0; i < pieces.length; ++i) {
                start[pieces[i][0]] = i;
            }

            for (int i = 0; i < arr.length;) {
                int startIndex = arr[i];
                if (start[startIndex] == -1) {
                    return false;
                }
                int[] piece = pieces[start[startIndex]];
                for (int j = 0; j < piece.length; ++i, ++j) {
                    if (i == arr.length || arr[i] != piece[j]) {
                        return false;
                    }
                }
            }

            return true;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true, s.canFormArray(new int[] {85}, Arrs.build2D("[[85]]")));
        Assert.assertEquals(true, s.canFormArray(new int[] {15, 85}, Arrs.build2D("[[85],[15]]")));
        Assert.assertEquals(false, s.canFormArray(new int[] {49, 18, 16}, Arrs.build2D("[[16,18,49]]")));
        Assert.assertEquals(true, s.canFormArray(new int[] {91, 4, 64, 78}, Arrs.build2D("[[78],[4,64],[91]]")));
        Assert.assertEquals(false, s.canFormArray(new int[] {1, 3, 5, 7}, Arrs.build2D("[[2,4,6,8]]")));
        Assert.assertEquals(false, s.canFormArray(new int[] {1, 3, 5, 7}, Arrs.build2D("[[1,3,5,7,9]]")));
    }

}
