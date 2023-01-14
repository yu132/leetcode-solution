package redo.zhousai;

public class P6104 {

    class Solution {
        public int countAsterisks(String s) {
            int count = 0, ans = 0;
            for (char ch : s.toCharArray()) {
                if (ch == '|') {
                    ++count;
                } else if (ch == '*' && count % 2 == 0) {
                    ++ans;
                }
            }
            return ans;
        }
    }

}
