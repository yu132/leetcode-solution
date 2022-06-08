package redo.p0400_0499;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

import utils.Strings;

/**  
 * @ClassName: P459  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月19日  
 *  
 */
public class P459 {

    class Solution {
        public boolean repeatedSubstringPattern(String s) {
            if (s.length() <= 1) {
                return false;
            }
            boolean[] isNotPrime = new boolean[s.length() / 2 + 2];
            for (int i = 2; i * i < isNotPrime.length; i++) {
                if (!isNotPrime[i]) {
                    for (int j = i * i; j < isNotPrime.length; j += i) {
                        if (isNotPrime[j])
                            continue;
                        isNotPrime[j] = true;
                    }
                }
            }

            l:
            for (int i = 2; i < isNotPrime.length; ++i) {
                if (!isNotPrime[i]) {
                    if (s.length() % i == 0) {
                        int len = s.length() / i;
                        String pattern = s.substring(0, len);
                        for (int j = len; j < s.length(); j += len) {
                            if (!pattern.equals(s.substring(j, j + len))) {
                                continue l;
                            }
                        }
                        return true;
                    }
                }
            }
            for (int i = 1; i < s.length(); ++i) {
                if (!(s.charAt(i) == s.charAt(0))) {
                    return false;
                }
            }
            return true;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(true, s.repeatedSubstringPattern("abab"));
        assertEquals(false, s.repeatedSubstringPattern("aba"));
        assertEquals(true, s.repeatedSubstringPattern("abcabcabcabc"));
        assertEquals(true, s.repeatedSubstringPattern(Strings.repeat("abc", 13)));
        assertEquals(true, s.repeatedSubstringPattern("bb"));
        assertEquals(true, s.repeatedSubstringPattern("abacababacab"));
        assertEquals(true, s.repeatedSubstringPattern("aaaaaaaaaaaaa"));

    }
}
