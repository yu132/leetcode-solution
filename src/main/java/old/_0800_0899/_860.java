package old._0800_0899;

public class _860 {
	
	class Solution {
		public boolean lemonadeChange(int[] bills) {
			int count5 = 0, count10 = 0;
			
			for (int each : bills) {
				if (each == 5) {
					++count5;
				} else if (each == 10) {
					if (count5 > 0) {//������1��5Ԫ
						--count5;
						++count10;
					} else {
						return false;
					}
				} else {//each == 20
					if (count10 > 0) {//��10Ԫ����10Ԫ
						if (count5 > 0) {//��һ����Ԫ���
							--count10;
							--count5;
						} else {//һ��5Ԫ��û�У�����������3��
							return false;
						}
					} else {//û��10Ԫ����3��5Ԫ
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
