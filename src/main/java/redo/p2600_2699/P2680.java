package redo.p2600_2699;

public class P2680 {

    class Solution {
        public long maximumOr(int[] nums, int k) {
            int nowBits = 0;
            int[] prefixBits = prefixBits(nums);
            long max = 0;
            for (int i = nums.length - 1; i >= 0; --i) {
                long now = (((long) nums[i]) << k) | (prefixBits[i] | nowBits);
                max = Math.max(max, now);
                nowBits |= nums[i];
            }
            return max;
        }

        int[] prefixBits(int[] nums) {
            int[] prefixBits = new int[nums.length + 1];
            for (int i = 0; i < nums.length; ++i) {
                prefixBits[i + 1] = prefixBits[i] | nums[i];
            }
            return prefixBits;
        }
    }


    /*
     long maxBit = 0;
            Set<Integer> maxBits = new HashSet<>();
            for (int num : nums) {
                int nowMaxBit = Integer.highestOneBit(num);
                if (nowMaxBit > maxBit) {
                    maxBit = nowMaxBit;
                    maxBits.clear();
                    maxBits.add(num);
                } else if (nowMaxBit == maxBit) {
                    maxBits.add(num);
                }
            }
            List<Integer> maxBitsList = new ArrayList<>();
            List<Integer> prefixBitsList = new ArrayList<>();
            prefixBitsList.add(0);
            int last = 0;
            int other = 0;
            for (int num : nums) {
                if (maxBits.contains(num)) {
                    maxBitsList.add(num);
                    prefixBitsList.add(num | last);
                    last = num;
                } else {
                    other |= num;
                }
            }
            int nowSuffixBits = 0;
            for (int i = maxBitsList.size() - 1; i >= 0; --i) {
                long oo = nowSuffixBits | prefixBitsList.get(i) | other;

            }
     */
}
