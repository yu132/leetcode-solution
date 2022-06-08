package redo.p1900_1999;

import java.util.PriorityQueue;

public class P1942 {

    class Solution {
        public int smallestChair(int[][] times, int targetFriend) {
            int[] seat = new int[times.length];
            PriorityQueue<Integer> usable = new PriorityQueue<>();
            for (int i = 0; i < times.length; ++i) {
                usable.offer(i);
            }
            PriorityQueue<Node> op = new PriorityQueue<>();
            for (int i = 0; i < times.length; ++i) {
                op.offer(new Node(true, times[i][0], i));
                op.offer(new Node(false, times[i][1], i));
            }
            while (!op.isEmpty()) {
                Node node = op.poll();
                if (node.come) {
                    int minSeat = usable.poll();
                    seat[node.index] = minSeat;
                    if (node.index == targetFriend) {
                        return minSeat;
                    }
                } else {
                    usable.offer(seat[node.index]);
                }
            }
            return -1;
        }

        class Node implements Comparable<Node> {
            //false意味离开
            boolean come;
            int time;
            int index;

            public Node(boolean come, int time, int index) {
                this.come = come;
                this.time = time;
                this.index = index;
            }

            @Override
            public int compareTo(Node o) {
                if (time == o.time) {
                    if (come) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
                return Integer.compare(time, o.time);
            }
        }
    }

}
