package redo.p0800_0899;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P838  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月29日  
 *  
 */
public class P838 {

    class Solution {
        public String pushDominoes(String dominoes) {
            Deque<Data> queue = new LinkedList<>();

            int n = dominoes.length();

            for (int i = 0; i < n; ++i) {
                if (dominoes.charAt(i) == 'L') {
                    queue.offer(new Data(i, -1));
                } else if (dominoes.charAt(i) == 'R') {
                    queue.offer(new Data(i, 1));
                }
            }

            int[] state = new int[n];

            while (!queue.isEmpty()) {
                Data d = queue.poll();
                if (d.index < 0 || d.index >= n) {
                    continue;
                }
                if (state[d.index] == -d.time) {
                    state[d.index] = 0;
                    continue;
                } else if (state[d.index] == 0) {
                    state[d.index] = d.time;
                    if (d.time < 0) {
                        queue.offer(new Data(d.index - 1, d.time - 1));
                    } else {
                        queue.offer(new Data(d.index + 1, d.time + 1));
                    }
                }
            }

            char[] ans = new char[n];

            for (int i = 0; i < n; ++i) {
                if (state[i] < 0) {
                    ans[i] = 'L';
                } else if (state[i] == 0) {
                    ans[i] = '.';
                } else {
                    ans[i] = 'R';
                }
            }

            return String.valueOf(ans);
        }

        class Data {
            int index, time;

            public Data(int index, int time) {
                super();
                this.index = index;
                this.time = time;
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("LL.RR.LLRRLL..", s.pushDominoes(".L.R...LR..L.."));
        Assert.assertEquals("RR.L", s.pushDominoes("RR.L"));
    }

}
