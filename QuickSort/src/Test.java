import java.util.Random;

public class Test {

    public static void showArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = new int[1000];
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            array[i] = random.nextInt(10000);
        }

        long time = System.currentTimeMillis();
        QuickSort q = new FirstQuickSort();
        for (int i = 0; i < 10_000; i++) {
            q.quickSort(array, 0, array.length - 1);
        }
        System.out.println("普通快速排序时间: " + (System.currentTimeMillis() - time) + "ms");
        showArray(array);
        System.out.println();


        time = System.currentTimeMillis();
        q = new RandomQuickSort();
        for (int i = 0; i < 10_000; i++) {
            q.quickSort(array, 0, array.length - 1);
        }
        System.out.println("随机快速排序时间: " + (System.currentTimeMillis() - time) + "ms");
        showArray(array);
    }
}
