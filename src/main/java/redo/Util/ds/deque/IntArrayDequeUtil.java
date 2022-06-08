package redo.Util.ds.deque;

/**  
 * @ClassName: IntLinkedDeque  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月31日  
 *  
 */
public class IntArrayDequeUtil {

    // 简化的数组双端队列，没有向头部添加的功能，也不能循环存储，必须开足够的空间
    static class SimpleIntArrayDeque {

        int start = 0, end = 0, deque[];

        public SimpleIntArrayDeque(int len) {
            super();
            this.deque = new int[len];
        }

        public void offerLast(int num) {
            deque[end++] = num;
        }

        public int pollLast() {
            return deque[--end];
        }

        public int peekLast() {
            return deque[end - 1];
        }

        public int pollFirst() {
            return deque[start++];
        }

        public int peekFirst() {
            return deque[start];
        }

        public boolean isEmpty() {
            return start == end;
        }

        public int size() {
            return end - start;
        }
    }


}
