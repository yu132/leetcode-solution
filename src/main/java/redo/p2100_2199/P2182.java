package redo.p2100_2199;

public class P2182 {

    class Solution {
        public String repeatLimitedString(String s, int repeatLimit) {
            int[] chCount = countLowercaseLetters(s);

            StringBuilder buf = new StringBuilder(s.length());

            int index1 = 25, index2 = 24;
            while (true) {
                if (chCount[index1] == 0) {
                    index1 = index2;
                    --index2;
                    while (index2 >= 0 && chCount[index2] == 0) {
                        --index2;
                    }
                    if (index2 == -1) {
                        if (chCount[index1] != 0) {
                            int useable = Math.min(repeatLimit, chCount[index1]);
                            chCount[index1] -= useable;
                            for (int i = 0; i < useable; ++i) {
                                buf.append((char) ('a' + index1));
                            }
                        }
                        break;
                    }
                } else {
                    int useable = Math.min(repeatLimit, chCount[index1]);
                    chCount[index1] -= useable;
                    for (int i = 0; i < useable; ++i) {
                        buf.append((char) ('a' + index1));
                    }
                    if (chCount[index1] == 0) {
                        continue;
                    }
                    while (index2 >= 0 && chCount[index2] == 0) {
                        --index2;
                    }
                    if (index2 == -1) {
                        break;
                    }
                    --chCount[index2];
                    buf.append((char) ('a' + index2));
                }
            }

            return buf.toString();
        }

        public int[] countLowercaseLetters(String str) {
            int[] count = new int[26];
            for (char ch : str.toCharArray()) {
                ++count[ch - 'a'];
            }
            return count;
        }
    }

}
