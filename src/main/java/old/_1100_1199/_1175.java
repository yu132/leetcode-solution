package old._1100_1199;

public class _1175 {
	
	class Solution {
		
		
		public int numPrimeArrangements(int n) {
			if (n < 3)
				return 1;
			
			int			count	= 0;
			boolean[]	nums	= new boolean[n + 1];
			for (int i = 2; i * i < nums.length; i++) {
				if (!nums[i]) {
					for (int j = i * i; j < nums.length; j += i) {
						if (nums[j])
							continue;
						nums[j] = true;
						count++;
					}
				}
			}
			// ������������(��1��Ԫ��1����������)
			count++;
			
			// 8���ڵ������������ڷ�����
			if (n < 8)
				count = n - count;
			
			// ���
			long res = 1;
			for (int i = 2; i <= count; i++) {
				res = (res * i) % 1000000007;
				// �����жϻ����һ�ֱ���
				if (i == n - count) {
					res = (res * res) % 1000000007;
				}
			}
			return (int) res;
			
		}
	}
	
	public static void main(String[] args) {
		new _1175().new Solution().numPrimeArrangements(5);
	}
	
	
	
}
