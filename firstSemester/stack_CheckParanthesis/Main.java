import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println( checkParenthesis( "({[]})" ) ); // should print True
        System.out.println( checkParenthesis( "([)]" ) ); // should print False
        System.out.println( checkParenthesis( "((()))" ) ); // should print True
        System.out.println( checkParenthesis( "())" ) ); // should print False
        System.out.println( checkParenthesis( "{[()]}" ) ); // should print True
        System.out.println( checkParenthesis( "[" ) ); // should print False
        System.out.println( checkParenthesis( "]" ) ); // should print False
        System.out.println( checkParenthesis( "" ) ); // should print True
    }

    static boolean checkParenthesis(String text) {
        Stack<Character> stack = new Stack<>();

        for (char c : text.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' ||c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                        return false;
                    }
            }
        }
        
        return true;
    }
}
