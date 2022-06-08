package _0800_0899;

import java.util.ArrayDeque;
import java.util.Deque;

public class _844 {

	public boolean backspaceCompare(String S, String T) {
		Deque<Character> stack1=new ArrayDeque<>();
		Deque<Character> stack2=new ArrayDeque<>();
		
		for(int i=0;i<S.length();i++){
			if(S.charAt(i)=='#'){
				if(!stack1.isEmpty())
					stack1.pop();
			}else
				stack1.push(S.charAt(i));
		}
		
		for(int i=0;i<T.length();i++){
			if(T.charAt(i)=='#'){
				if(!stack2.isEmpty())
					stack2.pop();
			}else
				stack2.push(T.charAt(i));
		}
		
		if(stack1.size()!=stack2.size())
			return false;
		
		while(!stack1.isEmpty()){
			if(stack1.pop()!=stack2.pop())
				return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(new _844().backspaceCompare("", ""));
	}
	
}
