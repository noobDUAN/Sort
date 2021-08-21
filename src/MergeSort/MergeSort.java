package MergeSort;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {9, 18, 56, 48, 28, 5, 5, 56, 3, 2, 1};
        int[] result = new int[array.length];
        mergeSort(array, 0, array.length - 1, result);
        System.out.println("___________");
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
        while (first_flag < mid + 1 || second_flag < end) {
            if (array[first_flag] >= array[second_flag]) {
                result[result_flag] = array[second_flag];
                second_flag++;
                result_flag++;
            } else {
                result[result_flag] = array[first_flag];
                first_flag++;
                result_flag++;
            }
            if (first_flag > mid) {
                for (; second_flag <= end; second_flag++) {
                    result[result_flag] = array[second_flag];
                    result_flag++;
                }
                break;
            }
            if (second_flag > end) {
                for (; first_flag <= mid; first_flag++) {
                    result[result_flag] = array[first_flag];
                    result_flag++;
                }
                break;
            }
        }


        for (; start <= end; start++) {
            array[start] = result[start];
        }
    }
}
