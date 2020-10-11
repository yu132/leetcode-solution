package _1000_1099;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**  
 * @ClassName: _1054  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月4日  
 *  
 */
public class _1054 {

    class Solution {
        public int[] rearrangeBarcodes(int[] barcodes) {
            Node head, tail;
            head = tail = new Node(0, Integer.MAX_VALUE);
            Map<Integer, Node> map = new HashMap<>();

            for (int each : barcodes) {
                if (!map.containsKey(each)) {
                    tail.next        = new Node(each, 1);
                    tail.next.before = tail;
                    map.put(each, tail.next);
                    tail = tail.next;
                } else {
                    Node node = map.get(each);
                    ++node.count;
                    if (node.count > node.before.count) {
                        Node nBefore = node.before;
                        int  temp1   = nBefore.num, temp2 = nBefore.count;
                        nBefore.num   = node.num;
                        nBefore.count = node.count;
                        node.num      = temp1;
                        node.count    = temp2;
                        map.put(nBefore.num, nBefore);
                        map.put(node.num, node);
                    }
                }
            }

            for (int i = 0; i < barcodes.length; i += 2) {
                barcodes[i] = head.next.num;
                --head.next.count;
                if (head.next.count == 0) {
                    head.next = head.next.next;
                }
            }

            for (int i = 1; i < barcodes.length; i += 2) {
                barcodes[i] = head.next.num;
                --head.next.count;
                if (head.next.count == 0) {
                    head.next = head.next.next;
                }
            }

            return barcodes;
        }

        class Node {
            int count;
            int num;
            Node next;
            Node before;

            public Node(int num, int count) {
                super();
                this.count = count;
                this.num   = num;
            }
        }
    }

    public static void main(String[] args) {
        System.out
            .println(Arrays.toString(new _1054().new Solution().rearrangeBarcodes(new int[] {1, 1, 1, 1, 2, 2, 3, 3})));

    }
}
