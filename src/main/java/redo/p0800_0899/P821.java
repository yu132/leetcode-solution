package redo.p0800_0899;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P821  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月21日  
 *  
 */
public class P821 {

    class Solution {
        public int[] shortestToChar(String S, char C) {
            List<Integer> cs = new ArrayList<>();
            for (int i = 0; i < S.length(); ++i) {
                if (S.charAt(i) == C) {
                    cs.add(i);
                }
            }
            Deque<Data> queue = new LinkedList<>();
            for (int c : cs) {
                queue.offer(new Data(c, 0, 1));
                queue.offer(new Data(c - 1, 1, -1));
            }
            int[] ans = new int[S.length()];
            Arrays.fill(ans, -1);
            while (!queue.isEmpty()) {
                Data data = queue.poll();
                if (data.index < 0 || data.index >= ans.length || ans[data.index] != -1) {
                    continue;
                }
                ans[data.index] = data.len;
                data.index += data.bias;
                data.len += 1;
                queue.offer(data);
            }
            return ans;
        }

        class Data {
            int index;
            int len;
            int bias;

            Data(int index, int len, int bias) {
                super();
                this.index = index;
                this.len = len;
                this.bias = bias;
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new int[] {3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0}, s.shortestToChar("loveleetcode", 'e'));
    }
}
