package redo.p2600_2699;

import redo.testUtil.Arrs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class P2662 {

    class Solution {
        public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
            int[] now = start;
            int length = 0;

            HashSet<Long> visited = new HashSet<>();

            PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.dis));
            while (!Arrays.equals(now, target)) {
                long tag = now[0] * 100001L + now[1];
                System.out.println(now[0] + " " + now[1]);
                if (visited.contains(tag)) {
                    Node close = pq.poll();
                    now = close.p;
                    length = close.dis;
                    continue;
                }
                visited.add(tag);
                pq.offer(new Node(length + dis(now, target), target));
                for (int[] sp : specialRoads) {
                    int[] next = new int[]{sp[0], sp[1]};
                    if (Arrays.equals(now, next)) {
                        pq.offer(new Node(length + sp[4], new int[]{sp[2], sp[3]}));
                    } else {
                        pq.offer(new Node(length + dis(now, next), next));
                    }
                }
                Node close = pq.poll();
                now = close.p;
                length = close.dis;
            }
            return length;
        }

        int dis(int[] p1, int[] p2) {
            return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
        }

        class Node {
            int dis;
            int[] p;

            public Node(int dis, int[] p) {
                this.dis = dis;
                this.p = p;
            }
        }

    }


    public static void main(String[] args) {
        new P2662().new Solution().minimumCost(new int[]{60391, 5269}, new int[]{67763, 24971}, Arrs.build2D("[[62034,12903,66447,23088,78130],[64241,12223,62019,12586,59645],[62424,14177,60636,5869,6808],[67058,10250,60762,5518,26662],[61955,24371,64054,15394,67978],[65914,15351,66141,8328,4744],[61527,14857,61209,11356,33765],[66700,22001,65171,11313,9404],[65214,7100,61217,22761,4567],[67554,9661,64468,19267,12625],[67448,9334,65387,8008,66754],[62025,11402,60701,24632,63063],[64702,19223,65721,12827,949],[64294,22821,62488,16604,2407],[60860,12453,65132,14980,6283],[63619,12247,65809,7297,50881],[63146,21177,65088,6611,9018],[61149,11270,61239,15740,17351],[65025,10469,61931,9056,83564],[67381,5706,63717,7356,4819],[63450,14784,66433,18244,97331],[61582,14654,63280,22675,1436]]"));
    }

}
