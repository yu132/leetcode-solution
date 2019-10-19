package _0800_0899;

public class _860 {
	
	class Solution {
		public boolean lemonadeChange(int[] bills) {
			int count5 = 0, count10 = 0;
			
			for (int each : bills) {
				if (each == 5) {
					++count5;
				} else if (each == 10) {
					if (count5 > 0) {//至少有1张5元
						--count5;
						++count10;
					} else {
						return false;
					}
				} else {//each == 20
					if (count10 > 0) {//有10元先找10元
						if (count5 > 0) {//有一张五元则可
							--count10;
							--count5;
						} else {//一张5元都没有，更不可能有3张
							return false;
						}
					} else {//没有10元，找3张5元
						if (count5 >= 3) {
							count5 -= 3;
						} else {
							return false;
						}
					}
				}
			}
			
			return true;
		}
	}
	
}
