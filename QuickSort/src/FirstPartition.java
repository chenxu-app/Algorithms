public class FirstPartition extends Partition {

    @Override
    int getPivot(int[] array, int left, int right) {
        return left;
    }
}
