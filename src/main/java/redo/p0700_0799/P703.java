package redo.p0700_0799;

import java.util.PriorityQueue;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P703  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月21日  
 *  
 */
public class P703 {

    class KthLargest {

        private PriorityQueue<Integer> pq = new PriorityQueue<>();
        private int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            pq.offer(val);
            if (pq.size() > k) {
                pq.poll();
            }
            return pq.peek();
        }
    }



    @Test
    public void test() {
        KthLargest s = new KthLargest(3, new int[] {4, 5, 8, 2});
        Assert.assertEquals(4, s.add(3));
        Assert.assertEquals(5, s.add(5));
        Assert.assertEquals(5, s.add(10));
        Assert.assertEquals(8, s.add(9));
        Assert.assertEquals(8, s.add(4));
    }

}
