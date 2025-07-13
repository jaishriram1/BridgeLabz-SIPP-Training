import java.util.Arrays;

public class SortComparison {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j]; arr[j] = arr[j+1]; arr[j+1] = temp;
                }
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r)/2;
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, r);
            merge(arr, l, m, r);
        }
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int[] left = Arrays.copyOfRange(arr, l, m+1);
        int[] right = Arrays.copyOfRange(arr, m+1, r+1);
        int i = 0, j = 0, k = l;
        while (i < left.length && j < right.length)
            arr[k++] = (left[i] <= right[j]) ? left[i++] : right[j++];
        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high], i = low - 1;
        for (int j = low; j < high; j++)
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
            }
        int temp = arr[i+1]; arr[i+1] = arr[high]; arr[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        int[] data = new int[10000];
        for (int i = 0; i < data.length; i++) data[i] = (int)(Math.random() * 10000);

        int[] bubble = data.clone();
        int[] merge = data.clone();
        int[] quick = data.clone();

        bubbleSort(bubble);
        mergeSort(merge, 0, merge.length - 1);
        quickSort(quick, 0, quick.length - 1);

        System.out.println("Sorting Completed.");
    }
}