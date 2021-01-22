package redo.Util.listAndArr;

import model.ListNode;

/**  
 * @ClassName: LinkedLists  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月19日  
 *  
 */
public class LinkedLists {

    static int len(ListNode head) {
        int len = 0;
        while (head != null) {
            ++len;
            head = head.next;
        }
        return len;
    }

}
