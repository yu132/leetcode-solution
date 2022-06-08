package redo.p2100_2199;

public class P2138 {

    class Solution {
        public String[] divideString(String s, int k, char fill) {

            s += repeat(fill, (k - (s.length() % k)) % k);

            String[] strs = new String[s.length() / k];

            for (int i = 0; i < s.length() / k; ++i) {
                strs[i] = s.substring(i * k, (i + 1) * k);
            }

            return strs;
        }

        public String repeat(char ch, int times) {
            StringBuilder buf = new StringBuilder(times);
            for (int i = 0; i < times; ++i) {
                buf.append(ch);
            }
            return buf.toString();
        }
    }

}
