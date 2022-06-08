package _0800_0899;

import java.util.Arrays;

/**  
 * @ClassName: _846  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月3日  
 *  
 */
public class _846 {

    class Solution {

        public boolean isNStraightHand(int[] hand, int W) {

            if (hand.length % W != 0) {
                return false;
            }

            Arrays.sort(hand);

            Node head, tail;

            head = tail = new Node(0, 0);

            int num   = hand[0];
            int count = 1;

            for (int i = 1; i < hand.length; ++i) {
                if (num == hand[i]) {
                    ++count;
                } else {
                    tail.next = new Node(num, count);
                    tail      = tail.next;
                    num       = hand[i];
                    count     = 1;
                }
            }

            tail.next = new Node(num, count);

            while (head.next != null) {
                num = head.next.num;
                Node node = head;

                for (int i = 0; i < W; ++i) {
                    if (node.next == null || num + i != node.next.num) {
                        return false;
                    } else {
                        --node.next.count;
                        if (node.next.count == 0) {
                            node.next = node.next.next;
                        } else {
                            node = node.next;
                        }
                    }
                }
            }

            return true;
        }

        public class Node {
            int num;
            int count;
            Node next;

            public Node(int num, int count) {
                super();
                this.num   = num;
                this.count = count;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new _846().new Solution().isNStraightHand(new int[] {1, 2, 3, 6, 2, 3, 4, 7, 8}, 3));
    }

}
