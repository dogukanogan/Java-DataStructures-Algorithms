public class App {
    public static void main(String[] args) {

        String[] arr = {"strawberry", "fig", "apple", "kiwi", "eggfruit", "blueberry", "avocado"};

        SwapSort(arr, false);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        // should print 'fig' to 'strawberry'

        SwapSort(arr, true);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

    public static void SwapSort(String[] arr, boolean reversed) {

        int length = arr.length;
        boolean swapped;

        do {
            swapped = false;

            for (int i = 0; i < length - 1; i++) {

                if(reversed && arr[i].length() < arr[i + 1].length() || !reversed && arr[i].length() > arr[i + 1].length()) {
                    String temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }

            }
            length--;
        } while (swapped);
    }
}
