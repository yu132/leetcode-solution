package redo.p0200_0299;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**  
 * @ClassName: P241  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月14日  
 *  
 */
public class P241 {

    class Solution {
        public List<Integer> diffWaysToCompute(String input) {
            List<Integer> indexesOfOps = indexesOfOps(input);

            int n = indexesOfOps.size() + 1;

            @SuppressWarnings("unchecked")
            List<Integer>[][] dp = new List[n][n];

            return helper(-1, indexesOfOps.size(), input, indexesOfOps, dp);
        }

        List<Integer> helper(int low, int high, String input,
            List<Integer> indexesOfOps, List<Integer>[][] dp) {

            if (dp[low + 1][high] == null) {
                if (low == high - 1) {
                    int start, end;
                    if (low == -1) {
                        start = 0;
                    } else {
                        start = indexesOfOps.get(low) + 1;
                    }
                    if (high == indexesOfOps.size()) {
                        end = input.length();
                    } else {
                        end = indexesOfOps.get(high);
                    }
                    dp[low + 1][high] = Arrays
                        .asList(Integer.valueOf(input.substring(start, end)));
                } else {

                    List<Integer> ans = new ArrayList<>();

                    for (int i = low + 1; i < high; ++i) {
                        List<Integer> left =
                            helper(low, i, input, indexesOfOps, dp),
                            right = helper(i, high, input, indexesOfOps, dp);

                        char op = input.charAt(indexesOfOps.get(i));

                        for (int l : left) {
                            for (int r : right) {
                                ans.add(cul(l, r, op));
                            }
                        }
                    }

                    dp[low + 1][high] = ans;
                }
            }

            return dp[low + 1][high];
        }

        int cul(int num1, int num2, char op) {
            switch (op) {
                case '+':
                    return num1 + num2;
                case '-':
                    return num1 - num2;
                case '*':
                    return num1 * num2;
                case '/':
                    return num1 / num2;
            }
            throw new RuntimeException();
        }

        List<Integer> indexesOfOps(String input) {
            List<Integer> ops = new ArrayList<>();

            for (int i = 0; i < input.length(); ++i) {
                char ch = input.charAt(i);
                if (ch == '+' || ch == '-' || ch == '*') {
                    ops.add(i);
                }
            }

            return ops;
        }
    }

}
