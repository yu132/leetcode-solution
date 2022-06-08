package redo.p0800_0899;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P884  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月22日  
 *  
 */
public class P884 {

    class Solution {
        public String[] uncommonFromSentences(String A, String B) {
            String[] As = A.split(" ");
            String[] Bs = B.split(" ");
            Set<String> sA_All = new HashSet<>();
            for (String str : As) {
                sA_All.add(str);
            }
            Set<String> sA_Copy = new HashSet<>(sA_All), sA0 = new HashSet<>();
            Set<String> sB_All = new HashSet<>();
            for (String str : Bs) {
                sB_All.add(str);
            }
            Set<String> sB_Copy = new HashSet<>(sB_All), sB0 = new HashSet<>();
            for (String str : As) {
                if (sA0.contains(str)) {
                    sA_Copy.remove(str);
                } else if (sB_All.contains(str)) {
                    sA_Copy.remove(str);
                }
                sA0.add(str);
            }
            for (String str : Bs) {
                if (sB0.contains(str)) {
                    sB_Copy.remove(str);
                } else if (sA_All.contains(str)) {
                    sB_Copy.remove(str);
                }
                sB0.add(str);
            }
            sA_Copy.addAll(sB_Copy);
            return sA_Copy.toArray(new String[0]);
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new String[] {"sweet", "sour"},
            s.uncommonFromSentences("this apple is sweet", "this apple is sour"));
        Assert.assertArrayEquals(new String[] {"banana"}, s.uncommonFromSentences("apple apple", "banana"));
    }
}
