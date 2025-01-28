package redo.p2700_2799;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class P2788 {

    class Solution {
        public List<String> splitWordsBySeparator(List<String> words, char separator) {
            List<String> ans = new ArrayList<>();
            for (String word : words) {
                for (String sp : word.split(Pattern.quote(String.valueOf(separator)))) {
                    if (sp.length() != 0) {
                        ans.add(sp);
                    }
                }
            }
            return ans;
        }
    }

}
