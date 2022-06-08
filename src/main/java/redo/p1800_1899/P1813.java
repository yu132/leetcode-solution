package redo.p1800_1899;

public class P1813 {

    class Solution {
        public boolean areSentencesSimilar(String sentence1, String sentence2) {
            if (sentence1.length() == sentence2.length()) {
                return sentence1.equals(sentence2);
            }
            String l, s;
            if (sentence1.length() > sentence2.length()) {
                l = sentence1;
                s = sentence2;
            } else {
                l = sentence2;
                s = sentence1;
            }
            for (int i = 0; i <= s.length(); ++i) {
                if (i != 0 && i != s.length() && s.charAt(i) != ' ') {
                    continue;
                }
                String f = s.substring(0, i), b = i < s.length() && s.charAt(i) == ' ' ? s.substring(i + 1) : s.substring(i);
                if (l.startsWith(f) && (l.charAt(f.length()) == ' ' || f.length() == 0)
                        && l.endsWith(b) && (l.charAt(l.length() - b.length() - 1) == ' ' || b.length() == 0)) {
                    return true;
                }
            }
            return false;
        }
    }

}
