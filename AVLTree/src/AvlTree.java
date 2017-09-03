public class AvlTree extends BinarySortTree {

    public BinaryTreeNode rotateWithLeftChild(BinaryTreeNode k2) {
        BinaryTreeNode k1 = k2.leftChild;
        k2.leftChild = k1.rightChild;
        k1.rightChild = k2;
        //重新计算高度
        k2.height = Math.max(height(k2.leftChild), height(k2.rightChild)) + 1;
        k1.height = Math.max(height(k1.leftChild), k2.height) + 1;
        return k1;
    }


    public BinaryTreeNode rotateWithRightChild(BinaryTreeNode k2) {
        BinaryTreeNode k1 = k2.rightChild;
        k2.rightChild = k1.leftChild;
        k1.leftChild = k2;
        //重新计算高度
        k2.height = Math.max(height(k2.leftChild), height(k2.rightChild)) + 1;
        k1.height = Math.max(height(k1.rightChild), k2.height) + 1;
        return k1;
    }

    public BinaryTreeNode doubleWithLeftChild(BinaryTreeNode k3) {
        k3.leftChild = rotateWithRightChild(k3.leftChild);
        return rotateWithLeftChild(k3);
    }

    public BinaryTreeNode doubleWithRightChild(BinaryTreeNode k3) {
        k3.rightChild = rotateWithLeftChild(k3.rightChild);
        return rotateWithRightChild(k3);
    }

    @Override
    public BinaryTreeNode insert(int value, BinaryTreeNode t) {
        if (t == null) {
            return new BinaryTreeNode(value);
        }
        //插入值与当前节点比较，小于插入到左子树，大于插入到右子树
        if (value < t.v) {
            t.leftChild = insert(value, t.leftChild);
            //判断平衡是否被破坏
            if (height(t.leftChild) - height(t.rightChild) == 2) {
                if (value < t.leftChild.v) {
                    t = rotateWithLeftChild(t);
                } else if (value > t.leftChild.v) {
                    t = doubleWithLeftChild(t);
                } else {/*impossible do nothing*/}
            }
        } else if (value > t.v) {
            t.rightChild = insert(value, t.rightChild);
            //判断平衡是否被破坏
            if (height(t.rightChild) - height(t.leftChild) == 2) {
                if (value > t.rightChild.v) {
                    t = rotateWithRightChild(t);
                } else if (value < t.rightChild.v) {
                    t = doubleWithRightChild(t);
                } else {/*impossible do nothing*/}
            }
        } else {/*equal,do nothing*/}
        //更新高度
        t.height = Math.max(height(t.leftChild), height(t.rightChild)) + 1;
        return t;
    }
}