package redo.p1600_1699;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1629  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月30日  
 *  
 */
public class P1629 {

    class Solution {
        public char slowestKey(int[] releaseTimes, String keysPressed) {
            int last = 0, maxTime = 0;
            char maxChar = 0;
            for (int i = 0; i < releaseTimes.length; ++i) {
                int time = releaseTimes[i] - last;

                if (time > maxTime) {
                    maxTime = time;
                    maxChar = keysPressed.charAt(i);
                } else if (time == maxTime) {
                    if (maxChar < keysPressed.charAt(i)) {
                        maxChar = keysPressed.charAt(i);
                    }
                }

                last = releaseTimes[i];
            }

            return maxChar;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals('c', s.slowestKey(new int[] {9, 29, 49, 50}, "cbcd"));
        Assert.assertEquals('a', s.slowestKey(new int[] {12, 23, 36, 46, 62}, "spuda"));
    }

}
