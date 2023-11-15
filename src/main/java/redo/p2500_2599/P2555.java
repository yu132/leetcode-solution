package redo.p2500_2599;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P2555 {

    class Solution {
        public int maximizeWin(int[] prizePositions, int k) {
            List<int[]> numAndCount = toNumAndCount(prizePositions);
            int start, end, endIndex = 0;
            start = end = numAndCount.get(0)[0];
            int count = 0;
            for (; endIndex < numAndCount.size(); ++endIndex) {
                end = numAndCount.get(endIndex)[0];
                if (start + k < end) {
                    break;
                }
                count += numAndCount.get(endIndex)[1];
            }

            LinkedList<Node> queue = new LinkedList<>();
            queue.offer(new Node(end, endIndex, count));

            int maxPre = -1;

            int tempCount = 0;
            int baseStart = numAndCount.get(0)[0];

            int ans = count;

            for (int i = 0; i + 1 < numAndCount.size() && endIndex < numAndCount.size(); ++i) {
                start = numAndCount.get(i + 1)[0];
                count -= numAndCount.get(i)[1];
                while (!queue.isEmpty() && queue.peek().end <= start) {
                    maxPre = Math.max(maxPre, queue.poll().count);
                }
                if (start - k <= baseStart) {
                    tempCount += numAndCount.get(i)[1];
                }
                for (; endIndex < numAndCount.size(); ++endIndex) {
                    end = numAndCount.get(endIndex)[0];
                    if (start + k < end) {
                        break;
                    }
                    count += numAndCount.get(endIndex)[1];
                }
                queue.offer(new Node(end, endIndex, count));
                if (maxPre == -1) {
                    ans = Math.max(ans, tempCount + count);
                } else {
                    ans = Math.max(ans, maxPre + count);
                }
            }

            return ans;
        }

        class Node {
            int end;
            int endIndex;
            int count;

            public Node(int end, int endIndex, int count) {
                this.end = end;
                this.endIndex = endIndex;
                this.count = count;
            }
        }

        // 需要num是排序的
        public List<int[]> toNumAndCount(int[] nums) {
            List<int[]> ans = new ArrayList<>();
            if (nums.length == 0) {
                return ans;
            }
            int num = nums[0];
            int count = 1;
            for (int i = 1; i < nums.length; ++i) {
                if (nums[i] == num) {
                    ++count;
                } else {
                    ans.add(new int[]{num, count});
                    num = nums[i];
                    count = 1;
                }
            }
            ans.add(new int[]{num, count});
            return ans;
        }
    }

    public static void main(String[] args) {
        int ans = new P2555().new Solution().maximizeWin(new int[]{1, 1, 1, 2, 2, 2, 2, 3, 7, 8, 9, 10, 11, 11, 11, 11, 11}, 3);
        System.out.println(ans);
    }

}
