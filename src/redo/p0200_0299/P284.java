package redo.p0200_0299;

import java.util.Iterator;

/**  
 * @ClassName: P284  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月14日  
 *  
 */
public class P284 {

    class PeekingIterator implements Iterator<Integer> {

        int val;
        boolean hasNext;
        Iterator<Integer> it;

        public PeekingIterator(Iterator<Integer> iterator) {
            it = iterator;
            maintainNext();
        }

        void maintainNext() {
            if (!it.hasNext()) {
                hasNext = false;
                return;
            }
            val = it.next();
            hasNext = true;
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return val;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            int ret = val;
            maintainNext();
            return ret;
        }

        @Override
        public boolean hasNext() {
            return hasNext;
        }
    }

}
