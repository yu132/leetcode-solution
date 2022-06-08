package redo.p2000_2099;

import java.util.ArrayList;
import java.util.List;

public class P2062 {

    class Solution {
        public int countVowelSubstrings(String word) {
            int ans = 0;
            List<int[]> vowelRanges = splitAndRemoveEmptyReturnRange(word);
            for (int[] range : vowelRanges) {
                int start = range[0], end = range[1];

                if (end - start < 5) {
                    continue;
                }

                int[] count = new int[6];
                for (int left = start, right = start; left < end; ++left) {
                    while (!check(count) && right < end) {
                        ++count[index(word.charAt(right))];
                        ++right;
                    }
                    if (right == end) {
                        if (check(count)) {
                            ans += 1;
                        }
                    } else {
                        ans += end - right + 1;
                    }

                    --count[index(word.charAt(left))];
                }
            }
            return ans;
        }

        public boolean check(int[] count) {
            for (int i = 0; i < 5; ++i) {
                if (count[i] == 0) {
                    return false;
                }
            }
            return true;
        }

        public List<int[]> splitAndRemoveEmptyReturnRange(String str) {
            int start = 0;
            List<int[]> ans = new ArrayList<>();
            for (int i = 0; i < str.length(); ++i) {
                if (index(str.charAt(i)) == 5) {
                    if (start == i) {
                        ++start;
                        continue;
                    }

                    ans.add(new int[]{start, i});

                    start = i + 1;
                }
            }

            if (start != str.length()) {
                ans.add(new int[]{start, str.length()});
            }

            return ans;
        }

        public int index(char ch) {
            if (ch == 'a') {
                return 0;
            } else if (ch == 'e') {
                return 1;
            } else if (ch == 'i') {
                return 2;
            } else if (ch == 'o') {
                return 3;
            } else if (ch == 'u') {
                return 4;
            } else {
                return 5;
            }
        }
    }

    public static void main(String[] args) {
        new P2062().new Solution().countVowelSubstrings("aioueieouauaueouei");
    }

}
