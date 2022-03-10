package redo.p0400_0499;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P432  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月17日  
 *  
 */
public class P432 {

    class AllOne {

        Map<Integer, Node> count2Strmap = new HashMap<>();

        Map<String, Integer> str2CountMap = new HashMap<>();

        Node head = new Node(0), tail = new Node(Integer.MAX_VALUE);

        {
            head.next = tail;
            tail.prev = head;

            count2Strmap.put(0, head);
        }

        class Node {
            Node next, prev;

            int val;

            Set<String> strs = new HashSet<>();

            public Node(int val) {
                super();
                this.val = val;
            }

            void inc(String str) {
                if (next.val != val + 1) {
                    addNodeNext();
                }
                if (this != head) {
                    strs.remove(str);
                }
                next.strs.add(str);
                if (strs.size() == 0 && this != head) {
                    removeSelf();
                }
            }

            void dec(String str) {
                if (prev.val != val - 1) {
                    addNodePrev();
                }
                strs.remove(str);
                if (prev != head) {
                    prev.strs.add(str);
                }
                if (strs.size() == 0) {
                    removeSelf();
                }
            }

            void addNodePrev() {
                Node node = new Node(val - 1);
                node.prev = prev;
                node.next = this;

                prev.next = node;
                prev = node;

                count2Strmap.put(val - 1, node);
            }

            void addNodeNext() {
                Node node = new Node(val + 1);
                node.next = next;
                node.prev = this;

                next.prev = node;
                next = node;

                count2Strmap.put(val + 1, node);
            }

            void removeSelf() {
                next.prev = prev;
                prev.next = next;
            }
        }

        /** Initialize your data structure here. */
        public AllOne() {}

        /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
        public void inc(String key) {
            int count = str2CountMap.getOrDefault(key, 0);
            str2CountMap.put(key, count + 1);

            Node n = count2Strmap.get(count);
            n.inc(key);
        }

        /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
        public void dec(String key) {
            if (!str2CountMap.containsKey(key)) {
                return;
            }

            int count = str2CountMap.get(key);
            if (count - 1 != 0) {
                str2CountMap.put(key, count - 1);
            } else {
                str2CountMap.remove(key);
            }

            Node n = count2Strmap.get(count);
            n.dec(key);
        }

        /** Returns one of the keys with maximal value. */
        public String getMaxKey() {
            if (tail.prev == head) {
                return "";
            }
            return tail.prev.strs.iterator().next();
        }

        /** Returns one of the keys with Minimal value. */
        public String getMinKey() {
            if (head.next == tail) {
                return "";
            }
            return head.next.strs.iterator().next();
        }
    }



    @Test
    public void test() {
        AllOne s = new AllOne();
        for (int i = 0; i < 2; ++i) {
            s.inc("1");
            s.dec("1");
        }
        System.out.println(s.getMaxKey());
        System.out.println(s.getMinKey());
    }

}
