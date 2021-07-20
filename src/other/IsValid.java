package other;

import java.util.Stack;

/**
 * 有效的括号
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 */
public class IsValid {

    public static void main(String[] args) {
        IsValid isValid = new IsValid();
        final String s = "()[]{}";
        System.out.println(isValid.isValid(s));
    }

    // 典型的使用栈的问题
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[')
                stack.push(c);
            else {
                if (stack.isEmpty()) {
                    return false;
                }
                char sc = stack.pop();
                if (sc == '(' && c != ')') {
                    return false;
                } else if (sc == '{' && c != '}') {
                    return false;
                } else if (sc == '[' && c != ']') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
