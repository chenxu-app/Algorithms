public class Test {

    public static void main(String[] args) {
        int c = 10;                     //背包的容量
        Item items[] = {new Item("空", 0, 0),
                new Item("钻石", 2, 6),
                new Item("水晶", 2, 3),
                new Item("黄金", 6, 5),
                new Item("白银", 5, 4),
                new Item("红宝石", 4, 6)};
//        int w[] = {0, 2, 2, 6, 5, 4};   //物品的重量，其中0号位置不使用 。
//        int v[] = {0, 6, 3, 5, 4, 6};   //物品对应的待加，0号位置置为空。
        int n = 5;                      //n为物品的个数

        Knapsack knapsack = new Knapsack(items, c, n);
        knapsack.package0_1();
        knapsack.answer();
    }
}
