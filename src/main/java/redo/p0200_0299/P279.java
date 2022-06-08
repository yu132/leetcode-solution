package redo.p0200_0299;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**  
 * @ClassName: P279  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月24日  
 *  
 */
public class P279 {

    class Solution {
        public int numSquares(int n) {

            List<Integer> table = new ArrayList<>();

            for (int i = 1; i * i <= n; ++i) {
                table.add(i * i);
            }

            Set<Integer> visited = new HashSet<>();

            Deque<Integer> queue = new LinkedList<>();

            queue.offer(n);

            int level = -1, size = 0;

            while (true) {
                if (size == 0) {
                    ++level;
                    size = queue.size();
                }
                int val = queue.poll();
                if (val == 0) {
                    return level;
                }
                for (int i = 0; i < table.size(); ++i) {
                    int next = val - table.get(i);
                    if (next < 0) {
                        break;
                    }
                    if (visited.contains(next)) {
                        continue;
                    }
                    visited.add(next);
                    queue.offer(next);
                }
                --size;
            }
        }
    }

    // class Solution {
    // public int numSquares(int n) {
    // double[] dp = new double[n + 1];
    //
    // Arrays.fill(dp, Double.POSITIVE_INFINITY);
    //
    // dp[0] = 0;
    //
    // for (int i = 1; i * i <= n; ++i) {
    // int val = i * i;
    // for (int j = val; j <= n; ++j) {
    // dp[j] = Math.min(dp[j], dp[j - val] + 1);
    // }
    // }
    //
    // return (int)dp[n];
    // }
    // }

}
