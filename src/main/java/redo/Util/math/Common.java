package redo.Util.math;

public class Common {

    int max(int... nums) {
        int ans = Integer.MIN_VALUE;
        for (int num : nums) {
            ans = Math.max(ans, num);
        }
        return ans;
    }

    long max(long... nums) {
        long ans = Integer.MIN_VALUE;
        for (long num : nums) {
            ans = Math.max(ans, num);
        }
        return ans;
    }

    int min(int... nums) {
        int ans = Integer.MAX_VALUE;
        for (int num : nums) {
            ans = Math.min(ans, num);
        }
        return ans;
    }

}
