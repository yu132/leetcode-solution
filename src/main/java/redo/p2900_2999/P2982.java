package redo.p2900_2999;

public class P2982 {

    class Solution {
        public int maximumLength(String s) {
            int[] max = new int[26];
            int[] count = new int[26];
            boolean[] m1 = new boolean[26];
            int c = 0;
            for (int i = 0; i < s.length() - 1; ++i) {
                ++c;
                if (s.charAt(i) != s.charAt(i + 1)) {
                    int idx = s.charAt(i) - 'a';
                    if (c > max[idx]) {
                        m1[idx] = c == max[idx] + 1;
                        max[idx] = c;
                        count[idx] = 1;
                    } else if (c == max[idx]) {
                        max[idx] = c;
                        count[idx] += 1;
                    } else if (c == max[idx] - 1) {
                        m1[idx] = true;
                    }
                    c = 0;
                }
            }
            ++c;
            int idx = s.charAt(s.length() - 1) - 'a';
            if (c > max[idx]) {
                m1[idx] = c == max[idx] + 1;
                max[idx] = c;
                count[idx] = 1;
            } else if (c == max[idx]) {
                max[idx] = c;
                count[idx] += 1;
            } else if (c == max[idx] - 1) {
                m1[idx] = true;
            }

            int ans = -1;
            for (int i = 0; i < 26; ++i) {
                int tmp;
                if (count[i] >= 3) {
                    tmp = max[i];
                } else if (count[i] == 2 || m1[i]) {
                    tmp = max[i] - 1;
                } else {
                    tmp = max[i] - 2;
                }
                if (tmp == 0) {
                    continue;
                }
                ans = Math.max(ans, tmp);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        new P2982().new Solution().maximumLength("cddedeedccedcedecdedcdeededdddcdddddcdeecdcddeecdc");
    }
}
