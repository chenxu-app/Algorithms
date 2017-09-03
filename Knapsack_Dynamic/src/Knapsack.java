public class Knapsack {

    private float m[][];        // 记录。
    private Item items[];       // 物品，其中0号位置不使用 。
    private int c;              // 背包的容量
    private int n;              // n为物品的个数

    public Knapsack() {

    }

    public Knapsack(Item[] items, int c, int n) {
        m = new float[n + 1][c + 1];
        this.items = items;
        this.c = c;
        this.n = n;
    }

    public void package0_1() {
        //采用从底到顶的顺序来设置m[i][j]的值
        //首先放w[n]
        for (int i = 0; i <= c; i++) {
            if (i < items[n].getWeight()) {
                m[n][i] = 0;
            } else {
                m[n][i] = items[n].getValue();
            }
        }

        //对剩下的n-1个物品进行放置。
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 0; j <= c; j++) {
                if (j < items[i].getWeight()) {     //如果j < w[i]则，当前位置就不能放置，它等于上一个位置的值。
                    m[i][j] = m[i + 1][j];
                } else {                            //否则，就比较到底是放置之后的值大，还是不放置的值大，选择其中较大者。
                    m[i][j] = m[i + 1][j] > m[i + 1][j - items[i].getWeight()] + items[i].getValue() ?
                            m[i + 1][j] : m[i + 1][j - items[i].getWeight()] + items[i].getValue();
                }
            }
        }

        for (int i = 1; i <= 5; i++) {
            for (int j = 0; j <= 10; j++)
                System.out.print((int) m[i][j] + "\t");
            System.out.println();
        }
    }

    public void answer() {
        int[] x = new int[n + 1];

        int j = c;
        int i;
        for (i = 1; i <= n - 1; i++) {
            if (m[i][j] == m[i + 1][j]) {
                x[i] = 0;
            } else {
                x[i] = items[i].getWeight();
                j = j - items[i].getWeight();
            }
        }
        x[n] = m[i][j] > 0 ? items[n].getWeight() : 0;

        System.out.println();
        for (i = 1; i <= n; i++) {
            System.out.println(items[i].getName() + ": " + x[i] + ", ");
        }
    }
}