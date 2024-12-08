package redo.p2400_2499;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class P2418 {

    class Solution {
        public String[] sortPeople(String[] names, int[] heights) {
            List<Node> nodes = new ArrayList<>();
            for (int i = 0; i < names.length; ++i) {
                nodes.add(new Node(names[i], heights[i]));
            }
            nodes.sort(Comparator.comparing(x -> -x.height));
            return nodes.stream().map(x -> x.name).toArray(String[]::new);
        }

        class Node {
            String name;
            int height;

            public Node(String name, int height) {
                this.name = name;
                this.height = height;
            }
        }
    }

}
