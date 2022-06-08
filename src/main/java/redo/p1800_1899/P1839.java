package redo.p1800_1899;

public class P1839 {

    class Solution {
        public int longestBeautifulSubstring(String word) {
            boolean isWord = word.charAt(0) == 'a';
            int len = word.charAt(0) == 'a' ? 1 : 0;
            int ans = 0;
            for (int i = 1; i < word.length(); ++i) {
                char now = word.charAt(i);
                char prev = word.charAt(i - 1);
                if (now == prev) {
                    ++len;
                    continue;
                }
                if (prev == 'u' && isWord) {
                    ans = Math.max(ans, len);
                }
                switch (now) {
                    case 'a':
                        isWord = true;
                        len = 1;
                        break;
                    case 'e':
                        if (prev != 'a') {
                            isWord = false;
                            len = 0;
                        } else {
                            ++len;
                        }
                        break;
                    case 'i':
                        if (prev != 'e') {
                            isWord = false;
                            len = 0;
                        } else {
                            ++len;
                        }
                        break;
                    case 'o':
                        if (prev != 'i') {
                            isWord = false;
                            len = 0;
                        } else {
                            ++len;
                        }
                        break;
                    case 'u':
                        if (prev != 'o') {
                            isWord = false;
                            len = 0;
                        } else {
                            ++len;
                        }
                        break;
                }
            }
            if (word.charAt(word.length() - 1) == 'u' && isWord) {
                ans = Math.max(ans, len);
            }
            return ans;
        }
    }

}
