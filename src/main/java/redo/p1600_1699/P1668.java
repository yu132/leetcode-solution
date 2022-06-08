package redo.p1600_1699;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1668  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月30日  
 *  
 */
public class P1668 {

    class Solution {
        public int maxRepeating(String sequence, String word) {
            StringBuilder buf = new StringBuilder(sequence.length());
            for (int i = 0;; ++i) {
                buf.append(word);
                if (!sequence.contains(buf.toString())) {
                    return i;
                }
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(2, s.maxRepeating("ababc", "ab"));
        Assert.assertEquals(1, s.maxRepeating("ababc", "ba"));
        Assert.assertEquals(0, s.maxRepeating("ababc", "ac"));
        Assert.assertEquals(1, s.maxRepeating("ababa", "aba"));
        Assert.assertEquals(5, s.maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba"));
    }

}
