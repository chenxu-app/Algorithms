import java.util.Arrays;

public class Knapsack {
    private float[] x;
    private Item items[];       // 物品，其中0号位置不使用 。
    private int c;              // 背包的容量
    private int n;              // n为物品的个数

    public Knapsack() {

    }

    public Knapsack(Item[] items, int c, int n) {
        x = new float[n + 1];
        this.items = items;
        this.c = c;
        this.n = n;
        Arrays.sort(this.items);
    }

    public void packagePart() {
        float room = c;
        int i;
        for (i = 1; i <= n; i++) {
            if (items[i].getWeight() > room) {
                break;
            }
            x[i] = items[i].getWeight();
            room -= items[i].getWeight();
        }

        if (i <= n) {
            x[i] = room;
        }
    }

    public void answer() {
        float sumValue = 0;
        for (int i = 1; i <= n; i++) {
            sumValue += (items[i].getAvgValue() * x[i]);
        }
        System.out.println("总价值: " + sumValue + "\n");
        for (int i = 1; i <= n; i++) {
            System.out.println(items[i].getName() + ": " + x[i]);
        }
    }
}