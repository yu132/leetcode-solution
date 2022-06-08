package redo.p0400_0499;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P430  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月16日  
 *  
 */
public class P430 {

    class Solution {
        public Node flatten(Node head) {
            last(head);
            return head;
        }

        Node last(Node node) {

            Node ret = node;

            while (node != null) {
                if (node.child != null) {
                    Node child = node.child;
                    Node next = node.next;
                    Node last = last(child);

                    node.child = null;

                    node.next = child;
                    child.prev = node;

                    last.next = next;
                    if (next != null) {
                        next.prev = last;
                    }

                    if (next != null) {
                        ret = next;
                    } else {
                        ret = last;
                    }

                    node = next;
                } else {
                    ret = node;
                    node = node.next;
                }
            }

            return ret;
        }
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };

}
