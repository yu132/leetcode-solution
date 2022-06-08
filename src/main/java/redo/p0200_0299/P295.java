package redo.p0200_0299;

import java.security.cert.PolicyQualifierInfo;
import java.util.PriorityQueue;

/**  
 * @ClassName: P295  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月28日  
 *  
 */
public class P295 {

    class MedianFinder {

        PriorityQueue<Integer> max = new PriorityQueue<>(),
            min = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        /** initialize your data structure here. */
        public MedianFinder() {}

        public void addNum(int num) {
            if (max.isEmpty() || num >= max.peek()) {
                max.offer(num);
            } else {
                min.offer(num);
            }

            if (max.size() > min.size() + 1) {
                min.offer(max.poll());
            }
            if (min.size() > max.size() + 1) {
                max.offer(min.poll());
            }
        }

        public double findMedian() {
            if (max.size() == min.size()) {
                if (max.isEmpty()) {
                    return -1;
                } else {
                    return (max.peek() + min.peek()) / 2.0;
                }
            }

            if (max.size() > min.size()) {
                return max.peek();
            } else {
                return min.peek();
            }
        }
    }

}
