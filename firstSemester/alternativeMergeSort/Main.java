public class Main {
    public static void main(String[] args) {

        int[] testArray = {6, 1, 3, 0, 2, 5, 9, 4};
        AlternativeMergeSort(testArray);
        
        for (int i = 0; i < 8; i++) {
            System.out.println(testArray[i] + " ");
        }
        // should print 0 1 2 3 4 5 6 9
    }

    static void AlternativeMergeSort(int[] arr) {
        int n = arr.length;
        int[] helperArr = new int[n]; 

        for (int size = 1; size < n; size *= 2) {

            for(int leftStart = 0; leftStart < n - size; leftStart += 2 * size) {

                int mid = leftStart + size - 1;
                int rightEnd = Math.min(leftStart + 2 * size - 1, n - 1);

                merge(arr, helperArr, leftStart, mid, rightEnd);
                
            }

        }

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

}
