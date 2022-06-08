package redo.p2000_2099;

public class P2024 {

    class Solution {
        public int maxConsecutiveAnswers(String answerKey, int k) {
            return Math.max(helper(answerKey, k, 'T'), helper(answerKey, k, 'F'));
        }

        public int helper(String answerKey, int k, char ch) {

            int use = 0, max = 0;

            outer:
            for (int left = 0, right = 0; right < answerKey.length(); ) {

                while (true) {
                    while (right < answerKey.length() && answerKey.charAt(right) == ch) {
                        ++right;
                    }

                    max = Math.max(right - left, max);

                    if (right == answerKey.length()) {
                        break outer;
                    }

                    ++right;
                    if (use < k) {
                        ++use;
                    } else {
                        break;
                    }
                }

                while (answerKey.charAt(left) == ch) {
                    ++left;
                }
                ++left;
            }

            return max;
        }
    }

}
