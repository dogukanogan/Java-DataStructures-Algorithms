public class App {
    public static void main(String[] args) {
        System.out.println(power(2, 4));
        System.out.println(power(10, 3));
    }

    public static int power(int num, int pow) {
        if (pow == 0) return 1;

        return num * power(num, pow - 1);
    }
}
