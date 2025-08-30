package Searching1;

/**
 * Problem Description
 * Given a bitonic sequence A of N distinct elements, write a program to find a given element B in the bitonic sequence in O(logN) time.
 *
 * NOTE:
 * A Bitonic Sequence is a sequence of numbers which is first strictly increasing then after a point strictly decreasing.
 *
 * Problem Constraints
 * 3 <= N <= 105
 * 1 <= A[i], B <= 108
 *
 * Given array always contain a bitonic point.
 * Array A always contain distinct elements.
 *
 * Input Format
 * First argument is an integer array A denoting the bitonic sequence.
 * Second argument is an integer B.
 *
 * Output Format
 * Return a single integer denoting the position (0 index based) of the element B in the array A if B doesn't exist in A return -1.
 */
public class SearchInBitonicArray {
    public static void main(String[] args) {
        int[] A = {3, 9, 10, 20, 17, 5, 1};
        int B = 9;
        System.out.println(solve(A, B));
    }
    // Function for binary search in ascending part
    static int ascendingBinarySearch(int[] arr, int low, int high, int key) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key)
                return mid;
            if (arr[mid] > key)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    // Function for binary search in descending part of array
    static int descendingBinarySearch(int[] arr, int low, int high, int key) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key)
                return mid;
            if (arr[mid] < key)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    // finding bitonic point
    static int findBitonicPoint(int[] arr, int n, int l, int r) {
        int mid;
        mid = (r + l) / 2;
        if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
            return mid;
        } else if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
            return findBitonicPoint(arr, n, mid, r);
        } else if (arr[mid] < arr[mid - 1] && arr[mid] > arr[mid + 1]) {
            return findBitonicPoint(arr, n, l, mid);
        }
        return -1;
    }

    // Function to search key in bitonic array
    static int searchBitonic(int[] arr, int n, int key, int index) {
        if (key > arr[index])
            return -1;
        else if (key == arr[index])
            return index;
        else {
            int temp = ascendingBinarySearch(arr, 0, index - 1, key);
            if (temp != -1) {
                return temp;
            }

            // Search in right of k
            return descendingBinarySearch(arr, index + 1, n - 1, key);
        }
    }

    static int solveQ(int[] arr, int b) {
        int index = findBitonicPoint(arr, arr.length, 0, arr.length - 1);
        int x = searchBitonic(arr, arr.length, b, index);
        return x;
    }

    static int solve(int[] A, int B) {
        return solveQ(A, B);
    }
}
