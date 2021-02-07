package redo.offer;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P33  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月5日  
 *  
 */
public class P33 {

    class Solution {
        public boolean verifyPostorder(int[] postorder) {

            int root = Integer.MAX_VALUE;

            Deque<Integer> mstack = new LinkedList<>();

            for (int i = postorder.length - 1; i >= 0; --i) {
                if (postorder[i] > root) {
                    return false;
                }
                while (!mstack.isEmpty() && mstack.peek() > postorder[i]) {
                    root = mstack.pop();
                }
                mstack.push(postorder[i]);
            }

            return true;
        }
    }

    // class Solution {
    // public boolean verifyPostorder(int[] postorder) {
    // return helper(postorder, 0, postorder.length);
    // }
    //
    // public boolean helper(int[] arr, int low, int high) {
    // if (low >= high - 1) {
    // return true;
    // }
    // int val = arr[high - 1];
    // int ll = low, hh = high - 1;
    // while (ll < hh && arr[ll] < val) {
    // ++ll;
    // }
    // while (ll < hh && arr[hh - 1] > val) {
    // --hh;
    // }
    // return ll == hh && helper(arr, low, ll)
    // && helper(arr, ll, high - 1);
    // }
    // }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(false,
            s.verifyPostorder(new int[] {1, 6, 3, 2, 5}));
        Assert.assertEquals(true, s.verifyPostorder(new int[] {1, 3, 2, 6, 5}));
        Assert.assertEquals(true,
            s.verifyPostorder(new int[] {4, 8, 6, 12, 16, 14, 10}));

        Assert.assertEquals(false, s.verifyPostorder(
            new int[] {5, 2, -17, -11, 25, 76, 62, 98, 92, 61}));

    }

}
