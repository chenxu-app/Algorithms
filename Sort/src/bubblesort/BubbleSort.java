package bubblesort;

import sort.Sort;

public class BubbleSort extends Sort {

    @Override
    public void sort(Comparable[] a) {
        int len = a.length;
        for (int i = 0; i < len - 1; i++) {
            boolean flag = true;
            for (int j = len - 1; j > i; j--) {
                if (less(a[j], a[j - 1])) {
                    exch(a, j, j - 1);
                    flag = false;
                }
                assert isSorted(a, 0, i);
            }
            if (flag) {
                break;
            }
        }
        assert isSorted(a);
    }
}
