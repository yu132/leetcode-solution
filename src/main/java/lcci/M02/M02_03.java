package lcci.M02;

import model.ListNode;

/**  
 * @ClassName: M02_03  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月26日  
 *  
 */
public class M02_03 {

    class Solution {
        public void deleteNode(ListNode node) {
            node.val  = node.next.val;
            node.next = node.next.next;
        }
    }

}
