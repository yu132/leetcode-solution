package redo.p0300_0399;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: P344  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月19日  
 *  
 */
public class P344 {

    class Solution {
        public void reverseString(char[] s) {
            int low = 0, high = s.length - 1;
            while (low < high) {
                char temp = s[low];
                s[low] = s[high];
                s[high] = temp;
                ++low;
                --high;
            }
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        char[] chs = {'h', 'e', 'l', 'l', 'o'};
        s.reverseString(chs);
        assertArrayEquals(new char[] {'o', 'l', 'l', 'e', 'h'}, chs);

        chs = new char[] {'H', 'a', 'n', 'n', 'a', 'h'};
        s.reverseString(chs);
        assertArrayEquals(new char[] {'h', 'a', 'n', 'n', 'a', 'H'}, chs);
    }


}
