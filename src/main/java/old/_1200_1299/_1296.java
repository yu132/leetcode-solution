package old._1200_1299;

import java.util.Arrays;

/**  
 * @ClassName: _1296  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月3日  
 *  
 */
public class _1296 {

    class Solution {
        public boolean isPossibleDivide(int[] nums, int k) {

            if (nums.length % k != 0) {
                return false;
            }

            Arrays.sort(nums);

            Node head, tail;

            head = tail = new Node(0, 0);

            int num   = nums[0];
            int count = 1;

            for (int i = 1; i < nums.length; ++i) {
                if (num == nums[i]) {
                    ++count;
                } else {
                    tail.next = new Node(num, count);
                    tail      = tail.next;
                    num       = nums[i];
                    count     = 1;
                }
            }

            tail.next = new Node(num, count);

            while (head.next != null) {
                num = head.next.num;
                Node node = head;

                for (int i = 0; i < k; ++i) {
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

}
