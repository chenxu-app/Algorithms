package bubblesort;


public class BubbleSortTest {

    public static void main(String args[]) {
        Integer[] array = {4, 6, 8, 2, 1, 3, 5, 9, 7};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(array);
        bubbleSort.show(array);
    }

}