package redo.p0700_0799;

import java.util.Deque;
import java.util.LinkedList;

/**  
 * @ClassName: P739  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月24日  
 *  
 */
public class P739 {

    static//

    class Solution {
        public int[] dailyTemperatures(int[] T) {
            Deque<Data> mstack = new LinkedList<>();

            for (int i = 0; i < T.length; ++i) {
                while (!mstack.isEmpty() && mstack.peek().val < T[i]) {
                    Data d = mstack.pop();
                    T[d.index] = i - d.index;
                }
                mstack.push(new Data(i, T[i]));
            }

            while (!mstack.isEmpty()) {
                T[mstack.pop().index] = 0;
            }

            return T;
        }

        static class Data {
            int index, val;

            public Data(int index, int val) {
                super();
                this.index = index;
                this.val = val;
            }
        }
    }

}
