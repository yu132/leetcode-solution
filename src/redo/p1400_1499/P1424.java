package redo.p1400_1499;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1424  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月8日  
 *  
 */
public class P1424 {

    static//

    class Solution {

        public int[] findDiagonalOrder(List<List<Integer>> nums) {
            List<Integer> ans = new ArrayList<>();

            DualLinkedNode<Data> head = new DualLinkedNode<>(null);

            for (int i = 0; i < nums.size(); ++i) {
                head.appendNext(new Data(nums.get(i), 0));
                visit(ans, head);
            }

            while (head.next != null) {
                visit(ans, head);
            }

            return toIntArray(ans);
        }

        private void visit(List<Integer> ans, DualLinkedNode<Data> head) {
            DualLinkedNode<Data> node = head.next;
            while (node != null) {
                if (node.data.list.size() == node.data.index) {
                    DualLinkedNode<Data> next = node.next;
                    node.removeThis();
                    node = next;
                } else {
                    ans.add(node.data.list.get(node.data.index++));
                    node = node.next;
                }
            }
        }

        static class Data {
            List<Integer> list;
            int index;

            public Data(List<Integer> list, int index) {
                super();
                this.list = list;
                this.index = index;
            }
        }

        static class DualLinkedNode<T> {

            T data;

            DualLinkedNode<T> last, next;

            public DualLinkedNode(T data) {
                super();
                this.data = data;
            }

            void appendNext(T data) {
                if (next == null) {
                    next = new DualLinkedNode<T>(data);
                    next.last = this;
                    return;
                }

                DualLinkedNode<T> node = new DualLinkedNode<T>(data);
                node.last = this;
                node.next = this.next;
                this.next.last = node;
                this.next = node;
            }

            void removeThis() {
                if (next == null) {
                    last.next = null;
                    return;
                }

                last.next = next;
                next.last = last;
            }
        }

        public static int[] toIntArray(List<Integer> list) {
            int[] arr = new int[list.size()];
            for (int i = 0; i < arr.length; ++i) {
                arr[i] = list.get(i);
            }
            return arr;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new int[] {1, 4, 2, 7, 5, 3, 8, 6, 9},
            s.findDiagonalOrder(Arrs.build2DL("[[1,2,3],[4,5,6],[7,8,9]]")));

        Assert.assertArrayEquals(new int[] {1, 6, 2, 8, 7, 3, 9, 4, 12, 10, 5, 13, 11, 14, 15, 16},
            s.findDiagonalOrder(Arrs.build2DL("[[1,2,3,4,5],[6,7],[8],[9,10,11],[12,13,14,15,16]]")));

        Assert.assertArrayEquals(new int[] {1, 4, 2, 5, 3, 8, 6, 9, 7, 10, 11},
            s.findDiagonalOrder(Arrs.build2DL("[[1,2,3],[4],[5,6,7],[8],[9,10,11]]")));

        Assert.assertArrayEquals(new int[] {1, 2, 3, 4, 5, 6}, s.findDiagonalOrder(Arrs.build2DL("[[1,2,3,4,5,6]]")));
    }

}
