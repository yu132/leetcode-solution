package redo.p1900_1999;

public class P1967 {

    class Solution {
        public int numOfStrings(String[] patterns, String word) {
            int count = 0;
            for (String pattern : patterns) {
                if (word.contains(pattern)) {
                    ++count;
                }
            }
            return count;
        }
    }

}
