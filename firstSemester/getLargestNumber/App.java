public class App {
    public static void main(String[] args) {
        
        int[] nums = {5, 7, 3, 10, 2, 4};
        System.out.println(getLargest(nums));
        System.out.println(getSecondLargest(nums));
    }

    static int getLargest(int[] numbers) {
        int largest = numbers[0];

        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i] > largest) largest = numbers[i];  
        }
        return largest;
    }

    static int getSecondLargest(int[] numbers) {
        int secLargest = numbers[0];

        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i] > secLargest) {
                if(numbers[i] < getLargest(numbers)) {
                    secLargest = numbers[i];
                }
            }
        }
        return secLargest;
    }
}
