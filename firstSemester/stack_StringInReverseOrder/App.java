import java.util.Stack;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Stack<String> st = new Stack<String>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string: ");

        while(true) {
            String text = sc.nextLine();

            if (text.equals("end")) {
                break;
            } else if (text.equals("undo")) {
                if (!st.isEmpty()) {
                    System.out.println("Last entry " + st.pop() + " removed.");
                } else {
                    System.out.println("Nothing to undo.");
                }
            } else {
                st.push(text);
            }
        }
        sc. close();

        System.out.println("Strings in reversed order: ");
        while(!st.isEmpty()) {
            System.out.println(st.pop());
        }
    }
}
