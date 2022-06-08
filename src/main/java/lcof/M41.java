package lcof;

import java.util.PriorityQueue;

/**  
 * @ClassName: M41  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月20日  
 *  
 */
public class M41 {

    class MedianFinder {

        private PriorityQueue<Integer> big = new PriorityQueue<>();

        private PriorityQueue<Integer> small = new PriorityQueue<>((a, b) -> {
            return Integer.compare(b, a);
        });

        /** initialize your data structure here. */
        public MedianFinder() {}

        public void addNum(int num) {
            if (big.size() == 0) {
                big.add(num);
                return;
            }
            if (num > findMedian()) {
                big.offer(num);
                if (big.size() > small.size() + 1) {
                    small.offer(big.poll());
                }
            } else {
                small.offer(num);
                if (small.size() > big.size() + 1) {
                    big.offer(small.poll());
                }
            }
        }

        public double findMedian() {
            if (big.size() == small.size()) {
                return (double)(big.peek() + small.peek()) / 2;
            } else if (big.size() > small.size()) {
                return big.peek();
            } else {
                return small.peek();
            }
        }
    }


}
