package shellsort;

import bubblesort.BubbleSort;

public class ShellSortTest {

    public static void main(String args[]) {
        Integer[] array = {4, 6, 8, 2, 1, 3, 5, 9, 7};
        ShellSort shellSort = new ShellSort();
        shellSort.sort(array);
        shellSort.show(array);
    }

}