package redo.p1900_1999;

public class P1910 {

    class Solution {
        public String removeOccurrences(String s, String part) {
            StringBuilder buf = new StringBuilder(s);
            int index;
            while ((index = buf.indexOf(part)) != -1) {
                buf.delete(index, index + part.length());
            }
            return buf.toString();
        }
    }

}
