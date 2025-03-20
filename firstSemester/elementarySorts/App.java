public class App {
	
	public static void main(String[] args) {

		int[] arr = {1,3,5,8,11,15,17};
		System.out.println(BinarySearch( arr, 15 ));
		
		int[] arr2 = {5,3,8,7,1,2};
		// SelectionSort( arr2 );
		InsertionSort( arr2 );
		for(int i=0; i<arr2.length; i++) {
			System.out.print(arr2[i] + " ");
		}
	}


	static int LinearSearch(int[] arr ,int key) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == key) return i;
		}
		return -1; 
	}


	static int BinarySearch(int[] arr, int key) {

		return binarySearchHelper(arr, key, 0, arr.length-1);

	}


	static int binarySearchHelper(int[] arr, int key, int low, int high) {

		if(low>high) return -1;
		// int mid = (low+high)/2; // CAUTION: integer overflow
		int mid = low + (high-low) / 2;
		if(arr[mid] == key) return mid;
		if(arr[mid] < key) return binarySearchHelper(arr, key, mid+1, high);

		return binarySearchHelper(arr, key, low, mid-1);

	}


	static int BinarySearchIterative(int[] arr, int key) {

		int low = 0;
		int high = arr.length-1;
		while( low <= high ) {
			// int mid = (low+high)/2; // CAUTION: integer overflow
			int mid = low + (high-low) / 2;
			if(arr[mid] == key) return mid;
			else if(arr[mid] < key) low = mid+1;
			else high = mid-1;
		}

		return -1;

	}


	static void SelectionSort(int[] numbers) {

		int length = numbers.length;

		for (int i = 0; i < length - 1; i++) {
			int min = numbers[i];
			int indexOfMin = i;
			for (int j = i + 1; j < length; j++) {
				if (numbers[j] < min) {
					min = numbers[j];
					indexOfMin = j;
				}
			}
			swap(numbers, i, indexOfMin);
		}
	}
    // Swap method
	private static void swap(int[] numbers, int a, int b) {
		int temp = numbers[a];
		numbers[a] = numbers[b];
		numbers[b] = temp;
	}


	static void InsertionSort(int[] arr) {

		for(int i = 1; i < arr.length; i++) {
			int currentValue = arr[i];

			int j = i - 1;

			while (j >= 0 && arr[j] > currentValue) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = currentValue;
		}

	}


}