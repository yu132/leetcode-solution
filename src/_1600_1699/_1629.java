package _1600_1699;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: _1629  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月14日  
 *  
 */
public class _1629 {

    class Solution {
        public char slowestKey(int[] releaseTimes, String keysPressed) {
            int temp = 0, max = 0;
            char key = 0;
            for (int i = 0; i < releaseTimes.length; ++i) {
                int time = releaseTimes[i] - temp;
                if (time > max) {
                    max = time;
                    key = keysPressed.charAt(i);
                } else if (time == max) {
                    key = (char)Math.max(key, keysPressed.charAt(i));
                }
                temp = releaseTimes[i];
            }
            return key;
        }
    }

    @Test
    public void test() {
        assertEquals('a', new Solution().slowestKey(new int[] {12, 23, 36, 46, 62}, "spuda"));
    }

    @Test
    public void test2() {
        assertEquals('b', new Solution().slowestKey(new int[] {1, 2}, "ba"));
    }

}
