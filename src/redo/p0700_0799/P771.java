package redo.p0700_0799;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P771  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月21日  
 *  
 */
public class P771 {

    class Solution {
        public int numJewelsInStones(String jewels, String stones) {
            Set<Character> set = new HashSet<>();
            for (char ch : jewels.toCharArray()) {
                set.add(ch);
            }
            int count = 0;
            for (char ch : stones.toCharArray()) {
                if (set.contains(ch)) {
                    ++count;
                }
            }
            return count;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(3, s.numJewelsInStones("aA", "aAAbbbb"));
        Assert.assertEquals(0, s.numJewelsInStones("z", "ZZ"));
    }

}
