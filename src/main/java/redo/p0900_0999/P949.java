package redo.p0900_0999;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P949  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月21日  
 *  
 */
public class P949 {

    class Solution {
        public String largestTimeFromDigits(int[] arr) {
            Arrays.sort(arr);
            String res = backtrack(0, new boolean[4], arr, new int[4]);
            if (res == null) {
                return "";
            }
            return res;
        }

        public String backtrack(int index, boolean[] used, int[] arr, int[] time) {
            if (index == 4) {
                if (check(time)) {
                    return "" + time[0] + time[1] + ":" + time[2] + time[3];
                }
                return null;
            }
            for (int i = arr.length - 1; i >= 0; --i) {
                if (used[i]) {
                    continue;
                }
                used[i] = true;
                time[index] = arr[i];
                String res = backtrack(index + 1, used, arr, time);
                if (res != null) {
                    return res;
                }
                used[i] = false;
            }
            return null;
        }

        boolean check(int[] time) {
            return time[0] * 10 + time[1] <= 23 && time[2] * 10 + time[3] <= 59;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("23:41", s.largestTimeFromDigits(new int[] {1, 2, 3, 4}));
        Assert.assertEquals("", s.largestTimeFromDigits(new int[] {5, 5, 5, 5}));
        Assert.assertEquals("00:00", s.largestTimeFromDigits(new int[] {0, 0, 0, 0}));
        Assert.assertEquals("10:00", s.largestTimeFromDigits(new int[] {0, 0, 1, 0}));
    }

}
