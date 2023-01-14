package old._0700_0799;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class _726 {

	/**
	 * 可以用栈来暂时存储，因为每遇到一个左括号，就压入其到右括号之间的原子�?
	 * 乘上倍数然后在和外层的相加就可以了，比起把每个括号里面的递归�?次要�?
	 * 
	 * @author 87663
	 *
	 */

	class Solution {

		public void combineCounterMap(Map<String, Integer> map1,
				Map<String, Integer> map2) {

			for (Entry<String, Integer> entry : map2.entrySet()) {
				int count1 = map1.getOrDefault(entry.getKey(), 0);
				map1.put(entry.getKey(), count1 + entry.getValue());
			}
		}

		public void multiplyCounterMap(Map<String, Integer> map1,
				int times) {

			if (times == 1)
				return;

			for (Entry<String, Integer> entry : map1.entrySet()) {
				map1.put(entry.getKey(), entry.getValue() * times);
			}
		}

		public void settle(Map<String, Integer> counterMap,
				boolean atomName, int atomNameFrom, int atomNameLength,
				boolean complexFormula, int complexFormulaFrom, int complexFormulaLength,
				boolean number, int numberFrom, int numberLength, String formula) {

			if (!atomName && !complexFormula)
				return;

			int count;

			if (!number)
				count = 1;
			else
				count = Integer.parseInt(formula.substring(numberFrom, numberFrom + numberLength));

			if (atomName) {
				String atomNameString = formula.substring(atomNameFrom,
						atomNameFrom + atomNameLength);
				counterMap.put(atomNameString, counterMap.getOrDefault(atomNameString, 0) + count);
			} else {//complexFormula

				String complexFormulaString = formula.substring(complexFormulaFrom + 1,
						complexFormulaFrom + complexFormulaLength - 1);
				Map<String, Integer> counterMapDeep = countDeep(complexFormulaString, count);
				combineCounterMap(counterMap, counterMapDeep);
			}
		}

		public Map<String, Integer> countDeep(String formula, int times) {
			Map<String, Integer> counterMap = new TreeMap<>();

			//原子名部�?
			boolean atomName = false;
			int atomNameFrom = -1;
			int atomNameLength = 0;

			//复杂表达式部�?
			boolean complexFormula = false;
			boolean complexFormulaEnd = false;
			int complexFormulaFrom = -1;
			int complexFormulaLength = 0;

			int leftParenthesesCount = 0;
			int rightParenthesesCount = 0;

			//数字部分（结算的时�?�数字部分没有表示只有一个）
			boolean number = false;
			int numberFrom = -1;
			int numberLength = 0;

			for (int i = 0; i < formula.length(); ++i) {

				char c = formula.charAt(i);

				if (complexFormula && !complexFormulaEnd) {//复杂表达式内�?

					++complexFormulaLength;//长度加一

					if (c == '(')//左括�?
						++leftParenthesesCount;//左括号计数加�?
					else if (c == ')') {//右括�?
						++rightParenthesesCount;//右括号计数加�?
						if (leftParenthesesCount == rightParenthesesCount)//左右括号数量相等�?
							complexFormulaEnd = true;				//证明�?个复杂表达式已经结束�?
					}
				} else {//非复杂表达式

					if (c == '(') {//复杂表达式开�?

						settle(counterMap, atomName, atomNameFrom, atomNameLength,
								complexFormula, complexFormulaFrom, complexFormulaLength, number,
								numberFrom, numberLength, formula);

						atomName = false;
						number = false;

						complexFormula = true;
						complexFormulaEnd = false;
						complexFormulaFrom = i;
						complexFormulaLength = 1;
						leftParenthesesCount = 1;
						rightParenthesesCount = 0;
					}

					else if (c >= 'A' && c <= 'Z') {//原子名开�?

						settle(counterMap, atomName, atomNameFrom, atomNameLength,
								complexFormula, complexFormulaFrom, complexFormulaLength, number,
								numberFrom, numberLength, formula);

						complexFormula = false;
						number = false;

						atomName = true;
						atomNameFrom = i;
						atomNameLength = 1;
					} else if (c >= 'a' && c <= 'z')//原子名内�?
						++atomNameLength;

					else if (c >= '0' && c <= '9') {

						if (!number) {
							number = true;
							numberFrom = i;
							numberLength = 1;
						} else
							++numberLength;
					}
				}
			}

			settle(counterMap, atomName, atomNameFrom, atomNameLength,
					complexFormula, complexFormulaFrom, complexFormulaLength, number,
					numberFrom, numberLength, formula);

			multiplyCounterMap(counterMap, times);

			return counterMap;
		}

		public String countOfAtoms(String formula) {
			Map<String, Integer> counterMap = countDeep(formula, 1);

			StringBuilder sb = new StringBuilder(formula.length());

			for (Entry<String, Integer> entry : counterMap.entrySet())
				sb.append(entry.getKey()).append(entry.getValue() != 1 ? entry.getValue() : "");

			return sb.toString();
		}
	}

	public static void main(String[] args) {
		System.out.println(new _726().new Solution().countOfAtoms(
				"((N42)24(OB40Li30CHe3O48LiNN26)33(C12Li48N30H13HBe31)21(BHN30Li26BCBe47N40)15(H5)16)14"));
	}

}
