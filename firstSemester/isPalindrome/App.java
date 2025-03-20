public class App {
    public static void main(String[] args) {
        System.out.println(isPalindrome("level"));
        System.out.println(isPalindrome("test"));
    }

    static boolean isPalindrome(String text) {

        if(text.length() <= 1) return true;

        if (text.charAt(0) == text.charAt(text.length() - 1)) {
            return isPalindrome(text.substring(1, text.length() - 1));
        }
        return false;
    }
}
