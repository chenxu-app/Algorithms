package insertsort;

import sort.Sort;


public class InsertSort extends Sort {

    @Override
    public void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
            assert isSorted(a, 0, i);
        }
        assert isSorted(a);
    }
}
