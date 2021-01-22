package redo.Util.ds.segmentTree;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.Test;

/**  
 * @ClassName: MaxSegmentTree  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月16日  
 *  
 */
public class MaxSegmentTreeUtil {

    // 单点更新，区间查询，如果要最小值，将Math.max替换为Math.min即可
    static class MaxSegmentTree {

        int n, tree[];
        int buildIndex, nums[];

        public MaxSegmentTree(int[] nums) {
            super();
            this.n = nums.length;
            this.tree = new int[4 * n + 1];

            this.buildIndex = 0;
            this.nums = nums;
            build(1, 1, 10);
        }

        void pushup(int i) {
            tree[i] = Math.max(tree[i << 1], tree[i << 1 | 1]);
        }

        void build(int i, int l, int r) {
            if (l == r) {
                tree[i] = nums[buildIndex++];
                return;
            }
            int mid = (l + r) / 2;
            build(i << 1, l, mid);
            build(i << 1 | 1, mid + 1, r);
            pushup(i);
        }

        void update(int x, int val) {
            update(1, 1, n, x + 1, val);
        }

        void update(int i, int l, int r, int x, int val) {
            if (l == r) {
                tree[i] = val;
                return;
            }
            int mid = (l + r) / 2;
            if (x <= mid)
                update(i << 1, l, mid, x, val);
            else
                update(i << 1 | 1, mid + 1, r, x, val);
            pushup(i);
        }

        int query(int x, int y) {
            return query(1, 1, n, x + 1, y);
        }

        private int query(int i, int l, int r, int x, int y) {
            if (x <= l && r <= y)
                return tree[i];
            int maxm = 0;
            int mid = (l + r) / 2;
            if (x <= mid)
                maxm = Math.max(maxm, query(i << 1, l, mid, x, y));
            if (y > mid)
                maxm = Math.max(maxm, query(i << 1 | 1, mid + 1, r, x, y));
            return maxm;
        }
    }



    @Test
    public void test() {

        int[] nums = new int[10000];

        ThreadLocalRandom random = ThreadLocalRandom.current();

        Arrays.setAll(nums, x -> random.nextInt());

        MaxSegmentTree s = new MaxSegmentTree(nums);

        long a = System.currentTimeMillis();
        for (int i = 0; i < 100000; ++i) {
            int max = 0;
            for (int num : nums) {
                max = Math.max(max, num);
            }
        }
        System.out.println(System.currentTimeMillis() - a);

        long b = System.currentTimeMillis();
        for (int i = 0; i < 100000; ++i) {
            s.query(0, nums.length);
        }
        System.out.println(System.currentTimeMillis() - b);
        // Assert.assertEquals(100, s.query(1, 1, 10, 1, 1));
        // Assert.assertEquals(0, s.query(1, 1, 10, 2, 2));
    }

}
