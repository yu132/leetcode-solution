package redo.Util.listAndArr;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**  
 * @ClassName: IntLists  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
 */
public class IntLists {

    public static int[] toIntArray(List<Integer> list) {
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public static List<Integer> toIntList(int[] nums) {
        List<Integer> ans = new ArrayList<>(nums.length);
        for (int num : nums) {
            ans.add(num);
        }
        return ans;
    }

    public static Set<Integer> toSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set;
    }

    public static int sum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    public static int sum(int[] nums, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; ++i) {
            sum += nums[i];
        }
        return sum;
    }

    public static double mean(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return (double)sum / nums.length;
    }

    public static int product(int[] nums, int start, int end) {
        int product = 1;
        for (int i = start; i < end; ++i) {
            product *= nums[i];
        }
        return product;
    }

    public static int max(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }

    public static int maxIndex(int[] nums, int start, int end) {
        int max = nums[start], maxIndex = start;
        for (int i = start + 1; i < end; ++i) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static int[] minMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        return new int[] {min, max};
    }

    public static int max(int[] nums, int start, int end) {
        int max = Integer.MIN_VALUE;
        for (int i = start; i < end; ++i) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    public static List<Integer> range(int start, int end) {
        List<Integer> list = new ArrayList<>(end - start);
        for (int i = start; i < end; ++i) {
            list.add(i);
        }
        return list;
    }


    public static void arrayRotationForward(int[] array, int from, int length, int k) {
        k %= length;
        reverse(array, from, from + k - 1);
        reverse(array, from + k, from + length - 1);
        reverse(array, from, from + length - 1);
    }

    public static void reverse(int[] array, int from, int to) {
        for (; from < to; ++from, --to) {
            swap(array, from, to);
        }
    }

    public static void swap(int[] array, int x, int y) {
        int num = array[x];
        array[x] = array[y];
        array[y] = num;
    }

    public int unique(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int indexToFill = 1;
        for (int indexToCheck = 1; indexToCheck < nums.length; ++indexToCheck) {
            if (nums[indexToCheck] != nums[indexToCheck - 1]) {
                nums[indexToFill++] = nums[indexToCheck];
            }
        }
        return indexToFill;
    }

    public List<Range> splitBy(int val, int[] nums) {
        List<Range> splitIndex = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == val) {
                if (start == i) {
                    start = i + 1;
                    continue;
                }
                splitIndex.add(new Range(start, i));
                start = i + 1;
            }
        }
        if (start != nums.length) {
            splitIndex.add(new Range(start, nums.length));
        }
        return splitIndex;
    }

    static class Range {
        int start;
        int end;

        Range(int start, int end) {
            super();
            this.start = start;
            this.end = end;
        }

        public boolean isValueInRange(int value) {
            return start <= value && value <= end;
        }
    }
}
