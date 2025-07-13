public class SearchComparison {
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == target) return i;
        return -1;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] data = new int[1000000];
        for (int i = 0; i < data.length; i++) data[i] = i;

        int target = 999999;
        System.out.println("Linear Search Result: " + linearSearch(data, target));
        System.out.println("Binary Search Result: " + binarySearch(data, target));
    }
}