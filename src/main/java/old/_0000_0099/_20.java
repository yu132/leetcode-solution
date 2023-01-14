package old._0000_0099;

import java.util.ArrayDeque;
import java.util.Deque;

public class _20 {
	
	public boolean match(char a,char b){
		if(a=='('&&b==')')
			return true;
		if(a=='['&&b==']')
			return true;
		if(a=='{'&&b=='}')
			return true;
		
		return false;
	}
	
	public int lorR(char a){
		if(a=='('||a=='['||a=='{')
			return -1;
		else if(a==')'||a==']'||a=='}')
			return 1;
		
		return 0;
	}
	
	public boolean isValid(String s) {
        
		Deque<Character> stack=new ArrayDeque<>();
		
		for(int i=0;i<s.length();i++){
			if(lorR(s.charAt(i))==-1){
				stack.push(s.charAt(i));
			}else{
				if(stack.isEmpty()||!match(stack.pop(), s.charAt(i)))
					return false;
			}
		}
		
		if(stack.isEmpty())
			return true;
		
		return false;
    }
	
	public static void main(String[] args) {
		System.out.println(new _20().isValid(""));
	}
	
}
