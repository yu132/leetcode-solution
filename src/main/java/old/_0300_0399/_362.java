package old._0300_0399;

import java.util.LinkedList;

/**  
 * @ClassName: _362  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月12日  
 *  
 */
public class _362 {

    class HitCounter {

        private LinkedList<Integer> queue = new LinkedList<>();

        /** Initialize your data structure here. */
        public HitCounter() {}

        /** Record a hit.
            @param timestamp - The current timestamp (in seconds granularity). */
        public void hit(int timestamp) {
            queue.addLast(timestamp);
        }

        /** Return the number of hits in the past 5 minutes.
            @param timestamp - The current timestamp (in seconds granularity). */
        public int getHits(int timestamp) {
            while (!queue.isEmpty() && timestamp - queue.getFirst() >= 300) {
                queue.removeFirst();
            }
            return queue.size();
        }
    }

}
