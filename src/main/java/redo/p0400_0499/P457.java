package redo.p0400_0499;

/**  
 * @ClassName: P457  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月18日  
 *  
 */
public class P457 {

    class Solution {
        public boolean circularArrayLoop(int[] nums) {

            if (nums.length <= 1) {
                return false;
            }

            int n = nums.length;

            int[] visitedPrev = new int[n], visitedNext = new int[n];

            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] < 0) {
                    if (visitPrev(i, nums, visitedPrev, n)) {
                        return true;
                    }
                } else {
                    if (visitNext(i, nums, visitedNext, n)) {
                        return true;
                    }
                }
            }

            return false;
        }

        boolean visitPrev(int index, int[] nums, int[] visited, int n) {
            if (visited[index] != 0) {
                return visited[index] == 2;
            }
            visited[index] = 2;
            if (nums[index] > 0) {
                visited[index] = 1;
                return false;
            }

            if (index == prev(index, -nums[index], n)) {
                visited[index] = 1;
                return false;
            }

            if (visitPrev(prev(index, -nums[index], n), nums, visited, n)) {
                return true;
            } else {
                visited[index] = 1;
                return false;
            }
        }

        boolean visitNext(int index, int[] nums, int[] visited, int n) {
            if (visited[index] != 0) {
                return visited[index] == 2;
            }
            visited[index] = 2;
            if (nums[index] < 0) {
                visited[index] = 1;
                return false;
            }

            if (index == next(index, nums[index], n)) {
                visited[index] = 1;
                return false;
            }

            if (visitNext(next(index, nums[index], n), nums, visited, n)) {
                return true;
            } else {
                visited[index] = 1;
                return false;
            }
        }

        int prev(int index, int bias, int len) {
            bias %= len;
            return (index + len - bias) % len;
        }

        int next(int index, int bias, int len) {
            bias %= len;
            return (index + bias) % len;
        }
    }

}
