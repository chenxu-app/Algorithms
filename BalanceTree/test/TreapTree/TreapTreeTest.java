package TreapTree;

import java.util.Random;

public class TreapTreeTest {

    public static void main(String[] args) {
        TreapTree treap = new TreapTree();
        Random random = new Random();

        for (int i = 0; i < 30; i++)
            treap.insert(i, random.nextInt(1000));
        System.out.println("\n中序遍历:");
        treap.inOrder();
        System.out.println("\n高度:" + treap.depth());

        System.out.println("-----------------------");

        for (int i = 11; i < 22; i++)
            treap.remove(i);
        System.out.println("\n中序遍历:");
        treap.inOrder();
        System.out.println("\n高度:" + treap.depth());

        treap.PrintTree();
    }

}