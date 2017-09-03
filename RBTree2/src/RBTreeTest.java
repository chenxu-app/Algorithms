

public class RBTreeTest {

    /**
     * @param args
     */
    public static void main(String[] args) {

        RBTree tree = new RBTree();

        long time = System.currentTimeMillis();
        for (int j = 0; j < 2000_000; j++) {
            tree.rbInsert(j);
        }
        System.out.println("插入用时: " + (System.currentTimeMillis() - time) + "ms");
        System.out.println();

//        time = System.currentTimeMillis();
//        for (int j = 0; j < 1000_000; j++) {
//            tree.rbDelete(j);
//        }
//        System.out.println("删除用时: " + (System.currentTimeMillis() - time) + "ms");

        tree.printTree();
    }
}
