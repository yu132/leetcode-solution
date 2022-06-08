package redo.Util.ag.allPermutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

/**  
 * @ClassName: JohnsonTrotter  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年4月17日  
 *  
 */
public class JohnsonTrotter {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        ans.add(toList(nums));

        boolean[] left = new boolean[nums.length];

        Arrays.fill(left, true);

        while (next(nums, left)) {
            ans.add(toList(nums));
        }

        return ans;
    }

    static List<Integer> toList(int[] nums) {
        return Arrays.stream(nums).boxed().collect(Collectors.toList());
    }

    static boolean next(int[] nums, boolean[] left) {
        int max = -1, maxIndex = -1;
        for (int i = 0; i < nums.length; ++i) {
            if (i == 0 && left[i]) {
                continue;
            } else if (i == nums.length - 1 && !left[i]) {
                continue;
            } else if (left[i] && nums[i - 1] >= nums[i]) {
                continue;
            } else if (!left[i] && nums[i] <= nums[i + 1]) {
                continue;
            }
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        if (maxIndex == -1) {
            return false;
        }

        if (left[maxIndex]) {
            swap(nums, maxIndex - 1, maxIndex);
            swap(left, maxIndex - 1, maxIndex);
        } else {
            swap(nums, maxIndex, maxIndex + 1);
            swap(left, maxIndex, maxIndex + 1);
        }

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > max) {
                left[i] = !left[i];
            }
        }

        return true;
    }

    static void swap(boolean[] nums, int i, int j) {
        boolean temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }



    @Test
    public void test() {
        JohnsonTrotter s = new JohnsonTrotter();
        List<List<Integer>> list = s.permute(new int[] {1, 1, 2, 3, 1});
        System.out.println(list.size());
        System.out.println(new HashSet<>(list).size());

    }

}
