package old._0800_0899;

/**  
 * @ClassName: _838  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月7日  
 *  
 */
public class _838 {

    class Solution {
        public String pushDominoes(String dominoes) {
            char[] ch = dominoes.toCharArray();
            l:
            for (int i = 0; i < dominoes.length(); ++i) {
                if (ch[i] == '.') {
                    if (i == 0 || ch[i - 1] == 'L') {// 左边没有向右边倒的情况
                        for (int j = i + 1; j < ch.length; ++j) {
                            if (ch[j] == 'L') {// 右边有向左边倒的情况
                                for (int k = i; k < j; ++k) {
                                    ch[k] = 'L';
                                }
                                i = j;
                                continue l;
                            } else if (ch[j] == 'R') {// 两边都不向中间倒
                                i = j;
                                continue l;
                            }
                        }
                        break l;
                    } else {// 左边有向右边倒的情况
                        for (int j = i + 1; j < ch.length; ++j) {
                            if (ch[j] == 'R') {// 右边没有向左边倒的情况
                                for (int k = i; k < j; ++k) {
                                    ch[k] = 'R';
                                }
                                i = j;
                                continue l;
                            } else if (ch[j] == 'L') {
                                int left = i, right = j - 1;
                                while (left < right) {
                                    ch[left++]  = 'R';
                                    ch[right--] = 'L';
                                }
                                i = j;
                                continue l;
                            }
                        }
                        // 到头都没有向左边的力
                        for (int k = i; k < ch.length; ++k) {
                            ch[k] = 'R';
                        }
                        break l;
                    }
                }
            }
            return String.valueOf(ch);
        }
    }

    public static void main(String[] args) {
        System.out.println(new _838().new Solution().pushDominoes("R.........L"));
    }
}
