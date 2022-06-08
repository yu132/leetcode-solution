package redo.p0700_0799;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P706  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月21日  
 *  
 */
public class P706 {

    class MyHashMap {

        private int prime = 9973;

        private Node[] table = new Node[prime];

        /** Initialize your data structure here. */
        public MyHashMap() {
            for (int i = 0; i < prime; ++i) {
                table[i] = new Node(0, 0, null);
            }
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            int hash = key % prime;
            Node node = table[hash];
            while (node.next != null) {
                if (node.next.key == key) {
                    node.next.val = value;
                    return;
                }
                node = node.next;
            }
            node.next = new Node(key, value, null);
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            int hash = key % prime;
            Node node = table[hash];
            while (node.next != null) {
                if (node.next.key == key) {
                    return node.next.val;
                }
                node = node.next;
            }
            return -1;
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            int hash = key % prime;
            Node node = table[hash];
            while (node.next != null) {
                if (node.next.key == key) {
                    node.next = node.next.next;
                    return;
                }
                node = node.next;
            }
        }

        class Node {
            int key;
            int val;
            Node next;

            Node(int key, int val, Node next) {
                super();
                this.key = key;
                this.val = val;
                this.next = next;
            }
        }
    }



    @Test
    public void test() {
        MyHashMap s = new MyHashMap();
        s.put(1, 1);
        s.put(2, 2);
        Assert.assertEquals(1, s.get(1));
        Assert.assertEquals(-1, s.get(3));
        s.put(2, 1);
        Assert.assertEquals(1, s.get(2));
        s.remove(2);
        Assert.assertEquals(-1, s.get(2));
    }

}
