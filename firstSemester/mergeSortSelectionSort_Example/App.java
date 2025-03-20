import java.util.Random;
import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) {

		Random r = new Random();

		int[] arr = IntStream
				.generate(()->r.nextInt())
				.limit(200000)
				.toArray();

		long start = System.currentTimeMillis();
		SelectionSort(arr);
		long end = System.currentTimeMillis();
		System.out.println("Selection Sort Time: " + (end-start));

		start = System.currentTimeMillis();
		MergeSort(arr);
		end = System.currentTimeMillis();
		System.out.println("Merge Sort Time: " + (end-start));
        
		//for(int k=0; k<arr.length; k++) System.out.print(arr[k] + " ");

	}

	static void MergeSort(int[] arr) {
		int[] helperArr = new int[arr.length];
		MergeSortHelper(arr, helperArr, 0, arr.length-1);
	}

	static void MergeSortHelper(int[] arr, int[] helperArr, int low, int high) {
		if(high <= low) return;
		int mid = low + (high-low) / 2; // why not (low+high) /2
		MergeSortHelper(arr, helperArr, low, mid);
		MergeSortHelper(arr, helperArr, mid+1, high);
		merge(arr, helperArr, low, mid, high);
	}

	static void merge(int[] arr, int[] helperArr, int low, int mid, int high) {
		int i=low, j=mid+1;
		for(int k=low; k<=high; k++) {
			if(j>high) helperArr[k] = arr[i++];
			else if(i>mid) helperArr[k] = arr[j++];
			else if(arr[i] <= arr[j]) helperArr[k] = arr[i++];
			else helperArr[k] = arr[j++];
		}

		for(int k=low; k<=high; k++) arr[k] = helperArr[k];

	}

	static void SelectionSort(int[] arr) {

		int N = arr.length;

		for(int i=0; i<N; i++) {
			int minIndex = i;
			for(int j=i+1; j<N; j++) {
				if(arr[j] < arr[minIndex]) minIndex = j;
			}
			// swap minIndex element with ith element
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}

	}

}
