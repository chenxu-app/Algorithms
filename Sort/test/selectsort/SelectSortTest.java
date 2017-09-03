package selectsort;


public class SelectSortTest {

    public static void main(String[] args) {
        Integer[] array = {4, 6, 8, 2, 1, 3, 5, 9, 7};
        SelectSort selectSort = new SelectSort();
        selectSort.sort(array);
        selectSort.show(array);
    }

}