package redo.p2500_2599;

public class P2559 {

    class Solution {
        public int[] vowelStrings(String[] words, int[][] queries) {
            int[] nums = new int[words.length];
            for (int i = 0; i < words.length; ++i) {
                if (isLowercaseVowel(words[i].charAt(0))
                        && isLowercaseVowel(words[i].charAt(words[i].length() - 1))) {
                    nums[i] = 1;
                }
            }
            int[] prefix = prefix(nums);
            int[] ans = new int[queries.length];
            for (int i = 0; i < queries.length; ++i) {
                ans[i] = prefix[queries[i][1] + 1] - prefix[queries[i][0]];
            }
            return ans;
        }

        // 前缀和 sum(0 to i)=prefix[i+1];
        int[] prefix(int[] nums) {
            int[] prefix = new int[nums.length + 1];
            for (int i = 0; i < nums.length; ++i) {
                prefix[i + 1] = prefix[i] + nums[i];
            }
            return prefix;
        }

        public boolean isLowercaseVowel(char ch) {
            return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
        }
    }

}
