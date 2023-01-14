package old._0600_0699;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _690 {
	
	class Employee {
		// It's the unique id of each node;
		// unique id of this employee
		public int id;
		// the importance value of this employee
		public int importance;
		// the id of direct subordinates
		public List<Integer> subordinates;
	};
	
	class Solution {
		
		private int dfs(int id, Map<Integer, Integer> idIndexMap, List<Employee> employees) {
			int			count	= 0;
			Employee	ee		= employees.get(idIndexMap.get(id));
			
			count += ee.importance;
			
			if (ee.subordinates != null) {
				for (Integer subId : ee.subordinates) {
					count += dfs(subId, idIndexMap, employees);
				}
			}
			
			return count;
		}
		
		public int getImportance(List<Employee> employees, int id) {
			
			Map<Integer, Integer> idIndexMap = new HashMap<>(employees.size() * 2);
			
			for (int i = 0; i < employees.size(); ++i) {
				idIndexMap.put(employees.get(i).id, i);
			}
			
			return dfs(id, idIndexMap, employees);
		}
	}
	
}
