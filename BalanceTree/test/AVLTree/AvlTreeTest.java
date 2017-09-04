package AVLTree;

public class AvlTreeTest {
    public static void main(String[] args) {
//        int[] date = {1, 6, 4, 3, 9, 2, 8, 7, 11, 23, 15, 19, 20};

        AvlTree avlTree = new AvlTree();

//        for (int i : date) {
//            avlTree.insert(i);
//        }

//        System.out.println("\n前序遍历:");
//        avlTree.preOrder();
//        System.out.println("\n中序遍历:");
//        avlTree.inOrder();
//        System.out.println("\n后序遍历:");
//        avlTree.postOrder();

//        System.out.println("\n树:");
//        avlTree.PrintTree();

        long time = System.currentTimeMillis();
        for (int j = 0; j < 20; j++) {
            avlTree.insert(j);
        }
        System.out.println("插入用时: " + (System.currentTimeMillis() - time) + "ms");
        System.out.println();
        avlTree.PrintTree();

//        time = System.currentTimeMillis();
//        for (int j = 0; j < 1000_000; j++) {
//            avlTree.remove(j);
//        }
//        System.out.println("删除用时: " + (System.currentTimeMillis() - time) + "ms");

    }
}