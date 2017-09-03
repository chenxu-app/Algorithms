package insertsort;


public class InsertSortTest {


    public static void main(String[] args) {
        Integer[] array = {4, 6, 8, 2, 1, 3, 5, 9, 7};
        InsertSort insertSort = new InsertSort();
        insertSort.sort(array);
        insertSort.show(array);
    }

}