/**
 * @Title: _910.java
 *
 * @Package _0900_0999
 *
 * @Description: TODO(用一句话描述该文件做什么)
 *
 * @author 余定邦
 *
 * @date 2020年1月29日
 *
 */
package _0900_0999;

/**
 * @ClassName: _910
 *
 * @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author 余定邦
 *
 * @date 2020年1月29日
 * 
 */
public class _910 {

    // class Solution {
    // public int smallestRangeII(int[] A, int K) {
    //
    // int max = A[0], min = A[0];
    // for (int i = 1; i < A.length; ++i) {
    // if (A[i] > max) {
    // max = A[i];
    // } else if (A[i] < min) {
    // min = A[i];
    // }
    // }
    //
    // if (max - min == 0) {
    // return 0;
    // }
    //
    // double half = ((double)max + min) / 2;
    //
    // int maxNext = Integer.MIN_VALUE, minNext = Integer.MAX_VALUE;
    //
    // boolean check = false;
    //
    // for (int i = 0; i < A.length; ++i) {
    // int now;
    // if (A[i] > half) {
    // now = A[i] - K;
    // } else if (A[i] < half) {
    // now = A[i] + K;
    // } else {
    // check = true;
    // continue;
    // }
    // if (now > maxNext) {
    // maxNext = now;
    // }
    // if (now < minNext) {
    // minNext = now;
    // }
    // if (maxNext - minNext > max - min) {
    // return max - min;
    // }
    // }
    //
    // if (check) {
    // int halfI = (int)half;
    // if (maxNext - halfI > halfI - minNext) {
    // int now = halfI + K;
    // if (now > maxNext) {
    // maxNext = now;
    // }
    // } else {
    // int now = halfI - K;
    // if (now < minNext) {
    // minNext = now;
    // }
    // }
    // if (maxNext - minNext > max - min) {
    // return max - min;
    // }
    // }
    // return maxNext - minNext;
    // }
    // }

}
