package _700_799;

public class _795 {
// v1
//	class Solution {
//	    public int numSubarrayBoundedMax(int[] A, int L, int R) {
//	        // 最大元素满足大于等于L小于等于R的子数组个数 = 最大元素小于等于R的子数组个数 - 最大元素小于L的子数组个数
//	        return numSubarrayBoundedMax(A, R) - numSubarrayBoundedMax(A, L - 1);
//	    }
//
//	    private int numSubarrayBoundedMax(int[] A, int Max) {
//	        int res = 0;
//	        int numSubarry = 0;
//	        for (int num : A) {
//	            if (num <= Max) {
//	                numSubarry++;
//	                res += numSubarry;
//	            } else {
//	                numSubarry = 0;
//	            }
//	        }
//	        return res;
//	    }
//	}
	
	class Solution {
	    public int numSubarrayBoundedMax(int[] A, int L, int R) {
	        int n = A.length;
	        int res = 0;
	        int l = 0;
	        int r = -1;
	        for (int i = 0; i < n; i++) {
	            if (A[i] > R) {
	                r = -1;
	                l = i + 1;
	            } else {
	                if (A[i] >= L) {
	                    r = i;
	                }
	                if (r >= 0) {
	                    res += r - l + 1;
	                }
	            }
	        }
	        return res;
	    }
	}
	
}
