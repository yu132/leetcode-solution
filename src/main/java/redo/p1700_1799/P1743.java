package redo.p1700_1799;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P1743 {

    class Solution {
        public int[] restoreArray(int[][] adjacentPairs) {
            Map<Integer, Node> map = new HashMap<>();

            for (int[] adjac : adjacentPairs) {
                map.computeIfAbsent(adjac[0], x -> new Node()).list.add(adjac[1]);
                map.computeIfAbsent(adjac[1], x -> new Node()).list.add(adjac[0]);
            }

            List<Integer> in1 = new ArrayList<>();

            for (Map.Entry<Integer, Node> entry : map.entrySet()) {
                if (entry.getValue().list.size() == 1) {
                    in1.add(entry.getKey());
                }
            }

            int[] ans = new int[map.size()];
            int index = 0;


            for (int val : in1) {
                Node node = map.get(val);
                if (node.used) {
                    continue;
                }
                node.used = true;
                ans[index++] = val;
                int now = node.list.get(0), prev = val;
                while (true) {
                    Node n = map.get(now);
                    n.used = true;
                    ans[index++] = now;
                    if (n.list.size() == 1) {
                        break;
                    }

                    int next = -1;
                    for (int x : n.list) {
                        if (x != prev) {
                            next = x;
                            break;
                        }
                    }

                    prev = now;
                    now = next;
                }
            }

            return ans;
        }

        class Node {
            List<Integer> list = new ArrayList<>();
            boolean used = false;

            public Node() {
            }
        }


    }

}
