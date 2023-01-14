package redo.zhousai;

import java.util.HashMap;
import java.util.Map;

public class P6108 {

    class Solution {
        public String decodeMessage(String key, String message) {
            Map<Character, Character> map = new HashMap<>();
            map.put(' ', ' ');
            for (char ch : key.toCharArray()) {
                if (map.containsKey(ch)) {
                    continue;
                }
                map.put(ch, (char) ('a' + map.size() - 1));
            }
            StringBuilder buf = new StringBuilder(message.length());
            for (char ch : message.toCharArray()) {
                buf.append(map.get(ch));
            }
            return buf.toString();
        }
    }

    public static void main(String[] args) {
        new P6108().new Solution().decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv");
    }
}
