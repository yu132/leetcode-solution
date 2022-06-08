package redo.p1900_1999;

import java.util.Comparator;

public class P1986 {

    static
            //
    class Solution {

        public int minSessions(int[] tasks, int sessionTime) {

            int n = tasks.length;

            Node[] dp = new Node[1 << n];
            dp[0] = new Node(1, 0);

            CompareHelper<Node> compareHelper =
                    CompareHelper.with(Comparator.comparing(Node::getSegment).thenComparing(Node::getCurrent));

            for (int mask = 1; mask < (1 << n); ++mask) {
                dp[mask] = new Node(Integer.MAX_VALUE, Integer.MAX_VALUE);
                for (int i = 0; i < n; ++i) {
                    if ((mask & (1 << i)) != 0) {
                        Node node = new Node(dp[mask ^ (1 << i)]);
                        if (node.current + tasks[i] <= sessionTime) {
                            node.current += tasks[i];
                        } else {
                            node.segment += 1;
                            node.current = tasks[i];
                        }
                        dp[mask] = compareHelper.min(dp[mask], node);
                    }
                }
            }

            return dp[(1 << n) - 1].segment;
        }

        static class CompareHelper<T> {

            Comparator<T> comparator;

            public CompareHelper(Comparator<T> comparator) {
                this.comparator = comparator;
            }

            static <T> CompareHelper<T> with(Comparator<T> comparator) {
                return new CompareHelper<>(comparator);
            }

            T min(T... elements) {
                T min = elements[0];
                for (int i = 1; i < elements.length; ++i) {
                    if (comparator.compare(min, elements[i]) > 0) {
                        min = elements[i];
                    }
                }
                return min;
            }

        }

        class Node {
            int segment, current;

            public int getSegment() {
                return segment;
            }

            public int getCurrent() {
                return current;
            }

            public Node(int segment, int current) {
                this.segment = segment;
                this.current = current;
            }

            public Node(Node node) {
                segment = node.segment;
                current = node.current;
            }
        }
    }

}
