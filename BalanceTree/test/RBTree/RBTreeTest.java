package RBTree;

public class RBTreeTest {
    private static final int a[] = {10, 40, 30, 60, 90, 70, 20, 50, 80};
    private static final boolean mDebugInsert = false;    // "插入"动作的检测开关(false，关闭；true，打开)
    private static final boolean mDebugDelete = false;    // "删除"动作的检测开关(false，关闭；true，打开)

    public static void main(String[] args) {
        int i, ilen = a.length;
        RBTree<Integer> tree = new RBTree<Integer>();

//        System.out.printf("== 原始数据: ");
//        for (i = 0; i < ilen; i++)
//            System.out.printf("%d ", a[i]);
//        System.out.printf("\n");

        for (i = 0; i < 20; i++) {
            tree.insert(i);
            // 设置mDebugInsert=true,测试"添加函数"
            if (mDebugInsert) {
                System.out.printf("== 添加节点: %d\n", a[i]);
                System.out.printf("== 树的详细信息: \n");
                tree.print();
                System.out.printf("\n");
            }
        }
        System.out.println("添加后: ");
        System.out.printf("== 前序遍历: ");
        tree.preOrder();
        System.out.printf("\n== 中序遍历: ");
        tree.inOrder();
        System.out.printf("\n== 后序遍历: ");
        tree.postOrder();
        System.out.printf("\n");
        tree.PrintTree();

//        System.out.printf("== 最小值: %s\n", tree.minimum());
//        System.out.printf("== 最大值: %s\n", tree.maximum());
//        System.out.printf("== 树的详细信息: \n");
//        tree.print();
//        System.out.printf("\n");

        // 设置mDebugDelete=true,测试"删除函数"
        for (i = 0; i < 10; i++) {
            tree.remove(i);
//
//                System.out.printf("== 删除节点: %d\n", a[i]);
//                System.out.printf("== 树的详细信息: \n");
//                tree.print();
//                System.out.printf("\n");
        }

        System.out.println("删除后: ");
        System.out.printf("== 前序遍历: ");
        tree.preOrder();
        System.out.printf("\n== 中序遍历: ");
        tree.inOrder();
        System.out.printf("\n== 后序遍历: ");
        tree.postOrder();
        System.out.printf("\n");
        tree.PrintTree();

        // 销毁二叉树

//        long time = System.currentTimeMillis();
//        for (int j = 0; j < 2000_000; j++) {
//            tree.insert(j);
//        }
//        System.out.println("插入用时: " + (System.currentTimeMillis() - time) + "ms");
//        System.out.println();
//
//        time = System.currentTimeMillis();
//        for (int j = 0; j < 1000_000; j++) {
//            tree.remove(j);
//        }
//        System.out.println("删除用时: " + (System.currentTimeMillis() - time) + "ms");

        tree.clear();
    }
}