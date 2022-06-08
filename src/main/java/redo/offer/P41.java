package redo.offer;

import java.security.cert.PolicyQualifierInfo;
import java.util.PriorityQueue;

/**  
 * @ClassName: P41  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月5日  
 *  
 */
public class P41 {

    class MedianFinder {

        PriorityQueue<Integer> max = new PriorityQueue<>(),
            min = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        /** initialize your data structure here. */
        public MedianFinder() {}

        public void addNum(int num) {
            if (max.isEmpty() || num > max.peek()) {
                max.offer(num);
            } else {
                min.offer(num);
            }
            if (max.size() > min.size() + 1) {
                min.offer(max.poll());
            } else if (min.size() > max.size() + 1) {
                max.offer(min.poll());
            }
        }

        public double findMedian() {
            if (min.size() == max.size()) {
                return (min.peek() + max.peek()) / 2.0;
            }
            if (min.size() > max.size()) {
                return min.peek();
            }
            return max.peek();
        }
    }

}
