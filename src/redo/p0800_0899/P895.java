package redo.p0800_0899;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**  
 * @ClassName: P895  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月28日  
 *  
 */
public class P895 {

    class FreqStack {

        @SuppressWarnings("unchecked")
        LinkedList<Integer>[] list = new LinkedList[10000];

        Map<Integer, Integer> count = new HashMap<>();

        int top = 0;

        public FreqStack() {}

        public void push(int x) {
            int level = count.getOrDefault(x, 0);
            if (list[level] == null) {
                list[level] = new LinkedList<>();
            }
            list[level].addLast(x);
            count.put(x, level + 1);
            top = Math.max(top, level);
        }

        public int pop() {
            int ret = list[top].removeLast();
            count.put(ret, top);
            if (list[top].size() == 0) {
                --top;
            }
            return ret;
        }
    }

}
