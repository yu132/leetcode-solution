package redo.p2000_2099;

import java.util.ArrayList;
import java.util.List;

public class P2047 {

    class Solution {
        public int countValidWords(String sentence) {
            List<int[]> strsRange = splitAndRemoveEmptyReturnRange(sentence, ' ');

            int count = 0;

            outer:
            for (int[] range : strsRange) {

                int start = range[0], end = range[1];

                if (end - start != 1) {

                    boolean hyphen = false;

                    //mid 必须为英文或-
                    for (int i = start + 1; i < end - 1; ++i) {
                        if (!('a' <= sentence.charAt(i) && sentence.charAt(i) <= 'z')
                                && sentence.charAt(i) != '-') {
                            continue outer;
                        }
                        if (sentence.charAt(i) == '-') {
                            if (hyphen) {
                                continue outer;
                            } else {
                                hyphen = true;
                            }
                            if (!Character.isLetter(sentence.charAt(i - 1)) || !Character.isLetter(sentence.charAt(i + 1))) {
                                continue outer;
                            }
                        }
                    }

                    //start 必须为英文
                    if (!('a' <= sentence.charAt(start) && sentence.charAt(start) <= 'z')) {
                        continue;
                    }
                }

                if (('0' <= sentence.charAt(end - 1) && sentence.charAt(end - 1) <= '9')
                        || sentence.charAt(end - 1) == '-') {
                    continue;
                }
                ++count;
            }
            return count;
        }

        public List<int[]> splitAndRemoveEmptyReturnRange(String str, char spliter) {
            int start = 0;
            List<int[]> ans = new ArrayList<>();
            for (int i = 0; i < str.length(); ++i) {
                if (str.charAt(i) == spliter) {
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
    }

}
