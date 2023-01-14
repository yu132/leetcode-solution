package redo.p2400_2499;

public class P2433 {


    class Solution {
        public int[] findArray(int[] pref) {
            int last = 0;
            for (int i = 0; i < pref.length; ++i) {
                int temp = pref[i];
                pref[i] = last ^ pref[i];
                last = temp;
            }
            return pref;
        }
    }
}
