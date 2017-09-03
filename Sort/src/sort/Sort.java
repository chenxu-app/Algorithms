package sort;

import java.util.Comparator;

public abstract class Sort {

    public abstract void sort(Comparable[] a);

    protected boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    protected boolean less(Object v, Object w, Comparator comparator) {
        return comparator.compare(v, w) < 0;
    }

    protected void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    protected void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    protected boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length);
    }

    protected boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i < hi; i++) {
            if (less(a[i], a[i - 1]))
                return false;
        }
        return true;
    }

    protected boolean isSorted(Object[] a, Comparator comparator) {
        return isSorted(a, 0, a.length, comparator);
    }

    protected boolean isSorted(Object[] a, int lo, int hi, Comparator comparator) {
        for (int i = lo + 1; i < hi; i++)
            if (less(a[i], a[i - 1], comparator))
                return false;
        return true;
    }

    public void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print((a[i]) + ", ");
        }
    }
}
