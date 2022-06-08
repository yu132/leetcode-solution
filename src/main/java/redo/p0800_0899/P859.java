package redo.p0800_0899;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P859  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月22日  
 *  
 */
public class P859 {

    class Solution {
        public boolean buddyStrings(String A, String B) {
            if (A.length() != B.length()) {
                return false;
            }
            char cha1 = '\0', cha2 = '\1', chb1 = '\2', chb2 = '\3';

            int count = 0;
            for (int i = 0; i < A.length(); ++i) {
                if (A.charAt(i) != B.charAt(i)) {
                    if (count == 0) {
                        cha1 = A.charAt(i);
                        chb1 = B.charAt(i);
                    } else if (count == 1) {
                        cha2 = A.charAt(i);
                        chb2 = B.charAt(i);
                    } else {
                        return false;
                    }
                    ++count;
                }
            }
            if (count == 0) {
                if (A.length() > 26) {
                    return true;
                }
                Set<Character> set = new HashSet<>();
                for (char ch : A.toCharArray()) {
                    if (set.contains(ch)) {
                        return true;
                    }
                    set.add(ch);
                }
                return false;
            } else {
                return cha1 == chb2 && cha2 == chb1;
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true, s.buddyStrings("ab", "ba"));
        Assert.assertEquals(false, s.buddyStrings("ab", "ab"));
        Assert.assertEquals(true, s.buddyStrings("aa", "aa"));
        Assert.assertEquals(true, s.buddyStrings("aaaaaaabc", "aaaaaaacb"));
        Assert.assertEquals(false, s.buddyStrings("", "aa"));
    }

}
