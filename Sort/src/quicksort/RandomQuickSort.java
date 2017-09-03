package quicksort;

import java.util.Random;

public class RandomQuickSort {

    Random random = new Random();

    int getPivot(int[] array, int left, int right) {
        return random.nextInt(right - left + 1) + left;
    }

    public int partition(int[] array, int left, int right) {
        int i = getPivot(array, left, right);
        swap(array, i, right);

        int pivot = array[right];
        int cur = left;

        for (i = left; i < right; i++) {
            if (array[i] < pivot) {
                swap(array, cur, i);
                cur++;
            }
        }

        swap(array, cur, right);
        return cur;
    }

    public void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public void quickSort(int[] array, int left, int right) {
        int mid;
        if (left < right) {
            mid = partition(array, left, right);
            quickSort(array, left, mid - 1);
            quickSort(array, mid + 1, right);
        }
    }
}
