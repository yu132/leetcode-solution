package redo.p1900_1999;

public class P1974 {

    class Solution {
        public int minTimeToType(String word) {
            int count = word.length();
            char chNow = 'a';
            for (char ch : word.toCharArray()) {
                count += distance(chNow, ch);
                chNow = ch;
            }
            return count;
        }

        int distance(char ch1, char ch2) {
            if (ch1 > ch2) {
                char temp = ch2;
                ch2 = ch1;
                ch1 = temp;
            }
            return Math.min(ch2 - ch1, ch1 - 'a' + 'z' - ch2 + 1);
        }
    }

}
