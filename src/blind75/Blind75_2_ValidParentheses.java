package blind75;

import java.util.HashMap;

public class Blind75_2_ValidParentheses {

	public static void main(String[] args) {
		String ques = "[]{}({[]})([)]";
		System.out.println(isValid(ques));
	}

	public static boolean isValid(String s) {

		if (s.length() % 2 == 1) {
			return false;
		}
		int len = 0;
		while (s.length() > 0) {
			len = s.length();
			s = s.replace("()", "");
			s = s.replace("[]", "");
			s = s.replace("{}", "");
			if (len == s.length()) {
				return false;
				
			}
		}
		 return true;
//        char[] stack = new char[s.length()];
//        int index=0;
//        for(char c : s.toCharArray()){
//            if(c == '(' || c == '{' || c == '['){
//                stack[index++] = c;
//            }else if(c == ')' && index > 0 && stack[index-1] == '(' ){
//                index--;
//            }else if(c == '}' && index > 0 && stack[index-1] == '{' ){
//                index--;
//            }else if(c == ']' && index > 0 && stack[index-1] == '[' ){
//                index--;
//            }else {
//                return false;
//            }
//        }
//        return (index==0);
	}
}

//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//An input string is valid if:
//
//Open brackets must be closed by the same type of brackets.
//Open brackets must be closed in the correct order.
//Every close bracket has a corresponding open bracket of the same type.
// 
//
//Example 1:
//
//Input: s = "()"
//Output: true
//Example 2:
//
//Input: s = "()[]{}"
//Output: true
//Example 3:
//
//Input: s = "(]"
//Output: false
// 
//
//Constraints:
//
//1 <= s.length <= 104
//s consists of parentheses only '()[]{}'.