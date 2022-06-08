package _1000_1099;

/**  
 * @ClassName: _1093  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月6日  
 *  
 */
public class _1093 {

    class Solution {
        public double[] sampleStats(int[] count) {

            boolean  fmin = true;

            long     sum  = 0, maxNum = 0, totalCount = 0;

            double[] ans  = new double[5];

            for (int i = 0; i < count.length; ++i) {
                // 最小值
                if (fmin) {
                    if (count[i] != 0) {
                        ans[0] = i;
                        fmin   = false;
                    }
                }
                // 最大值
                if (count[i] != 0) {
                    ans[1] = i;
                }
                // 平均值
                sum += count[i] * i;

                // 中位数
                totalCount += count[i];

                // 众数
                if (count[i] > maxNum) {
                    maxNum = count[i];
                    ans[4] = i;
                }
            }

            // 平均值
            ans[2] = (double)sum / totalCount;

            // 中位数
            if ((totalCount & 1) == 1) {// 奇数
                totalCount >>= 1;
                for (int i = 0; i < count.length; ++i) {
                    if (count[i] != 0) {
                        totalCount -= count[i];
                        if (totalCount < 0) {
                            ans[3] = i;
                            return ans;
                        }
                    }
                }
            } else {// 偶数
                totalCount >>= 1;
                boolean flag = false;
                int     num  = 0;
                for (int i = 0; i < count.length; ++i) {
                    if (count[i] != 0) {
                        if (flag) {
                            ans[3] = (double)(num + i) / 2;
                            return ans;
                        } else {
                            totalCount -= count[i];
                            if (totalCount < 0) {
                                ans[3] = i;
                                return ans;
                            } else if (totalCount == 0) {
                                flag = true;
                                num  = i;
                            }
                        }
                    }
                }
            }

            return null;
        }
    }

}
