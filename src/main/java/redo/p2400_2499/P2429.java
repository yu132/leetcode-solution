package redo.p2400_2499;

public class P2429 {

    class Solution {
        public int minimizeXor(int num1, int num2) {
            int count = Integer.bitCount(num2);
            String sNum1 = paddingFront(Integer.toBinaryString(num1), 30, '0');

            boolean[][] flag = new boolean[2][sNum1.length()];

            for (int i = 0; i < sNum1.length(); ++i) {
                if (sNum1.charAt(i) == '1' && count > 0) {
                    flag[0][i] = true;
                    --count;
                }
            }

            for (int i = sNum1.length() - 1; i >= 0; --i) {
                if (sNum1.charAt(i) == '0' && count > 0) {
                    flag[1][i] = true;
                    --count;
                }
            }

            StringBuilder buf = new StringBuilder(sNum1.length());
            for (int i = 0; i < sNum1.length(); ++i) {
                if (flag[0][i] || flag[1][i]) {
                    buf.append('1');
                } else {
                    buf.append('0');
                }
            }

            return Integer.parseInt(buf.toString(), 2);
        }

        String paddingFront(String str, int len, char padChar) {
            if (str.length() >= len) {
                return str;
            }
            StringBuilder buf = new StringBuilder();
            for (int i = 0; i < len - str.length(); ++i) {
                buf.append(padChar);
            }
            buf.append(str);
            return buf.toString();
        }
    }

}
