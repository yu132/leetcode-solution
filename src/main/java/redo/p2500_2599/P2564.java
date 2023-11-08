package redo.p2500_2599;

import redo.testUtil.Arrs;

import java.util.HashMap;

public class P2564 {

    class Solution {
        public int[][] substringXorQueries(String s, int[][] queries) {

            HashMap<Integer, Node> map = new HashMap<>();

            for (int i = 0; i < s.length(); ++i) {
                int num = 0;
                for (int j = 0; j <= 30 && i + j < s.length(); ++j) {
                    num = num * 2 + s.charAt(j + i) - '0';
                    if (!map.containsKey(num)) {
                        map.put(num, new Node(i, i + j));
                    }
                    if (j == 0 && num == 0) {
                        break;
                    }
                }
            }

            int[][] ans = new int[queries.length][2];
            for (int i = 0; i < queries.length; ++i) {
                Node node = map.get(queries[i][0] ^ queries[i][1]);
                if (null == node) {
                    ans[i][0] = ans[i][1] = -1;
                } else {
                    ans[i][0] = node.start;
                    ans[i][1] = node.end;
                }
            }

            return ans;
        }

        class Node {
            int start;
            int end;

            public Node(int start, int end) {
                this.start = start;
                this.end = end;
            }
        }
    }

    public static void main(String[] args) {
        new P2564().new Solution().substringXorQueries("101101", Arrs.build2D("[[0,5],[1,2]]"));
    }

}
