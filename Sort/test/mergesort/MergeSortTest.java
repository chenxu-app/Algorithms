package mergesort;


import bubblesort.BubbleSort;

public class MergeSortTest {

    public static void main(String args[]) {
        Integer[] array = {4, 6, 8, 2, 1, 3, 5, 9, 7};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(array);
        mergeSort.show(array);
    }
}