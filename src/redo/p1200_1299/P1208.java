package redo.p1200_1299;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1208  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月13日  
 *  
 */
public class P1208 {

    static//

    class Solution {
        public int equalSubstring(String s, String t, int maxCost) {
            int[] diff = new int[s.length()];
            for (int i = 0; i < s.length(); ++i) {
                diff[i] = Math.abs(s.charAt(i) - t.charAt(i));
            }
            return maxLenSubArr(diff, new LittleThanNWindowMaintainer(maxCost));
        }

        static int maxLenSubArr(int[] arr, WindowMaintainer maintainer) {
            int max = 0, left = 0;
            for (int right = 0; right < arr.length; ++left) {
                while (maintainer.windowMeetRequirements()) {
                    max = Math.max(max, right - left);
                    if (right >= arr.length) {
                        break;
                    }
                    maintainer.insertRight(arr[right++]);
                }
                maintainer.removeLeft(arr[left]);
            }
            return max;
        }

        static interface WindowMaintainer {
            void insertRight(int rightValue);

            void removeLeft(int leftValue);

            boolean windowMeetRequirements();
        }

        static class LittleThanNWindowMaintainer implements WindowMaintainer {

            int n;
            int sum = 0;

            public LittleThanNWindowMaintainer(int n) {
                super();
                this.n = n;
            }

            @Override
            public void insertRight(int rightValue) {
                sum += rightValue;
            }

            @Override
            public void removeLeft(int leftValue) {
                sum -= leftValue;
            }

            @Override
            public boolean windowMeetRequirements() {
                return sum <= n;
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(3, s.equalSubstring("abcd", "bcdf", 3));
        Assert.assertEquals(1, s.equalSubstring("abcd", "cdef", 3));
        Assert.assertEquals(1, s.equalSubstring("abcd", "acde", 0));
        Assert.assertEquals(4, s.equalSubstring("krpgjbjjznpzdfyz", "nxargkbydxmsgbya", 14));
    }

}
