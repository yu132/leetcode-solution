package redo.p0200_0299;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**  
 * @ClassName: P290  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月19日  
 *  
 */
public class P290 {

    class Solution {
        public boolean wordPattern(String pattern, String s) {
            String[] strs = s.split(" ");
            if (pattern.length() != strs.length) {
                return false;
            }
            Map<String, Character> mapping = new HashMap<>();
            for (int i = 0; i < pattern.length(); ++i) {
                if (mapping.containsKey(strs[i])) {
                    if (pattern.charAt(i) != mapping.get(strs[i])) {
                        return false;
                    }
                } else {
                    if (mapping.values().contains(pattern.charAt(i))) {
                        return false;
                    }
                    mapping.put(strs[i], pattern.charAt(i));
                }
            }
            return true;
        }
    }


    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(true, s.wordPattern("abba", "dog cat cat dog"));
        assertEquals(false, s.wordPattern("abba", "dog cat cat fish"));
        assertEquals(false, s.wordPattern("aaaa", "dog cat cat dog"));
        assertEquals(false, s.wordPattern("abba", "dog dog dog dog"));
    }
}
