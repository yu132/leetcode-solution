package old._0800_0899;

import java.util.ArrayList;
import java.util.Collections;

/**  
 * @ClassName: _853  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月18日  
 *  
 */
public class _853 {

    class Solution {

        class Node {
            int pos;
            int speed;

            public Node(int pos, int speed) {
                super();
                this.pos   = pos;
                this.speed = speed;
            }
        }

        public int carFleet(int target, int[] position, int[] speed) {
            ArrayList<Node> list = new ArrayList<>();

            for (int i = 0; i < position.length; ++i) {
                list.add(new Node(position[i], speed[i]));
            }

            Collections.sort(list, (a, b) -> {
                return Integer.compare(b.pos, a.pos);
            });

            double time  = -1;
            int    count = 0;

            for (int i = 0; i < list.size(); ++i) {
                double t = ((double)target - list.get(i).pos) / list.get(i).speed;
                if (Double.compare(time, t) < 0) {
                    time = t;
                    ++count;
                }
            }

            return count;
        }
    }

}
