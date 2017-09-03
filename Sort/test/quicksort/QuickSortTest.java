package quicksort;

import stdlib.StdOut;
import stdlib.StdRandom;

public class QuickSortTest {

//    public static void showArray(int[] array) {
//        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i] + ", ");
//        }
//        System.out.println();
//    }
//
//    public static void main(String[] args) {
////        int[] array = {4, 6, 8, 2, 1, 3, 5, 9, 7};
////        showArray(array);
//        int[] array = new int[1000];
//        Random random = new Random();
//        for (int i = 0; i < 1000; i++) {
//            array[i] = random.nextInt(10000);
//        }
//
//        long time = System.currentTimeMillis();
//        FirstQuickSort f = new FirstQuickSort();
//        for (int i = 0; i < 10_000; i++) {
//            f.quickSort(array, 0, array.length - 1);
//        }
//        System.out.println("普通快速排序时间: " + (System.currentTimeMillis() - time) + "ms");
//        showArray(array);
//
//
//        time = System.currentTimeMillis();
//        RandomQuickSort q = new RandomQuickSort();
//        for (int i = 0; i < 10_000; i++) {
//            q.quickSort(array, 0, array.length - 1);
//        }
//        System.out.println("随机快速排序时间: " + (System.currentTimeMillis() - time) + "ms");
//        showArray(array);
//    }

    public static void main(String[] args) {
        Integer[] array = {4, 6, 8, 2, 1, 3, 5, 9, 7};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(array);
        quickSort.show(array);

        // shuffle
        StdRandom.shuffle(array);
        StdOut.println();
        quickSort.show(array);

        // display results again using select
        StdOut.println();
        for (int i = 0; i < array.length; i++) {
            Integer ith = (Integer) quickSort.select(array, i);
            StdOut.print(ith + ", ");
        }
    }
}
