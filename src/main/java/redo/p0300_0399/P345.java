package redo.p0300_0399;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**  
 * @ClassName: P345  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月19日  
 *  
 */
public class P345 {

    class Solution {
        public String reverseVowels(String s) {
            int low = 0, high = s.length() - 1;
            char[] chs = s.toCharArray();
            while (low < high) {
                while (low < high && !isVowel(chs[low])) {
                    ++low;
                }
                while (low < high && !isVowel(chs[high])) {
                    --high;
                }
                if (low >= high) {
                    break;
                }
                char temp = chs[low];
                chs[low] = chs[high];
                chs[high] = temp;
                ++low;
                --high;
            }
            return String.valueOf(chs);
        }

        private List<Character> vowels = Arrays.asList('a', 'o', 'i', 'u', 'e');

        private boolean isVowel(char ch) {
            return vowels.contains(Character.toLowerCase(ch));
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals("holle", s.reverseVowels("hello"));
        assertEquals("leotcede", s.reverseVowels("leetcode"));
        assertEquals("Aa", s.reverseVowels("aA"));
    }
}
