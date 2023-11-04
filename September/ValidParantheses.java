package September;

import java.util.Stack;

public class ValidParantheses {
    public static void main(String[] args) {
        ValidParantheses validParantheses = new ValidParantheses();
        System.out.println(validParantheses.check("((((((((((())])))))))))"));
    }

    private boolean check(String string) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < string.length(); i++) {

            char c = string.charAt(i);

            switch (c) {
                case '(':
                    stack.push(')');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case '[':
                    stack.push(']');
                    break;
                default:
                    if (stack.isEmpty() || c != stack.pop())
                        return false;
            }

        }

        return stack.isEmpty();
    }
}
