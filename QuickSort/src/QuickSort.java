public abstract class QuickSort {

    Partition part;

    public void quickSort(int[] array, int left, int right) {
        int mid;
        if (left < right) {
            mid = part.partition(array, left, right);
            quickSort(array, left, mid - 1);
            quickSort(array, mid + 1, right);
        }
    }
}
