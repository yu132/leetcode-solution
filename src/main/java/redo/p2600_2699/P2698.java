package redo.p2600_2699;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P2698 {


    class Solution {

        int[] arr = new int[]{1, 9, 10, 36, 45, 55, 82, 91, 99, 100, 235, 297, 369, 370, 379, 414, 657, 675, 703, 756, 792, 909, 918, 945, 964, 990, 991, 999, 1000};

        public int punishmentNumber(int n) {
            int ans = 0;
            for (int i = 0; i < arr.length && arr[i] <= n; ++i) {
                ans += arr[i] * arr[i];
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 1000; ++i) {
            if (backtrack(0, 0, 0, i, toDigits(i * i))) {
                list.add(i);
            }
        }
        System.out.println(list);
    }

    static boolean backtrack(int index, int now, int sum, int i, Integer[] digits) {
        if (index == digits.length) {
            return now + sum == i;
        }
        boolean b = backtrack(index + 1, digits[index], sum + now, i, digits);
        if (b) {
            return true;
        }
        b = backtrack(index + 1, digits[index] + now * 10, sum, i, digits);
        return b;
    }

    static Integer[] toDigits(int num) {
        List<Integer> list = new ArrayList<>();
        while (num != 0) {
            list.add(num % 10);
            num /= 10;
        }
        Collections.reverse(list);
        if (list.isEmpty()) {
            list.add(0);
        }
        return list.toArray(new Integer[0]);
    }

}
