package shellsort;

import sort.Sort;

public class ShellSort extends Sort {

    @Override
    public void sort(Comparable[] a) {
        int len = a.length;
        int h = 1;
        while (h < len / 3) {
            h = h * 3 + 1;
        }
        while (h >= 1) {
            for (int i = h; i < len; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            assert isHSorted(a, h);
            h /= 3;
        }
        assert isSorted(a);
    }

    private boolean isHSorted(Comparable[] a, int h) {
        for (int i = h; i < a.length; i++) {
            if (less(a[i], a[i - h]))
                return false;
        }
        return true;
    }
}
