package old._0600_0699;

public class _682 {

	//	class Solution {
	//		public int calPoints(String[] ops) {
	//			Deque<Integer> stack = new ArrayDeque<>(ops.length);
	//
	//			for (String str : ops) {
	//				switch (str) {
	//					case "+":
	//						int top = stack.removeFirst();
	//						int next = stack.getFirst();
	//						stack.addFirst(top);
	//						stack.addFirst(top + next);
	//						break;
	//					case "D":
	//						stack.addFirst(stack.getFirst() * 2);
	//						break;
	//					case "C":
	//						stack.removeFirst();
	//						break;
	//					default:
	//						stack.push(Integer.parseInt(str));
	//				}
	//			}
	//
	//			int sum = 0;
	//			for (Integer num : stack)
	//				sum += num;
	//
	//			return sum;
	//		}
	//	}

	class Solution {
		public int calPoints(String[] ops) {
			int[] stack = new int[ops.length];
			int index = 0;

			for (String str : ops) {
				switch (str) {
					case "+":
						stack[index] = stack[index - 1] + stack[index - 2];
						++index;
						break;
					case "D":
						stack[index] = stack[index - 1] << 1;
						++index;
						break;
					case "C":
						--index;
						break;
					default:
						stack[index++] = Integer.parseInt(str);
				}
			}

			int sum = 0;
			for (int i = 0; i < index; ++i)
				sum += stack[i];

			return sum;
		}
	}

	public static void main(String[] args) {
		new _682().new Solution().calPoints(new String[] {
				"5", "2", "C", "D", "+"
		});
	}

}
