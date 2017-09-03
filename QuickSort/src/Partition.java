public abstract class Partition {

    abstract int getPivot(int[] array, int left, int right);

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

}
