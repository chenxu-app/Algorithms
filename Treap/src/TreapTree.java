/**
 * Treap树算是一种简单的优化策略，树和堆的合体，其实原理比较简单，
 * 在树中维护一个"优先级“，”优先级“采用随机数的方法，但是”优先级“必须满足根堆的性质
 */
public class TreapTree {

    private TreapNode root;

    /**
     * @param x
     */
    private void rotateLeft(TreapNode x) {// rotate to left on node x //左旋当前节点
        TreapNode y = x.right; // 把当前节点的右节点，复制给y
        x.right = y.left; // 把当前节点的右节点的左子树复制给当前节点
        y.left = x;
        swapLocatePoint(x, y);
    }

    /**
     * @param x
     */
    private void rotateRight(TreapNode x) {// rotate to right on node x
        TreapNode y = x.left;
        x.left = y.right;
        y.right = x;
        swapLocatePoint(x, y);
    }

    /**
     * @param x
     * @param y
     */
    private void swapLocatePoint(TreapNode x, TreapNode y) {
        TreapNode parent = findParent(root, x.key, null);
        if (parent == null) {
            root = y;
            return;
        }
        if (parent.left == x) {
            parent.left = y;
        } else {
            parent.right = y;
        }
    }

    /**
     * @param key
     * @return
     */
    public TreapNode find(int key) {
        return find(root, key);
    }

    /**
     * @param root
     * @param key
     * @return
     */
    public TreapNode find(TreapNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key == root.key) {
            return root;
        } else {
            if (key < root.key) {
                return find(root.left, key);
            } else {
                return find(root.right, key);
            }
        }
    }

    /**
     * @param root
     * @param key
     * @param parent
     * @return
     */
    public TreapNode findParent(TreapNode root, int key, TreapNode parent) {
        if (root == null) {
            return null;
        }
        if (key == root.key) {
            return parent;
        } else {
            if (key < root.key) {
                return findParent(root.left, key, root);
            } else {
                return findParent(root.right, key, root);
            }
        }
    }

    /**
     * @param root
     * @param node
     */
    private void insert(TreapNode root, TreapNode node) {
        if (node.key < root.key) {
            if (root.left == null)
                root.left = new TreapNode(node.key, node.priority);
            else
                insert(root.left, node);
            if (root.left.priority > root.priority)
                rotateRight(root);
        } else if (node.key > root.key) {
            if (root.right == null)
                root.right = new TreapNode(node.key, node.priority);
            else
                insert(root.right, node);
            if (root.right.priority > root.priority)
                rotateLeft(root);
        } else {
            root.priority = node.priority;
        }
    }

    /**
     * @param key
     * @param priority
     */
    public void insert(int key, int priority) {
        TreapNode node = new TreapNode(key, priority);
        if (root == null) {
            root = node;
            return;
        }
        insert(root, node);
    }

    /**
     * @param root
     * @param key
     * @return
     */
    private TreapNode remove(TreapNode root, int key) {
        if (root == null)
            return null;

        if (key < root.key)
            return remove(root.left, key);
        else if (key > root.key)
            return remove(root.right, key);
        else {
            if (root.left == null && root.right == null) {
                swapLocatePoint(root, null);
                return null;
            } else if (root.left == null) {
                swapLocatePoint(root, root.right);
                return root;
            } else if (root.right == null) {
                swapLocatePoint(root, root.left);
                return root;
            } else {
                if (root.left.priority < root.right.priority) {
                    rotateLeft(root);
                    root = find(root.key);
                    return remove(root, key);
                } else {
                    rotateRight(root);
                    root = find(root.key);
                    return remove(root, key);
                }
            }
        }
    }

    public TreapNode remove(int key) {
        return remove(root, key);
    }

    /**
     * 前序遍历
     *
     * @param tree
     */
    private void preOrder(TreapNode tree) {
        if (tree != null) {
            System.out.print(tree.key + " ");
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    /**
     * 中序遍历
     *
     * @param tree
     */
    private void inOrder(TreapNode tree) {
        if (tree != null) {
            inOrder(tree.left);
            System.out.print(tree.key + " ");
            inOrder(tree.right);
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    /**
     * 后序遍历
     *
     * @param tree
     */
    private void postOrder(TreapNode tree) {
        if (tree != null) {
            postOrder(tree.left);
            postOrder(tree.right);
            System.out.print(tree.key + " ");
        }
    }

    public void postOrder() {
        postOrder(root);
    }

    /**
     * 按竖向树状打印的二叉树
     *
     * @param node
     * @return
     */
    public int depth(TreapNode node) {
        if (node == null)
            return -1;
        int l = depth(node.left);
        int r = depth(node.right);

        return (l < r) ? (r + 1) : (l + 1);
    }

    public int depth() {
        return depth(root);
    }

    /**
     * 按竖向树状打印的二叉树
     *
     * @param node
     * @param layer
     */
    private void PrintTree(TreapNode node, int layer) {
        if (node == null)
            return;
        PrintTree(node.right, layer + 1);
        for (int i = 0; i < layer; i++)
            System.out.print("\t");

        System.out.print(node.key + "/" + node.priority + "\n");
        PrintTree(node.left, layer + 1);
    }

    /**
     * 打印树
     */
    public void PrintTree() {
        PrintTree(root, 0);
    }
}