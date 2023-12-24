package redo.p0200_0299;

import java.util.*;

public class P218 {

    class Solution {
        public List<List<Integer>> getSkyline(int[][] buildings) {
            List<Op> opList = new ArrayList<>();
            for (int i = 0; i < buildings.length; ++i) {
                opList.add(new Op(true, buildings[i][0], i));
                opList.add(new Op(false, buildings[i][1], i));
            }
            Collections.sort(opList, Comparator.comparingInt(op -> op.loc));
            PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(x -> -x.height));
            HashSet<Integer> removed = new HashSet<>();

            List<List<Integer>> ans = new ArrayList<>();

            int nowLoc = opList.get(0).loc;
            int lastTop = 0;

            for (int i = 0; ; nowLoc = opList.get(i).loc) {
                while (i < opList.size() && opList.get(i).loc == nowLoc) {
                    Op op = opList.get(i);
                    if (op.up) {
                        pq.offer(new Node(op.buildingIndex, buildings[op.buildingIndex][2]));
                    } else {
                        removed.add(op.buildingIndex);
                    }
                    ++i;
                }
                while (!pq.isEmpty() && removed.contains(pq.peek().buildingIndex)) {
                    pq.poll();
                }
                int top;
                if (pq.isEmpty()) {
                    top = 0;
                } else {
                    top = pq.peek().height;
                }
                if (top != lastTop) {
                    ans.add(Arrays.asList(nowLoc, top));
                    lastTop = top;
                }
                if (i == opList.size()) {
                    break;
                }
            }
            return ans;
        }

        class Node {
            int buildingIndex;
            int height;

            public Node(int buildingIndex, int height) {
                this.buildingIndex = buildingIndex;
                this.height = height;
            }
        }

        class Op {
            boolean up;
            int loc;
            int buildingIndex;

            public Op(boolean up, int loc, int buildingIndex) {
                this.up = up;
                this.loc = loc;
                this.buildingIndex = buildingIndex;
            }
        }
    }

}
