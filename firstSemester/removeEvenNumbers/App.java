import java.util.ArrayList;


public class App {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] result = removeEvenNumbers(arr);

        for(int num: result) {
            System.out.println(num + " ");
        }
        
    }

    public static int[] removeEvenNumbers(int[] arr) {
        ArrayList<Integer> resultList = new ArrayList<>();

        for (int num: arr) {
            if(num % 2 != 0) {
                resultList.add(num);
            }
        }

        int[] result = new int[resultList.size()];
        for(int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        } 

        return result;
    }
}
