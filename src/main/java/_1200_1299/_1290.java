/**
 * @Title: _1290.java
 *
 * @Package _1200_1299
 *
 * @Description: TODO(用一句话描述该文件做什么)
 *
 * @author 余定邦
 *
 * @date 2020年1月7日
 *
 */
package _1200_1299;

import model.ListNode;

/**
 * @ClassName: _1290
 *
 * @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author 余定邦
 *
 * @date 2020年1月7日
 * 
 */
public class _1290 {

    class Solution {
        public int getDecimalValue(ListNode head) {

            StringBuilder sb = new StringBuilder();

            while (head != null) {
                sb.append(head.val);
                head = head.next;
            }

            return Integer.parseInt(sb.toString(), 2);

        }
    }

}
