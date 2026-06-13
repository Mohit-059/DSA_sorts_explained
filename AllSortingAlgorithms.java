import java.util.Arrays;

public class AllSortingAlgorithms {

    public static void main(String[] args) {

        int[] arr1 = {5, 3, 8, 4, 2};
        bubbleSort(arr1);
        System.out.println("Bubble Sort:    " + Arrays.toString(arr1));

        int[] arr2 = {5, 3, 8, 4, 2};
        selectionSort(arr2);
        System.out.println("Selection Sort: " + Arrays.toString(arr2));

        int[] arr3 = {5, 3, 8, 4, 2};
        insertionSort(arr3);
        System.out.println("Insertion Sort: " + Arrays.toString(arr3));

        int[] arr4 = {5, 3, 8, 4, 2};
        mergeSort(arr4, 0, arr4.length - 1);
        System.out.println("Merge Sort:     " + Arrays.toString(arr4));

        int[] arr5 = {5, 3, 8, 4, 2};
        quickSort(arr5, 0, arr5.length - 1);
        System.out.println("Quick Sort:     " + Arrays.toString(arr5));
    }

    // =====================================================
    // BUBBLE SORT
    // =====================================================

    /*
       IDEA:
       Compare adjacent elements.

       If left > right
       swap them.

       Largest element keeps moving to the end
       after every pass.

       Example:
       [5,3,8,4,2]

       Pass 1:
       5 3 -> swap
       5 8 -> no swap
       8 4 -> swap
       8 2 -> swap

       Largest number (8) reaches the end.
    */

    public static void bubbleSort(int[] arr) {

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - 1 - i; j++) {

                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // =====================================================
    // SELECTION SORT
    // =====================================================

    /*
       IDEA:

       Find smallest element.

       Put it at correct position.

       Example:

       [5,3,8,4,2]

       First pass:
       Smallest = 2

       Swap with first position.

       [2,3,8,4,5]

       Repeat for remaining array.
    */

    public static void selectionSort(int[] arr) {

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < n; j++) {

                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // =====================================================
    // INSERTION SORT
    // =====================================================

    /*
       IDEA:

       Treat left side as sorted.

       Take one element.

       Insert it into correct position.

       Example:

       [5,3,8,4]

       Sorted Part: [5]

       Take 3

       Shift 5 right

       Insert 3

       [3,5,8,4]

       Continue...
    */

    public static void insertionSort(int[] arr) {

        int n = arr.length;

        for (int i = 1; i < n; i++) {

            int current = arr[i];

            int j = i - 1;

            while (j >= 0 && arr[j] > current) {

                arr[j + 1] = arr[j];

                j--;
            }

            arr[j + 1] = current;
        }
    }

    // =====================================================
    // MERGE SORT
    // =====================================================

    /*
       DIVIDE AND CONQUER

       Split array until single elements.

       Then merge while sorting.

       Example:

       [5,3,8,4]

           [5,3] [8,4]

           [5][3][8][4]

       Merge:

       [3,5] [4,8]

       Final:

       [3,4,5,8]
    */

    public static void mergeSort(int[] arr, int left, int right) {

        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;

        mergeSort(arr, left, mid);

        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr,
                              int left,
                              int mid,
                              int right) {

        int size1 = mid - left + 1;
        int size2 = right - mid;

        int[] leftArray = new int[size1];
        int[] rightArray = new int[size2];

        for (int i = 0; i < size1; i++) {
            leftArray[i] = arr[left + i];
        }

        for (int j = 0; j < size2; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < size1 && j < size2) {

            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }

            k++;
        }

        while (i < size1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < size2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // =====================================================
    // QUICK SORT
    // =====================================================

    /*
       DIVIDE AND CONQUER

       Choose a pivot.

       Put smaller elements left.

       Put larger elements right.

       Example:

       [5,3,8,4,2]

       Pivot = 2

       After partition:

       [2,3,8,4,5]

       Then sort left and right parts.
    */

    public static void quickSort(int[] arr,
                                 int low,
                                 int high) {

        if (low < high) {

            int pivotIndex = partition(arr, low, high);

            quickSort(arr, low, pivotIndex - 1);

            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr,
                                 int low,
                                 int high) {

        int pivot = arr[high];

        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (arr[j] < pivot) {

                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}