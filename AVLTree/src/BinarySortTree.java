import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinarySortTree {

    private BinaryTreeNode root;

    //需要处理空节点，为空时高为-1
    public static int height(BinaryTreeNode node) {
        return node == null ? -1 : node.height;
    }

    public BinaryTreeNode getRoot() {
        return root;
    }

    public void insert(int value) {
        this.root = insert(value, this.root);
    }

    //递归插入
    public BinaryTreeNode insert(int value, BinaryTreeNode t) {
        if (t == null) {
            return new BinaryTreeNode(value);
        }
        //插入值与当前节点比较，小于插入到左子树，大于插入到右子树
        if (value < t.v) {
            t.leftChild = insert(value, t.leftChild);
        } else if (value > t.v) {
            t.rightChild = insert(value, t.rightChild);
        } else {/*equal,do nothing*/}
        //更新高度
        t.height = Math.max(height(t.leftChild), height(t.rightChild)) + 1;
        return t;
    }

    /*
     * 前序遍历
     */
    private void preOrder(BinaryTreeNode tree) {
        if (tree != null) {
            System.out.print(tree.v + " ");
            preOrder(tree.leftChild);
            preOrder(tree.rightChild);
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    /*
     * 中序遍历
     */
    private void inOrder(BinaryTreeNode tree) {
        if (tree != null) {
            inOrder(tree.leftChild);
            System.out.print(tree.v + " ");
            inOrder(tree.rightChild);
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    /*
     * 后序遍历
     */
    private void postOrder(BinaryTreeNode tree) {
        if (tree != null) {
            postOrder(tree.leftChild);
            postOrder(tree.rightChild);
            System.out.print(tree.v + " ");
        }
    }

    public void postOrder() {
        postOrder(root);
    }


    public void printTree() {
        if (root == null)
            return;

        List<Character> list = new ArrayList<>();
        List<BinaryTreeNode> vector = new LinkedList<>();
        vector.add(root);
        int size, level = 1;

        while (!vector.isEmpty()) {
            size = vector.size();

            for (int i = 0; i < size; i++) {
                if (vector.get(i) != null)
                    list.add((char) (vector.get(i).v + '0'));
                else
                    list.add(' ');
            }
            list.add('\n');
            for (int i = 0; i < size; i++) {
                if (vector.get(i) != null) {
                    if (vector.get(i).leftChild != null) {
                        list.add('/');
                        vector.add(vector.get(i).leftChild);
                    } else {
                        list.add(' ');
                        vector.add(vector.get(i).leftChild);
                    }

                    if (vector.get(i).rightChild != null) {
                        list.add('\\');
                        vector.add(vector.get(i).rightChild);
                    } else {
                        list.add(' ');
                        vector.add(vector.get(i).rightChild);
                    }
                }
            }

            for (int i = 0; i < size; i++) {
                vector.remove(0);
            }
            list.add('\n');
            level++;
        }

        System.out.println(list.toString());

        boolean flag = true;
        for (int i = 0; i <= level; i++) {
            System.out.print(" ");
        }
        for (Character c : list) {
            switch (c) {
                case '/':
                case '\\':
                    if (flag) {
                        for (int i = 0; i <= level; i++) {
                            System.out.print(" ");
                        }
                    }
                    System.out.print(c + "  ");
                    flag = false;
                    break;
                case '\n':
                    System.out.print(c);
                    if (flag) {
                        level--;
                    }
                    break;
                default:
                    if (!flag) {
                        for (int i = 0; i <= level; i++) {
                            System.out.print(" ");
                        }
                    }
                    System.out.print(c + "  ");
                    flag = true;
                    break;
            }
        }
    }

    private void PrintTree(BinaryTreeNode node, int layer)  /* 按竖向树状打印的二叉树 */ {
        if (node == null)
            return;
        PrintTree(node.rightChild, layer + 1);
        for (int i = 0; i < layer; i++)
            System.out.print("\t");
        System.out.print(node.v + "\n");
        PrintTree(node.leftChild, layer + 1);
    }

    public void PrintTree() {
        PrintTree(root, 0);
    }

    //节点结构
    public static class BinaryTreeNode {
        int v, height;
        BinaryTreeNode leftChild, rightChild;

        public BinaryTreeNode(int v) {
            this.v = v;
            this.leftChild = null;
            this.rightChild = null;
            this.height = 0;
        }

        public BinaryTreeNode(int v, BinaryTreeNode leftChild,
                              BinaryTreeNode rightChild, int height) {
            super();
            this.v = v;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
            this.height = height;
        }

    }


}