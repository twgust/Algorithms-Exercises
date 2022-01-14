import java.util.Scanner;
import java.util.Stack;

public class Balance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();


        Stack<Character> stack = new Stack<Character>();
        char ch;
        boolean success = true;

        // loop through the string
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);

            // condition for pushing
            if ((ch == '(') || (ch == '[')) {
                stack.push(ch);

            }
            else if (ch == ')' || ch == ']') {
                if (stack.isEmpty()) {
                    // loop break to avoid popping an empty stack
                    success = false;
                    break;
                }
                else if (stack.peek() == '(' && ch == ']' || stack.peek() == '[' && ch == ')'){
                    success = false;
                }
                else if ((stack.peek() == '(' )&&( ch == ')')){
                    stack.pop();
                }
                else if ((stack.peek() == '[') && (ch == ']')){
                    stack.pop();
                }
            }
        }
        if (!stack.isEmpty() || !success) {
            System.out.println(0);

        }
        else if (stack.isEmpty()) {
            System.out.println(1);
        }
    }
}

