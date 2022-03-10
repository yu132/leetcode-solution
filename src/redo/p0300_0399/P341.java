package redo.p0300_0399;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import model.NestedInteger;

/**  
 * @ClassName: P341  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月15日  
 *  
 */
public class P341 {

    static//

    public class NestedIterator implements Iterator<Integer> {

        List<NestedInteger> top;
        int index = 0;

        boolean hasNext = true;
        int val;

        Deque<Data> stack = new LinkedList<>();

        public NestedIterator(List<NestedInteger> nestedList) {
            top = nestedList;
            if (index == top.size()) {
                hasNext = false;
            }
            handleNext();
        }

        void handleNext() {
            while (index == top.size()) {
                if (stack.isEmpty()) {
                    hasNext = false;
                    return;
                }
                Data d = stack.pop();
                top = d.list;
                index = d.index;
            }

            NestedInteger ni = top.get(index++);
            if (ni.isInteger()) {
                val = ni.getInteger();
            } else {
                stack.push(new Data(top, index));
                top = ni.getList();
                index = 0;
                handleNext();
            }
        }

        @Override
        public Integer next() {
            int ret = val;
            handleNext();
            return ret;
        }

        @Override
        public boolean hasNext() {
            return hasNext;
        }

        static class Data {
            List<NestedInteger> list;
            int index;

            public Data(List<NestedInteger> list, int index) {
                super();
                this.list = list;
                this.index = index;
            }
        }
    }

}
