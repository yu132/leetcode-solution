package redo.p0900_0999;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P933  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月25日  
 *  
 */
public class P933 {

    class RecentCounter {

        private Deque<Integer> queue = new LinkedList<>();

        public RecentCounter() {}

        public int ping(int t) {
            while (!queue.isEmpty() && queue.peek() < t - 3000) {
                queue.poll();
            }
            queue.offer(t);
            return queue.size();
        }
    }



    @Test
    public void test() {
        RecentCounter s = new RecentCounter();
        Assert.assertEquals(1, s.ping(1));
        Assert.assertEquals(2, s.ping(100));
        Assert.assertEquals(3, s.ping(3001));
        Assert.assertEquals(3, s.ping(3002));
    }

}
