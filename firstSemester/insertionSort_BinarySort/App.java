

public class App {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 8, 11, 15, 17};
        System.out.println(binarySearch(arr, 15));
        
        int[] arr2 = {5, 3, 8, 7, 1, 2};
        InsertionSort(arr2);
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i] + " ");
        }


    /* 

         for(int apt = 0; apt < 100; apt++) {
            System.out.println("apt. pata apt. pata apt. pata");
        }

     */

    }

    static int search(int[]arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == key) return i;
        }
        return -1;
    }

    static int binarySearch(int [] arr, int key) {
        return binarySearchHelper(arr, key, 0, arr.length-1);
    }

    static int binarySearchHelper(int[] arr, int key, int low, int high) {
        if(low > high) return -1;
        int mid = low + (high - low) / 2;
        if (arr[mid] < key) return binarySearchHelper(arr, key, mid + 1, high);
        return binarySearchHelper(arr, key, low, mid - 1); // burdaki if kalıbını sildik. java çalışmıyor.
    }

    static int binarySearchIterative(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] == key) return mid;
            else if(arr[mid] < key) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    static void selectionSort(int[] arr) {
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            int minIndex = i;                         //apt. pata apt. pata apt. pata dont you want me lile i want you baby dont you need me like i need you now  
            for (int j = i + 1; j < N; j++) {
                if (arr[j] < arr[minIndex]) minIndex = j;
            }  
            // swap min with i 
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }


    static void InsertionSort(int[] arr)
    {
        int N=arr.length;
        for(int i=1; i<N ;i++)
        {
            for(int j = i; j>0; j--)
            {
                if(arr[j]<arr[j-1])
                {
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }
                else break;
            }
        }
    }
}
