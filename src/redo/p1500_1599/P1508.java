package redo.p1500_1599;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1508  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月6日  
 *  
 */
public class P1508 {

    class Solution {

        public final static int MOD = 1000000007;

        public int rangeSum(int[] nums, int n, int left, int right) {
            int[] prefixSum = new int[nums.length + 1], prefixPrefixSum = new int[nums.length + 1];
            for (int i = 0; i < nums.length; ++i) {
                prefixSum[i + 1] = prefixSum[i] + nums[i];
                prefixPrefixSum[i + 1] = prefixPrefixSum[i] + prefixSum[i + 1];
            }
            return getAllSubArrsSum(prefixPrefixSum, prefixSum, right, n)
                - getAllSubArrsSum(prefixPrefixSum, prefixSum, left - 1, n);
        }

        /*
         * 此子问题是在前面两个问题完成之后的一个问题
         * 即求排序2D数组中小于num的所有数的和，如果是一般情况给定二维数组的情况下
         * 依然不得不遍历二维数组中遍历的边界之外的元素，以本题的矩阵为例
         * 
         *  1   3   6   10    
         *      2   5   9
         *          3   7
         *              4
         * 
         * 求小于等于5的元素，我们的遍历顺序是1,3,6,5,9,7,4的顺序，但是为了求和，
         * 每次都依然需要遍历下面的已知一定小于num的元素，因为需要知道具体的数是什么，
         * 因此遍历顺序是1,3(2),6,5(3),9,7,4，除了10没有遍历之外其他的所有元素都需要遍历
         * 
         * 但是本数组比较特殊，可以通过前缀和的前缀和来进行快速计算，无需遍历整个数组即可求出结果
         * 对于原数组为【1，2，3，4】，则前缀和数组为【0，1，3，6，10】其和矩阵第一行是完全一致的
         * 前缀和的前缀和数组则为【0，1，4，10，20】
         * 
         * 此处按行求和比较简单，因此就不按列求和，例如求第二行的【2，5】两项的和，此时我们应当遍历到9
         * 发现9太大了，比5要大，因此要向下移动，然后我们先将j=j-1，此时j的位置为5所在的位置，i表示行数
         * 
         * prefixPrefixSum[j+1] = 10 = 1+3+6 = (1)+(1+2)+(1+2+3)
         * 
         * 我们需要的和为 2+5 = (2)+(2+3) = 10 - 1 - (j-i+1) * 1
         * 
         * 同理，如果我们需要加和为第三行的【3】，那么我们需要的和为3 = (3) = 10 - 4 - (j-i+1) * 3
         * 
         * 可以发现规律为sum(i,j) = prefixPrefixSum[j+1] - prefixPrefixSum[i] - (j-i+1) * prefixSum[i]
         * 
         * 因此可以和countLittleThanNum方法类似，去找到小于num的边界，然后对于每一行计算sum(i,j)，然后总和
         * 就为“‘大小小于num的子数组’ 的 和”的总和，和我们的结果就非常接近了
         * 
         * 但是我们的目标是求出前k小的子数组的和的总和，而不是小于等于第k小的总和的子数组和的总和
         * 
         * 例如有子数组和为 1,1,1,2,2,2,[3],3,3,4,4,4，并且此时k为7，那么我们并不能将所有的和为3的子数组都
         * 计入最后的总和，否则结果就会偏大，不过运气很好的是，我们只有可能多计算值为num的子数组和，
         * 如果此时我们统计我们计算的子数组数量cnt，并且此时已知需要子数组数量为k，那么多计算的数量就是k-cnt
         * 由于多计算的子数组大小一定为num，因此多计算的值为(cnt-k)*num
         * 
         */
        public int getAllSubArrsSum(int[] prefixPrefixSum, int[] prefixSum, int k, int n) {
            int num = minK(prefixSum, k, n), count = 0;
            long sum = 0;

            for (int i = 0, j = 0; i < n; ++i) {
                while (j < n && num >= get2DArray(i, j, prefixSum)) {
                    ++j;
                }
                --j;
                sum = (sum + sumLine(i, j, prefixPrefixSum, prefixSum)) % MOD;
                count += j - i + 1;
            }

            return (int)(sum - (count - k) * num);
        }

        public int sumLine(int i, int j, int[] prefixPrefixSum, int[] prefixSum) {
            return prefixPrefixSum[j + 1] - prefixPrefixSum[i] - (j - i + 1) * prefixSum[i];
        }

        /*
         * 此处实质是遍历一个2d的数组，去寻找数组中第k小的元素
         * 思想见 @Code Sorted2DArrayUtil，不过此处有略微的变化
         * 这个2d数组并不是一个完整的数组，而是一个上三角数组，并且排序的顺序略有区别
         * 正常的排序2D数组是从【上到下】和从左到右有序，但本数组是从【下到上】、从左到右有序
         * 并且本题中的数组并未直接给出，而是以一种前缀和计算的方式给出
         * 以下以【1，2，3，4】数组为例，给出本2D矩阵，
         * 
         *  1   3   6   10    
         *      2   5   9
         *          3   7
         *              4
         *              
         * 本矩阵是子数组和矩阵，A[i,j]表示从i到j（包括）的子数组的和，由于j不能大于i，因此没有下半边的矩阵
         * 因此寻找本矩阵第k小的数字，即寻找原数组中子数组中第k小的子数组的和
         * 
         * 但是本数组并未直接给出，但是可以通过前缀和计算得到相应的结果，A[i,j]=prefixSum[j+1]-prefixSum[i];
         * 
         * 由于矩阵的顺序有变化，因此遍历的顺序也发生了变化，原本是从左下向右上进行双指针遍历，此处明显应该将
         * 上下进行颠倒，因此从左上向右下进行遍历
         */
        public int minK(int[] prefixSum, int k, int n) {
            int low = 0, high = prefixSum[n];
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (countLittleThanNum(prefixSum, mid, n) >= k) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }

        public int countLittleThanNum(int[] prefixSum, int num, int n) {
            int x = 0, y = 0, count = 0;
            while (y < n) {
                if (get2DArray(x, y, prefixSum) <= num) {
                    count += y - x + 1;
                    ++y;
                } else {
                    ++x;
                    if (x > y) {
                        ++y;
                    }
                }
            }
            return count;
        }

        public int get2DArray(int x, int y, int[] prefixSum) {
            return prefixSum[y + 1] - prefixSum[x];
        }
    }


    private static void print(int[] arr) {
        int[] prefixSum = new int[arr.length + 1];
        for (int i = 0; i < arr.length; ++i) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }
        System.out.println(Arrays.toString(prefixSum));
        System.out.println();
        for (int i = 0; i < arr.length; ++i) {
            for (int j = 0; j < i; ++j) {
                System.out.print("   ");
            }
            for (int j = i; j < arr.length; ++j) {
                System.out.print(prefixSum[j + 1] - prefixSum[i] + " ");
            }
            System.out.println();
        }
    }


    @Test
    public void test() {
        Solution s = new Solution();
        // Assert.assertEquals(6, s.countLittleThanNum(new int[] {0, 1, 3, 6, 10}, 5, 4));
        // Assert.assertEquals(5, s.minK(new int[] {0, 1, 3, 6, 10}, 6, 4));
        //
        // Assert.assertEquals(13, s.rangeSum(new int[] {1, 2, 3, 4}, 4, 1, 5));
        // Assert.assertEquals(6, s.rangeSum(new int[] {1, 2, 3, 4}, 4, 3, 4));
        // Assert.assertEquals(50, s.rangeSum(new int[] {1, 2, 3, 4}, 4, 1, 10));

        print(new int[] {7, 5, 8, 5, 6, 4, 3, 3});
        Assert.assertEquals(5, s.countLittleThanNum(new int[] {0, 7, 12, 20, 25, 31, 35, 38, 41}, 5, 8));
        Assert.assertEquals(3, s.minK(new int[] {0, 7, 12, 20, 25, 31, 35, 38, 41}, 1, 8));

        // Assert.assertEquals(3, s.rangeSum(new int[] {7, 5, 8, 5, 6, 4, 3, 3}, 8, 1, 6));
        Assert.assertEquals(23, s.rangeSum(new int[] {7, 5, 8, 5, 6, 4, 3, 3}, 8, 2, 6));
    }

}
