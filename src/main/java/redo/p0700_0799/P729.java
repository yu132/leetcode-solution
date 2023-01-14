package redo.p0700_0799;

import java.util.TreeMap;

public class P729 {

    class MyCalendar {

        TreeMap<Integer, Node> table = new TreeMap<>();

        public MyCalendar() {
        }

        public boolean book(int start, int end) {
            Integer temp = table.floorKey(start);
            if (temp != null) {
                if (table.get(temp).right > start) {
                    return false;
                }
            }
            temp = table.ceilingKey(start);
            if (temp != null) {
                if (end > table.get(temp).left) {
                    return false;
                }
            }
            table.put(start, new Node(start, end));
            return true;
        }

        class Node {
            int left, right;

            public Node(int left, int right) {
                this.left = left;
                this.right = right;
            }
        }
    }


}
