package redo.p0700_0799;

import static org.junit.Assert.*;

import org.junit.Test;

/**  
 * @ClassName: P705  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月21日  
 *  
 */
public class P705 {

    class MyHashSet {

        private int prime = 9973;

        private Node[] table = new Node[prime];

        /** Initialize your data structure here. */
        public MyHashSet() {
            for (int i = 0; i < prime; ++i) {
                table[i] = new Node(0, null);
            }
        }

        public void add(int key) {
            int hash = key % prime;
            Node node = table[hash];
            while (node.next != null) {
                if (node.next.val == key) {
                    return;
                }
                node = node.next;
            }
            node.next = new Node(key, null);
        }

        public void remove(int key) {
            int hash = key % prime;
            Node node = table[hash];
            while (node.next != null) {
                if (node.next.val == key) {
                    node.next = node.next.next;
                    return;
                }
                node = node.next;
            }
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            int hash = key % prime;
            Node node = table[hash];
            while (node.next != null) {
                if (node.next.val == key) {
                    return true;
                }
                node = node.next;
            }
            return false;
        }

        class Node {
            int val;
            Node next;

            Node(int val, Node next) {
                super();
                this.val = val;
                this.next = next;
            }
        }
    }



    @Test
    public void test() {
        MyHashSet s = new MyHashSet();
        s.add(1);
        s.add(2);
        assertTrue(s.contains(1));
        assertTrue(!s.contains(3));
        s.add(2);
        assertTrue(s.contains(2));
        s.remove(2);
        assertTrue(!s.contains(2));
    }

}
