package old._0700_0799;

/**  
 * @ClassName: _708  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月17日  
 *  
 */
public class _708 {

    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val  = _val;
            next = _next;
        }
    };

    class Solution {
        public Node insert(Node head, int insertVal) {
            if (head == null) {
                head      = new Node(insertVal);
                head.next = head;
                return head;
            }
            if (head == head.next) {
                head.next = new Node(insertVal, head);
                return head;
            }
            Node    node = head;
            boolean flag = false;
            while (true) {
                if (node == head) {
                    if (!flag) {
                        flag = true;
                        node = node.next;
                    } else {
                        node.next = new Node(insertVal, node.next);
                        return head;
                    }
                }

                boolean goNext = false, insert = false;
                if (node.val < node.next.val) {
                    if (insertVal > node.next.val) {
                        goNext = true;
                    } else if (insertVal == node.next.val) {
                        insert = true;
                    } else {// insertVal < node.next.val
                        if (insertVal < node.val) {
                            goNext = true;
                        } else {// node.val <= insertVal
                            insert = true;
                        }
                    }
                } else if (node.val > node.next.val) {
                    if (node.val <= insertVal) {
                        insert = true;
                    } else {// insertVal < node.val
                        if (node.next.val >= insertVal) {
                            insert = true;
                        } else {// node.next.val < insertVal
                            goNext = true;
                        }
                    }
                } else {// node.val == node.next.val
                    if (node.val == insertVal) {
                        insert = true;
                    } else {
                        goNext = true;
                    }
                }
                if (goNext) {
                    node = node.next;
                } else if (insert) {
                    node.next = new Node(insertVal, node.next);
                    return head;
                }
            }
        }
    }

    /*
    else if (node.val > insertVal) {
                    if (insertVal < node.next.val) {
                        if (node.val > node.next.val) {
                            node.next = new Node(insertVal, node.next);
                            return head;
                        } else {
                            node = node.next;
                        }
                    } else {
                        node.next = new Node(insertVal, node.next);
                        return head;
                    }
                } else if (node.val == insertVal) {
                    node.next = new Node(insertVal, node.next);
                    return head;
                } else {// node.val < insertVal
                    if (node.val < node.next.val) {
                        if (insertVal < node.next.val) {
                            node.next = new Node(insertVal, node.next);
                            return head;
                        } else {
                            node = node.next;
                        }
                    } else {
                        node.next.next = new Node(insertVal, node.next.next);
                        return head;
                    }
                }
    
    */

}
