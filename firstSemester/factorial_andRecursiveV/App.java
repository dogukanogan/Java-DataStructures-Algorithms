public class App {
    public static void main(String[] args) {
        
        System.out.println(factorial(2));
        System.out.println(factorial(5));
        System.out.println(factorial(10));
        System.out.println(recursiveFactorial(2));
        System.out.println(recursiveFactorial(5));
        System.out.println(recursiveFactorial(10));
    }

    static int factorial(int number) {
         
        int i, fact = 1;

        if(number < 0) return -1;

        for(i = 1; i <= number; i++) {
            fact *= i;
        }
        return fact;
    }

    static int recursiveFactorial(int number) {

        if (number < 0) return -1;
        if(number == 0 || number == 1) return 1;

        return number * recursiveFactorial(number - 1);
    }

}    
