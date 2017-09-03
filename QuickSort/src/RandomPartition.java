import java.util.Random;

public class RandomPartition extends Partition {

    private Random random;

    public RandomPartition() {
        random = new Random();
    }

    @Override
    int getPivot(int[] array, int left, int right) {
        return random.nextInt(right - left + 1) + left;
    }
}
