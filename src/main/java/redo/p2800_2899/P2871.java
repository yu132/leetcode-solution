package redo.p2800_2899;

import redo.testUtil.Arrs;

import java.util.LinkedList;

public class P2871 {

    class Solution {
        public int maxSubarrays(int[] nums) {
            LinkedList<Integer> queue = new LinkedList<>();
            for (int num : nums) {
                queue.push(num);
                while (queue.size() >= 2) {
                    int n1 = queue.pop();
                    int n2 = queue.pop();
                    if (n2 > (n1 & n2)) {
                        queue.push(n1 & n2);
                    } else {
                        queue.push(n2);
                        queue.push(n1);
                        break;
                    }
                }
            }
            while (queue.size() >= 2) {
                int n1 = queue.pop();
                int n2 = queue.pop();
                if (n1 + n2 > (n1 & n2)) {
                    queue.push(n1 & n2);
                } else {
                    queue.push(n2);
                    queue.push(n1);
                    break;
                }
            }
            return queue.size();
        }
    }

    public static void main(String[] args) {
        int ans = new P2871().new Solution().maxSubarrays(Arrs.build("[1,2,2,1]"));
        System.out.println(ans);
    }

}
