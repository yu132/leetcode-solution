package redo.p0000_0099;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**  
 * @ClassName: P49  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月11日  
 *  
 */
public class P49 {

    static //

    class Solution {

        final static int PRIME = 0x61c88647;

        public List<List<String>> groupAnagrams(String[] strs) {
            Map<Key, List<String>> map = new HashMap<>();

            for (String str : strs) {
                add(map, str);
            }

            return new ArrayList<>(map.values());
        }

        void add(Map<Key, List<String>> map, String str) {
            Key k = new Key(str);
            map.computeIfAbsent(k, (x) -> new ArrayList<>()).add(str);
        }

        static class Key {
            String str;

            int[] count;

            int hash = 0;

            public Key(String str) {
                super();
                this.str = str;
                count = new int[26];

                for (char ch : str.toCharArray()) {
                    ++count[ch - 'a'];
                }

                for (int num : count) {
                    hash = hash * PRIME + num;
                }
            }

            @Override
            public int hashCode() {
                return hash;
            }

            @Override
            public boolean equals(Object obj) {
                if (!(obj instanceof Key)) {
                    return false;
                }
                return Arrays.equals(count, ((Key)obj).count);
            }
        }
    }

}
