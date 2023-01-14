package redo.mianshi.p17;

import static org.junit.jupiter.api.Assertions.*;

import java.util.PriorityQueue;

import org.junit.Test;

/**  
 * @ClassName: P17_20  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月18日  
 *  
 */
public class P17_20 {

    class MedianFinder {

        PriorityQueue<Integer> max = new PriorityQueue<>(),
            min = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        /** initialize your data structure here. */
        public MedianFinder() {}

        public void addNum(int num) {
            if (max.isEmpty()) {
                max.offer(num);
                return;
            }
            if (num >= max.peek()) {
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
            if (max.size() == min.size()) {
                return (max.peek() + min.peek()) / 2.0;
            }
            if (max.size() > min.size()) {
                return max.peek();
            } else {
                return min.peek();
            }
        }
    }



    @Test
    public void test() {
        MedianFinder s = new MedianFinder();
        s.addNum(1);
        s.addNum(2);
        assertEquals(1.5, s.findMedian());
        s.addNum(3);
        assertEquals(2, s.findMedian());
    }

}
