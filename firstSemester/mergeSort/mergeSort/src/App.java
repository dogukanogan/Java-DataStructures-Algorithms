

public class App {
    public static void main(String[] args) {
        int[] arr = {5, 4, 2, 1, 3, 9, 7, 6};

        int[] a = {2, 4, 6, 8};
        int[] b = {1, 3, 7, 9};
        int[] c = new int[8];

        int i = 0, j = 0;
        for (int k = 0; k < 8; k++) {
            if (j > b.length - 1) c[k] = a[i++];
            if (i > b.length - 1) c[k] = b[i++];
            else if (a[i] <= b[j]) c[k] = a[i++];
            else c[k] = b[j++];
        }

        for (int k = 0; k < 8; k++) System.out.println(c[k] + " ");

    }

    static void MergeSort(int[] arr) {
        MergeSortHelper(arr, 0, arr.length - 1);
    }

    static void MergeSortHelper(int[] arr, int low, int high) {
        int mid = low + (high - low) / 2;

        MergeSortHelper(arr, low, mid);
        MergeSortHelper(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    static void merge(int[] arr, int low, int mid, int high) {
        int[] helperArr = new int[arr.length];

        int i = low, j = mid + 1;
        for (int k = 0; k < 8; k++) {
            if (j > high) helperArr[k] = arr[i++];
            if (i > mid) helperArr[k] = arr[j++];
            else if (arr[i] <= arr[j]) helperArr[k] = arr[i++];
            else helperArr[k] = arr[j++];
        }
        for (int k = low; k < high; k++) arr[k] = helperArr[k];
    }


}
