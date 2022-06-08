package redo.p2000_2099;

public class P2000 {

    class Solution {
        public String reversePrefix(String word, char ch) {
            int i = word.indexOf(ch);
            if (i == -1) {
                return word;
            } else {
                char[] chs = word.toCharArray();
                reverseInclude(chs, 0, i);
                return String.copyValueOf(chs);
            }
        }

        public void reverseInclude(char[] array, int from, int to) {
            for (; from < to; ++from, --to) {
                char temp = array[from];
                array[from] = array[to];
                array[to] = temp;
            }
        }
    }

}
