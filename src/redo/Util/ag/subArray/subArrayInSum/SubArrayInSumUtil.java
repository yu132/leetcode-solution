package redo.Util.ag.subArray.subArrayInSum;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: SubArrayInSumUtil  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月5日  
 *  
 */
public class SubArrayInSumUtil {

    public static List<int[]> getShortestSubArrayInSum(int[] nums, int targetSum) {
        Map<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, -1);

        List<int[]> ans = new ArrayList<>();
        int prefixSum = 0;

        for (int i = 0; i < nums.length; ++i) {
            prefixSum += nums[i];

            if (prefixMap.containsKey(prefixSum - targetSum)) {
                ans.add(new int[] {prefixMap.get(prefixSum - targetSum) + 1, i + 1});
            }

            prefixMap.put(prefixSum, i);
        }

        return ans;
    }

    public static List<int[]> getSubArrayInSum(int[] nums, int targetSum) {
        ListMap<Integer, Integer> prefixMap = new ListMap<>();
        prefixMap.add(0, -1);

        List<int[]> ans = new ArrayList<>();
        int prefixSum = 0;

        for (int i = 0; i < nums.length; ++i) {
            prefixSum += nums[i];

            if (prefixMap.contains(prefixSum - targetSum)) {
                for (int j : prefixMap.get(prefixSum - targetSum)) {
                    ans.add(new int[] {j + 1, i + 1});
                }
            }

            prefixMap.add(prefixSum, i);
        }

        return ans;
    }

    // 双指针法，只能用于nums中所有值大于0的情况，不能存在负数或者0
    public static List<int[]> getSubArrayInSumUse2Pointer(int[] nums, int targetSum) {
        List<int[]> ans = new ArrayList<>();
        int sum = 0;

        for (int left = 0, right = 0; right < nums.length; ++right) {
            sum += nums[right];

            while (left <= right && sum > targetSum) {
                sum -= nums[left++];
            }

            if (left <= right && sum == targetSum) {
                ans.add(new int[] {left, right + 1});
            }
        }

        return ans;
    }

    static class ListMap<K, E> {

        Map<K, List<E>> map = new HashMap<>();

        public void add(K key, E element) {
            map.computeIfAbsent(key, (x) -> new ArrayList<>()).add(element);
        }

        public void remove(K key, E element) {
            map.computeIfAbsent(key, (x) -> new ArrayList<>()).remove(element);
        }

        public List<E> get(K key) {
            return map.getOrDefault(key, Collections.emptyList());
        }

        public boolean contains(K key) {
            return !get(key).isEmpty();
        }
    }

    @Test
    public void test() {
        assertEquals("[[0,2],[2,3]]", Arrs.toStr(getSubArrayInSum(new int[] {1, 2, 3, 4, 5, 6}, 3)));
        assertEquals("[[0,1],[0,2],[1,2]]", Arrs.toStr(getSubArrayInSum(new int[] {0, 0}, 0)));
        assertEquals("[[0,2],[1,3],[3,4]]", Arrs.toStr(getSubArrayInSumUse2Pointer(new int[] {6, 1, 6, 7}, 7)));
    }

}
