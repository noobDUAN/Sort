package MergeSort;

import java.util.Arrays;

public class MergeSortRecursion {
    public static void main(String[] args) {
        int[] array = {9, 18, 56, 152, 56, 65, 84, 75, 79, 153, 48, 28, 5, 5, 56, 3, 2, 1};
        int[] result = new int[array.length];
        mergeSort(array, 0, array.length - 1, result);
        System.out.println(Arrays.toString(array));
//        Arrays.stream(array).sorted();
    }

    private static void mergeSort(int[] array, int start, int end, int[] result) {
        if (start == end) {
            return;
        }
        int mid = (start + end) >> 1;
        mergeSort(array, start, mid, result);
        mergeSort(array, mid + 1, end, result);
        mergeArray(array, start, mid, end, result);
    }

    private static void mergeArray(int[] array, int start, int mid, int end, int[] result) {
        int first_flag = start;
        int second_flag = mid + 1;
        int result_flag = start;

        while (first_flag <= mid && second_flag <= end) {
            result[result_flag++] = array[first_flag] >= array[second_flag] ? array[second_flag++] : array[first_flag++];
        }

        while (second_flag <= end) {
            for (; second_flag <= end; ) {
                result[result_flag++] = array[second_flag++];
            }
        }

        while (first_flag <= mid) {
            for (; first_flag <= mid; ) {
                result[result_flag++] = array[first_flag++];
            }
        }

        for (; start <= end; start++) {
            array[start] = result[start];
        }
    }
}
