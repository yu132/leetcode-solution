package old._1000_1099;

import java.util.Arrays;
import java.util.PriorityQueue;

/**  
 * @ClassName: _1094  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月6日  
 *  
 */
public class _1094 {

    class Solution {
        public boolean carPooling(int[][] trips, int capacity) {


            Arrays.sort(trips, (a, b) -> {
                return Integer.compare(a[1], b[1]);
            });



            PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> {
                                          return Integer.compare(a.placeToGetOutOfCar, b.placeToGetOutOfCar);
                                      });

            int                 index = 0, numOfPeopleInCar = 0;

            while (index != trips.length) {
                if (queue.isEmpty() || trips[index][1] < queue.peek().placeToGetOutOfCar) {
                    queue.offer(new Node(trips[index][0], trips[index][2]));
                    numOfPeopleInCar += trips[index++][0];
                    if (numOfPeopleInCar > capacity) {
                        return false;
                    }
                } else {
                    Node node = queue.poll();
                    numOfPeopleInCar -= node.numOfPeople;
                }
            }

            return true;
        }

        class Node {
            int numOfPeople;
            int placeToGetOutOfCar;

            public Node(int numOfPeople, int placeToGetOutOfCar) {
                super();
                this.numOfPeople        = numOfPeople;
                this.placeToGetOutOfCar = placeToGetOutOfCar;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(
            new _1094().new Solution().carPooling(new int[][] {{9, 3, 4}, {9, 1, 7}, {4, 2, 4}, {7, 4, 5}}, 23));
    }

}
