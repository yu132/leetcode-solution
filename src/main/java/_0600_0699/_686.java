package _0600_0699;

public class _686 {

    class Solution {
        public int repeatedStringMatch(String A, String B) {

            for (int i = 0; i < A.length(); ++i) {
                int iA = i, iB = 0, c = 1;
                while (A.charAt(iA) == B.charAt(iB)) {
                    ++iA;
                    ++iB;
                    if (iB == B.length()) {
                        return c;
                    }
                    if (iA == A.length()) {
                        iA = 0;
                        ++c;
                    }
                }
            }

            return -1;
        }
    }

}
