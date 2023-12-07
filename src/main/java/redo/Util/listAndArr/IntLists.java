package redo.Util.listAndArr;

import redo.Util.counter.NumCounterUtil;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;

/**
 * @author 余定邦
 * @ClassName: IntLists
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2020年12月29日
 * @see NumCounterUtil 存储了一些用于求前缀和，后缀和等函数
 */
public class IntLists {

    int[] maxCountNum(List<Integer> list) {
        int num = list.get(0), count = 1;
        for (int i = 1; i < list.size(); ++i) {
            if (num == list.get(i)) {
                ++count;
            } else {
                if (count == 0) {
                    num = list.get(i);
                    count = 1;
                } else {
                    --count;
                }
            }
        }
        int realCount = getEleCount(list, num);
        if (realCount >= list.size() / 2) {
            return new int[]{num, realCount};
        } else {
            return null;
        }
    }

    int getEleCount(List<Integer> list, int val) {
        int count = 0;
        for (Integer integer : list) {
            if (val == integer) {
                ++count;
            }
        }
        return count;
    }

    Map<Integer, Integer> getIndexMap(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; ++i) {
            map.put(arr[i], i);
        }
        return map;
    }

    //排序查找两个数组是否包含相同元素
    boolean findEquals(int[] sortedArr1, int[] sortedArr2) {
        int index1 = 0, index2 = 0;
        while (index1 < sortedArr1.length && index2 < sortedArr2.length) {
            if (sortedArr1[index1] < sortedArr2[index2]) {
                ++index1;
            } else if (sortedArr1[index1] > sortedArr2[index2]) {
                ++index2;
            } else {
                return true;
            }
        }
        return false;
    }

    //查找第一个能匹配的子数组的开始下标
    public int indexOf(int[] src, int[] toMatch, int start) {
        outer:
        for (int i = start; i <= src.length - toMatch.length; ++i) {
            for (int j = 0; j < toMatch.length; ++j) {
                if (src[i + j] != toMatch[j]) {
                    continue outer;
                }
            }
            return i;
        }
        return -1;
    }

    //查找数组内第一个等于target的元素下标
    public int indexOf(int[] arr, int target, int start) {
        for (int i = start; i < arr.length; ++i) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    //长度相等的数组，返回前一个数组是否比后一个数组的每个位置的元素都大或相等
    boolean greaterEquals(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; ++i) {
            if (arr1[i] < arr2[i]) {
                return false;
            }
        }
        return true;
    }

    //长度相等的数组，每个位置上相减
    void minus(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; ++i) {
            arr1[i] -= arr2[i];
        }
    }

    //长度相等的数组，每个位置上相加
    void add(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; ++i) {
            arr1[i] += arr2[i];
        }
    }

    void sort(int[] arr, Comparator<Integer> comparator) {
        Integer[] copy = new Integer[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            copy[i] = arr[i];
        }
        Arrays.sort(copy, comparator);
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = copy[i];
        }
    }

    int[] toIntArray(List<Integer> list) {
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    <E> int[] toIntArray(List<E> list, Function<E, Integer> valueTaker) {
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = valueTaker.apply(list.get(i));
        }
        return arr;
    }

    List<Integer> toIntList(int[] nums) {
        List<Integer> ans = new ArrayList<>(nums.length);
        for (int num : nums) {
            ans.add(num);
        }
        return ans;
    }

    Set<Integer> toSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set;
    }

    long sumLong(int[] nums) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    int sum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    int sum(int[] nums, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; ++i) {
            sum += nums[i];
        }
        return sum;
    }

    double mean(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return (double) sum / nums.length;
    }

    int product(int[] nums, int start, int end) {
        int product = 1;
        for (int i = start; i < end; ++i) {
            product *= nums[i];
        }
        return product;
    }

    int max(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
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

    int maxIndex(int[] nums, int start, int end) {
        int max = nums[start], maxIndex = start;
        for (int i = start + 1; i < end; ++i) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    int[] minMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        return new int[]{min, max};
    }

    int[] minMaxIndex(int[] nums, int start, int end) {
        int max = nums[start], maxIndex = start;
        int min = nums[start], minIndex = start;
        for (int i = start + 1; i < end; ++i) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            } else if (nums[i] < min) {
                min = nums[i];
                minIndex = i;
            }
        }
        return new int[]{minIndex, maxIndex};
    }

    int max(int[] nums, int start, int end) {
        int max = Integer.MIN_VALUE;
        for (int i = start; i < end; ++i) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    List<Integer> range(int start, int end) {
        List<Integer> list = new ArrayList<>(end - start);
        for (int i = start; i < end; ++i) {
            list.add(i);
        }
        return list;
    }


    void arrayRotationForward(int[] array, int from, int length, int k) {
        k %= length;
        int mid = from + k;
        rotate(array, from, mid, from + length);
    }

    void arrayRotationBackward(int[] array, int from, int length, int k) {
        k %= length;
        int mid = from + length - k;
        rotate(array, from, mid, from + length);
    }

    void rotate(int[] array, int from, int mid, int to) {
        reverse(array, from, mid - 1);
        reverse(array, mid, to - 1);
        reverse(array, from, to - 1);
    }

    void reverse(int[] array, int from, int to) {
        for (; from < to; ++from, --to) {
            swap(array, from, to);
        }
    }

    void swap(int[] array, int x, int y) {
        int num = array[x];
        array[x] = array[y];
        array[y] = num;
    }

    void shuffle(int[] nums) {
        ThreadLocalRandom r = ThreadLocalRandom.current();
        for (int i = nums.length - 1; i >= 1; --i) {
            int IndexToSwap = r.nextInt(i + 1);
            swap(nums, i, IndexToSwap);
        }
    }

    int unique(int[] nums) {
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

    List<Range> splitBy(int val, int[] nums) {
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

        boolean isValueInRange(int value) {
            return start <= value && value <= end;
        }
    }
}
