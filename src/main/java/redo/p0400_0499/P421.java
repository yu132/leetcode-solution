package redo.p0400_0499;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P421  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月28日  
 *  
 */
public class P421 {

    static//

    class Solution {
        public int findMaximumXOR(int[] nums) {
            int maxBit = 0;
            for (int num : nums) {
                maxBit |= num;
            }
            maxBit = Integer.highestOneBit(maxBit);

            int ans = 0;

            BitTrieNode root = new BitTrieNode();

            for (int num : nums) {
                add(root, num, maxBit);
            }

            for (int num : nums) {
                ans = Math.max(ans, findMax(root, root, num, maxBit));
            }

            return ans;
        }

        int findMax(BitTrieNode now, BitTrieNode Opposed, int num, int maxBit) {
            int ans = 0, index;
            for (; maxBit != 0; maxBit >>= 1, now = now.children[index]) {
                index = (num & maxBit) == 0 ? 0 : 1;
                if (Opposed.children[index ^ 1] != null) {
                    ans |= maxBit;
                    Opposed = Opposed.children[index ^ 1];
                } else {
                    Opposed = Opposed.children[index];
                }
            }
            return ans;
        }

        void add(BitTrieNode root, int num, int maxBit) {
            int index;
            for (; maxBit != 0; maxBit >>= 1, root = root.children[index]) {
                index = (num & maxBit) == 0 ? 0 : 1;
                if (root.children[index] == null) {
                    root.children[index] = new BitTrieNode();
                }
            }
        }

        static class BitTrieNode {
            BitTrieNode[] children = new BitTrieNode[2];
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(28,
            s.findMaximumXOR(new int[] {3, 10, 5, 25, 2, 8}));
    }

}
