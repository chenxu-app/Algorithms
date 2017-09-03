
public class AvlTreeTest {

    public static void main(String[] args) {
        AvlTree<Integer> tree = new AvlTree<>();

        for (int i = 0; i < 20; i++) {
            tree.insert(i);
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

        for (int i = 0; i < 10; i++) {
            tree.remove(i);
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

        long time = System.currentTimeMillis();
        for (int j = 0; j < 2000_000; j++) {
            tree.insert(j);
        }
        System.out.println("插入用时: " + (System.currentTimeMillis() - time) + "ms");
        System.out.println();

        time = System.currentTimeMillis();
        for (int j = 0; j < 1000_000; j++) {
            tree.remove(j);
        }
        System.out.println("删除用时: " + (System.currentTimeMillis() - time) + "ms");

        tree.makeEmpty();
    }

}