package redo.p0200_0299;

import model.ListNode;

/**  
 * @ClassName: P237  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月18日  
 *  
 */
public class P237 {

    class Solution {
        public void deleteNode(ListNode node) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }

}
