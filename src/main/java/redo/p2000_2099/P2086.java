package redo.p2000_2099;

public class P2086 {

    class Solution {
        public int minimumBuckets(String street) {

            boolean needPutRight = true, forcePutRight = true;

            int ans = 0;

            for (int i = 0; i < street.length(); ++i) {
                if (street.charAt(i) == '.') {
                    forcePutRight = false;
                    needPutRight = true;
                } else {// 'H'
                    boolean right = i + 1 < street.length() && street.charAt(i + 1) != 'H';
                    if (forcePutRight) {
                        if (right) {
                            needPutRight = false;
                            forcePutRight = false;
                            ++i;
                            ++ans;
                            continue;
                        } else {
                            return -1;
                        }
                    }
                    if (needPutRight) {
                        if (right) {
                            needPutRight = false;
                            forcePutRight = false;
                            ++i;
                            ++ans;
                            continue;
                        } else {
                            needPutRight = true;
                            forcePutRight = true;
                            ++ans;
                            continue;
                        }
                    }
                    forcePutRight = true;
                    needPutRight = true;
                }
            }

            return ans;
        }
    }

    public static void main(String[] args) {
        new P2086().new Solution().minimumBuckets(".H..H.HH");

    }

}
