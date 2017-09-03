public class Test {

    public static void main(String[] args) {
        int c = 20;                     //背包的容量
        int n = 8;                      //n为物品的个数

        // name, weight, value
        Item items[] = {new Item("空", 0, 0),
                new Item("钻石", 2, 80),
                new Item("水晶", 2, 30),
                new Item("黄金", 5, 50),
                new Item("白银", 7, 40),
                new Item("红宝石", 4, 80),
                new Item("蓝宝石", 4, 60),
                new Item("玛瑙", 4, 70),
                new Item("珍珠", 4, 20)};

        Knapsack knapsack = new Knapsack(items, c, n);
        knapsack.package0_1();
        knapsack.answer();
    }
}
