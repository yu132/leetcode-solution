package redo.p2400_2499;

public class P2483 {
    class Solution {
        public int bestClosingTime(String customers) {
            int cY = countCharInStr(customers, 'Y'), pN = 0;
            int min = cY, ans = 0;
            for (int i = 0; i < customers.length(); ++i) {
                char ch = customers.charAt(i);
                if (ch == 'Y') {
                    --cY;
                } else {
                    ++pN;
                }
                if (min > cY + pN) {
                    min = cY + pN;
                    ans = i + 1;
                }
            }
            return ans;
        }

        public int countCharInStr(String str, char ch) {
            int count = 0;
            for (char c : str.toCharArray()) {
                if (c == ch) {
                    ++count;
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        new P2483().new Solution().bestClosingTime("NYNYYYYNNYY");
    }
}
